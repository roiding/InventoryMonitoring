package ran.ding.notifying.task.notify.email;

import ch.qos.logback.core.spi.ContextAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ran.ding.notifying.entity.EmailSubscriber;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.service.MailSubscribeService;
import ran.ding.notifying.task.notify.NotifyStrategy;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailNotifyStrategy implements NotifyStrategy {
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private Environment environment;
    @Resource
    private MailSubscribeService mailSubscribeService;

    @Override
    public void sendNotify(List<String> notifyAddress, MonitorItem item, int count) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(item.getName() + "已补货!");
        message.setFrom(environment.getProperty("spring.mail.username"));
        //自己发给自己，通过密送给订阅者
        message.setTo(environment.getProperty("spring.mail.username"));
        message.setBcc(notifyAddress.toArray(new String[notifyAddress.size()]));
        message.setSentDate(new Date());
        message.setText(item.getName() + "已补货，请尽快购买，目前库存为:" + count);
        javaMailSender.send(message);
    }

    @Override
    public void checkMailSubscribe(MonitorItem item, int count) {
        List<EmailSubscriber> subscribers = mailSubscribeService.getEmailSubscribeByNotifyId(item.getId());
        if (subscribers.size() > 0) {
            List<String> notifyAddress = subscribers.stream().map(subscriber -> {
                return subscriber.getMailAddress();
            }).collect(Collectors.toList());
            sendNotify(notifyAddress, item, count);
            //清理已发送邮件者的订阅信息
            mailSubscribeService.cleanSubscriber(notifyAddress);
        }
    }
}

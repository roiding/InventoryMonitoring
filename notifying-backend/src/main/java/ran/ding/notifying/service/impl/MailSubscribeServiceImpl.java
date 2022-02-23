package ran.ding.notifying.service.impl;

import org.springframework.stereotype.Service;
import ran.ding.notifying.dao.MailSubscribeDao;
import ran.ding.notifying.entity.EmailSubscriber;
import ran.ding.notifying.service.MailSubscribeService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class MailSubscribeServiceImpl implements MailSubscribeService {
    @Resource
    private MailSubscribeDao mailSubscribeDao;

    @Override
    public void addNewNotifyMail(String mailAddress, int itemId) {
        mailSubscribeDao.addNewNotifyMail(mailAddress, itemId);
    }

    @Override
    public List<EmailSubscriber> getEmailNotifyerByNotifyId(int notifyId) {
        return mailSubscribeDao.getEmailNotifyerByNotifyId(notifyId);
    }

    @Override
    public boolean checkMailAddress(String mailAddress) {
        Optional<Integer> checkResult = mailSubscribeDao.checkMailAddress(mailAddress);
        return !checkResult.isPresent();
    }


}

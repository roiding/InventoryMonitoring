package ran.ding.notifying.service.impl;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;
import ran.ding.notifying.common.SystemConstant;
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
        if(mailSubscribeDao.checkIsOldPeople(mailAddress)){
            mailSubscribeDao.updateNotifyMail(mailAddress,itemId);
        }
        mailSubscribeDao.addNewNotifyMail(mailAddress, itemId);
    }

    @Override
    public List<EmailSubscriber> getEmailSubscribeByNotifyId(int notifyId) {
        return mailSubscribeDao.getEmailSubscribeByNotifyId(notifyId);
    }

    @Override
    public boolean checkMailAddress(String mailAddress) {
        Optional<Integer> checkResult = mailSubscribeDao.checkMailAddress(mailAddress);
        if(!checkResult.isPresent()|| SystemConstant.NO_SUBSCRIBE!=checkResult.get().intValue()) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void cleanSubscriber(List<String> mailAddress) {
        mailSubscribeDao.cleanSubscriber(mailAddress, SystemConstant.NO_SUBSCRIBE);
    }


}

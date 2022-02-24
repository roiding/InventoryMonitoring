package ran.ding.notifying.service;

import ran.ding.notifying.entity.EmailSubscriber;

import java.util.List;

public interface MailSubscribeService {
    void addNewNotifyMail(String mailAddress, int itemId);

    List<EmailSubscriber> getEmailSubscribeByNotifyId(int notifyId);

    boolean checkMailAddress(String mailAddress);

    void cleanSubscriber(List<String> mailAddress);
}

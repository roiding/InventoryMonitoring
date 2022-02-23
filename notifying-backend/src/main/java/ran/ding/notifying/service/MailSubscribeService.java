package ran.ding.notifying.service;

import ran.ding.notifying.entity.EmailSubscriber;

import java.util.List;

public interface MailSubscribeService {
    void addNewNotifyMail(String mailAddress, int itemId);

    List<EmailSubscriber> getEmailNotifyerByNotifyId(int notifyId);

    boolean checkMailAddress(String mailAddress);
}

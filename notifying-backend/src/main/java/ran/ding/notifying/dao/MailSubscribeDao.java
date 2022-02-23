package ran.ding.notifying.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ran.ding.notifying.entity.EmailSubscriber;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MailSubscribeDao {

    @Select("select id from mail_subscribe where mail_address = #{mailAddress}")
    Optional<Integer> checkMailAddress(String mailAddress);

    @Insert("insert into mail_subscribe(mail_address,notify_id) values (#{mailAddress},#{itemId})")
    void addNewNotifyMail(String mailAddress,int itemId);

    @Select("select id,mail_address,has_mailed,notify_id from mail_notify where mail_subscribe=#{notifyId}")
    List<EmailSubscriber> getEmailNotifyerByNotifyId(int notifyId);

}

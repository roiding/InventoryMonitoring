package ran.ding.notifying.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ran.ding.notifying.entity.EmailSubscriber;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MailSubscribeDao {

    @Select("select if(count(1)!=0,True,False) from mail_subscribe where mail_address = #{mailAddress}")
    boolean checkIsOldPeople(String mailAddress);

    @Select("select notify_id from mail_subscribe where mail_address = #{mailAddress}")
    Optional<Integer> checkMailAddress(String mailAddress);

    @Insert("insert into mail_subscribe(mail_address,notify_id) values (#{mailAddress},#{itemId})")
    void addNewNotifyMail(String mailAddress,int itemId);

    @Update("update mail_subscribe(notify_id) values #{itemId} where mail_address=#{mailAddress}")
    void updateNotifyMail(String mailAddress,int itemId);

    @Select("select id,mail_address,has_mailed,notify_id from mail_subscribe where notify_id=#{notifyId}")
    List<EmailSubscriber> getEmailSubscribeByNotifyId(int notifyId);

    @Update("update mail_subscribe(has_mailed,notify_id) set has_mailed=has_mailed+1 and notify_id = #{noSubscribeCode}")
    void cleanSubscriber(List<String> mailAddress,int noSubscribeCode);
}

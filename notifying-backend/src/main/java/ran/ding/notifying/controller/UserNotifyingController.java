package ran.ding.notifying.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ran.ding.notifying.common.ResponseResult;
import ran.ding.notifying.service.MailSubscribeService;

import javax.annotation.Resource;

@RestController("/notify")
public class UserNotifyingController {
    @Resource
    private MailSubscribeService mailSubscribeService;

    @RequestMapping("/addNewNotify")
    public ResponseResult addNewNotifyMail(String mailAddress,int itemId){
        if (mailSubscribeService.checkMailAddress(mailAddress)) {
            mailSubscribeService.addNewNotifyMail(mailAddress,itemId);
            return ResponseResult.buildSuccessResult("新增成功");
        }else{
            return ResponseResult.buildErrorResult("500","目前同一邮箱只支持订阅一个商品");
        }
    }

}

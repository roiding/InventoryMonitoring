package ran.ding.notifying.service.impl;

import org.springframework.stereotype.Component;
import ran.ding.notifying.common.ResponseResult;
import ran.ding.notifying.common.SubscribeTypeEnum;
import ran.ding.notifying.entity.SubscribeItem;
import ran.ding.notifying.service.MailSubscribeService;
import ran.ding.notifying.service.SubscribeHandler;

import javax.annotation.Resource;

@Component
public class MailSubscribeHandler implements SubscribeHandler {
    @Resource
    private MailSubscribeService mailSubscribeService;

    @Override
    public boolean isSupply(SubscribeItem subscribeItem) {
        return subscribeItem.getSubscribeType().equals(SubscribeTypeEnum.MAIL.getSubscribeType());
    }

    @Override
    public ResponseResult handleSubscribe(SubscribeItem subscribeItem) {
        if (mailSubscribeService.checkMailAddress(subscribeItem.getAddress())) {
            mailSubscribeService.addNewNotifyMail(subscribeItem.getAddress(),subscribeItem.getItemId());
            return ResponseResult.buildSuccessResult("新增成功");
        }else{
            return ResponseResult.buildErrorResult("500","目前同一邮箱只支持订阅一个商品");
        }
    }
}

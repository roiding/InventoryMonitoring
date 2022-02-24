package ran.ding.notifying.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ran.ding.notifying.common.ResponseResult;
import ran.ding.notifying.entity.SubscribeItem;
import ran.ding.notifying.service.handler.SubscribeHandler;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subscribe")
public class UserNotifyingController {
    @Resource
    private List<SubscribeHandler> subscribeHandlers;

    @PostMapping("/addNewNotify")
    @Valid
    public ResponseResult addNewNotifyMail(@RequestBody SubscribeItem subscribeItem){
        for (SubscribeHandler subscribeHandler : subscribeHandlers) {
            if(subscribeHandler.isSupply(subscribeItem)){
                return subscribeHandler.handleSubscribe(subscribeItem);
            }
        }
        return ResponseResult.buildErrorResult("500","未找到对应订阅渠道处理方式，请联系管理员");

    }

}

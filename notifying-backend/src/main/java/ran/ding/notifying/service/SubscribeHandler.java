package ran.ding.notifying.service;

import ran.ding.notifying.common.ResponseResult;
import ran.ding.notifying.entity.SubscribeItem;

public interface SubscribeHandler {

    boolean isSupply(SubscribeItem subscribeItem);

    ResponseResult handleSubscribe(SubscribeItem subscribeItem);
}

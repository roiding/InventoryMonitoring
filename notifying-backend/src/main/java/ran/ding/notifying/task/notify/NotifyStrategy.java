package ran.ding.notifying.task.notify;

import ran.ding.notifying.entity.MonitorItem;

import java.util.List;

public interface NotifyStrategy {
    /**
     * 不要在外部直接调这个
     * 这是真正的推送发送
     * @param notifyAddress
     * @param item
     * @param count
     */
    void sendNotify(List<String> notifyAddress, MonitorItem item, int count);

    /**
     * 检查是否有订阅者
     * @param item
     * @param count
     */
    void checkSubscribe(MonitorItem item, int count);
}

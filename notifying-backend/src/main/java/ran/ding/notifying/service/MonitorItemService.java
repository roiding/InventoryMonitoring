package ran.ding.notifying.service;

import ran.ding.notifying.entity.MonitorItem;

import java.util.List;

public interface MonitorItemService {
    /**
     * 获得当前平台支持的所有监控列表
     * @return
     */
    List<MonitorItem> getAllItemMonitor();
}

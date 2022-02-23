package ran.ding.notifying.service.impl;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.service.MonitorItemService;
import ran.ding.notifying.service.SystemService;
import ran.ding.notifying.task.crawling.CrawlingStrategy;
import ran.ding.notifying.task.notify.NotifyStrategy;
import ran.ding.notifying.task.thread.CrawAndNotifyThread;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
    @Resource
    private MonitorItemService monitorItemService;
    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Resource
    private List<CrawlingStrategy> crawlingStrategies;
    @Resource
    private List<NotifyStrategy> notifyStrategies;

    @Override
    public void startTask() {
        List<MonitorItem> allItemMonitor = monitorItemService.getAllItemMonitor();
        threadPoolTaskScheduler.setPoolSize(allItemMonitor.size());
        allItemMonitor.forEach(itemMonitor -> {
            threadPoolTaskScheduler.scheduleWithFixedDelay(new CrawAndNotifyThread(crawlingStrategies, notifyStrategies, itemMonitor), Duration.ofSeconds(30));
        });
    }
}

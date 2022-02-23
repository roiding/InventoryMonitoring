package ran.ding.notifying.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.service.MonitorItemService;
import ran.ding.notifying.service.SystemService;
import ran.ding.notifying.task.crawling.CrawlingStrategy;
import ran.ding.notifying.task.notify.NotifyStrategy;
import ran.ding.notifying.task.thread.CrawAndNotifyThread;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;

/**
 * 项目启动成功后的检索任务启动runner
 */
@Component
public class NotifyApplicationRunner implements ApplicationRunner {
    @Resource
    private SystemService systemService;

    @Override
    public void run(ApplicationArguments args) {
        systemService.startTask();
    }

}

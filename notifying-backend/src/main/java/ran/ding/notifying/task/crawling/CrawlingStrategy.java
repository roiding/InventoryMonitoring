package ran.ding.notifying.task.crawling;

import ran.ding.notifying.entity.MonitorItem;

public interface CrawlingStrategy {

    boolean isSupply(MonitorItem item);

    int runCrawling(MonitorItem item);
}

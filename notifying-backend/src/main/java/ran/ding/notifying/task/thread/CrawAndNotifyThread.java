package ran.ding.notifying.task.thread;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.task.crawling.CrawlingStrategy;
import ran.ding.notifying.task.notify.NotifyStrategy;

import java.util.List;


@AllArgsConstructor
public class CrawAndNotifyThread implements Runnable{

    private List<CrawlingStrategy> crawlingStrategies;

    private List<NotifyStrategy> notifyStrategies;

    private MonitorItem monitorItem;

    @Override
    public void run() {
        int count=0;
        //执行爬取
        for (CrawlingStrategy crawlingStrategy : crawlingStrategies) {
             if(crawlingStrategy.isSupply(monitorItem)){
                 count=crawlingStrategy.runCrawling(monitorItem);
                 break;
             }
        }
        //有库存，执行推送
        if(count!=0){
            for (NotifyStrategy notifyStrategy : notifyStrategies) {
                notifyStrategy.checkMailSubscribe(monitorItem,count);
            }
        }

    }
}

package ran.ding.notifying.task.crawling.yili;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Component;
import ran.ding.notifying.common.CrawlingTypeCodeEnum;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.task.crawling.CrawlingStrategy;

import java.util.List;

@Component
public class YiLiCrawling implements CrawlingStrategy {

    @Override
    public boolean isSupply(MonitorItem item) {
        return item.getType()== CrawlingTypeCodeEnum.YILI_GAME.getTypeCode();
    }

    @Override
    public int runCrawling(MonitorItem item) {
        String html = HttpUtil.get(item.getUrl());
        List<String> countStr = ReUtil.findAll("var giftcount = (\\d+);", html, 1);
        System.out.println("我在爬.....");
        return Integer.parseInt(countStr.get(0));
    }
}

package ran.ding.notifying.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ran.ding.notifying.common.ResponseResult;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.service.MonitorItemService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/items")
public class MonitorItemController {
    @Resource
    private MonitorItemService monitorItemService;

    @RequestMapping("/getAllMonitorItems")
    public ResponseResult<List<MonitorItem>> getAllMonitorItems(){
        return ResponseResult.buildSuccessResult(monitorItemService.getAllItemMonitor());
    }
}

package ran.ding.notifying.service.impl;

import org.springframework.stereotype.Service;
import ran.ding.notifying.dao.MonitorItemDao;
import ran.ding.notifying.entity.MonitorItem;
import ran.ding.notifying.service.MonitorItemService;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MonitorItemServiceImpl implements MonitorItemService {

    @Resource
    private MonitorItemDao monitorItemDao;


    @Override
    public List<MonitorItem> getAllItemMonitor() {
        return monitorItemDao.getAllMonitor();
    }
}

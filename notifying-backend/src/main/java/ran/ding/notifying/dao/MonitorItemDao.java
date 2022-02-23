package ran.ding.notifying.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ran.ding.notifying.entity.MonitorItem;

import java.util.List;

@Mapper
public interface MonitorItemDao {
    /**
     * 获得所有可以订阅的商品
     * @return
     */
    @Select("select id,name,url,type from monitor_info")
    List<MonitorItem> getAllMonitor();
}

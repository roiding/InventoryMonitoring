package ran.ding.notifying.controller;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ran.ding.notifying.common.ResponseResult;
import ran.ding.notifying.service.SystemService;

import javax.annotation.Resource;

/**
 * 数据库的爬取列表有更新的话，refresh
 */
@RestController
@RequestMapping("/api/system")
public class SystemController {
    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Resource
    private SystemService systemService;

    @RequestMapping("/refresh")
    public ResponseResult refresh(){
        //关闭
        threadPoolTaskScheduler.shutdown();

        //等待线程池关闭的最大时间，然后复用
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(60000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                systemService.startTask();
            }
        }).start();

        return ResponseResult.buildSuccessResult("刷新成功");
    }
}

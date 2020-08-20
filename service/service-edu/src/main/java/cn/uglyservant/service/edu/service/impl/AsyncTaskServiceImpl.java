package cn.uglyservant.service.edu.service.impl;

import cn.uglyservant.service.edu.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author uglys
 * @since 0:35 2020/8/20
 * TODO
 */
@Slf4j
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {

    @Async
    @Override
    public void testAsync() {
        try {
            Thread.sleep(3000);
            log.info("Async task running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

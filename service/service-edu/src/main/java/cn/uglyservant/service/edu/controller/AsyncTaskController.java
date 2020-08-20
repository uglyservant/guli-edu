package cn.uglyservant.service.edu.controller;

import cn.uglyservant.common.global.R;
import cn.uglyservant.service.edu.service.AsyncTaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uglys
 * @since 0:37 2020/8/20
 * TODO
 */
@Api(tags = "异步任务")
@CrossOrigin
@RestController
@RequestMapping("/edu/async-task")
public class AsyncTaskController {

    @Autowired
    AsyncTaskService asyncTaskService;

    @GetMapping("/test")
    public R test() {
        asyncTaskService.testAsync();
        return R.ok(null);
    }
}

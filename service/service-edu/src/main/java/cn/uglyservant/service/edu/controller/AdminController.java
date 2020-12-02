package cn.uglyservant.service.edu.controller;

import cn.uglyservant.common.global.R;
import cn.uglyservant.common.global.V;
import cn.uglyservant.common.service.vo.AdminInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * @author uglys
 * @since 2020-06-23 22:14:23
 * TODO
 */
@Api(tags = "学院后台管理")
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/info")
    public R info() {
        return R.success(new AdminInfo(
                "admin",
                "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
                Collections.singletonList("admin")));
    }

    @PostMapping("/login")
    public R login() {
        return R.success(new V("token", "admin"));
    }

}

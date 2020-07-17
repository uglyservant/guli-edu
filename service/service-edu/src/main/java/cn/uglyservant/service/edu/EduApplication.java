package cn.uglyservant.service.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author uglys
 * Created on 2020/6/6 at 0:37
 * Edu模块启动类
 */
@SpringBootApplication
@MapperScan("cn.uglyservant.service.edu.mapper")
@ComponentScan(basePackages = {"cn.uglyservant.service.edu", "cn.uglyservant.common.service"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}

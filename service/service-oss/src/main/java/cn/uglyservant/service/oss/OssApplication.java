package cn.uglyservant.service.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author uglys
 * Created on 2020/6/6 at 0:37
 * Oss模块启动类
 */
@ComponentScan(basePackages = {"cn.uglyservant.service.oss", "cn.uglyservant.common.service"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}

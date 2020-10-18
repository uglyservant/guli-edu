package cn.uglyservant.common.service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author uglys
 * @since 0:26 2020/8/20
 * 线程池配置类
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {

    /**
     * 核心线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maxPoolSize;

    /**
     * 非核心线程空闲时演出回收时间
     */
    private long keepAliveSeconds;

    /**
     * 阻塞队列大小
     */
    private int queueCapacity;

    /**
     * 线程名称格式
     */
    private String threadNameFormat;
}

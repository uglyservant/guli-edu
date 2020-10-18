package cn.uglyservant.common.service.config;

import cn.uglyservant.common.service.properties.ThreadPoolProperties;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author uglys
 * @since 0:29 2020/8/20
 * 重写Spring默认线程池类
 */
@Slf4j
@EnableAsync
@Configuration
public class ThreadPoolConfig implements AsyncConfigurer {

    @Autowired
    ThreadPoolProperties threadPoolProperties;

    /**
     * @return 自定义线程池
     */
    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolExecutor(
                threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaxPoolSize(),
                threadPoolProperties.getKeepAliveSeconds(),
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(threadPoolProperties.getQueueCapacity()),
                new ThreadFactoryBuilder().setNameFormat(threadPoolProperties.getThreadNameFormat()).build()
        );
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> log.error("Exception method: {}", method.getName(), throwable);
    }
}

package cn.uglyservant.common.service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author uglys
 * @since 21:27 2020/7/6
 * 阿里云OSS服务配置类
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {

    /**
     * 节点名称
     */
    private String endpoint;

    /**
     * 桶名称
     */
    private String bucketName;

    /**
     * 密钥ID
     */
    private String keyId;

    /**
     * 密钥
     */
    private String keySecret;
}

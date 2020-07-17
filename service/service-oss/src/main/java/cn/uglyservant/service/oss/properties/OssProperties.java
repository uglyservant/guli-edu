package cn.uglyservant.service.oss.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author uglys
 * @since 21:27 2020/7/6
 * TODO
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {
    private String endpoint;
    private String bucketName;
    private String keyId;
    private String keySecret;
}

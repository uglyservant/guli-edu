package cn.uglyservant.service.oss.service.impl;

import cn.uglyservant.common.global.exception.GuliException;
import cn.uglyservant.service.oss.properties.OssProperties;
import cn.uglyservant.service.oss.service.OssService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @author uglys
 * @since 21:42 2020/7/6
 * TODO
 */
@Slf4j
@Service
public class OssServiceImpl implements OssService {

    @Autowired
    OssProperties ossProperties;

    @Override
    public String uploadAvatar(String accountId, MultipartFile avatar) {
        OSS ossClient = new OSSClientBuilder().build(
                ossProperties.getEndpoint(),
                ossProperties.getKeyId(),
                ossProperties.getKeySecret()
        );
        try {
            Objects.requireNonNull(avatar.getOriginalFilename());
            String avatarPath = "avatar/"
                    + accountId
                    + avatar.getOriginalFilename().substring(avatar.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            ossClient.putObject(ossProperties.getBucketName(), avatarPath, avatar.getInputStream());
            return "https://" +
                    ossProperties.getBucketName() + "." +
                    ossProperties.getEndpoint() + "/" +
                    avatarPath;
        } catch (IOException | NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new GuliException("上传文件异常");
        } finally {
            ossClient.shutdown();
            log.info("Oss client shutdown in expected");
        }
    }
}

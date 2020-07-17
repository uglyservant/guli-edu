package cn.uglyservant.service.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author uglys
 * @since 21:41 2020/7/6
 * TODO
 */
public interface OssService {
    String uploadAvatar(String accountId, MultipartFile avatar);
}

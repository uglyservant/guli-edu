package cn.uglyservant.service.oss.controller;

import cn.uglyservant.common.global.R;
import cn.uglyservant.common.service.dto.AvatarUpload;
import cn.uglyservant.common.global.V;
import cn.uglyservant.service.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uglys
 * @since 21:41 2020/7/6
 * TODO
 */
@CrossOrigin
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/uploadAvatar")
    public R uploadAvatar(AvatarUpload avatarUpload) {
        String fileUri = ossService.uploadAvatar(avatarUpload.getAccountId(), avatarUpload.getAvatar());
        return R.ok(new V("fileUri", fileUri));
    }
}

package cn.uglyservant.service.oss.controller;

import cn.uglyservant.common.global.R;
import cn.uglyservant.common.global.V;
import cn.uglyservant.common.service.dto.AvatarUpload;
import cn.uglyservant.service.oss.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "上传服务")
@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @ApiOperation("上传头像")
    @PostMapping("/avatar")
    public R uploadAvatar(AvatarUpload avatarUpload) {
        String fileUri = uploadService.uploadAvatar(avatarUpload.getAccountId(), avatarUpload.getAvatar());
        return R.success(new V("fileUri", fileUri));
    }
}

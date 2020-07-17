package cn.uglyservant.common.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author uglys
 * @since 14:41 2020/7/12
 * TODO
 */
@ApiModel("讲师查询条件")
@Getter
@Setter
public class AvatarUpload {

    @ApiModelProperty("用户ID")
    String accountId;


    @ApiModelProperty("头像数据")
    MultipartFile avatar;
}

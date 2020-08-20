package cn.uglyservant.service.edu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author uglyservant
 * @since 2020-07-18
 */
@Data
@TableName("edu_subject")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Subject对象", description = "课程科目")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程类别ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "类别名称")
    private String title;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", example = "2020-06-18", hidden = true)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", example = "2020-06-18", hidden = true)
    private Date gmtModified;


}

package cn.uglyservant.common.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author uglys
 * Created on 2020/6/13 at 19:38
 * TODO
 */
@ApiModel("讲师查询条件")
@Getter
@Setter
public class TeacherQuery {

    @ApiModelProperty("讲师姓名")
    private  String name;

    @ApiModelProperty("讲师等级")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2020-06-18 00:00:00")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2020-06-18 23:59:59")
    private String end;
}

package cn.uglyservant.common.global;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author uglys
 * Created on 2020/6/13 at 12:15
 * TODO
 */
@ApiModel("统一返回结果")
@Setter
@Getter
@Accessors(chain = true)
public class R {

    @ApiModelProperty(value = "结果代码")
    Integer code;

    @ApiModelProperty(value = "结果描述")
    String message;

    @ApiModelProperty(value = "结果数据")
    Object data;

    private R() {
    }

    public static R ok(Object o) {
        return new R().setCode(ResultCode.SUCCESS).setMessage(ResultMessage.SUCCESS).setData(o);
    }

    public static R error(Object o) {
        return new R().setCode(ResultCode.ERROR).setMessage(ResultMessage.ERROR).setData(o);
    }

}

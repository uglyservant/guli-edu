package cn.uglyservant.common.global;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author uglys
 * Created on 2020/6/13 at 12:15
 * 统一返回结果
 */
@Getter
@ApiModel("统一返回结果")
public class R {

    @ApiModelProperty(value = "结果代码")
    private final Integer code;

    @ApiModelProperty(value = "结果描述")
    private final String msg;

    @ApiModelProperty(value = "结果数据")
    private final Object data;

    private R(Result result, Object data) {
        this.code = result.code;
        this.msg = result.msg;
        this.data = data;
    }

    public static R success(Object data) {
        return new R(Result.SUCCESS, data);
    }

    public static R error(Object data) {
        return new R(Result.ERROR, data);
    }

    private enum Result {

        SUCCESS(20000, "请求成功"),
        ERROR(50000, "内部错误");

        private final Integer code;
        private final String msg;

        Result(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}

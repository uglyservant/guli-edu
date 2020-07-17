package cn.uglyservant.common.service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author uglys
 * Created on 2020/6/13 at 19:30
 * 分页查询讲师结果对象
 */
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class PageObject {

    private Long total;

    private Object rows;
}

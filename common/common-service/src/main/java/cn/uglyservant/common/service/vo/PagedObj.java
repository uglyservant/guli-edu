package cn.uglyservant.common.service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author uglys
 * Created on 2020/6/13 at 19:30
 * 分页查询讲师结果对象
 */
@Getter
@AllArgsConstructor
public class PagedObj {

    private final Long total;

    private final Object records;
}

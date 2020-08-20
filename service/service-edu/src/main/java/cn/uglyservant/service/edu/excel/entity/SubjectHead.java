package cn.uglyservant.service.edu.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author uglys
 * @since 2:08 2020/7/18
 * Excel 课程实体类
 */
@Getter
@Setter
@ToString
public class SubjectHead {

    @ExcelProperty(index = 0)
    private String firstLevel;

    @ExcelProperty(index = 1)
    private String secondaryLevel;
}

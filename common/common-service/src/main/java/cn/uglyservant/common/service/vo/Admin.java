package cn.uglyservant.common.service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author uglys
 * @since 22:22 2020/6/23
 * TODO
 */
@Getter
@AllArgsConstructor
public class Admin {

    private final String name;

    private final String avatar;

    private final List<String> roles;

}

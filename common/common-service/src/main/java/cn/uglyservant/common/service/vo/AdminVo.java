package cn.uglyservant.common.service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author uglys
 * @since 22:22 2020/6/23
 * TODO
 */
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class AdminVo {

    String name;

    String avatar;

    List<String> roles;

}

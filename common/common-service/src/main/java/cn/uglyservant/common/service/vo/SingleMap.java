package cn.uglyservant.common.service.vo;

import java.util.HashMap;

/**
 * @author uglys
 * @since 11:40 2020/6/27
 * TODO
 */
public class SingleMap extends HashMap<String, Object> {
    public SingleMap(String key, Object value) {
        this.put(key, value);
    }
}

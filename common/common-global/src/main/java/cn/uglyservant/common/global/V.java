package cn.uglyservant.common.global;

import cn.uglyservant.common.global.exception.GuliException;

import java.util.HashMap;
import java.util.List;

/**
 * @author uglys
 * @since 11:40 2020/6/27
 * 自定义Map类
 */
public class V extends HashMap<String, Object> {

    public V(String key, Object value) {
        this.put(key, value);
    }

    public V(List<String> keys, List<Object> values) {
        if (keys.size() != values.size()) {
            throw new GuliException(String.format("键值长度不匹配，keys.size()：%s，values.size()：%s", keys.size(), values.size()));
        }
        for (int i = 0; i < keys.size(); i++) {
            this.put(keys.get(i), values.get(i));
        }
    }
}

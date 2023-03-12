package com.yoyoping.admin.utils;

import org.springframework.beans.BeanUtils;

public class CBeanUtil {

    /**
     * 功能描述：浅拷贝 - 转换Bean对象
     *
     * @param sourceObject
     * @param clazz
     * @return
     * @author Elivense White
     */
    public static <T> T convertToBean(Object sourceObject, Class<T> clazz) {
        T result = null;
        if (sourceObject != null) {
            try {
                result = clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(sourceObject, result);
        }
        return result;
    }
}

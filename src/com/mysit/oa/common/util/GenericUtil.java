package com.mysit.oa.common.util;

import com.mysit.oa.common.exception.S2shException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtil {


    public static Class getGenericActualTypeParameterBySupperClass(Class clazz, Integer index) {
        if (clazz == null) {
            throw new S2shException("getGenercActualTypeParamenterBySupperClass的Class参数为空");
        }
        if (index == null || index < 0) {
            throw new S2shException("getGenercActualTypeParamenterBySupperClass的index参数为空");
        }
//        获取这个类的父类类型
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass!=null) {
//         转型成为参数类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (ArrayUtils.isNotEmpty(actualTypeArguments)) {

                if(index<actualTypeArguments.length){
                    return (Class) actualTypeArguments[index];
            }
                return Object.class;
            }
        }
        return Object.class;
    }
}

package com.lhyzp.excel;

/**
 * 字段值转换方法接口
 * Created by Administrator on 2017-11-29.
 */
public interface ConvertValue {
    String convert(Object obj);
    String convert(String obj);
}

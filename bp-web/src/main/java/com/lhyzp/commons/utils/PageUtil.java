package com.lhyzp.commons.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * JPA获取分页对象工具
 */
public class PageUtil {


    public static PageRequest getPageRequest(int page, int size, Sort sort){

        return new PageRequest(page,size,sort);
    }

}

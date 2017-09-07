package com.lhyzp.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 判断对象、字符串、集合是否为空、不为空
 */
public final class StringUtils {
	/**
	 *  判断字符串是否为空
	 * @param string
	 * @return boolean
	 */
	public static boolean isEmptyString(String string){
		if (string == null || string.length() == 0&&"".equals(string)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 *  判断字符串是否不为空
	 *  "" null 返回true
	 * @param string
	 * @return boolean
	 */
	public static boolean isNotEmptyString(String string){
		if (string != null && string.length() > 0&&!"".equals(string)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 *  判断集合是否为空
	 * @param collection
	 * @return boolean
	 */
	public static boolean isEmptyCollection(Collection<?> collection){
		if (collection == null || collection.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 *  判断集合是否不为空
	 * @param collection
	 * @return boolean
	 */
	public static boolean isNotEmptyCollection(Collection<?> collection){
		if (collection != null && !collection.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 *  判断map集合是否不为空
	 * @param map
	 * @return boolean
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmptyMap(Map map){
		if (map != null && !map.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 *  判断map集合是否为空
	 * @param map
	 * @return boolean
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmptyMap(Map map){
		if (map == null || map.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 是否为空
	 *
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String) {
			String instance = (String) obj;
			if (instance.trim().length() <= 0 || "null".equalsIgnoreCase(instance)) {
				return true;
			}
		} else if (obj instanceof Integer) {
			Integer instance = (Integer) obj;
			if (instance < 0) {
				return true;
			}
		} else if (obj instanceof List<?>) {
			List<?> instance = (List<?>) obj;
			if (instance.size() <= 0) {
				return true;
			}
		} else if (obj instanceof Map<?, ?>) {
			Map<?, ?> instance = (Map<?, ?>) obj;
			if (instance.size() <= 0) {
				return true;
			}
		} else if (obj instanceof Object[]) {
			Object[] instance = (Object[]) obj;
			if (instance.length <= 0) {
				return true;
			}
		} else if (obj instanceof Long) {
			Long instance = (Long) obj;
			if (instance < 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 不为空判断
	 * @param obj
	 * @return
	 */
	public static boolean notEmpty(Object obj) {
		return !isEmpty(obj);
	}
}

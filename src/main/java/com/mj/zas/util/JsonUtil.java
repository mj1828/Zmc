package com.mj.zas.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: JsonUtil
 * @Description: 将List转换为JSONArray
 * @author: Zyc
 * @date: 2018年1月27日 下午12:58:25
 */
public class JsonUtil {
	private static ObjectMapper mapper = new ObjectMapper();

	public static String toJsonString(Object o) {
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
}

package com.mj.zas.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: ResultUtil
 * @Description: 返回信息工具类
 * @author: Zyc
 * @date: 2018年1月14日 下午12:49:23
 */
public class ResultUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * @Description: 成功
	 * @param: message
	 */
	public static String success(Object message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Result", true);
		result.put("Status", 1);
		result.put("Message", message);
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";

	}

	/**
	 * @Description: 失败
	 * @param: message
	 */
	public static String fail(Object message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Result", false);
		result.put("Status", 0);
		result.put("Message", message);
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String needLogin(Object message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Result", false);
		result.put("Status", 0);
		result.put("NeedLogin", message);
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
}

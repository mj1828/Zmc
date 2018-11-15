package com.mj.zas.util;

import javax.servlet.http.HttpServletRequest;

/**
 * http请求工具类
 * 
 * @author zyc
 *
 */
public class HttpUtil {

	public static boolean isAjax(HttpServletRequest request) {
		boolean result = false;
		String requestType = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(requestType)) {
			result = true;
		}
		return result;
	}
}

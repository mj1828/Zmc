package com.mj.zas.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.mj.zas.util.ResultUtil;

/**
 * 自定义登录成功拦截
 * 
 * @author zyc
 *
 */
@Component
public class MJAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	/**
	 * 根据请求类型，执行后续操作。1. Ajax 请求返回json数据 2. 表单提交，页面跳转
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write(ResultUtil.success("{'result':'data'}").toString());
		out.flush();
		out.close();
		// logger.info("判断请求");
		// // if (HttpUtil.isAjax(request)) {
		// logger.info("Ajax请求");
		// RequestCache requestCache = new HttpSessionRequestCache();
		// SavedRequest savedRequest = requestCache.getRequest(request, response);
		// String targetUrl = savedRequest.getRedirectUrl();
		// response.setContentType("application/json;charset=utf-8");
		// PrintWriter out = response.getWriter();
		// // ObjectMapper objectMapper = new ObjectMapper();
		// //
		// out.write(ResultUtil.success(objectMapper.writeValueAsString(UserUtil.getCurrentHr())).toString());
		// out.write(ResultUtil.success(targetUrl).toString());
		// out.flush();
		// out.close();
		// } else {
		// super.onAuthenticationSuccess(request, response, authentication);
		// }
	}
}

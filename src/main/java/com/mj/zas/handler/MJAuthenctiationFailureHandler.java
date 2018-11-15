package com.mj.zas.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.mj.zas.util.ResultUtil;

/**
 * 自定义登录失败
 * 
 * @author zyc
 *
 */
@Component
public class MJAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	/**
	 * 登录失败，默认使用Ajax登录，返回json格式数据
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
			out.write(ResultUtil.fail("用户名或密码输入错误，登录失败!").toString());
		} else if (exception instanceof DisabledException) {
			out.write(ResultUtil.fail("账户被禁用，登录失败，请联系管理员!").toString());
		} else {
			out.write(ResultUtil.fail("登录失败!").toString());
		}
		out.flush();
		out.close();
	}
}

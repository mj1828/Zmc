package com.mj.zas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.zas.util.ResultUtil;
import com.mj.zas.util.UserUtil;

@RestController
@CrossOrigin
public class LoginController {

	@GetMapping("/doLogin")
	public String doLogin() {
		String userInfo = UserUtil.getCurrentUser();
		if (userInfo.equals("anonymousUser")) {
			return ResultUtil.needLogin("未登录");
		}
		return ResultUtil.success(userInfo);
	}

}

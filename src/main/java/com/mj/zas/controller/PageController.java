package com.mj.zas.controller;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/login")
	public String login(HttpRequest request) {
		System.out.println(request.toString());
		return "login";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}

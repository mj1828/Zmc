package com.mj.zas.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class UserUtil {

	public static User getCurrentHr() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public static String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}
}

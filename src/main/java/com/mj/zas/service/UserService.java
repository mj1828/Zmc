package com.mj.zas.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mj.zas.entity.ZAUser;

public interface UserService extends UserDetailsService {

	String delete(String id);

	String list(Map<String, Object> param, int pageNum, int pageSize);

	ZAUser selectByName(String userName);

	ZAUser selectById(String userName);

	String save(ZAUser user);
}

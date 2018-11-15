package com.mj.zas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mj.zas.entity.ZAUser;
import com.mj.zas.mapper.ZAUserMapper;
import com.mj.zas.service.UserService;
import com.mj.zas.util.JsonUtil;
import com.mj.zas.util.ResultUtil;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @author: Zyc
 * @date: 2018年1月13日 下午1:18:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	ZAUserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ZAUser user = selectByName(username);
		if (user != null) {
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			// TODO 获取用户权限
			authorities.add(new SimpleGrantedAuthority("all"));
			return new User(user.getUserName(), user.getPassword(), authorities);
		} else {
			throw new UsernameNotFoundException("admin: " + username + " do not exist!");
		}
	}

	@Override
	public String delete(String id) {
		String message = "删除用户信息失败！";
		if (StringUtils.isEmpty(id)) {
			message = "ID 为空，删除用户信息失败！";
		} else {
			int result = userMapper.delete(id);
			if (result > 0) {
				message = "删除用户信息成功！";
				return ResultUtil.success(message);
			}
		}
		return ResultUtil.fail(message);
	}

	@Override
	public String list(Map<String, Object> param, int pageNum, int pageSize) {
		PageHelper.offsetPage(pageNum * pageSize, pageSize);
		List<ZAUser> list = userMapper.listByParam(param);
		return ResultUtil.success(JsonUtil.toJsonString(new PageInfo(list)));
	}

	@Override
	public ZAUser selectByName(String userName) {
		return userMapper.selectByName(userName);
	}

	@Override
	public ZAUser selectById(String id) {
		return userMapper.selectById(id);
	}

	@Override
	public String save(ZAUser user) {
		if (user != null) {
			if (user.getId() != null) {
				user.setUpdateTime(new Date());
				user.setUpdateUser("Admin");
				int result = userMapper.update(user);
				if (result > 0) {
					return ResultUtil.success("更新用户成功！");
				}
				return ResultUtil.fail("更新用户失败！");
			} else {
				user.setAddTime(new Date());
				user.setAddUser("Admin");
				int result = userMapper.insert(user);
				if (result > 0) {
					return ResultUtil.success("添加用户成功！");
				}
				return ResultUtil.fail("添加用户失败！");
			}
		}
		return ResultUtil.fail("操作用户信息失败！");
	}

}

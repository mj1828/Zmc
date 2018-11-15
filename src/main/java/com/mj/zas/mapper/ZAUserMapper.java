package com.mj.zas.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mj.zas.entity.ZAUser;

@Mapper
public interface ZAUserMapper {

	int delete(String id);

	int insert(ZAUser record);

	List<ZAUser> listByParam(Map<String, Object> param);

	ZAUser selectById(String id);

	ZAUser selectByName(String userName);

	int update(ZAUser user);

}
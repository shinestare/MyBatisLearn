package com.wang.map;

import org.apache.ibatis.annotations.Delete;


public interface MyUserMapInterface {
	// 使用注解方式
	@Delete("delete from myuser where id = #{id}")
	public void deleteUser(int id);
}

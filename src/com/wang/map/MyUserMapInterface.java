package com.wang.map;

import org.apache.ibatis.annotations.Delete;


public interface MyUserMapInterface {
	// ʹ��ע�ⷽʽ
	@Delete("delete from myuser where id = #{id}")
	public void deleteUser(int id);
}

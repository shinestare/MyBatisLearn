package com.wang.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.map.MyUserMapInterface;
import com.wang.pojo.MyUser;

public class TestUpdate {
	
	public static void main(String[] args) {
		String resource = "com/wang/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		session = sqlMapper.openSession();
		try {
			/*
			// insert测试
			MyUser myUser = new MyUser();
			myUser.setUsername("user001");
			myUser.setPassword("m001");
			session.insert("insertUser", myUser);
			session.commit();*/
			
			/*// update测试
			MyUser updateUser = new MyUser();
			updateUser.setUsername("updateUser");
			updateUser.setPassword("666");
			updateUser.setId(2);
			session.update("updateUser", updateUser);
			session.commit();*/
			
			// delete测试,用注解实现的方式，先实现接口
			MyUserMapInterface user = session.getMapper(MyUserMapInterface.class);
			user.deleteUser(3);
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}

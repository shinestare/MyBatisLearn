package com.wang.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.pojo.MyReader;
import com.wang.pojo.MyUser;

public class TestSelect {
	
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
			// hashmap格式参数
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("username", "helloworld");
			paramMap.put("password", "a");
			MyUser myUser = session.selectOne("loginSelect", paramMap);
			if (myUser != null) {
				System.out.println("登陆成功");
			}*/
			
			/*// 对象格式参数
			MyUser user = new MyUser();
			user.setUsername("helloworld");
			user.setPassword("a");
			MyUser temp = session.selectOne("login2", user);
			if (temp != null) {
				System.out.println("2成功");
			}
			*/
			
			/*// list对象格式返回
			List<MyUser> list = session.selectList("selectUserList");
			for (MyUser user : list) {
				System.out.println("用户名= " + user.getUsername());
			}*/
			
			// resultMap格式返回
			List<MyUser> list = session.selectList("selectUsers");
			for (MyUser user : list) {
				System.out.println("用户名= " + user.getUsername());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
	}
}

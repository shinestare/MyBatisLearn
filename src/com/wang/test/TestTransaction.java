package com.wang.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.pojo.Author;
import com.wang.pojo.MyUser;

public class TestTransaction {
	public static void main(String[] args) {
		String resource = "com/wang/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		session = factory.openSession(false);	// 关闭自动提交
		
		try {
			MyUser user = new MyUser();
			user.setUsername("useruser");
			user.setPassword("pass");
			session.insert("insertUser", user);
			System.out.println("新加入的user id= " + user.getId());
			
			Author auth = new Author();
			auth.setUser(user);
			auth.setRealName("realnamea");
//			auth.setIDCard("123");
			session.insert("insertAuthor", auth);
			session.commit();	// 提交事务
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();	// 回滚事务
		} finally {
			session.close();	// 关闭session
		}
		
	}
}

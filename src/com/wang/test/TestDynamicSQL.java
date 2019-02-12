package com.wang.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.pojo.Author;
import com.wang.pojo.MyReader;
import com.wang.pojo.MyUser;

/**
 * 动态SQL
 * @author wang
 *
 */
public class TestDynamicSQL {
	
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
			/*MyReader myReader = new MyReader();
			myReader.setMoney(200);	// 删除此行，即不设置money，此时值为null，查出来的是全部的
			
			List<MyReader> list = session.selectList("selectReaderMoney", myReader);
			
			for (MyReader oneReader : list) {
				System.out.println("查询到的ReaderID=" + oneReader.getId());
			}*/
			
			/*// 动态SQL，choose条件
			MyUser myUser = new MyUser();
//			myUser.setUsername("%user%");	
//			myUser.setId(10);
			
			List<MyUser> list = session.selectList("selectMyuserChoose", myUser);
			
			for (MyUser oneUser : list) {
				System.out.println("查询到的UserID=" + oneUser.getId() + ",用户名=" + oneUser.getUsername());
			}*/
			
			/*// 动态SQL，where条件
			MyUser myUser = new MyUser();
			myUser.setUsername("%user%");	
			myUser.setId(10);
			
			List<MyUser> list = session.selectList("selectMyuserWhere", myUser);
			
			for (MyUser oneUser : list) {
				System.out.println("查询到的UserID=" + oneUser.getId() + ",用户名=" + oneUser.getUsername());
			}*/
			
			/*// 动态SQL，set标记
			MyUser myUser = new MyUser();
			myUser.setId(10);
			myUser.setUsername("newusername");	
			myUser.setPassword("newpass");	
			
			session.update("updateMyuserSet", myUser);
			session.commit();*/
			
			/*// 动态SQL，trim标记
			MyUser myUser = new MyUser();
			myUser.setId(10);
			myUser.setUsername("username");	
			myUser.setPassword("pass");	
			
			session.update("updateMyuserTrim", myUser);
			session.commit();*/
			
			/*// 动态SQL，foreach标记,查询多个记录
			List<Integer> ids = new ArrayList();
			ids.add(1);
			ids.add(2);
			ids.add(10);
			List<MyUser> list = session.selectList("selectMyuserForeach", ids);
			for (MyUser oneUser : list) {
				System.out.println("查询到的UserID=" + oneUser.getId() + ",用户名=" + oneUser.getUsername());
			}*/
			
			// 动态SQL，foreach标记,查询多个记录
			List<MyUser> users = new ArrayList();
			MyUser user1 = new MyUser("user1", "pass1");
			MyUser user2 = new MyUser("user2", "pass2");
			users.add(user1);
			users.add(user2);
			session.insert("insertMyuserForeach", users);
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
	}
}

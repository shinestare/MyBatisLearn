package com.wang.dbutils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.pojo.NewUser;

public class MySqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	//初始化创建SqlSessionFactory对象
	static {
		try {
			// 读取mybatis的config.xml文件
			InputStream inputStream = Resources.getResourceAsStream("com/wang/map/MyBatisConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	// 获取SqlSession对象的静态方法
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	// 获取SqlSessionFactory的静态方法
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		// 获得Session对象
		SqlSession session = MySqlSessionFactory.getSqlSession();
		
		/*//创建对象
		NewUser user = new NewUser("jack", "jackaaa");
		// 插入数据
		session.insert("com.wang.test.NewMapper.saveUser", user);*/
		
		/*// 查询数据,根据id查询NewUser对象
		NewUser user = session.selectOne("com.wang.test.NewMapper.selectUser", 1);
		System.out.println(user.toString());*/
		
		/*// 查询数据,根据id查询NewUser对象
		NewUser user = session.selectOne("com.wang.test.NewMapper.selectUser", 1);
		// 修改NewUser对象的属性值
		user.setUsername("aa");
		user.setPassword("123");
		// 修改NewUser对象
		session.update("com.wang.test.NewMapper.updateUser", user);*/
		
		// 删除id=1的NewUser对象
		session.delete("com.wang.test.NewMapper.deleteUser", 1);
		
		// 提交事务
		session.commit();
		// 关闭session
		session.close();
	}
}

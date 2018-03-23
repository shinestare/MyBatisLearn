package com.wang.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.pojo.Author;

/**
 * ������ѯ
 * @author wang
 *
 */
public class TestAssociation {
	
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
//			List<Author> list = session.selectList("selectAuthorJoin");		// ������ʽ
//			List<Author> list = session.selectList("selectAuthorJoin2");	// ���캯����ʽ
			List<Author> list = session.selectList("selectSubAuthor");	// �Ӳ�ѯ
			for (Author author : list) {
				System.out.println("��ʵ������" + author.getRealName() + 
						"����Ӧ�û�����" + author.getUser().getUsername());
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
	}
}

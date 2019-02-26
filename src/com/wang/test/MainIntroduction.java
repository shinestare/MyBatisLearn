package com.wang.test;

public class MainIntroduction {
	public static void main(String[] args) {
		/**
		 * SqlSessionFactory是MyBatis的关键对象，它是单个数据库映射关系经过编译后的内存镜像。
		 * SqlSessionFactory对象的实例可以通过SqlSessionFactoryBuilder对象获得，
		 * 而SqlSessionFactoryBuilder则可以从XML配置文件或一个预先定制的Configration的实例构建出SqlSessionFactory的实例。
		 * 每一个MyBatis的应用程序都以一个SqlSessionFactory对象的实例为核心。其也是线程安全的，SqlSessionFactory一旦创建，应该在应用执行期间都存在。
		 * 在应用运行期间不要重复创建多次，建议使用单例模式。SqlSessionFactory是创建SqlSession的工厂。
		 */
		
		/**
		 * SqlSession是MyBatis的关键对象，是执行持久化的对象，类似于JDBC中的Connection。
		 * 它是应用程序与持久化层之间执行交互操作的一个单线程对象，也是MyBatis执行持久化操作的关键对象。
		 * SqlSession对象完全包含以数据库为背景的所有执行SQL操作的方法，它的底层封装了JDBC连接，可以用SqlSession实例来直接执行已映射的SQL语句。
		 * 每个线程都应该有自己的SqlSession实例。SqlSession实例不能被共享，也是线程不安全的，决不能将SqlSession实例的引用放在一个类的静态字段甚至是实例字段中。
		 * 也决不能将SqlSession实例的引用放在任何类型的管理范围中，比如Servlet当中的HttpSession对象中。
		 * 使用完SqlSession之后关闭Session很重要，应该确保使用finally块来关闭它。
		 */
	}
}

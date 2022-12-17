package com.atguigu.test;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DataSourceTest {
	
	public static ApplicationContext app= null;
	
	static {
		app = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test1() throws Exception {
		
		DruidDataSource dataSource = app.getBean("dataSource", DruidDataSource.class);
		DruidPooledConnection connection = dataSource.getConnection();
		System.out.println(connection);    //com.mysql.jdbc.JDBC4Connection@52e6fdee测试成功
		connection.close();
		
	}
	

}

package com.atguigu.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtils {
	
	@Autowired
	private SessionFactory sessionFactory;

	// 开启一个会话，提交后会自动关闭会话
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// 开启一个会话，提交后需要手动关闭会话
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	// 关闭会话
	public void closeSession(Session session) {
		if (session != null & session.isOpen()) {
			try {
				session.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}


}

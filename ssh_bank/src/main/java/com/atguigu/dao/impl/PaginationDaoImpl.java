package com.atguigu.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.dao.PaginationDao;
import com.atguigu.entities.Customer;
import com.atguigu.utils.HibernateUtils;


@Repository
public class PaginationDaoImpl implements PaginationDao{

	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public List<Customer> getAllListPage(Customer customer) {
		
		Session session = hibernateUtils.getSession();
		//动态查询 
		String sql = "from Customer where 1=1";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		if (customer.getFullName() != "") {
			sb.append("and fullName like '%").append(customer.getFullName()).append("%'");
		}
		if (customer.getAdmin() != "") {
			sb.append("and admin like '%").append(customer.getAdmin()).append("%'");
		}
		if (customer.getDepartment() != "") {
			sb.append("and department like '%").append(customer.getDepartment()).append("%'");
		}
		if (customer.getService() != "") {
			sb.append("and service like '%").append(customer.getService()).append("%'");
		}
		if (customer.getJobKind() != "") {
			sb.append("and jobKind like '%").append(customer.getJobKind()).append("%'");
		}
		if (customer.getPhase() != "") {
			sb.append("and phase like '%").append(customer.getPhase()).append("%'");	
		} 
		/* sb.append("order by cid desc"); //根据cid进行排序   */ 
		Query query = session.createQuery(sb.toString());
		//进行分页查询
		query.setFirstResult(customer.getOffset());
		query.setMaxResults(customer.getLimit());
		List<Customer> list = query.list();
		return list;		
	}

	@Override
	public Integer getTotal() {
		Session session = hibernateUtils.getSession();
		Query query = session.createQuery("select COUNT(1) from Customer");
		Long obj = (Long)query.uniqueResult();
		int count = obj.intValue();
		return count;
	}

}

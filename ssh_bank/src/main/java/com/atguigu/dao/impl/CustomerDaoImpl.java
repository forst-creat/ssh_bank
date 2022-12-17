package com.atguigu.dao.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.entities.Result;
import com.alibaba.fastjson.JSONArray;
import com.atguigu.dao.CustomerDao;
import com.atguigu.entities.CustPeople;
import com.atguigu.entities.Customer;
import com.atguigu.entities.PartPrincipal;
import com.atguigu.entities.Principal;
import com.atguigu.utils.HibernateUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateUtils hibernateUtils;

	// 添加
	@Override
	public void insertAllOrPart(Result result) {
		// 开启session
		 Session session = hibernateUtils.getSession();
						Customer customer = new Customer();
						customer.setCid(result.getCustomer().getCid());
						customer.setFullName(result.getCustomer().getFullName());
						customer.setSingleName(result.getCustomer().getSingleName());
						customer.setProgrameName(result.getCustomer().getProgrameName());
						customer.setService(result.getCustomer().getService());
						customer.setJobKind(result.getCustomer().getJobKind());
						customer.setPhase(result.getCustomer().getPhase());
						customer.setPlace(result.getCustomer().getPlace());
						customer.setAdmin(result.getCustomer().getAdmin());
						customer.setDepartment(result.getCustomer().getDepartment());
						customer.setCreateTime(new Date());
						customer.setStartTime(result.getCustomer().getStartTime());
						customer.setEndTime(result.getCustomer().getEndTime());
						customer.setInstruction(result.getCustomer().getInstruction());
						customer.setTarget(result.getCustomer().getTarget());
						customer.setContent(result.getCustomer().getContent());
						customer.setEffect(result.getCustomer().getEffect());
						if (result.getCustpeople().size() > 0) {
							List<CustPeople> custs = result.getCustpeople();
							for (CustPeople custPeople : custs) {
								customer.getSetCustPeople().add(custPeople);
							}
						}
						if (result.getPartprincipal().size() > 0) {
							List<PartPrincipal> parts = result.getPartprincipal();
							for (PartPrincipal partPrincipal : parts) {	
								customer.getSetPartPrincipal().add(partPrincipal);
							}
						}					
						if (result.getPrincipal().size() > 0) {
							List<Principal> principals = result.getPrincipal();
							for (Principal principal : principals) {
								customer.getSetPrincipal().add(principal);
							}
							
						}
				session.saveOrUpdate(customer);
	}

	
	//删除
	@Override
	public void deleteCust(List<Integer> idList) {
		
		Session session = hibernateUtils.getSession();
		for (int i = 0; i < idList.size(); i++) {
			//根据id来查customer客户
			Customer customer = session.get(Customer.class, idList.get(i));
			//调用delete方法删除
			session.delete(customer);
		}
		
	}


	//编辑-----动态表格
	@Override
	public Result editCust(Integer id) {
		
		Session session = hibernateUtils.getSession();
		Customer customer = session.get(Customer.class, id);
		Set<Principal> setPrincipal = customer.getSetPrincipal();
		List<Principal> principals = new ArrayList<Principal>();
		for (Principal principal : setPrincipal) {
			principals.add(principal);
		}
		Set<CustPeople> setCustPeople = customer.getSetCustPeople();
		List<CustPeople> custPeoples = new ArrayList<CustPeople>();
		for (CustPeople custPeople : setCustPeople) {
			custPeoples.add(custPeople);
		}
		Set<PartPrincipal> setPartPrincipal = customer.getSetPartPrincipal();
		List<PartPrincipal> partPrincipals = new ArrayList<PartPrincipal>();
		for (PartPrincipal partPrincipal : setPartPrincipal) {
			partPrincipals.add(partPrincipal);
		}
		
		Result result = new Result();
		result.setPrincipal(principals);
		result.setCustomer(customer);
		result.setPartprincipal(partPrincipals);
		result.setCustpeople(custPeoples);	
		
		return result;
	}

	//更新
	@Override
	public void updateCust(Result result) {
		Session session = hibernateUtils.getSession();
		Customer customer = session.get(Customer.class, result.getCustomer().getCid());
		customer.setFullName(result.getCustomer().getFullName());
		customer.setSingleName(result.getCustomer().getSingleName());
		customer.setProgrameName(result.getCustomer().getProgrameName());
		customer.setService(result.getCustomer().getService());
		customer.setJobKind(result.getCustomer().getJobKind());
		customer.setPhase(result.getCustomer().getPhase());
		customer.setPlace(result.getCustomer().getPlace());
		customer.setAdmin(result.getCustomer().getAdmin());
		customer.setDepartment(result.getCustomer().getDepartment());
		customer.setCreateTime(new Date());
		customer.setStartTime(result.getCustomer().getStartTime());
		customer.setEndTime(result.getCustomer().getEndTime());
		customer.setInstruction(result.getCustomer().getInstruction());
		customer.setTarget(result.getCustomer().getTarget());
		customer.setContent(result.getCustomer().getContent());
		customer.setEffect(result.getCustomer().getEffect());
		if (result.getPrincipal().size() > 0 ) {
			List<Principal> principals = result.getPrincipal();
			for (Principal principal : principals) {
				if(principal.getPid() != null){
					Principal principal1 = session.get(Principal.class, principal.getPid());
					principal1.setPname(principal.getPname());
					principal1.setIdentity(principal.getIdentity());
					principal1.setDname(principal.getDname());
					customer.getSetPrincipal().add(principal1);
				}else {
					customer.getSetPrincipal().add(principal);
				}
			}
		}
		
		if (result.getCustpeople().size() > 0) {
			List<CustPeople> custPeoples = result.getCustpeople();
			for (CustPeople custPeople : custPeoples) {
				if (custPeople.getCpid() != null) {
					CustPeople custPeople1 = session.get(CustPeople.class, custPeople.getCpid());
					custPeople1.setCpname(custPeople.getCpname());
					custPeople1.setDuty(custPeople.getDuty());
					custPeople1.setMobile(custPeople.getMobile());
					customer.getSetCustPeople().add(custPeople1);
				}else {
					customer.getSetCustPeople().add(custPeople);
				}

			}
		}
		
		if (result.getPartprincipal().size() > 0) {
			List<PartPrincipal> partPrincipals = result.getPartprincipal();
			for (PartPrincipal partPrincipal : partPrincipals) {
				if (partPrincipal.getPpid() != null) {
					PartPrincipal partPrincipal1 = session.get(PartPrincipal.class, partPrincipal.getPpid());
					partPrincipal1.setPpname(partPrincipal.getPpname());
					partPrincipal1.setDuty(partPrincipal.getDuty());
					partPrincipal1.setOrganization(partPrincipal.getOrganization());
					partPrincipal1.setPpMobile(partPrincipal.getPpMobile());
					customer.getSetPartPrincipal().add(partPrincipal1);
				}else {
					customer.getSetPartPrincipal().add(partPrincipal);
				}

			}
		}
		
		session.saveOrUpdate(customer);
	}


	//编辑模块对客户负责的各项人员的增减
	@Override
	public void deleteEmp(JSONArray array1, JSONArray array2, JSONArray array3) {
		Session session = hibernateUtils.getSession();
		if (array1.size() > 0) {
			for (int i = 0; i < array1.size(); i++) {
				//根据id来查询principal
				Principal principal = session.get(Principal.class, (int)array1.get(i));
				session.delete(principal);
			}
		}
		
		if (array2.size() > 0) {
			for (int i = 0; i < array2.size(); i++) {
				//根据id来查询custpeople
				CustPeople custPeople = session.get(CustPeople.class, (int)array2.get(i));
				session.delete(custPeople);
			}
		}
		
		if (array3.size() > 0) {
			for (int i = 0; i < array3.size(); i++) {
				//根据id来查询custpeople
				PartPrincipal partPrincipal = session.get(PartPrincipal.class, (int)array3.get(i));
				session.delete(partPrincipal);
			}
		}
		
	}

	
	//查询页面导出excel
	@Override
	public List<Customer> exportCust() {
		
		Session session = hibernateUtils.getSession();
		Query query = session.createQuery("from Customer");
		List list = query.list();
		/*
		 * for (int i = 0; i < idList.size(); i++) { //根据id来查customer客户 Customer
		 * customer = session.get(Customer.class, idList.get(i)); //添加到arrayList集合中
		 * arrayList.add(customer); }
		 */
		return list;
	}
	
	
	
							
}

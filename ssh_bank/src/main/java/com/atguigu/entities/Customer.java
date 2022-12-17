package com.atguigu.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Customer extends Page{

	private Integer cid; // 客户id
	private String fullName; // 客户全称
	private String singleName; // 客户简称
	private String programeName; // 项目名
	private String service; // 业务场景
	private String jobKind; // 工作类型
	private String phase; // 阶段
	private String place; //地点
	private String admin;  //负责人
	private String department;  //部门
	private Date createTime;   //创建时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date startTime; // 起始时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date endTime; // 结束时间
	private String instruction; // 说明
	private String target;   //目标[起因]
	private String content;   //内容
	private String effect;   //效果
	
	private Set<Principal> setPrincipal = new LinkedHashSet<Principal>(); // 负责人 ;一个客户有多个负责人，一对多关系
	private Set<CustPeople> setCustPeople = new LinkedHashSet<CustPeople>();  //客户人员：一个客户可以有多个客户人员，一对多关系
	private Set<PartPrincipal> setPartPrincipal = new LinkedHashSet<PartPrincipal>();  //分行人员:一个客户可以有多个分行人员

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSingleName() {
		return singleName;
	}

	public void setSingleName(String singleName) {
		this.singleName = singleName;
	}

	public String getProgrameName() {
		return programeName;
	}

	public void setProgrameName(String programeName) {
		this.programeName = programeName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getJobKind() {
		return jobKind;
	}

	public void setJobKind(String jobKind) {
		this.jobKind = jobKind;
	}

	public String getPhase() {
		return phase;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}
		
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@JsonIgnore  //因为级联操作导致你中有我，我中有你---->死循环，加该注解可以使返回前端页面的数据忽略该get方法
	public Set<Principal> getSetPrincipal() {
		return setPrincipal;
	}

	public void setSetPrincipal(Set<Principal> setPrincipal) {
		this.setPrincipal = setPrincipal;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	@JsonIgnore
	public Set<CustPeople> getSetCustPeople() {
		return setCustPeople;
	}

	public void setSetCustPeople(Set<CustPeople> setCustPeople) {
		this.setCustPeople = setCustPeople;
	}
	
	@JsonIgnore
	public Set<PartPrincipal> getSetPartPrincipal() {
		return setPartPrincipal;
	}

	public void setSetPartPrincipal(Set<PartPrincipal> setPartPrincipal) {
		this.setPartPrincipal = setPartPrincipal;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Customer() {
		super();
	}

	public Customer(Integer cid, String fullName, String singleName, String programeName, String service,
			String jobKind, String phase, String place, String admin, String department, Date createTime, Date startTime,
			Date endTime, String instruction, String target, String content, String effect) {
		super();
		this.cid = cid;
		this.fullName = fullName;
		this.singleName = singleName;
		this.programeName = programeName;
		this.service = service;
		this.jobKind = jobKind;
		this.phase = phase;
		this.place = place;
		this.admin = admin;
		this.department = department;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instruction = instruction;
		this.target = target;
		this.content = content;
		this.effect = effect;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fullName=" + fullName + ", singleName=" + singleName + ", programeName="
				+ programeName + ", service=" + service + ", jobKind=" + jobKind + ", phase=" + phase + ", place="
				+ place + ", admin=" + admin + ", department=" + department + ", createTime=" + createTime + ", startTime="
				+ startTime + ", endTime=" + endTime + ", instruction=" + instruction + ", target=" + target
				+ ", content=" + content + ", effect=" + effect + "]";
	}


	
}

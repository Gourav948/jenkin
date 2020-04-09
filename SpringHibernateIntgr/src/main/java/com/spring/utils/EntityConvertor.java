package com.spring.utils;

public class EntityConvertor {
	
	public static com.spring.hibernate.entity.Employee convertEmployeeJsonToHibernate(com.spring.entity.Employee empJson) {
		com.spring.hibernate.entity.Employee empDB = new com.spring.hibernate.entity.Employee();
		empDB.setEmpname(empJson.getEmpname());
		empDB.setSalary(empJson.getSalary());
		return empDB;
	}
	
	public static com.spring.entity.Employee convertEmployeeHibernateToJson(com.spring.hibernate.entity.Employee empDB) {
		com.spring.entity.Employee empJson = new com.spring.entity.Employee();
		empJson.setEmpname(empDB.getEmpname());
		empJson.setSalary(empDB.getSalary());
		empJson.setId(empDB.getId());
		return empJson;
	}
	public static com.spring.hibernate.entity.Account convertAccountJsonToHibernate(com.spring.entity.Account accJson) {
		com.spring.hibernate.entity.Account accDB = new com.spring.hibernate.entity.Account();
		accDB.setName(accJson.getName());
		accDB.setBalance(accJson.getBalance());
		return accDB;
	}
	public static com.spring.entity.Account convertAccountHibernateToJson(com.spring.hibernate.entity.Account accDB) {
		com.spring.entity.Account accJson = new com.spring.entity.Account();
		accJson.setId(accDB.getId());
		accJson.setName(accDB.getName());
		accJson.setBalance(accDB.getBalance());
		return accJson;
	}
}

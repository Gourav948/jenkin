package com.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.dao.AccountDAO;
import com.spring.entity.Account;
import com.spring.utils.EntityConvertor;

public class AccountServiceImpl implements AccountService
{
	@Autowired
	@Qualifier("accountDao")
	private AccountDAO accountDao;

	public void save(Account accountJson) {
		accountDao.save(EntityConvertor.convertAccountJsonToHibernate(accountJson));
	}

	public void update(Account accountJson,int id) {
		accountDao.update(EntityConvertor.convertAccountJsonToHibernate(accountJson), id);
	}

	public void delete(int accountId) 
	{
		accountDao.delete(accountId);
		
	}

	public List<Account> get() 
	{
		List <com.spring.hibernate.entity.Account> accDb = accountDao.get();
		List <com.spring.entity.Account> accJson = new ArrayList <com.spring.entity.Account>();
		for (com.spring.hibernate.entity.Account account : accDb) 
		{
			accJson.add(EntityConvertor.convertAccountHibernateToJson(account));		
		}
		return accJson;		
	}

	public Account getAccountById(int id) {
		return EntityConvertor.convertAccountHibernateToJson(accountDao.getAccById(id));
	}

}

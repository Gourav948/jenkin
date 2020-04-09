package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.entity.Account;

public class AccountHibernateDAOSupportImpl 
extends HibernateDaoSupport 
	implements AccountDAO {

	@Transactional
	public void save(Account account) 
	{
		getHibernateTemplate().save(account);
	}
	@Transactional
	public void update(Account account,int id) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Account currentAccount = session.load(Account.class, id);
		currentAccount.setName(account.getName());
		currentAccount.setBalance(account.getBalance());
	}
	@Transactional
	public void delete(int accountId) 
	{
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Account acc = (Account) session.load(Account.class, new Integer(accountId));
		if(null != acc){
			session.delete(acc);
		}
		
	}

	public List<Account> get() {
		
		return getHibernateTemplate().loadAll(Account.class);
		
		
	}
	
	public Account getAccById(int id) 
	{	
		Account acc = (Account)getHibernateTemplate().get(Account.class,id);
		return acc;
		
	}
	


}

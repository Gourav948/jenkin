package com.spring.dao;

import java.util.List;

import com.spring.hibernate.entity.Account;

public interface AccountDAO 
{
	public void save(Account account);
	public void update(Account accounts, int id);
	public void delete(int accountId);
	public List<Account> get();
	public Account getAccById(int id);

}

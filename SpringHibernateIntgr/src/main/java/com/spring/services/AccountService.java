package com.spring.services;

import java.util.List;

import com.spring.entity.Account;

public interface AccountService 
{
	public void save(Account account);
	public void update(Account account, int id);
	public void delete(int accountID);
	public List<Account> get();
	public Account getAccountById(int id);
}

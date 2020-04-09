package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Account;
import com.spring.services.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/account", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addAccount(@RequestBody Account account) {
		accountService.save(account);
		return "{ \"result\": \"Success\"}";
	}
	@RequestMapping(value="/account/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE )
	public String updateAccount(@RequestBody Account account,@PathVariable("id") int id) {
		accountService.update(account,id);
		return "{ \"result\": \"Success\"}";
	}
	@RequestMapping(value="/account/{id}", method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable("id") int id) 
	{
		accountService.delete(id);
		return "{ \"result\": \"Success\"}";
	}
	@RequestMapping(value="/account", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccount() 
	{
		
		return accountService.get();
	}
	@RequestMapping(value="/account/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Account getAccountById(@PathVariable("id") int id) 
	{
		
		return accountService.getAccountById(id);
	}
}

package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dao.I_ATM;
import com.example.demo.entity.AtmRepo;
import com.example.demo.entity.Atm_Pojo;

@Service
public class Atm_Service implements I_ATM
{
	@Autowired
	private AtmRepo atmdao;

	//This method is used to withdraw money from account
	@Override
	public Optional<Atm_Pojo> withdraw(int acno,int amt) 
	{
		Atm_Pojo a;
		Optional<Atm_Pojo> entity=atmdao.findById(acno);
		if(entity.isPresent())
		{
			a=entity.get();
			a.balance=a.balance-amt;
			atmdao.save(a);
		}
		
		return entity;
	}

	//This method is used to Deposite Money from account
	@Override
	public Optional<Atm_Pojo> deposit(int acno,int amt) 
	{
		Atm_Pojo a;
		Optional<Atm_Pojo> entity=atmdao.findById(acno);
		if(entity.isPresent())
		{
			a=entity.get();
			a.balance=a.balance+amt;
			atmdao.save(a);
			
		}
		
		return entity;
		
	}

	
	//This method is used to Check balance of account
	@Override
	public Optional<Atm_Pojo> checkBalance(int accno) 
	{
		return atmdao.findById(accno);
	}

	
	//This method is used to check account details 
	@Override
	public Optional<Atm_Pojo> checkDetails(int accno) 
	{
		return atmdao.findById(accno);
	}

	//This method is used to Update account
	@Override
	public Atm_Pojo updateDetails (Atm_Pojo a) 
	{
		return atmdao.save(a);
		
	}

	//This method is used to create account
	@Override
	public Atm_Pojo createAccount(Atm_Pojo a) 
	{
		return atmdao.save(a);
	}

	
	//This method is used to delete account
	@Override
	public String deleteAccount(int acno) 
	{
		Optional<Atm_Pojo> entity= atmdao.findById(acno);
		if(entity.isPresent())
		{
			atmdao.delete(entity.get());
			return "Account Deleted Sucessfully";
		}
		return "Accout not found";
	}

	
}

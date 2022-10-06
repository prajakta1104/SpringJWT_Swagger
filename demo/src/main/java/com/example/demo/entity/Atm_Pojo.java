package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atm_Pojo 
{
	@Id
	//variables
	public Integer accno;//To store account number
	public String name;  //To store name
	public int balance;  //To store balance
	
	//Getters
	public Integer getAccno() 
	{
		return accno;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getBalance() 
	{
		return balance;
	}
	
	
	//Setters
	public void setAccno(Integer accno) 
	{
		this.accno = accno;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	  public void setBalance(int balance)
	  { 
		  this.balance = balance; 
	}
	 
}

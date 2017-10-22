package ATM;

import java.util.*;

public class UserData {
	private User user;
	private String password;
	private double balance;
	private List<String> transaction; 
	
	public UserData(){
	}
	
	public UserData(User user, String password){
		this.user = user;
		this.password = password;
		balance = 0.0;
		transaction = new ArrayList<String>();
	}
	
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;		
	}
	
	public void setPassword(String password){
		this.password = password;	
	}
	public String getPassword(){
		return password;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	public double getBalance(){
		return balance;
	}
	
	public void setTransaction(String transaction){
		this.transaction.add(transaction);
	}
	public List<String> getTransaction(){
		return transaction;
	}

}

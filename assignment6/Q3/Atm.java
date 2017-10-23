package ATM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Atm implements Serializable{
	private double availableAmountInMachine;
	private double transactionFee;
	ArrayList<UserData> userDataBase;
	UserData current;
	Scanner sc = new Scanner(System.in);
	
	public Atm(){}
	
	public Atm(double availableAmountInMachine, double transactionFee){
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		userDataBase = new ArrayList<UserData>();
	}
	public void userType(){
		int userNum;
		System.out.println("Welcome to bank of NEU! \nAre You NEW USER or CURRENT USER ?(Please choose number)");
		System.out.println("1: NEW USER \n2: CURRENT USER");
		userNum = sc.nextInt();
		if(userNum == 1){
			createNewUser();
			System.out.println("Your new account has been created!");
			manage();
		}
		if(userNum == 2){
			System.out.println("Forgot password?(Y/N)");
			String input = sc.next();
			if(input.equalsIgnoreCase("Y")){
				forgotPassword();
			}else if(input.equalsIgnoreCase("N")){
			    login();
			}else{
				System.out.println("Invalid input, try again");
				userType();
			}
		}
		else if (userNum != 1 && userNum != 2){
			System.out.println("Please input a valid number!");
			userType();
		}
	}
	
	UserData createNewUser(){
		System.out.println("You need to open a new account.\nPlease enter your name");
		String name = sc.next();
		System.out.println("Please enter your age");
		int age = sc.nextInt();
		System.out.println("Please enter your address");
		String address = sc.next();
		System.out.println("Please enter your phone number");
		String phonenumber = sc.next();
		System.out.println("Please enter your bank account number");
		String bankaccountnumber = sc.next();
		System.out.println("Please enter your password");
		String password = sc.next();
		
		User user = new User(name, age, address, phonenumber, bankaccountnumber);
		UserData userdata = new UserData(user,password);
		userDataBase.add(userdata);
		current = userdata;
		return current;
	}
	
	void forgotPassword(){
		System.out.println("Do you want to reset your password?(Y/N)");
		String input = sc.next();
		    if(input.equalsIgnoreCase("Y")){
		    	reset();
		    }
		    else if(input.equalsIgnoreCase("N")){
		    	userType();
		    }
		    else{
		    	System.out.println("Invalid input, try again");
		    	forgotPassword();
		    }
	}
	
	void reset(){
		System.out.println("Please input your name");
		String name = sc.next();
		System.out.println("Please input your age");
		int age = sc.nextInt();
		System.out.println("Please input your phone number");
		String phonenumber = sc.next();
		
		UserData ud;
		for(int i = 0; i < userDataBase.size(); i++){
			ud = userDataBase.get(i);
			if(name.equals(ud.getUser().getName())&& age == ud.getUser().getAge()&&phonenumber.equals(ud.getUser().getPhoneNumber())){
				System.out.println("Please enter your new password");
				String password = sc.next();
				current.setPassword(password);
				System.out.println("Your password has been reset!");
			}else{
				System.out.println("Information is wrong. Please try again");
				reset();
			}
		}
	}
	
	void login(){
		System.out.println("Please enter your account number");
		String accountnumber = sc.next();
		System.out.println("Please enter your password");
		String password = sc.next();
		
		UserData ud;
		for(int i = 0; i < userDataBase.size(); i++){
			ud = userDataBase.get(i);
			if(accountnumber.equals(ud.getUser().getBankAccountNumber())&& password.equals(ud.getPassword())){
				current = ud;
				manage();
			}
			else if(!accountnumber.equals(ud.getUser().getBankAccountNumber())&& password.equals(ud.getPassword())){
				System.out.println("Invalid account number. Try again");
				login();
			}
			else if(accountnumber.equals(ud.getUser().getBankAccountNumber())&& !password.equals(ud.getPassword())){
				System.out.println("Your password is wrong. Try again");
				login();
			}
			else {
				System.out.println("Invalid account number and password! Try again!");
				login();
			}
		}
		
	}
	
	public void manage(){
		//User a = new User();
		//Hello "+ a.getName() + ", 
		System.out.println("Welcome!\n");
		System.out.println("Manage your account:(Choose Number)");
		System.out.println("1.Available balance");
		System.out.println("2.Withdraw");
		System.out.println("3.Deposit");
		System.out.println("4.Recent transaction");
		System.out.println("5.Change password");
		System.out.println("6.Exit");
		int input = sc.nextInt();
		
		if(input == 1){
			availableBalance();
		}
		else if(input == 2){
			withDraw();
		}
		else if(input == 3){
			deposit();
		}
		else if(input == 4){
			recentTransaction();
		}
		else if(input == 5){
			changePassword();
		}
		else if(input == 6){
			sc.close();
			System.exit(0);
		}
		else{
			System.out.println("Please enter vaild numbers!");
			manage();
		}

	}
	
	double availableBalance(){
		double balance = current.getBalance();
		System.out.println("Your available balance is: " + balance +"\n");
		System.out.println("What do you want to do?\n");
		manage();
		return balance;
	}
	
	void withDraw(){
		if(current.getBalance() == 0){
			System.out.println("You need to deposit first.");
		}else{
			System.out.println("How much money do you want to withdraw?");
			double withdraw = sc.nextDouble();
		    if(withdraw > current.getBalance() + transactionFee){
		    	System.out.println("Sorry, you don't have enough money. Please try again");
		    	withDraw();
		    }
		    else if(withdraw <= current.getBalance() + transactionFee){
		    	double balance = current.getBalance() - withdraw - transactionFee;
		    	current.setBalance(balance);
		    	this.availableAmountInMachine -= withdraw;
		    	String tranw = "Withdraw" + "     " + withdraw;
		    	current.getTransaction().add(tranw);
		    	System.out.println("Please collect your money");
		    }
		}
		manage();
	}
	
	void deposit(){
		System.out.println("How much money do you want to deposit?");
		double deposit = sc.nextDouble();
		double balance = current.getBalance() + deposit - transactionFee;
		current.setBalance(balance);
		this.availableAmountInMachine += deposit;
		String trand = "Deposit" + "      " + deposit;
    	current.getTransaction().add(trand);
		System.out.println("Thank You! You have saved $" + deposit);
		manage();
	}
	
	void recentTransaction(){
		if(current.getTransaction() != null){
			System.out.println("Recent 10 transactions are: \n");
			for(int i = 1; i <= current.getTransaction().size() && i < 10; i++){
				System.out.println(current.getTransaction().get(i));
			}
		}
		else{
			System.out.println("Transaction is empty");
		}
		manage();
	}
	
	void changePassword(){
		System.out.println("Please enter your new password");
		String password = sc.next();
		current.setPassword(password);
		System.out.println("Your password has been reset");
	}
	
	void store(Atm atm){
		try {
			ObjectOutputStream os = new ObjectOutputStream(
			        new FileOutputStream("C:/atm.txt"));
			os.writeObject(atm);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("C:/atm.txt"));
		Atm temp = (Atm)is.readObject();
		System.out.println(temp.current.getUser().getAddress());
		System.out.println(temp.current.getUser().getAge());
		System.out.println(temp.current.getUser().getBankAccountNumber());
		System.out.println(temp.current.getUser().getName());
		System.out.println(temp.current.getUser().getPhoneNumber());
		List alist= (List)is.readObject();
		for (Iterator iterator = alist.iterator(); iterator.hasNext();) {  
            System.out.print(iterator.next());  
	    }
		is.close();
	    }
	  catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {  
		// TODO Auto-generated catch block
        e.printStackTrace();  
    }  
	}
	
	public static void main(String args[]){
		User a = new User("nick", 20,"downtown","123","001");
		UserData aud = new UserData(a,"001");
		Atm atm = new Atm(5000.0 , 1.0);
		atm.userDataBase.add(aud);
		atm.userType();
	}

}

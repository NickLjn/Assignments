package ATM;

import java.util.*;

public class Atm {
	private double availableAmountInMachine;
	private double transactionFee;
	private ArrayList<UserData> userDataBase;
	Scanner sc = new Scanner(System.in);
	
	public Atm(){}
	
	public Atm(int availableAmountInMachine, int transactionFee, ArrayList<UserData> userDataBase){
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		this.userDataBase = userDataBase;
	}
	public void userType(){
		int userNum;
		System.out.println("Welcome to bank of NEU! \nAre You NEW USER or CURRENT USER ?(Please choose number)");
		System.out.println("1: NEW USER \n2: CURRENT USER");
		userNum = sc.nextInt();
		if(userNum == 1){
			System.out.println("1");
		}
		if(userNum == 2){
			System.out.println("2");
		}
		else if (userNum != 1 && userNum != 2){
			System.out.println("Please enter correct number!");
			userType();
		}
	}
	
	
	public static void main(String args[]){
		Atm a = new Atm();
		a.userType();
	}
}



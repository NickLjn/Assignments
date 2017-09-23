import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class assignment2 {
	
    public static void main(String args[]){
    	//1
	    System.out.println(employeeSalary(45));
		//2
	    System.out.println(addDigits(26));
	    //3
	    printPerfectNumbers(6);

	    
		    }
	/* 1. Write a java function to calculate the salary of an employee based on the following rules.
		 i. function takes input of number of hours an employee worked and returns the salary.
		ii.  The first 36 hours worked are paid at a rate of 15.0, then the next 5 hours are paid at a rate of 15 * 1.5. Hours after that up to a max of 48 are paid at a rate of 15 * 2.
			
		Here is the prototype you can work with*/
			
		public static double employeeSalary( double hours){
				
			double hour1 = 36;
			double hour2 = 36 + 5;
			double hour3 = 48;
			double rate1 = 15.0;
			double rate2 = 15 * 1.5;
			double rate3 = 15 * 2;
			double salary;
		
			if (hours >= 0 && hours <= hour1){
				salary = hours * rate1;
			} 
			else if (hours > hour1 && hours <= hour2){
				salary = hour1 * rate1 + (hours - hour1) * rate2;
			}
			else if (hours > hour2 && hours <= hour3){
				salary = hour1 * rate1 + (hour2 - hour1) * rate2 + (hours - hour2) * rate3;
			}
			else if (hours > 48) {
				salary = hour1 * rate1 + (hour2 - hour1) * rate2 + (hours - hour2) * rate3;
			}
			else return 0.0;
			return salary;
		}

	

	/*2. Write a java function that adds all the digits of an integer until it is single digit.
		i. function takes an integer as input and returns its sum of digits.
		ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.*/
		
		public static int addDigits( int input){
			int result = 0;
			int temp1 = input/10;
			int temp2 = input%10;
			
			while (input >= 10){
				input = temp1 + temp2;
			}
			result = input;
			if(input < 10){
				result = input;
			}
			return result;
		}

		
	/*3. Write a java function to print all perfect number between 1 and n.
		i. Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
		ii. For example: 6 is the first perfect number, Proper divisors of 6 are 1, 2, 3. Sum of its proper divisors = 1 + 2 + 3 = 6.*/
		public static void printPerfectNumbers( int n){
			int sum = 0;
			for(int i = 1; i < n; i++){
				if (n % i == 0){
					sum += i;
				}
			}
			if (sum == n){
				System.out.println(n + " is perfect number!");
			}
			else System.out.println(n + " is not perfect number.");
		}

	/*4. Write a java class called pizza with (Add detail as needed) : 
	    i. Create atleast 3 attributes :pizza type , unit price and loyalty points. More attributes are welcome to have. 
	    ii. Create constructors . Extra-credit of 0.5 point if you write more than 1 right constructor to this class*/
		
		public class pizza{
			String PizzaType;
			float Price;
			int LoyaltyPoints;

			
			
			public pizza(String pt, float p, int lp){
				this.PizzaType = pt;
				this.Price = p;
				this.LoyaltyPoints = lp;
			}
			public pizza (String pt, float p){
				this.PizzaType = pt;
				this.Price = p;
				this.LoyaltyPoints = 100; 
			}
			
			
		}

    /*5. Write a java class called customer (Add detail as needed) : 
	    i. Create Attributes: customer name and which pizzas customer has ordered. 
	    ii. Think about what kind of data structure can be used to record the pizza name and number of each kind of pizza.( Give me your thought, Extra credit of 1 point)
	    iii. In main method , sum up how much money the customer spent. */
		
		public class customer{
			String CustomerName;
			double pizzaPrice;
			//HashMap is a good data structure can be used.
			Map<String, Integer>pizzaOrders = new HashMap<String, Integer>();
		    public customer(String name){
		    	this.CustomerName = name;

		    }

		    
		    public double sumMoney(){
		    	double sum= 0.0;
		    	for( Entry entry :pizzaOrders.entrySet()){
		    		entry.getValue();
		    			entry.getKey();
		    		sum += pizzaPrice* pizzaOrders.get(pizzaPrice);
		    	}
		    	return sum;

		    }

		}
}



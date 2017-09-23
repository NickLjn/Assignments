import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class question6 {

		
	    public static void main(String args[]){
		    //5
		    customer bin = new customer("nick");
		    System.out.println(bin.sumMoney());
		    
		    //6
		    printIsoscelesTriangle(7);
	    }
		    
	    
	    /*5. Write a java class called customer (Add detail as needed) : 
		    i. Create Attributes: customer name and which pizzas customer has ordered. 
		    ii. Think about what kind of data structure can be used to record the pizza name and number of each kind of pizza.( Give me your thought, Extra credit of 1 point)
		    iii. In main method , sum up how much money the customer spent. */
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
			public static class customer{
				String CustomerName;
				double pizzaPrice;
				//HashMap is a good data structure can be used.
				Map<pizza, Integer>pizzaOrders = new HashMap<pizza, Integer>();
			    public customer(String name){
			    	this.CustomerName = name;

			    }

			    
			    public double sumMoney(){
			    	double sum= 0.0;
			    	for( Entry entry :pizzaOrders.entrySet()){
			    		pizza p = (pizza)(entry.getKey());
			    		Integer n = (Integer)(entry.getValue());
			    		sum += p.Price*n;
			    	}
			    	return sum;

			    }

			}
	

			    
	/*	 EXTRA CREDIT
	6. Write a Java program that generates an isosceles right angled triangle made of asterisks. 
		i. function should take input of one equal side as integer. Other than the edges the inner part of the triangle should be empty.
		ii. For example input is 6. the function should print—
			
		   *
		   **
		   * *
		   *  *
		   *   *
		   ******
*/
		
		public static void printIsoscelesTriangle( int n){
			if (n < 1){
				System.out.println("n must bigger than 1");
			}
			System.out.println("*");
//			System.out.println("**");
			for(int i = 2; i < n ; i++){
				System.out.print("*");
				for(int j = 2 ; j < i ; j++){
					System.out.print(" ");
				}
				System.out.println("*");
			}
			for(int i=0; i<n;i++){
				System.out.print("*");
			}
			System.out.println();
		}
}

package assignmentthree;

import java.util.*;

public class assignment3 {
	
	public static void main(String args[]){
		//problem3 
			System.out.println(removeVowelsFromString("QWERTYUIOPasdfghjklzxcvbnm"));
		//problem4
			System.out.println(checkIfTwoStringsAreAnagrams("java","vaja"));
		//problem5
			Calculator c = new Calculator();
			//features i
			System.out.println("//features i");
			System.out.println(c.addition(1,2));
			System.out.println(c.subtraction(2,1));
			System.out.println(c.multiplication(10,2));
			System.out.println(c.division(14,2));
			//features ii
			System.out.println("//features ii");
			System.out.println(c.squareRoot(2));
			System.out.println(c.square(3));
			System.out.println(c.cube(3));
			//features iii
			System.out.println("//features iii");
			System.out.println(c.convertFahrenheitToCelsius(68));
			System.out.println(c.convertCelsiusToFahrenheit(20));
			System.out.println(c.convertFeetToInche(1));
			System.out.println(c.convertIncheToFeet(240));
		//Extra problem
			System.out.println("extra problem");
			System.out.println(c.quadraticEquation(1,-3,2)[0]);
			System.out.println(c.quadraticEquation(1,-3,2)[1]);

	}
	/*1. Find the error in the following code and explain in few lines why it is wrong. (Score 1)
  
    public class Book{
            int size;
            int price;
            String name;
        
        public Book(int size){
            this.size = size;
        }
        
        public Book(int size, int price, String name){
            super();
            this.size = size;
            this.price = price;
            this.name = name;
        }
        
        public Book(int price){
            this.price = price;
        }
        
        public setName(String name){
            return name;
        }
    }
	errors: 
		1. the first constructor and the third constructor has same parameter "Book(int)" , they cant be the same.
		2. in the second constructor, the constructor calls 'super()' and 'this.'. constructors can call either of them, but cant call both of them.
		3. there should be this.name = name; before 'retrurn name', and it should be written in public void setName(String name){}.
		*/
	
	
	
	/*2. Find the error in the following code and explain in few lines why it is wrong. (Score 1)

	class Clock{
        String time;
        
        void getTime(){
           return time;
        }
        void setTime(String t){
           time = t ;
        }
    }
	errors:
		1.the return type in getTime() should be String, instead of void. if the type is void, it cant return value.
		*/
	
	
//	3. Write a Java function to remove vowels in a string. (Score 2)
//	i. The function should take a string as input.
//	ii. Should return the input string after omitting the vowels.
	
	public static String removeVowelsFromString(String input){
	    if(input.length() == 0){
			return null;
	    }
	    String vowels = input.replaceAll("[aeiouAEIOU]","");
	    
	    return vowels;
		
	}
	
//	4. Write a java function to check if two strings are Anagrams or not. (Score 2)
//	i. The function should take two input strings.
//	ii. Should return a boolean ‘true’ if the inputs are Anagrams else return ‘false’.
	
	public static boolean checkIfTwoStringsAreAnagrams(String s1, String s2){
		if(s1.length() != s2.length() || s1 == null || s2 == null || s1 == s2){
			return false;
		}
		
		char[]arr1 = s1.toCharArray();
		char[]arr2 = s2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1,arr2)){
			return true;
		}
		return false;
	}
	
	
//	5. Create a calculator that can perform the following features. (Total Score 4)
//	i. The calculator should be able to perform Addition, subtraction, multiplication, division. (Score 2)
//	ii. Should be able to perform squareRoot, square, cube. (Score 1)
//	iii. Should be able to convert ‘Fahrenheit-Celsius’ , ‘Feet-Inches’. (Score 1)
	static class Calculator{
		
		//features i
		protected double addition(double a, double b){
			return a + b;
		}
		protected double subtraction(double a, double b){
			return a - b;
		}
		protected double multiplication(double a, double b){
			return a * b;
		}
		protected double division(double a, double b){
			if(b == 0){
				throw new IllegalArgumentException("error");
			}
			else 
				return a / b;
		}
		
		//features ii
		protected double squareRoot(double a){
			return Math.sqrt(a);
		}
		protected double square(double a){
			// Just return a * a;
			return a *= a;
		}
		protected double cube(double a){
			// Same here, return a * a * a;
			return a *= a*= a;
		}
		
		//features iii
		protected double convertFahrenheitToCelsius(double a){
			return (a - 32)/ 1.8;
		}
		protected double convertCelsiusToFahrenheit(double a){
			return a * 1.8 + 32;
		}
		protected double convertFeetToInche(double a){
			if(a < 0 ){
				throw new IllegalArgumentException("error");
			}
			else
				return a * 12;
		}
		protected double convertIncheToFeet(double a){
			if(a < 0){
				throw new IllegalArgumentException("error"); 
			}
			else
				return a / 12;
		}
	
	/*Extra Credit(Score 2)
	The calculator should be able to solve a quadratic equation and return the solution as array.
	i. This function should take three arguments.
	ii. For example, if quadratic equation is Ax2 + Bx + C. The function should take A,B,C as arguments
	and return a solution as array.
	*/
	
		protected double[] quadraticEquation(double a, double b, double c){
			double[] result = new double[2];
			if(a == 0){
				if (b == 0){
					return null;
				}
			    result = new double[1];
			    result[0] = -c/b;
				return result;
			}


			double delta = subtraction((square(b)),4*(multiplication(a,c)));
			if(delta <0){
				System.out.println("no result");
			}
			else if(delta == 0){
				result = new double[1];
				result[0] = -b/2*a;
				return result;
			}
			else {
				result[0] = division(addition((-b),squareRoot(delta)),(2*a));
				result[1] = division(subtraction((-b),squareRoot(delta)),(2*a));
			}
			return result;
		}
	}
}

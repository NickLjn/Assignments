package assignment6;

public class Test {
	public static void main(String[] args) {
		int index = 10;
		int lowerBound = 0;
		int upperBound = 9;
		try{
			if(index > upperBound || index < lowerBound){
				throw new MyIndexOutOfBoundException("Error Message: "+"Index: "+ index +", but Lower bound: "+ lowerBound +", Upper bound: "+ upperBound);
		    }
		
		}
		catch (Exception e){
			e.printStackTrace();
        }

    }
}
class MyIndexOutOfBoundException extends Exception{
	public MyIndexOutOfBoundException(String message){
		super(message);
		}
	}

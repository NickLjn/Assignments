package midterm;

public class Reverse {
	public static void main (String args[]){
		int data[] = new int[]{2,4,5,6,1,3,7,9,8};
		reverseEvenIndices(data);
		print(data);
	}
	
	public static void reverseEvenIndices(int arr[]){
		int len = arr.length/2;
		int head = 0;
		int tail = arr.length - 1;  
		for(int x = 0; x < len ; x++){
			int temp = arr[head];
			arr[head] = arr[tail];
			arr[tail] = temp;
			head ++;
			tail --;
		}
	}
	public static void print(int temp[]){
		System.out.print("{");
		for(int x = 0; x < temp.length; x++){
			System.out.print(temp[x]+",");
		}
		System.out.print("}\n");
	}

}

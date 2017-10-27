package midterm;

public class Arrange {
	public int arrangeCoins(int n){
		int k = 0;
		int temp = 0;
		int time = 0;
		while(temp < n){
			if(temp == n){
				return time;
			}
			else{
				k++;
				temp += k;
				time ++;
			}
		}
		return time -1;
	}

	public static void main(String[] args) {
		Arrange a = new Arrange();
		int output = a.arrangeCoins(8);
		System.out.println(output);
	}

}

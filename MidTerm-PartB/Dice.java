package midterm;

public class Dice {
	public int countNumberOfPossibleWays(int m, int n, int x){
		int ways = 0;
		if(n == 1){
			if(x>=1 && x<=m){
				return 1;
				}
			else return 0;
		}
		for(int i = 1; i < m; i++){
			ways += countNumberOfPossibleWays(m, n-1, x-i);
		}
		return ways;
	}
	
	
	public static void main(String[] args) {
		Dice d = new Dice();
		int output1 = d.countNumberOfPossibleWays(6, 2, 5);
		int output2= d.countNumberOfPossibleWays(5, 3, 6 );
		System.out.println(output1);
		System.out.println(output2);
		
	}

}

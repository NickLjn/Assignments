package assignment7;

public class PascalTriangle {
	public static void printPascalTriangle(int n){
		int[][] nums = new int[n][n];
		int x=0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				if(j == 0 || j == i){
					x = 1;
				    nums[i][j] = x;
				}else{
					x = nums[i-1][j-1]+nums[i-1][j];
					nums[i][j] = x;
				}
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printPascalTriangle(8);
	}

}

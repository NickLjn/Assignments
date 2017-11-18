package assignment7;

public class Extra {

	public static boolean findPartition (int arr[]) {
		int sum = 0;
		for(int i = 0; i<arr.length; i++){
			sum += arr[i];
		}
		
		if(sum%2 == 1){
			return false;
		}
		
		sum = sum/2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		
		for(int i = 0; i < arr.length; i++ ){
			for(int j = sum; j >= arr[i]; j--){
				dp[j] = dp[j] || dp[j-arr[i]];
			}
		}
		return dp[sum];
	}
	public static void main(String[] args) {
		int[] arr = {1,5,5,11};
		System.out.println(findPartition(arr));
	}

}

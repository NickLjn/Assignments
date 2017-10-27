package midterm;

public class Move {
	public int minMoves(int[] nums){
		int head = 0;
		int tail = nums.length -1;
		int time = 0;

		for(int a = 0; a < nums.length; a++){     //sort from low to high
			for(int x = 0; x < nums.length - 1; x++){
			    if(nums[x] > nums[x+1]){
				    int temp = nums[x];
				    nums[x] = nums[x+1];
				    nums[x+1] = temp;
			    }
		    }
		}	
	    while(nums[head] != nums[tail]){
		    for(int y = 0; y < nums.length - 2; y++){  //each of (n-1)elements +1,except the biggest one.
			    nums[y] = nums[y] + 1;
		    }
		    for(int b = 0; b < nums.length; b++){      //then sort them
		        for(int x = 0; x < nums.length - 1; x++){
		            if(nums[x] > nums[x+1]){
			            int temp = nums[x];
			            nums[x] = nums[x+1];
			            nums[x+1] = temp;
		            }
		        }
		    }
		    time ++;
	    }
		return time;
    }
	
	
	public static void main(String[] args) {
		int data[] = new int[]{1,2,3,4,5,6,7};
		Move m = new Move();
		int output = m.minMoves(data);
		System.out.println(output);
	}

}

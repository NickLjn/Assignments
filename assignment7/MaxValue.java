package assignment7;

public class MaxValue extends Thread{
	private int lo, hi;
	private int[] arr;
	private int ans = 0;
	
	public MaxValue(int[]arr, int lo, int hi){
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
	}
	
	@Override
	public void run(){
		for(int i = lo; i < hi; i++){
			if(arr[i] > ans){
				ans = arr[i];
			}
		}
	}
	
	public static int max(int[] arr) throws InterruptedException{
		int len = arr.length;
		int ans = 0;
		
		MaxValue[] mv = new MaxValue[4];
		for (int i = 0; i < 4; i++){
			mv[i] = new MaxValue(arr, (i*len)/4, ((i+1)*len/4));
			mv[i].start();
		}
		
		for (int i = 0; i < 4; i++){
			mv[i].join();
			if(mv[i].ans > ans){
				ans = mv[i].ans;
			}
		}
		return ans;
		
	}
	
	public static void main(String args[]) throws InterruptedException{
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++){
			arr[i] = (int)(Math.random()*100);
			int max = max(arr);
			System.out.println("Max: "+ max);
		}
	}
}

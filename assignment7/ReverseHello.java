package assignment7;

public class ReverseHello extends Thread{
	int num;
	
	public ReverseHello(int num){
		this.num = num;
	}
	
	public void run(){
		if(num < 50){
			num++;
			this.Next(num);
		}
		System.out.println("Hello From Thread "+ (num));
	}
	
	private void Next(int i) {
		ReverseHello t = new ReverseHello(num);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ReverseHello rh = new ReverseHello(0);
		rh.start();
	}

}

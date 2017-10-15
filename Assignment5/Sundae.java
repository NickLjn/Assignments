package assignment5;

class Sundae extends IceCream{
	private String topping;
	private int toppingCost;
	
	public Sundae(String name, int cost, String topping, int toppingCost){
		super(name,cost);
		this.topping = topping;
		this.toppingCost = toppingCost;
	}
	
	@Override
	public int getCost(){
		return super.getCost() + toppingCost/100;
	}
	
	@Override
	public String toString(){
		String topName = topping + " Sundae With\n";
		String NameAndCost = String.format("%-25s%5s", name, getCost());
		return topName+ NameAndCost + "\n";
	}
}

package assignment5;

class IceCream extends DessertItem{
	private int cost;
	
	public IceCream(String name,int cost){
		super(name);
		this.cost = cost;
		
	}
	
	@Override
	public int getCost(){
		return cost/100;
	}
	
	@Override
	public String toString(){
		String NameAndCost = String.format("%-25s%5s", name, getCost());
		return NameAndCost +"\n";
	}
}


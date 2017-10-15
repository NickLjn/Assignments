package assignment5;

class Cookie extends DessertItem{
	private double weight;
	private int pricePerDozen;
	
	public Cookie(String name, double weight, int pricePerDozen){
		super(name);
		this.weight = weight;
		this.pricePerDozen = pricePerDozen;
	}
	
	@Override
	public int getCost(){
		return (int)Math.round(weight*pricePerDozen);
	}
	
	@Override
	public String toString(){
		String NameAndCost = String.format("%-25s%5s", name, DessertShoppe.cents2dollarsAndCents(getCost()));
		String Weight = String.format("%-2f", weight);
		return Weight+" @ " + DessertShoppe.cents2dollarsAndCents(pricePerDozen) +"/dz.\n"+ NameAndCost +"\n";
	}
}


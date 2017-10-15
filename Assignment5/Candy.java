package assignment5;

class Candy extends DessertItem{
	private double weight;
	private int pricePerPound;
	
	public Candy(String name, double weight, int pricePerPound){
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	
	@Override
	public int getCost(){
		//int dolar = (Integer)DessertShoppe.cents2dollarsAndCents(pricePerPound);
		return (int)Math.round(weight*pricePerPound);
	}
	
	@Override
	public String toString(){
		String NameAndCost = String.format("%-25s%5s", name, DessertShoppe.cents2dollarsAndCents(getCost()));
		String Weight = String.format("%-2f", weight);
		return Weight+" lbs. @ " + DessertShoppe.cents2dollarsAndCents(pricePerPound) +"/lb.\n"+ NameAndCost +"\n";
	}
}

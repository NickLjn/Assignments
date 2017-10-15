package assignment5;

import java.util.Vector;

public class Checkout {
	private Vector<DessertItem>items;
	
	public Checkout(){
		items = new Vector<DessertItem>();
	}
	
	public int numberOfItems(){
		return items.size();
	}
	
	public void enterItem(DessertItem item){
		items.add(item);
	}
	
	public void clear(){
		items.clear();
	}
	
	public int totalCost(){
		int sum = 0;
		for(int i = 0; i < items.size(); i++){
			sum += items.get(i).getCost();
		}
		return sum;
	}
	
	public int totalTax(){
		return (int)Math.round(totalCost()*DessertShoppe.taxRate);
	}
	
	@Override
	public String toString(){
		System.out.println("     "+DessertShoppe.name);
		System.out.println("     "+"-------------------");
		System.out.print("\n");
		
		for(DessertItem desserts: items){
			System.out.print(desserts.toString());
		}
		System.out.println();
		String Tax = String.format("%-25s%5s", "Tax", totalTax());
		String Cost = String.format("%-25s%5s", "Total Cost", totalCost());
		String taxAndCost = Tax + "\n" + Cost;
		return taxAndCost;
	}
}

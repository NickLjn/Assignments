package assignment5;

public class DessertShoppe {
	public static final String name = "M & M Dessert Shoppe";
	public static final double taxRate = 0.065;
	public static final int maxSizeOfItemName = 25;
	public static final int widthOfReceipt = 30;
	
	public static String cents2dollarsAndCents(int cents){
		double convertCents = (double)cents/100;
		String dollar = Double.toString(convertCents);
		return dollar;
	}

}

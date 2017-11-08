package project2;

public class Card {
	private int num;
	private int suit;
	
	public Card(int num, int suit){
		this.num = num;
		this.suit = suit;
	}
	
	public int getNum(){
		return num;
	}
	
	public int getSuit(){
		return suit;
	}
	
	public void display(){
		switch(num){
		case 11:
			System.out.println("Jack ");
			break;
		case 12:
			System.out.println("Queen ");
			break;
		case 13:
			System.out.println("King ");
			break;
		case 14:
			System.out.println("Ace ");
			break;
		default:
			System.out.println("default");
		}
		
		switch(suit){
		case 0:
			System.out.println("of clubs");
			break;
		case 1:
			System.out.println("of diamonds");
			break;
		case 2:
			System.out.println("of hearts");
			break;
		case 3:
			System.out.println("of spades");
			break;
		default:
			System.out.println("default");
		}
	}
}

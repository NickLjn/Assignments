package project2;

public class Deck extends GroupOfCards{
	public static int TOTAL_CARDS = 52;
	
	public Deck(){
		super(TOTAL_CARDS);
		for (int suit =0;suit<4;++suit) {
			for (int num=2;num<15;++num) {
				super.addCard(new Card(num,suit));
			}
		}
	}
	
	public void shuffle(){
		int unshuffled = super.getCurrentSize();
		for(int i = unshuffled; i > 0; --i){
			int index = (int)(Math.random()*(unshuffled-1));
			super.addCard(removeCard(index));
			
		}
	}
	
	public Card dealCard(){
			return this.removeCard(0);
	}
}

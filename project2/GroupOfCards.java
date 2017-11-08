package project2;

public class GroupOfCards {
	private Card[] cards;
	private int currentSize = 0;
	
	public GroupOfCards(int size){
		cards = new Card[size];
	}
	
	public int getCurrentSize(){
		return currentSize;
	}
	
	public Card getCard(int i){
		return cards[i];
	}
	
	public void addCard(Card card){
		if(cards.length == currentSize){
			return;
		}
		cards[currentSize++] = card;
	}
	
	public Card removeCard(int index){
		Card temp = cards[index];
		--currentSize;
		for(int i = index; i < currentSize - 1; ++i){
			cards[i] = cards[i+1];
		}
		cards[currentSize] = null;
		return temp;
	}
	
	public void display(){
		for(int i = 0; i < currentSize; i++){
			cards[i].display();
		}
	}
}

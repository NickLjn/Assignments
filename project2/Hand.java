package project2;

public class Hand extends GroupOfCards{
	public final int NUM;
	private int shortest = 0;
	
	public Hand(int playerNum, int numberOfCards){
		super(numberOfCards);
		this.NUM = playerNum;
	}
	
	public void sort(){
		int unsorted = getCurrentSize() - 1;
		for(int i = unsorted; i > 0 ; i--){
			int maxIndex = unsorted -1;
			for(int j = 0; j < i; j++){
				int tempValue = getCard(i).getSuit()*13 + getCard(i).getNum();
				int maxValue = getCard(maxIndex).getSuit()*13 + getCard(maxIndex).getNum();
				if(tempValue > maxValue){
					maxIndex = i;
				}
			}
			super.addCard(removeCard(maxIndex));
		}
	}
	
	public void setShortest(){
		int numOfClubs = 0;
		int numOfDiamonds = 0;
		int numOfHearts = 0;
		int numOfSpades = 0;

		for(int i = 0; i < getCurrentSize() ; i++){
			switch(getCard(i).getSuit()){
			
			case 0: numOfClubs ++;
			break;
			
			case 1: numOfDiamonds ++;
			break;
			
			case 2: numOfHearts ++;
			break;
			
			case 3: numOfSpades ++;
			break;
			}
		}
		
		shortest = 0;
		if(numOfDiamonds <= numOfClubs){
			shortest = 1;
		}
		if(numOfSpades <= numOfClubs && numOfSpades <= numOfDiamonds && find(14,3) == -1 && find(13,3)== -1 && find(12,3)== -1){
			shortest = 3;
		}
	}
	
	public int getShortest(){
		return shortest;
	}
	
	public Card playACard(Game game, Trick trick){
		int index = -1;
		if (trick.getCurrentSize() == 0 && (index = findHighest(shortest)) >= 0){
			index=findHighest(shortest)==-1? findLowest(game):findHighest(shortest); 
		}
		else if (trick.getCurrentSize() == game.PLAYERS - 1 && !trick.getHearts() && !trick.getQueen() && (index = findHighest(shortest)) >=0 ){
			System.out.println("shortest 2: " + shortest + " index: " + index);
		}
		else if (trick.getWinningCard() != null && (index = findHighestBelow(trick.getWinningCard())) >= 0){
			System.out.println("findHighestBelow - index: " + index);
		}
		else if (trick.getWinningCard() != null && (index = findMiddleHigh(game, trick.getWinningCard().getSuit())) >= 0) {
			System.out.println("findMiddleHigh - index: " + index);
		}
		else if ((index = find(12, 3)) >= 0); // queen of Spades
		else if ((index = find(14, 3)) >= 0); // Ace of Spades
		else if ((index = find(13, 3)) >= 0); // King of Spades
		else if ((index = findHighest(2)) >= 0); // heart
		else
		{
		  index = findHighest();
		}
		
		Card card = removeCard(index);
		trick.update(NUM, card);
		game.updateHeartsAndQueen(card);
		return card;
	}

	public int findLowest(int suit){
		int min = 15;
		if(findCount(suit) == 0){
			return -1;
		}
		for(int i = 0; i < getCurrentSize(); i++){
			if(getCard(i).getSuit() == suit){
				min = Math.min(min, getCard(i).getNum());
			}
		}
		return min;
	}
	
	private int findCount(int suit){
		int count = 0;
		for(int i = 0; i < getCurrentSize(); i++){
			if(this.getCard(i).getSuit() == suit){
				count++;
			}
		}
		return count;
	}
	
	private int find(int num, int suit){
		for(int i = 0; i < getCurrentSize(); i++){
			if(this.getCard(i).getNum() == num && this.getCard(i).getSuit() == suit){
				return i;
			}
		}
		return -1;
	}
	
	private int findHighest(int suit){
		if(findCount(suit)==0){
			return -1;
		}
		int max = 0;
		int index = 0;
		for(int i = 0; i < getCurrentSize(); i++){
			if(getCard(i).getSuit() == suit){
				max = Math.max(max, getCard(i).getNum());
				index = i;
			}
		}
		return max;
		
	}
	
	private int findLowest(Game game){
		int lowest = -1;
		int lowestNum = 15;
		if(!game.getHearts() && findCount(2) == getCurrentSize()){
			return lowest;
		}
		if(game.getHearts()){
			for(int i =0; i < getCurrentSize(); i++)
				if(getCard(i).getNum() < lowestNum){
					lowestNum = getCard(i).getNum();
					lowest = i;
				}
		}
		else{
			for (int i = 0; i < getCurrentSize(); i++){
				if (getCard(i).getNum() < lowestNum && getCard(i).getSuit() != 2) {
					lowestNum = getCard(i).getNum();
					lowest = i;
				}
			}
		}
		return lowest;
	}
	
	private int findLastHigh(int suit){
		if(suit != 3){
			return findHighest(suit);
		}
		else{
			int highest = -1;
			int highestNum = 0;
			for (int i = 0; i < this.getCurrentSize(); i++){
				if (getCard(i).getSuit() == suit){
					if (getCard(i).getNum() > highestNum && getCard(i).getNum() < 12) {
						highest = i;
						highestNum = getCard(i).getNum();
					}
				}
			}
			return highest;
		}
	}
	
	private int findHighestBelow(Card winningCard){
		int index=-1;
		   int suit=winningCard.getSuit();
		   for(int i=0;i<this.getCurrentSize();i++){
			   if(this.getCard(i).getSuit()==suit){
				   if(this.getCard(i).getNum()<winningCard.getNum()){ 
					   if((i!=this.getCurrentSize()-1 && this.getCard(i+1).getSuit()==suit) || i==this.getCurrentSize()-1 ){
				        index=i;
					   return index;
					   }
				   }
			   }
		   }
		   return index;
	}
	
	private int findMiddleHigh(Game game, int suit){
		if (suit == 3 && game.getQueenOfSpades() == false){
			for (int i = 0; i < getCurrentSize(); i++){
				if (getCard(i).getNum() <= 11){
					return i;
				}
			}
		}
		return findHighest(suit);
	}
	
	private int findHighest(){
		int max = 0;
		int index = 0;
		for (int i = 0; i < getCurrentSize(); i++) {
			if (getCard(i).getNum() > max) {
				max = getCard(i).getNum();
				index = i;
			}
		}
		return index;
	}
}

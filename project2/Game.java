package project2;

public class Game {
	public final int PLAYERS;
	private Deck deck;
	private Hand[] players;
	private Trick[] tricks;
	private int numberOfTricks = 0;
	private boolean hearts = false;
	private boolean queenOfSpades = false;
	
	public Game(int numberOfPlayers){
		PLAYERS = numberOfPlayers;
		players = new Hand[numberOfPlayers];
		int numberOfCards = 52 / numberOfPlayers;
		for(int i = 0; i< numberOfPlayers; i++){
			players[i] = new Hand(i, numberOfCards);
		}
		tricks = new Trick[numberOfCards];
	}
	
	public int getNumberOfTricks(){
		return numberOfTricks;
	}
	
	public boolean getHearts(){
		return hearts;
	}
	
	public boolean getQueenOfSpades(){
		return queenOfSpades;
	}
	
	public void playAGame(){
		deck = new Deck();
		deck.shuffle();
		int cardsLeft = 52% PLAYERS;
		
		for(int i = 0; i < 52/PLAYERS; i++){
			for(int j = 0; j < PLAYERS; j++){
				players[j].addCard(deck.dealCard());
			}
		}
		
		for(int i = 0; i < PLAYERS; i++){
			players[i].sort();
			players[i].setShortest();
		}
		
		int playerNum = 0;
		for(int i = 0; i < PLAYERS; i++){
			System.out.println("player " + i + " shortest= " + players[i].getShortest());
			for(int j = 0; j < players[i].getCurrentSize(); j++){
				players[i].getCard(j).display();
				if(players[i].getCard(j).getSuit() == 0){
					playerNum = i;
				}
			}
		}
		for(int i = 0; i <tricks.length; i++){
			System.out.println();
			System.out.println("Round"+ (i+1));
			tricks[i] = new Trick(PLAYERS);
			int index = playerNum;
			for(int j = 0; j< PLAYERS; j++){
				Card c = new Card(0,0);
				if (i == 0 && j == 0) {
	                c = players[index].removeCard(0);
	            } 
				else{
	                c = players[index].playACard(this, tricks[i]);
	            }
				tricks[i].addCard(c);
				tricks[i].update(index, c);
				System.out.println("player" + index + "      ");
				c.display();
				updateHeartsAndQueen(c);
				if(++index == PLAYERS){
					index = 0;
				}
			}
			
			if(i == 0){
				for(int j = 0; j < cardsLeft; j++){
					Card card  = deck.dealCard();
					tricks[i].addCard(card);
					System.out.println("Undelt Card "+ index + "     ");
					card.display();
					updateHeartsAndQueen(card);
				}
			}
			playerNum = tricks[i].getWinner();
		}
		System.out.println();
		for (int i = 0; i < PLAYERS; i ++) {
            System.out.println("Player " + i + ": score = " + computePoints(i));
        }
	}
	
	public void updateHeartsAndQueen(Card card){
		if( hearts == false && card.getSuit()== 2){
			hearts = true;
			System.out.println("Hearts is now broken");
		}
		if(card.getNum() == 12 && card.getSuit() == 3){
			queenOfSpades = true;
		}
	}
	
	private int computePoints(int playerNum){
		int points =0;
		for(Trick t : tricks){
			if(t.getWinner() == playerNum){
				for(int i = 0; i < t.getCurrentSize(); i++){
					if(t.getCard(i).getNum() == 12 && t.getCard(i).getSuit() == 3){
						points += 13;
					}
					if(t.getCard(i).getSuit() == 2){
						points ++;
					}
				}
			}
		}
		return points;
	}
}

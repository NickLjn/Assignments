package project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	private ArrayList<String>words = new ArrayList<String>();
	private ArrayList<Character>correctList = new ArrayList<Character>();
    private ArrayList<Character>wrongList = new ArrayList<Character>();
    static String choosenWord ;
	
	public Hangman(){}
	
	public Hangman(ArrayList<String>words){
		this.words = words;
		
	}
	
	public String chooseWord(){
		Random rd = new Random();
	    int choosed = rd.nextInt(words.size());
	    String choosenWord = words.get(choosed);
	    return choosenWord;
	}
	
	public void handleGuess(String word){
		Scanner s = new Scanner(System.in);
		String sn = s.next();
		if (word.contains(sn)){
			correctList.add(sn.charAt(0));
			displayWord(word);
			printHangman();
		}
		else{
			wrongList.add(sn.charAt(0));
			displayWord(word);
			printHangman();
		}
	}
	
	public void displayWord(String word){
		for(int i=0; i< word.length();i++){
			if(correctList.contains(word.charAt(i))){
				System.out.print(word.charAt(i));
			}
			else System.out.print("-");
		}
	}
	
	public void playGame(){
		System.out.println("Welcome to Hangman Game!");
		System.out.println("Let's guess words!");
		System.out.println();
	}
	
	public void printHangman(){
		System.out.println();
		if (wrongList.size()==0){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |_____________");	
		}
		else if (wrongList.size()==1){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==2){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==3){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |    ---");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==4){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |    --- ---");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==5){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |    --- ---");
			System.out.println(" |      /");
			System.out.println(" |     /");
			System.out.println(" |");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==6){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |    --- ---");
			System.out.println(" |      / \\");
			System.out.println(" |     /   \\");
			System.out.println(" |");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==7){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |    --- ---");
			System.out.println(" |      / \\");
			System.out.println(" |     /   \\");
			System.out.println(" |   --");
			System.out.println(" |_____________");
	    }
		else if (wrongList.size()==8){
			System.out.println("  ________");
			System.out.println(" |       |");
			System.out.println(" |       0");
			System.out.println(" |       |");
			System.out.println(" |    --- ---");
			System.out.println(" |      / \\");
			System.out.println(" |     /   \\");
			System.out.println(" |   --     --");
			System.out.println(" |_____________");
	    }
		else System.out.println();
	}
	
	
	public boolean gameWon(){
		if(correctList.size()== chooseWord().length() ){
			return true;
		}
		else
			return false;
	}
	
	public boolean gameOver(){
		if (wrongList.size() == 8){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String args[]){
		ArrayList<String> words = new ArrayList<String>();
		words.add("rythm");
		words.add("obligate");
		words.add("excute");

		Hangman game = new Hangman(words);
		String guessword = game.chooseWord();
		game.playGame();
		while (game.correctList.size()!= game.chooseWord().length() && game.wrongList.size()!=8) {
            game.handleGuess(guessword);
            if (game.correctList.size()== game.chooseWord().length()){
                System.out.println("Congratulations!");

            }
            else if (game.wrongList.size()==8){
                System.out.println("Game Over!");
            }
            else continue;
        } 
		
	}
       
}





 


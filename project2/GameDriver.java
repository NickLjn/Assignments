package project2;

import java.util.Scanner;

public class GameDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("Please input number of players.");
			int i = input.nextInt();
			Game game = new Game(i);
			game.playAGame();
			while (true) {
				System.out.println("Play another game? y/n");
				char c=input.next().charAt(0);
				if (c=='n') {
					input.close();
					return;
				}
				if (c=='y')
					break;
			}
			
		}
		
	}

}

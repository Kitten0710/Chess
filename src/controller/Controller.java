package controller;

import model.Game;

public class Controller {
	Game game = new Game();
	public Controller() {
		int count = 1;
		System.out.println(game.isEnd());
		while(game.isEnd() == false) {
			System.out.println(count++);
			game.play();
			if(game.isCheckMated() == true) System.out.println("chieu tuong!");;
		}
	}
}

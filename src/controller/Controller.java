package controller;

import model.Game;

public class Controller {
	Game game = new Game();
	public Controller() {
		while(game.Bkinglive() == true && game.Wkinglive() == true) {
			//if(game.isCheckMated(true) == true) System.out.println("chieu tuong trang!");
			//if(game.isCheckMated(false) == true) System.out.println("chieu tuong den!");
		}
		System.out.println("end game!");
		if(game.Bkinglive() == false) System.out.println("Quan trang win!");
		else if(game.Bkinglive() == false) System.out.println("Quan den win!");
		else System.out.println("Hoa");
	}
}

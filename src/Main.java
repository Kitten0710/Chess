import model.Game;
import time.set_time_black;
import time.set_time_white;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		game.play();
		set_time_white white = new set_time_white();
		set_time_black black = new set_time_black();
	}

}

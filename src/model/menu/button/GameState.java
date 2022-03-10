package model.menu.button;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import model.Game;

public class GameState implements ActionListener{

	private Button bt1;
	private Button bt2;
	
	public GameState() {
		bt1 = new Button(this, "Start", 300, 100, 100, 40);
		bt1 = new Button(this, "Start", 300, 200, 100, 40);
	}

	public void render(Graphics g) {
		bt1.render(g);
		bt2.render(g);
	}
	
	public void mousePressed(MouseEvent e) {
		bt1.mousePressed(e);
		bt2.mousePressed(e);
	}
	
	public void mouseReleased(MouseEvent e) {
		bt1.mouseReleased(e);
		bt2.mouseReleased(e);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getOb() == bt1) {
			Game.State = Game.STATE.GAME;
		}
		if(e.getOb() == bt2) {
			System.exit(0);
		}
	}

}

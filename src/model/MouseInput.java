package model;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		/*
		public Rectangle playButton = new Rectangle(205, 150, 120, 50);
		public Rectangle settingButton = new Rectangle(205, 250, 120, 50);
		public Rectangle exitButton = new Rectangle(205, 350, 120, 50);
		*/
		// Play Button
		if(x >= 205 && x <= 325) {
			if(y >=  150 && y <= 200) {
				Game.State = Game.STATE.GAME;
			}
		}
		// Setting Button ??
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

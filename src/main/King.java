package main;

import main.Spot;
import main.Piece;

public class King implements Spot{
	
	//THH 01
	
	private Piece a;

	public King(Piece a) {
		super();
		this.a = a;
	}

	public King(int x, int y, boolean color, boolean isDead, String name) {
		super();
		this.a = new Piece(x, y, color, isDead, name);
	}
	
	public Piece getA() {
		return a;
	}

	public void setA(Piece a) {
		this.a = a;
	}

	@Override
	public boolean move() {
		if(a.getX() >= 0) {
			// sang trái 1
			if(a.getX() == a.getX() - 1 && a.getY() == a.getY()) return true;
			// sang phải 1
			if(a.getX() == a.getX() + 1 && a.getY() == a.getY()) return true;
			// chéo trái 1
			if(a.getX() == a.getX() - 1 && a.getY() == a.getY() + 1) return true;
			// lên 1
			if(a.getX() == a.getX() && a.getY() == a.getY() + 1) return true;
			// chéo phải 1
			if(a.getX() == a.getX() + 1 && a.getY() == a.getY() + 1) return true;
			// xuống dưới
			if(a.getX() >= 1) {
				// xuống -1
				if(a.getX() == a.getX() && a.getY() == a.getY() - 1) return true;
				// chéo phải -1
				if(a.getX() == a.getX() + 1 && a.getY() == a.getY() - 1) return true;
				// chéo trái -1
				if(a.getX() == a.getX() - 1 && a.getY() == a.getY() - 1) return true;
			}
		}
		return false;
	}

	@Override
	public boolean isCheckMove() {
		// TODO phải kiểm tra xem ô đó trống hay k
		return false;
	}

}

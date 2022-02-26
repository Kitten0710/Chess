package main;

import main.Spot;
import main.Piece;

public class Pawn implements Spot{

	private Piece a;

	public Pawn(Piece a) {
		super();
		this.a = a;
	}

	public Pawn(int x, int y, boolean color, boolean isDead, String name) {
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
		if(a.getX() == a.getX() && a.getY() == a.getY() + 1) return true;
		return false;
	}

	@Override
	public boolean isCheckMove() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

package main;

import main.Spot;
import main.Piece;

public class Rook implements Spot{

	private Piece a;

	public Rook(Piece a) {
		super();
		this.a = a;
	}

	public Rook(int x, int y, boolean color, boolean isDead, String name) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCheckMove() {
		// TODO Auto-generated method stub
		return false;
	}

}

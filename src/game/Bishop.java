package game;

import game.Piece;
import game.Spot;

public class Bishop implements Spot{

	private Piece a;

	public Bishop(Piece a) {
		super();
		this.a = a;
	}

	public Bishop(int x, int y, boolean color, boolean isDead, String name) {
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
	public boolean move(int x, int y) {
		a.move(x, y);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCheckMove() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Piece getPiece() {
		return this.a;
	}

}

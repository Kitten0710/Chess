package game;

import game.Piece;
import game.Spot;

public class King implements Spot{
	
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
	public boolean move(int x, int y) {
		boolean canMove = false; 
		if(Math.abs(x - a.getX()) <= 1 && Math.abs(y - a.getY()) <= 1 && x >= 0 && x < 8 && y >= 0 && y < 8) canMove = true;
		a.move(x, y, canMove);
		return true;
	}

	@Override
	public boolean isCheckMove() {
		// TODO phải kiểm tra xem ô đó trống hay k
		return false;
	}
	
	@Override
	public Piece getPiece() {
		return this.a;
	}
}

package game;

import game.Piece;
import game.Spot;

public class Queen implements Spot{

	private Piece a;

	public Queen(Piece a) {
		super();
		this.a = a;
	}

	public Queen(int x, int y, boolean color, boolean isDead, String name) {
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
	public void move(int x, int y) {
		boolean canMove = false;
		if(x >= 0 && x < 8 && y >= 0 && y < 8) {
			if((x - a.getX() == y - a.getY()) || (x - a.getX() == a.getY() - y) || (x == a.getX() && y != a.getY()) || (x != a.getX() && y == a.getY())) canMove = true;
		}
		a.move(x, y, canMove);
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

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
		boolean canMove = true; 
		if(Math.abs(x - a.getX()) > 1 && Math.abs(y - a.getY()) > 1) canMove = false;
		a.move(x, y, canMove);
//		if(a.getX() >= 0) {
//			// sang trái 1
//			if(a.getX() == a.getX() - 1 && a.getY() == a.getY()) return true;
//			// sang phải 1
//			if(a.getX() == a.getX() + 1 && a.getY() == a.getY()) return true;
//			// chéo trái 1
//			if(a.getX() == a.getX() - 1 && a.getY() == a.getY() + 1) return true;
//			// lên 1
//			if(a.getX() == a.getX() && a.getY() == a.getY() + 1) return true;
//			// chéo phải 1
//			if(a.getX() == a.getX() + 1 && a.getY() == a.getY() + 1) return true;
//			// xuống dưới
//			if(a.getX() >= 1) {
//				// xuống -1
//				if(a.getX() == a.getX() && a.getY() == a.getY() - 1) return true;
//				// chéo phải -1
//				if(a.getX() == a.getX() + 1 && a.getY() == a.getY() - 1) return true;
//				// chéo trái -1
//				if(a.getX() == a.getX() - 1 && a.getY() == a.getY() - 1) return true;
//			}
//		}
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

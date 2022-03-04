package model;

public class Knight implements Spot{
	private Piece a;

	public Knight(Piece a) {
		super();
		this.a = a;
	}

	public Knight(int x, int y, boolean color, boolean isDead, String name) {
		super();
		this.a = new Piece(x, y, color, isDead, name);
	}
	
	public Piece getA() {
		return a;
	}

	public void setA(Piece a) {
		this.a = a;
	}

	/*
	@Override
	public boolean move() {
		// Tiến phải 1
		if(a.getX() == a.getX() + 2 && a.getY() == a.getY()) return true;
		// Tiến phải 2
		if(a.getX() == a.getX() + 1 && a.getY() == a.getY() + 2) return true;
		// Tiến trái 1
		if(a.getX() == a.getX() - 1 && a.getY() == a.getY() + 2) return true;
		// Tiến trái 2
		if(a.getX() == a.getX() - 2 && a.getY() == a.getY() + 1) return true;
		
		// Lui trái 1
		if(a.getX() == a.getX() - 1 && a.getY() == a.getY() - 2) return true;
		// Lui trái 2
		if(a.getX() == a.getX() - 2 && a.getY() == a.getY() - 1) return true;
		// Lui phải 1
		if(a.getX() == a.getX() + 1 && a.getY() == a.getY() - 2) return true;
		// Lui phải 2
		if(a.getX() == a.getX() + 2 && a.getY() == a.getY() - 1) return true;
		return false;
	}
	*/

	// more simple way
	// TODO code function: boolean still_in_the_board() if necessary
	@Override
	public void move(int x, int y) {
		boolean canMove = false; 
		if(x >= 0 && x < 8 && y >= 0 && y < 8) {
			if((Math.abs(x - a.getX()) == 2 && Math.abs(y - a.getY()) == 1) || (Math.abs(x - a.getX()) == 1 && Math.abs(y - a.getY()) == 2)) canMove = true;
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
package game;

import game.Piece;
import game.Spot;

public class Knight implements Spot{
	
	// THH
	
	private Piece a;
	private static int[] moves ={-1, 2, -1, -2, 1, 2, 1, -2, -2, 1, -2, -1, 2, 1, 2, -1 };

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
	public boolean move(int x, int y) {
		boolean canMove = true; 
		a.move(x, y, canMove);
		for(int i = 0; i < moves.length; i++) {
			if(a.getX() == a.getX() + moves[i] && a.getY() == a.getY() + moves[i + 1]) return true;
		}
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

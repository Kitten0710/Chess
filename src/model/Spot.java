package model;

public interface Spot {

	public boolean move(int x, int y);
	
	public void CheckMove();

	public Piece getPiece();

}

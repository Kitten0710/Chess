package model;

public interface Spot {

	public void move(int x, int y);
	
	public boolean isCheckMove();

	public Piece getPiece();

}

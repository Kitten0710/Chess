package model;

public interface Spot {

	public boolean move(int x, int y);
	
	public boolean isCheckMove();

	public Piece getPiece();

}

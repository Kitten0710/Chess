package game;

public interface Spot {

	public boolean move();
	
	public boolean isCheckMove();

	public Piece getPiece();

}
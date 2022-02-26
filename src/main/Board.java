package main;

import java.util.Arrays;

public class Board {
	private Square [][]squares = new Square[8][8];
	
	public Board() {
		super();
	}
	public Square[][] getSquares() {
		return squares;
	}
	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}
	@Override
	public String toString() {
		return "Board:  [squares=" + Arrays.toString(squares) + "]";
	}
	
}

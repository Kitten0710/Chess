package main;

public class Piece {

	private int x;
	private int y;
	private boolean color;
	private boolean isDead;
	private String name;
	
	public Piece(int x, int y, boolean color, boolean isDead, String name) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.isDead = isDead;
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCheckMove() {
		
		return false;
	}
	
	public boolean checkArea() {
		
		return false;
	}

}

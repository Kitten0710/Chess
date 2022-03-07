package model.spot.piece;

import java.awt.Color;

import model.Game;

public class Piece {

	private int x;
	private int y;
	private int px;
	private int py;
	private boolean color;
	private boolean isDead;
	private String name;
	
	public Piece(int x, int y, boolean color, boolean isDead, String name) {
		super();
		this.x = x;
		this.y = y;
		this.px = x*88;
		this.py = y*88;
		this.color = color;
		this.isDead = isDead;
		this.name = name;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
		//this.x = px/88;
	}
	public int getPy() {
		return py;
	}
	public void setPy(int py) {
		this.py = py;
		//this.y = py/88;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.px = x*88;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		this.py = y*88;
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
	public boolean move(int xp, int yp, boolean canMove){
		if(x == xp && y == yp) canMove = false;
		if(canMove == true) {
			System.out.println((color?"White ":"Black ") + name + ": " + (char)(x + 'A') + (8 - y) + " -> " + (char)(xp + 'A') + (8 - yp));
		}
		if(canMove == false) {
			px = this.x*88;
			py = this.y*88;
			return false;
		}
		if(Game.getSpot(xp*88, yp*88) != null){
			if(Game.getSpot(xp*88, yp*88).getPiece().isColor() != color){
				Game.getSpot(xp*88, yp*88).getPiece().kill();
			}else{
				px = this.x*88;
				py = this.y*88;
				return false;
			}
		}
		this.x = xp;
		this.y = yp;
		this.px = xp*88;
		this.py = yp*88;
		if(canMove) return true;
		else return false;
	}
	public void kill(){
		this.isDead = true;
	}

}
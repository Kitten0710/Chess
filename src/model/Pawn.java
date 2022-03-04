package model;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Spot{

	private Piece a;

	public Pawn(Piece a) {
		super();
		this.a = a;
	}

	public Pawn(int x, int y, boolean color, boolean isDead, String name) {
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
	public void move(int x, int y) {
		System.out.println(a.getName() + " " + a.getX() + " " + a.getY());
		boolean canMove = false; 
		if(a.isColor() == false) {	// nếu là tốt đen
			if(Math.abs(x - a.getX()) == 1 && y == a.getY() + 1) {	// kiểm tra giết
				for(Spot p : Game.getWspots()) {
					if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
						if(a.getY() == 6 && y == 7) { // phong hậu
							canMove = true;
							a.move(x, y, canMove);
							Queen b = new Queen(x, y, false, false, "queen");
							List<Spot> l = new ArrayList<Spot>(Game.getBspots());
							l.add(b);
							l.remove(this);
							a.kill();
							Game.setBspots(l);
							return;
						}
						canMove = true;
						a.move(x, y, canMove);
						return;
					}
				}
			} else if(a.getY() == 1) {	// nếu ở vị trí xuất phát
				if(y - a.getY() <= 2 && x == a.getX()) {	// có thể đi 2 bước
					canMove = true;
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					a.move(x, y, canMove);
					return;
				} 
			} else {	// các bước sau
				if(a.getY() == 6 && y == 7) { // phong hậu
					canMove = true;
					a.move(x, y, canMove);
					a.kill();
					Queen b = new Queen(x, y, false, false, "queen");
					List<Spot> l = new ArrayList<Spot>(Game.getWspots());
					l.add(b);
					Game.setWspots(l);
					return;
				}
				if(y - a.getY() == 1 && x == a.getX()) {	// có thể đi 1 bước
					canMove = true;
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					a.move(x, y, canMove);
					return;
				} 
			}
		} else {	// nếu là tốt trắng
			if(Math.abs(x - a.getX()) == 1 && a.getY() == y + 1) {	// kiểm tra giết
				for(Spot p : Game.getBspots()) {
					if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
						if(a.getY() == 1 && y == 0) { // phong hậu
							canMove = true;
							a.move(x, y, canMove);
							Queen b = new Queen(x, y, true, false, "queen");
							List<Spot> l = new ArrayList<Spot>(Game.getWspots());
							l.add(b);
							l.remove(this);
							a.kill();
							Game.setWspots(l);
							return;
						}
						canMove = true;
						a.move(x, y, canMove);
						return;
					}
				}
			} else if(a.getY() == 6) {	// nếu ở vị trí xuất phát
				if(a.getY() - y <= 2 && x == a.getX()) {	// có thể đi 2 bước
					canMove = true;
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					a.move(x, y, canMove);
					return;
				} 
			} else {	// các bước sau
				if(a.getY() - y == 1 && x == a.getX()) {	// có thể đi 1 bước
					if(a.getY() == 1 && y == 0) { // phong hậu
						canMove = true;
						a.move(x, y, canMove);
						Queen b = new Queen(x, y, true, false, "queen");
						List<Spot> l = new ArrayList<Spot>(Game.getWspots());
						l.add(b);
						l.remove(this);
						a.kill();
						Game.setWspots(l);
						return;
					}
					canMove = true;
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					a.move(x, y, canMove);
					return;
				} 
			}
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
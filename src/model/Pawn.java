package model;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Spot{

	private Piece a;

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

	public Pawn(Piece a) {
		super();
		this.a = a;
	}
	@Override
	public boolean move(int x, int y) {
		boolean canMove = false; 
		if(x != a.getX() || y != a.getY())
		if(a.isColor() == false) {	// nếu là tốt đen
			//bắt tốt sang sông
			//			if(a.getY() == 4 && y == 5 && Math.abs(x - a.getX()) == 1
			//					&& Game.getSpot(x*64, (y - 1)*64) != null
			//					&& Game.getSpot(x*64, (y - 1)*64).getPiece().isColor() != a.isColor()) {	
			//				Spot p = Game.getSpot(x*64, (y - 1)*64);
			//				Pawn pawn = (Pawn) p;
			//				if(pawn.getCountTurn() == 1) {
			//					List<Spot> l = new ArrayList<Spot>(Game.getWspots());
			//					l.remove(p);
			//					Game.getSpot(x*64, (y - 1)*64).getPiece().kill();
			//					Game.setWspots(l);
			//					canMove = true;
			//					a.move(x, y, canMove);
			//					countTurn++;
			//					return;
			//				}
			//			}
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
							return canMove;
						}
						canMove = true;
						a.move(x, y, canMove);
						return canMove;
					}
				}
			} else if(a.getY() == 1) {	// nếu ở vị trí xuất phát
				if(y - a.getY() <= 2 && x == a.getX()) {	// có thể đi 2 bước
					canMove = true;
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return canMove;
						}
					}
					a.move(x, y, canMove);
					return canMove;
				} 
			} else {	// các bước sau
				if(a.getY() == 6 && y == 7 && Game.getSpot(x*64, y*64) == null) { // phong hậu
					canMove = true;
					a.move(x, y, canMove);
					a.kill();
					Queen b = new Queen(x, y, false, false, "queen");
					List<Spot> l = new ArrayList<Spot>(Game.getWspots());
					l.add(b);
					Game.setWspots(l);
					return canMove;
				}
				if(y - a.getY() == 1 && x == a.getX()) {	// có thể đi 1 bước
					canMove = true;
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return canMove;
						}
					}
					a.move(x, y, canMove);
					return canMove;
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
							return canMove;
						}
						canMove = true;
						a.move(x, y, canMove);
						return canMove;
					}
				}
			} else if(a.getY() == 6) {	// nếu ở vị trí xuất phát
				if(a.getY() - y <= 2 && x == a.getX()) {	// có thể đi 2 bước
					canMove = true;
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return canMove;
						}
					}
					a.move(x, y, canMove);
					return canMove;
				} 
			} else {	// các bước sau
				if(a.getY() - y == 1 && x == a.getX()) {	// có thể đi 1 bước
					if(a.getY() == 1 && y == 0 && Game.getSpot(x*64, y*64) == null) { // phong hậu
						canMove = true;
						a.move(x, y, canMove);
						Queen b = new Queen(x, y, true, false, "queen");
						List<Spot> l = new ArrayList<Spot>(Game.getWspots());
						l.add(b);
						l.remove(this);
						a.kill();
						Game.setWspots(l);
						return canMove;
					}
					canMove = true;
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == x && p.getPiece().getY() == y) {
							canMove = false;
							a.move(x, y, canMove);
							return canMove;
						}
					}
					a.move(x, y, canMove);
					return canMove;
				} 
			}
		}
		a.move(x, y, canMove);
		return canMove;
	}

	@Override
	public void CheckMove() {
		// TODO Auto-generated method stub
	}

	@Override
	public Piece getPiece() {
		return this.a;
	}

}

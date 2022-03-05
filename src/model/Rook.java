package model;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Spot{
	private Piece a;
	private int countTurn = 0;

	public Rook(Piece a) {
		super();
		this.a = a;
	}

	public Rook(int x, int y, boolean color, boolean isDead, String name) {
		super();
		this.a = new Piece(x, y, color, isDead, name);
	}

	public int getCountTurn() {
		return countTurn;
	}

	public void setCountTurn(int countTurn) {
		this.countTurn = countTurn;
	}

	public Piece getA() {
		return a;
	}

	public void setA(Piece a) {
		this.a = a;
	}

	@Override
	public void move(int x, int y) {
		boolean canMove = false; 
		System.out.println(countTurn);
		Spot b = Game.getSpot(x*64, y*64);
		// nhập thành
		if(b != null && countTurn == 0 && b.getPiece().getName() == "king") {
			King k = (King) b;
			if(a.isColor() == false && k.getCountTurn() == 0) {	// quân đen
				int k1, k2;
				if(x > a.getX()) {
					k1 = a.getX();
					k2 = x;
				} else {
					k1 = x;
					k2 = a.getX();
				}
				for(int i = k1 + 1; i < k2; i++) {
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == i && p.getPiece().getY() == a.getY()) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == i && p.getPiece().getY() == a.getY()) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
				}
				a.kill();
				k.getPiece().kill();
				Rook rook;
				King king;
				if(a.getX() == 7) {	// nhập thành cánh vua
					rook = new Rook(5, 0, false, false, "rook");
					king = new King(6, 0, false, false, "king");
				} else {	//Nếu nhập thành cánh Hậu, 
					rook = new Rook(3, 0, false, false, "rook");
					king = new King(2, 0, false, false, "king");
				}
				List<Spot> l = new ArrayList<Spot>(Game.getBspots());
				l.add(rook);
				l.add(king);
				Game.setBspots(l);
				rook.setCountTurn(1);
				king.setCountTurn(1);
				a.move(x, y, canMove);
				return;
			} else if(a.isColor() == true && k.getCountTurn() == 0) {	// quân trắng
				int k1, k2;
				if(x > a.getX()) {
					k1 = a.getX();
					k2 = x;
				} else {
					k1 = x;
					k2 = a.getX();
				}
				for(int i = k1 + 1; i < k2; i++) {
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == i && p.getPiece().getY() == a.getY()) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == i && p.getPiece().getY() == a.getY()) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
				}
				a.kill();
				k.getPiece().kill();
				Rook rook;
				King king;
				if(a.getX() == 7) {	// nhập thành cánh vua
					rook = new Rook(5, 7, true, false, "rook");
					king = new King(6, 7, true, false, "king");
				} else {	//Nếu nhập thành cánh Hậu, 
					rook = new Rook(3, 7, true, false, "rook");
					king = new King(2, 7, true, false, "king");
				}
				List<Spot> l = new ArrayList<Spot>(Game.getWspots());
				l.add(rook);
				l.add(king);
				Game.setWspots(l);
				rook.setCountTurn(1);
				king.setCountTurn(1);
				a.move(x, y, canMove);
				return;
			}
		}
		
		if((x == a.getX() && y != a.getY()) || (x != a.getX() && y == a.getY()) 
				&& x >= 0 && x < 8 && y >= 0 && y < 8
				&& (a.getX() == x && a.getY() != y) || (a.getX() != x && a.getY() == y)) {
			canMove = true;
			if(Game.getSpot(x*64, y*64) != null) {
				if(Game.getSpot(x*64, y*64).getPiece().isColor() == a.isColor()) {
					canMove = false;
					a.move(x, y, canMove);
					return;
				}
			}
			int k1, k2;
			if(x != a.getX()) {
				if(x > a.getX()) {
					k1 = a.getX();
					k2 = x;
				} else {
					k1 = x;
					k2 = a.getX();
				}
				for(int i = k1 + 1; i < k2; i++) {
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == i && p.getPiece().getY() == a.getY()) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == i && p.getPiece().getY() == a.getY()) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
				}
			} else {
				if(y > a.getY()) {
					k1 = a.getY();
					k2 = y;
				} else {
					k1 = y;
					k2 = a.getY();
				}
				for(int i = k1 + 1; i < k2; i++) {
					for(Spot p : Game.getWspots()) {
						if(p.getPiece().getX() == a.getX() && p.getPiece().getY() == i) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
					for(Spot p : Game.getBspots()) {
						if(p.getPiece().getX() == a.getX() && p.getPiece().getY() == i) {
							canMove = false;
							a.move(x, y, canMove);
							return;
						}
					}
				}
			}
		}
		a.move(x, y, canMove);
		if(canMove == true) countTurn++;
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

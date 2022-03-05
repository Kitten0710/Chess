package model;

import java.util.ArrayList;
import java.util.List;

public class King implements Spot{
	private Piece a;
	private int countTurn = 0;
	public King(Piece a) {
		super();
		this.a = a;
	}

	public King(int x, int y, boolean color, boolean isDead, String name) {
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
		if(countTurn == 0 && b.getPiece().getName() == "rook") {
			Rook r = (Rook) b;
			if(a.isColor() == false && r.getCountTurn() == 0) {	// quân đen
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
				r.getPiece().kill();
				Rook rook;
				King king;
				if(x == 7) {	// nhập thành cánh vua
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
			} else if(a.isColor() == true && r.getCountTurn() == 0) {	// quân trắng
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
				r.getPiece().kill();
				Rook rook;
				King king;
				if(x == 7) {	// nhập thành cánh vua
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
		if(Math.abs(x - a.getX()) <= 1 && Math.abs(y - a.getY()) <= 1 
				&& x >= 0 && x < 8 && y >= 0 && y < 8) {
			canMove = true;
			if(b != null) {
				if(b.getPiece().isColor() == a.isColor()) {
					canMove = false;
					a.move(x, y, canMove);
					return;
				}
			}
			
			
			
		}
		a.move(x, y, canMove);
		if(canMove == true) countTurn++;
	}

	@Override
	public boolean isCheckMove() {
		// TODO phải kiểm tra xem ô đó trống hay k
		return false;
	}
	
	@Override
	public Piece getPiece() {
		return this.a;
	}
}

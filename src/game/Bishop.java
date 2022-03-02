package game;

import game.Piece;
import game.Spot;

public class Bishop implements Spot{

	private Piece a;

	public Bishop(Piece a) {
		super();
		this.a = a;
	}

	public Bishop(int x, int y, boolean color, boolean isDead, String name) {
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
		boolean canMove = false;
		System.out.println(x + " " + y);
		if(x >= 0 && x < 8 && y >= 0 && y < 8) {
			if((x - a.getX() == y - a.getY()) || (x - a.getX() == a.getY() - y)) {
				canMove = true;
				int kx1, kx2, ky1, ky2;
				if((x - a.getX() == y - a.getY())) {
					if(x > a.getX()) {
						kx1 = a.getX();
						kx2 = x;
						ky1 = a.getY();
						ky2 = y;
					} else {
						kx1 = x;
						kx2 = a.getX();
						ky1 = y;
						ky2 = a.getY();
					}
					for(int i = kx1 + 1; i < kx2; i++) {
						for(int j = ky2 - 1; j > ky1; j--) {
							for(Spot p : Game.getWspots()) {
								if(p.getPiece().getX() == i && p.getPiece().getY() == j) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
							for(Spot p : Game.getBspots()) {
								if(p.getPiece().getX() == i && p.getPiece().getY() == j) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
						}
					}
				} else {
					if(y < a.getY()) {
						kx1 = a.getX();
						kx2 = x;
						ky1 = y;
						ky2 = a.getY();
					} else {
						kx1 = x;
						kx2 = a.getX();
						ky1 = a.getY();
						ky2 = y;
					}
					for(int i = kx1 + 1; i < kx2; i++) {
						for(int j = ky2 - 1; j > ky1; j--) {
							for(Spot p : Game.getWspots()) {
								if(p.getPiece().getX() == i && p.getPiece().getY() == j) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
							for(Spot p : Game.getBspots()) {
								if(p.getPiece().getX() == i && p.getPiece().getY() == j) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
						}
					}
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

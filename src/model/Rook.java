package model;

public class Rook implements Spot{

	private Piece a;

	public Rook(Piece a) {
		super();
		this.a = a;
	}

	public Rook(int x, int y, boolean color, boolean isDead, String name) {
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
		if((x == a.getX() && y != a.getY()) || (x != a.getX() && y == a.getY()) && x >= 0 && x < 8 && y >= 0 && y < 8) {
			canMove = true;
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
						if(p.getPiece().getX() == a.getX() && p.getPiece().getY() == i) {
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

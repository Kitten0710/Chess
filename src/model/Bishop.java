package model;

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
				int k;
				if((x - a.getX() == y - a.getY())) { // cheo chinh
					if(x > a.getX()) {
						k = x - a.getX();
						for(int i = 1; i < k; i++) {
							for(Spot p : Game.getWspots()) {
								if(p.getPiece().getX() == a.getX() + i && p.getPiece().getY() == a.getY() + i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
							for(Spot p : Game.getBspots()) {
								if(p.getPiece().getX() == a.getX() + i && p.getPiece().getY() == a.getY() + i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
						}
					} else {
						k = a.getX() - x;
						for(int i = 1; i < k; i++) {
							for(Spot p : Game.getWspots()) {
								if(p.getPiece().getX() == x + i && p.getPiece().getY() == y + i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
							for(Spot p : Game.getBspots()) {
								if(p.getPiece().getX() == x + i && p.getPiece().getY() == y + i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
						}
					}
				} else if(x - a.getX() == a.getY() - y) { // cheo phu
					if(x > a.getX()) {
						k = x - a.getX();
						for(int i = 1; i < k; i++) {
							for(Spot p : Game.getWspots()) {
								if(p.getPiece().getX() == a.getX() + i && p.getPiece().getY() == a.getY() - i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
							for(Spot p : Game.getBspots()) {
								if(p.getPiece().getX() == a.getX() + i && p.getPiece().getY() == a.getY() - i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
						}
					} else if(x < a.getX()){
						k = a.getX() - x;
						for(int i = 1; i < k; i++) {
							for(Spot p : Game.getWspots()) {
								if(p.getPiece().getX() == x + i && p.getPiece().getY() == y - i) {
									canMove = false;
									a.move(x, y, canMove);
									return;
								}
							}
							for(Spot p : Game.getBspots()) {
								if(p.getPiece().getX() == x + i && p.getPiece().getY() == y - i) {
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

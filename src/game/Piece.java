package game;

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
		this.px = x*64;
		this.py = y*64;
		this.color = color;
		this.isDead = isDead;
		this.name = name;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
		this.x = px/64;
	}
	public int getPy() {
		return py;
	}
	public void setPy(int py) {
		this.py = py;
		this.y = py/64;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.px = x*64;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		this.py = y*64;
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
	public void move(int xp,int yp){
		
		if(Game.getSpot(xp*64, yp*64) != null){
			if(Game.getSpot(xp*64, yp*64).getPiece().isColor() != color){
				Game.getSpot(xp*64, yp*64).getPiece().kill();
			}else{
				px = this.x*64;
				py = this.y*64;
				return;
			}
		}
		this.x = xp;
		this.y = yp;
		this.px = xp*64;
		this.py = yp*64;
	}
	public void kill(){
		this.isDead = true;
	}

}

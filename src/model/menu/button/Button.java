package model.menu.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Button {

	private int x;
	private int y;
	private int width;
	private int height;
	
	private boolean enabled;
	private boolean pressed;
	
	private String text;
	private final Font font = new Font("arial", Font.BOLD, 32);
	private ActionListener listener;
	
	public Button(ActionListener listener, String text, int x, int y, int width, int height) {
		super();
		this.listener = listener;
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) {
		if(pressed) {
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.cyan);
		}
		if(enabled) {
			g.fillRect(x, y, width, height);
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString(text, x + width / 2, y + height / 2);
		}
	}
	
	public boolean isPressed(int x, int y) {
		return x>= this.x && x <= this.x + width
				&& y >= this.y && y <= this.y + height;
	}
	
	public void mousePressed(MouseEvent e) {
		if(isPressed(e.getX(), e.getY())) {
			pressed = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(pressed && enabled) {
			listener.actionPerformed(new ActionEvent(this));
			pressed = false;
		}
	}
	

}

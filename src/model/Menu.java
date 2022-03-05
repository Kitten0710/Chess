package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
			
	public Rectangle playButton = new Rectangle(205, 150, 120, 50);
	public Rectangle settingButton = new Rectangle(205, 250, 120, 50);
	public Rectangle exitButton = new Rectangle(205, 350, 120, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font f = new Font("arial", Font.BOLD, 32);
		g.setFont(f);
		g.setColor(Color.BLUE);
		g.setColor(new Color(57, 172, 115));
		g.drawString("CHESS GAME", 150, 100);
		
		Font f1 = new Font("arial", Font.BOLD, 24);
		g.setFont(f1);
		g.drawString("PLAY", playButton.x + 28, playButton.y + 34);
		g2d.draw(playButton);
		g.drawString("SETTING", settingButton.x + 10, settingButton.y + 34);
		g2d.draw(settingButton);
		g.drawString("EXIT", exitButton.x + 36, exitButton.y + 34);
		g2d.draw(exitButton);
		
		/*
		try {
			BufferedImage image = ImageIO.read(new File("D:\\Background & Theme\\Walpaper\\TXT\\txt.jpg"));
			g.drawImage(image, 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

}

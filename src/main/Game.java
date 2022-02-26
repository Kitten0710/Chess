package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
	private Board board;
	private Player []player = new Player[2];
	private Spot []spots = new Spot[32];
	public Game() {
		super();
		this.board = new Board();
		BufferedImage all = null;
		try {
			all = ImageIO.read(new File("D:\\chess.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgs[] = new Image[12];
		int ind=0;
		for(int y = 0; y < 400; y += 200){
			for(int x = 0; x < 1200; x += 200){
				imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
				ind++;
			}    
		}
		JFrame frame = new JFrame();
		frame.setBounds(30, 30, 525, 550);
		//frame.setUndecorated(true);
		//frame.setSize(532, 522);
		frame.setTitle("Chess");
		JPanel pn = new JPanel() {
			@Override
			public void paint(Graphics g) {
				boolean white = true;
				for(int y = 0; y < 8; y++)
				{
					for(int x = 0; x < 8; x++)
					{
						if(white) g.setColor(new Color(235,235, 208));
						else g.setColor(new Color(119, 148, 85));
						g.fillRect(x*64, y*64, 64, 64);
						white =! white;
					}
					white =! white;
				}
			}
		};
		frame.add(pn);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Player[] getPlayer() {
		return player;
	}
	public void setPlayer(Player[] player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return "Game [board=" + board + ", player=" + Arrays.toString(player) + "]";
	}
	
	public boolean isEnd() {
		return false;
	}
	
	public boolean isTurn() {
		return false;
	}
	
	public boolean isCheckMated() {
		return false;
	}
	
	public void play() {
		
	}
}

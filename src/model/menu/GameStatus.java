package model.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Game;

public class GameStatus extends JFrame implements ActionListener{

	private JPanel bwin = new JPanel();
	private JPanel wwin = new JPanel();
	private JPanel draw = new JPanel();

	public GameStatus() {

		//===== Black win =====
			// JText 1
		JTextField jt1 = new JTextField("BLACK WON!!!");
		jt1.setFont(new Font("Arial", Font.BOLD, 36));
		jt1.setEditable(false);
		jt1.setBackground(new Color(255, 230, 204));
		jt1.setBounds(900, 100, 250, 50);
		jt1.setBorder(null);
		jt1.setForeground(Color.black);
			// Jpanel Black Win
		bwin.setBounds(500, 500, 500, 500);
		bwin.setBackground(new Color(255, 235, 204));
		try {
			JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("img\\blackKing2.png"))));
			bwin.add(bg);
			bwin.add(jt1);
			this.add(bwin);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//===== White Win =====
			// JText 2
		JTextField jt2 = new JTextField("WHITE WON!!!");
		jt2.setFont(new Font("Arial", Font.BOLD, 36));
		jt2.setEditable(false);
		jt2.setBackground(new Color(167,226,245));
		jt2.setBounds(900, 100, 250, 50);
		jt2.setBorder(null);
		jt2.setForeground(Color.black);
			// Jpanel White Win
		wwin.setBounds(500, 500, 500, 500);
		wwin.setBackground(new Color(167,226,245));
		try {
			JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("img\\whiteKing2.png"))));
			wwin.add(bg);
			wwin.add(jt2);
			this.add(wwin);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//===== Draw =====
			// JText 3
		JTextField jt3 = new JTextField("<>DRAW<>");
		jt3.setFont(new Font("Arial", Font.BOLD, 36));
		jt3.setEditable(false);
		jt3.setBackground(new Color(255,159,125));
		jt3.setBounds(900, 100, 250, 50);
		jt3.setBorder(null);
		jt3.setForeground(Color.black);
			// Jpanel Draw
		draw.setBounds(500, 500, 500, 500);
		draw.setBackground(new Color(255,159,125));
		try {
			JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("img\\draw1.1.png"))));
			draw.add(bg);
			draw.add(jt3);
			this.add(draw);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setResizable(false);
		this.setSize(360, 360);
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Game game = new Game();
		if(game.Bkinglive() == false) {
			//this.add(wwin);
			this.setVisible(true);
		}
		if(game.Wkinglive() == false) {
			//this.add(bwin);
			this.setVisible(true);
		}
	}

}

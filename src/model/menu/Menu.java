package model.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Game;
import model.Sound;

public class Menu extends JFrame implements ActionListener{

	JButton startBtn = new JButton("START");
	JButton exitBtn = new JButton("EXIT");
	
	Sound sound = new Sound();
	public Menu() {
		playMusic(0);
		this.setTitle("CHESS GAME"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 400, 1148, 688);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		//===== Start Button =====
		startBtn.setBounds(490, 250, 150, 50);
		startBtn.setFont(new Font("Arial", Font.BOLD, 32));
		startBtn.setBackground(new Color(167, 226, 245));
		startBtn.setBorder(null);
		startBtn.setFocusPainted(false);
		//===== Exit Button =====
		exitBtn.setBounds(490, 350, 150, 50);
		exitBtn.setFont(new Font("Arial", Font.BOLD, 32));
		exitBtn.setBackground(new Color(167, 226, 245));
		exitBtn.setBorder(null);
		exitBtn.setFocusPainted(false);
		
		try {
			JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("img\\bg9.jpg"))));
			this.add(bg);
			bg.add(startBtn, BorderLayout.CENTER);
			bg.add(exitBtn, BorderLayout.CENTER);
		} catch (IOException e) {
            e.printStackTrace();
       }
		startBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		this.setVisible(true);

	}
	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	public void stopMusic() {
		sound.stop();
	}
	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {
			Game game = new Game();
			this.setVisible(false);
			stopMusic();
		}
		if(e.getSource() == exitBtn)
			System.exit(0);
	}

}

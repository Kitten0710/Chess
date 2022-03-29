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

public class Menu extends JFrame implements ActionListener{

	JButton startBtn = new JButton("START");
	JButton exitBtn = new JButton("EXIT");

	public Menu() {

		this.setTitle("CHESS GAME"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 400, 1148, 688);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		startBtn.setBounds(320, 300, 150, 50);
		startBtn.setFont(new Font("Arial", 0, 32));
		startBtn.setBackground(Color.white);
		exitBtn.setBounds(320, 400, 150, 50);
		exitBtn.setFont(new Font("Arial", 0, 32));
		exitBtn.setBackground(Color.white);
		
		try {
			JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("img\\bg8.jpg"))));
			bg.setSize(1148, 688);
			
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {
			Game game = new Game();
		}
		if(e.getSource() == exitBtn)
			System.exit(0);
	}

}

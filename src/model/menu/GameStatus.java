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

public class GameStatus extends JFrame implements ActionListener{

	private JPanel bwin = new JPanel();
	private JPanel wwin = new JPanel();
	private JPanel draw = new JPanel();

	public GameStatus() {
		//===== Black win =====
		JTextField jt1 = new JTextField("BLACK WON!!!");
		jt1.setFont(new Font("Arial", Font.BOLD, 36));
		jt1.setEditable(false);
		//jt1.setBackground(Color.white);
		jt1.setBounds(70, 300, 250, 50);
		jt1.setBorder(null);
		bwin.setBounds(500, 500, 500, 500);
		bwin.setBackground(Color.white);
		//bwin.add(jt1);
		try {
			JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("img\\blackKing1.png"))));
			bg.setBounds(80, 100, 40, 40);
			this.add(bg);
			bg.add(jt1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setResizable(false);
		this.setSize(400, 400);
		this.setBackground(new Color(255, 229, 153));
		//this.add(bwin);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

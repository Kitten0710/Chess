package model;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import model.board.Board;
import model.menu.Menu;
import model.menu.button.GameState;
import model.spot.Spot;
import model.spot.piece.Bishop;
import model.spot.piece.King;
import model.spot.piece.Knight;
import model.spot.piece.Pawn;
import model.spot.piece.Queen;
import model.spot.piece.Rook;



public class Game implements ActionListener{
	private Board board;
	private static List<Spot> bspots = new ArrayList<Spot>();
	private static List<Spot> wspots = new ArrayList<Spot>();
	private Spot selectedSpot = null;
	private static boolean isContinue = true; 
	private static boolean isTurn = true;

	public static enum STATE{
		MENU,
		GAME
	};
	public static STATE State = STATE.MENU;
	private GameState menu = new GameState();
	//===Time_setting===
	JLabel timeLabel1 = new JLabel();
	JLabel timeLabel2 = new JLabel();
	int seconds = 0;
	int minutes = 15;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	JButton W_startButton = new JButton("START");
	JButton W_resetButton = new JButton("RESET");
	boolean started = false;
	public Game() {
		Rook brook      = new Rook(0, 0, false, false, "rook");
		bspots.add(brook);
		Knight bkinght  = new Knight(1, 0, false, false, "knight");
		bspots.add(bkinght);
		Bishop bbishop  = new Bishop(2, 0, false, false, "bishop");
		bspots.add(bbishop);
		Queen bqueen    = new Queen(3, 0, false, false, "queen");
		bspots.add(bqueen);
		King bking      = new King(4, 0, false, false, "king");
		bspots.add(bking);
		Bishop bbishop2 = new Bishop(5, 0, false, false, "bishop");
		bspots.add(bbishop2);
		Knight bknight2 = new Knight(6, 0, false, false, "knight");
		bspots.add(bknight2);
		Rook brook2     = new Rook(7, 0, false, false, "rook");
		bspots.add(brook2);
		Pawn bpawn1     = new Pawn(1, 1, false, false, "pawn");
		bspots.add(bpawn1);
		Pawn bpawn2     = new Pawn(2, 1, false, false, "pawn");
		bspots.add(bpawn2);
		Pawn bpawn3     = new Pawn(3, 1, false, false, "pawn");
		bspots.add(bpawn3);
		Pawn bpawn4     = new Pawn(4, 1, false, false, "pawn");
		bspots.add(bpawn4);
		Pawn bpawn5     = new Pawn(5, 1, false, false, "pawn");
		bspots.add(bpawn5);
		Pawn bpawn6     = new Pawn(6, 1, false, false, "pawn");
		bspots.add(bpawn6);
		Pawn bpawn7     = new Pawn(7, 1, false, false, "pawn");
		bspots.add(bpawn7);
		Pawn bpawn8     = new Pawn(0, 1, false, false, "pawn");
		bspots.add(bpawn8);

		Rook wrook      = new Rook(0, 7, true, false, "rook");
		wspots.add(wrook);
		Knight wknight  = new Knight(1, 7, true, false, "knight");
		wspots.add(wknight);
		Bishop wbishop  = new Bishop(2, 7, true, false, "bishop");
		wspots.add(wbishop);
		Queen wqueen    = new Queen(3, 7, true, false, "queen");
		wspots.add(wqueen);
		King wking      = new King(4, 7, true, false, "king");
		wspots.add(wking);
		Bishop wbishop2 = new Bishop(5, 7, true, false, "bishop");
		wspots.add(wbishop2);
		Knight wknight2 = new Knight(6, 7, true, false, "knight");
		wspots.add(wknight2);
		Rook wrook2     = new Rook(7, 7, true, false, "rook");
		wspots.add(wrook2);
		Pawn wpawn1     = new Pawn(1, 6, true, false, "pawn");
		wspots.add(wpawn1);
		Pawn wpawn2     = new Pawn(2, 6, true, false, "pawn");
		wspots.add(wpawn2);
		Pawn wpawn3     = new Pawn(3, 6, true, false, "pawn");
		wspots.add(wpawn3);
		Pawn wpawn4     = new Pawn(4, 6, true, false, "pawn");
		wspots.add(wpawn4);
		Pawn wpawn5     = new Pawn(5, 6, true, false, "pawn");
		wspots.add(wpawn5);
		Pawn wpawn6     = new Pawn(6, 6, true, false, "pawn");
		wspots.add(wpawn6);
		Pawn wpawn7     = new Pawn(7, 6, true, false, "pawn");
		wspots.add(wpawn7);
		Pawn wpawn8     = new Pawn(0, 6, true, false, "pawn");
		wspots.add(wpawn8);

		this.board = new Board();
		BufferedImage all = null;
		try {
			all = ImageIO.read(new File("img\\chess.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgs[] = new Image[12];
		int ind=0;
		for(int y = 0; y < 400; y += 200){
			for(int x = 0; x < 1200; x += 200){
				imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(81, 81, BufferedImage.SCALE_SMOOTH);
				ind++;
			}    
		}

		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.setUndecorated(true);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(648 + 500, 648 + 40);
		frame.setTitle("Chess");

		//board_game_setting
		JLabel lb1 = new JLabel() {
			@Override
			public void paint(Graphics g) {
				boolean white = true;
				//if(State == STATE.GAME) {
				for(int y = 0; y < 8; y++)
				{
					for(int x = 0; x < 8; x++)
					{
						if(white) g.setColor(new Color(235,235, 208));
						else g.setColor(new Color(119, 148, 85));
						g.fillRect(x*81, y*81, 81, 81);
						white =! white;
					}
					white =! white;
				}
				for(Spot p: wspots)
				{
					if(p.getPiece().isDead() == true) continue;
					int id = 0;
					if(p.getPiece().getName().equalsIgnoreCase("king")){
						id = 0;
					}
					if(p.getPiece().getName().equalsIgnoreCase("queen")){
						id = 1;
					}
					if(p.getPiece().getName().equalsIgnoreCase("bishop")){
						id = 2;
					}
					if(p.getPiece().getName().equalsIgnoreCase("knight")){
						id = 3;
					}
					if(p.getPiece().getName().equalsIgnoreCase("rook")){
						id = 4;
					}
					if(p.getPiece().getName().equalsIgnoreCase("pawn")){
						id = 5;
					}
					if(!p.getPiece().isColor()){
						id += 6;
					}
					g.drawImage(imgs[id], p.getPiece().getPx(), p.getPiece().getPy(), this);
				}
				for(Spot p: bspots)
				{
					if(p.getPiece().isDead() == true) continue;
					int id = 0;
					if(p.getPiece().getName().equalsIgnoreCase("king")){
						id = 0;
					}
					if(p.getPiece().getName().equalsIgnoreCase("queen")){
						id = 1;
					}
					if(p.getPiece().getName().equalsIgnoreCase("bishop")){
						id = 2;
					}
					if(p.getPiece().getName().equalsIgnoreCase("knight")){
						id = 3;
					}
					if(p.getPiece().getName().equalsIgnoreCase("rook")){
						id = 4;
					}
					if(p.getPiece().getName().equalsIgnoreCase("pawn")){
						id = 5;
					}
					if(!p.getPiece().isColor()){
						id += 6;
					}
					g.drawImage(imgs[id], p.getPiece().getPx(), p.getPiece().getPy(), this);
				}
				//} else if(State == STATE.MENU) {
				//	menu.render(g);
				//}
			}
		};
		//===mouse_listener===
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(selectedSpot != null && selectedSpot.getPiece().isColor() != isTurn) {
					selectedSpot = null;
					return;
				}
				if(selectedSpot != null) {

					selectedSpot.getPiece().setPx((e.getX() - 40));
					selectedSpot.getPiece().setPy((e.getY() - 70));
					frame.repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});

		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			//Mouse_press
			@Override
			public void mousePressed(MouseEvent e) {
				if(getSpot(e.getX() - 8, e.getY() - 31) != null) {
					selectedSpot = getSpot(e.getX() - 8, e.getY() - 31);
					System.out.println(selectedSpot.getPiece().getName());
				}
			}

			//Mouse_release
			@Override
			public void mouseReleased(MouseEvent e) {
				if(selectedSpot != null) {
					if(selectedSpot.move((e.getX() - 8)/81, (e.getY() - 31)/81) == true) {
						if(isTurn == true) isTurn = false;
						else isTurn = true;
					}

					selectedSpot.move((e.getX() - 8)/81, (e.getY() - 31)/81);
					Iterator<Spot> itr1 = wspots.iterator();
					while(itr1.hasNext()) {
						Spot temp = itr1.next();
						if(temp.getPiece().isDead() == true) {
							itr1.remove();
						}
					}
					Iterator<Spot> itr2 = bspots.iterator();
					while(itr2.hasNext()) {
						Spot temp = itr2.next();
						if(temp.getPiece().isDead() == true) {
							itr2.remove();
						}
					}
					frame.repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lb1.setSize(648, 648);
		//===Time_label_1_setting===

		timeLabel1.setText(minutes_string+":"+seconds_string);
		timeLabel1.setBounds(655,0,470,163);
		timeLabel1.setFont(new Font("Verdana",Font.PLAIN,70));
		timeLabel1.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel1.setOpaque(true);
		timeLabel1.setHorizontalAlignment(JTextField.CENTER);

		//===Time_label_2_setting===

		timeLabel2.setText(minutes_string+":"+seconds_string);
		timeLabel2.setBounds(655,485,470,163);
		timeLabel2.setFont(new Font("Verdana",Font.PLAIN,70));
		timeLabel2.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel2.setOpaque(true);
		timeLabel2.setHorizontalAlignment(JTextField.CENTER);

		W_startButton.setBounds(950,200,130,60);
		W_startButton.setFocusable(false);
		W_startButton.addActionListener(this);

		W_resetButton.setBounds(950,300,130,60);
		W_resetButton.setFocusable(false);
		W_resetButton.addActionListener(this);

		//===Frame_add_setting===
		frame.add(W_startButton);
		frame.add(W_resetButton);
		frame.add(timeLabel1);
		frame.add(timeLabel2);
		frame.add(lb1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	//===Time_setting===
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(seconds>0) {
				seconds = seconds-1;
			}
			else if(seconds==0 && minutes>0) {
				minutes = minutes - 1;
				seconds = 59;
			}
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			timeLabel1.setText(minutes_string+":"+seconds_string);

		}

	});
	//===Time_run===
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==W_startButton) {

			if(started==false) {
				started=true;
				W_startButton.setText("STOP");
				start();
			}
			else {
				started=false;
				W_startButton.setText("START");
				stop();
			}

		}
		if(e.getSource()==W_resetButton) {
			started=false;
			reset();
		}
	}
	//===button===
	void start() {
		timer.start();
	}

	void stop() {
		timer.stop();
	}

	void reset() {
		timer.stop();
		seconds = 0;
		minutes = 15;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		timeLabel1.setText(minutes_string+":"+seconds_string);
	}
	public static Spot getSpot(int x, int y){
		int xp = x/81;
		int yp = y/81;
		for(Spot p: bspots){
			if(xp == p.getPiece().getX() && yp== p.getPiece().getY()){
				return p;
			}
		}
		for(Spot p: wspots){
			if(xp == p.getPiece().getX() && yp== p.getPiece().getY()){
				return p;
			}
		}
		return null;
	}
	public void play() {

	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isEnd() {
		boolean bkinglive = false, wkinglive = false;
		for(Spot p : bspots) {
			if(p.getPiece().getName() == "king" && p.getPiece().isDead() == false) {
				bkinglive = true;
			}
		}
		for(Spot p : wspots) {
			if(p.getPiece().getName() == "king" && p.getPiece().isDead() == false) {
				wkinglive = true;
			}
		}	
		if(bkinglive == true || wkinglive == true) return false;
		else return true;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public boolean isCheckMated() {
		for(Spot p : bspots) {
			if(p.getPiece().getName() == "king" && ((King) (p)).CheckMate(false) == true) {
				System.out.println("Vua den dang bi chieu");	
				return true;
			}
		}
		for(Spot p : wspots) {
			if(p.getPiece().getName() == "king" && ((King) (p)).CheckMate(true) == true) {
				System.out.println("Vua trang dang bi chieu");	
				return true;
			}
		}
		return false;
	}
	public static List<Spot> getWspots() {
		return wspots;
	}
	public static void setWspots(List<Spot> wspots) {
		Game.wspots = wspots;
	}
	public static List<Spot> getBspots() {
		return bspots;
	}
	public static void setBspots(List<Spot> bspots) {
		Game.bspots = bspots;
	}
	public static boolean isContinue() {
		return isContinue;
	}
	public static void setTurn(boolean isTurn) {
		Game.isTurn = isTurn;
	}
	public static void setContinue(boolean isContinue) {
		Game.isContinue = isContinue;
	}





}

package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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



public class Game {
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
				imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(72, 72, BufferedImage.SCALE_SMOOTH);
				ind++;
			}    
		}
		JFrame frame = new JFrame();
		//frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setBounds(100, 100, 576, 576);
		frame.setTitle("Chess");
		JPanel pn = new JPanel() {
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
						g.fillRect(x*72, y*72, 72, 72);
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
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(selectedSpot != null && selectedSpot.getPiece().isColor() != isTurn) {
					selectedSpot = null;
					return;
				}
				if(selectedSpot != null){
					selectedSpot.getPiece().setPx((e.getX()));
					selectedSpot.getPiece().setPy((e.getY()));
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

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
				if(getSpot(e.getX(), e.getY()) != null) selectedSpot = getSpot(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(selectedSpot != null) {
					if(selectedSpot.move((e.getX())/72, (e.getY())/72) == true) {
						if(isTurn == true) isTurn = false;
						else isTurn = true;
					}
					selectedSpot.move((e.getX())/72, (e.getY())/72);
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
		//pn.setPreferredSize(new Dimension(1000, 600));
		pn.setBackground(Color.red);
		pn.setLayout(new FlowLayout());
		frame.add(pn);
		frame.setDefaultCloseOperation(3);
		//		JButton startButton = new JButton("START");
		//		JButton resetButton = new JButton("RESET");
		//		JLabel timeLabel = new JLabel();
		//		JLabel timeLabel2 = new JLabel();
		//		JPanel pn2 = new JPanel();
		//		int seconds =0;
		//		int minutes =1;
		//		int hours =0;
		//		boolean started = true;
		//		String seconds_string = String.format("%02d", seconds);
		//		String minutes_string = String.format("%02d", minutes);
		//		String hours_string = String.format("%02d", hours);
		//
		//		Timer timer = new Timer(1000, new ActionListener() {
		//
		//			public void actionPerformed(ActionEvent e) {
		//
		//				if(seconds>0) {
		//					seconds = seconds-1;
		//				}
		//				else if(seconds==0 && minutes>0) {
		//					minutes = minutes - 1;
		//					seconds = 59;
		//				}
		//				seconds_string = String.format("%02d", seconds);
		//				minutes_string = String.format("%02d", minutes);
		//				hours_string = String.format("%02d", hours);
		//				timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		//
		//			}
		//
		//		});
		//		Timer timer2 = new Timer(1000, new ActionListener() {
		//
		//			public void actionPerformed(ActionEvent e) {
		//
		//				if(seconds>0) {
		//					seconds = seconds-1;
		//				}
		//				else if(seconds==0 && minutes>0) {
		//					minutes = minutes - 1;
		//					seconds = 59;
		//				}
		//				seconds_string = String.format("%02d", seconds);
		//				minutes_string = String.format("%02d", minutes);
		//				hours_string = String.format("%02d", hours);
		//				timeLabel2.setText(hours_string+":"+minutes_string+":"+seconds_string);
		//
		//			}
		//
		//		});
		//		pn2.add(timeLabel);
		//		pn2.add(timeLabel2);
		//		pn2.add(startButton);
		//		pn2.add(resetButton);
		//		pn2.setLayout(null);
		//		pn2.setBackground(Color.red);
		//		pn2.setBounds(10, 10, 500, 500);
		//		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		//		timeLabel.setBounds(100,100,200,100);
		//		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		//		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		//		timeLabel.setOpaque(true);
		//		timeLabel2.setText(hours_string+":"+minutes_string+":"+seconds_string);
		//		timeLabel2.setBounds(100,350,200,100);
		//		timeLabel2.setFont(new Font("Verdana",Font.PLAIN,35));
		//		timeLabel2.setBorder(BorderFactory.createBevelBorder(1));
		//		timeLabel2.setOpaque(true);
		//		startButton.setBounds(200,200,100,50);
		//		startButton.setFocusable(false);
		//		startButton.addActionListener(this);
		//
		//		resetButton.setBounds(200,300,100,50);
		//		resetButton.setFocusable(false);
		//		resetButton.addActionListener(this);


		pn.setBounds(0, 0, 704, 704);
		frame.add(pn);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public static Spot getSpot(int x, int y){
		int xp = x/72;
		int yp = y/72;
		for(Spot p: bspots){
			if(xp == p.getPiece().getX() && yp== p.getPiece().getY()){
				return p;
			}
		}
		for(Spot p: wspots){
			if(xp == p.getPiece().getX()&& yp== p.getPiece().getY()){
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
		return bkinglive && wkinglive;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public boolean isCheckMated() {
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

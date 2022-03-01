package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Game {
	private Board board;
	private Player []player = new Player[2];
	private Pawn []Pawns = new Pawn[32];
	private static List<Spot> bspots = new ArrayList<Spot>();
	private static List<Spot> wspots = new ArrayList<Spot>();
	public static Piece selectedPiece = null;
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
				imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
				ind++;
			}    
		}
		JFrame frame = new JFrame();
		frame.setBounds(30, 30, 512, 512);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				for(Spot p: wspots)
				{
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
					g.drawImage(imgs[id], p.getPiece().getX()*64, p.getPiece().getY()*64, this);
				}
				for(Spot p: bspots)
				{
					int id = 0;
					if((p.getPiece()).getName().equalsIgnoreCase("king")){
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
					g.drawImage(imgs[id], p.getPiece().getX()*64, p.getPiece().getY()*64, this);
				}
			}
		};
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(selectedPiece != null){
					System.out.println("da click" + e.getX() + " " + e.getY());
					selectedPiece.setX((e.getX())/64);
					selectedPiece.setY((e.getY())/64);
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
				System.out.println((getSpot(e.getX(), e.getY()).getPiece().isColor()?"white":"black")+getSpot(e.getX(), e.getY()).getPiece().getName());
				//selectedPiece = new Piece(e.getX(), e.getY(), getSpot(e.getX(), e.getY()).getPiece().isColor()?true:false, false, getSpot(e.getX(), e.getY()).getPiece().getName());
				selectedPiece = (getSpot(e.getX(), e.getY()).getPiece());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				selectedPiece.move(e.getX()/64, e.getY()/64);
				frame.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		frame.add(pn);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}
	public static Spot getSpot(int x, int y){
		int xp = x/64;
		int yp = y/64;
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

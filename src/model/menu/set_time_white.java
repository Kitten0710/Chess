package model.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class set_time_white implements ActionListener{

	JFrame frame = new JFrame();
	JButton W_startButton = new JButton("START");
	JButton W_resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int seconds = 0;
	int minutes = 15;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

	Timer timer = new Timer(1000, new ActionListener() {

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
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

		}

	});


	public set_time_white(){

		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);

		W_startButton.setBounds(100,200,100,50);
		W_startButton.setFocusable(false);
		W_startButton.addActionListener(this);

		W_resetButton.setBounds(200,200,100,50);
		W_resetButton.setFocusable(false);
		W_resetButton.addActionListener(this);

		frame.add(W_startButton);
		frame.add(W_resetButton);
		frame.add(timeLabel);
		frame.setTitle("White_clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

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
			W_resetButton.setText("START");
			reset();
		}

	}

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
		hours = 0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);       timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}

}
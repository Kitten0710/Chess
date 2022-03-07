package model.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class set_time_black implements ActionListener{

	JFrame frame = new JFrame();
	JButton B_startButton = new JButton("START");
	JButton B_resetButton = new JButton("RESET");
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


	public set_time_black(){

		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);

		B_startButton.setBounds(100,200,100,50);
		B_startButton.setFocusable(false);
		B_startButton.addActionListener(this);

		B_resetButton.setBounds(200,200,100,50);
		B_resetButton.setFocusable(false);
		B_resetButton.addActionListener(this);

		frame.add(B_startButton);
		frame.add(B_resetButton);
		frame.add(timeLabel);
		frame.setTitle("B_clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==B_startButton) {

			if(started==false) {
				started=true;
				B_startButton.setText("STOP");
				start();
			}
			else {
				started=false;
				B_startButton.setText("START");
				stop();
			}

		}
		if(e.getSource()==B_resetButton) {
			started=false;
			B_resetButton.setText("START");
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
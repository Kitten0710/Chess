package time;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
public class set_time {
	static int interval;
	static Timer time;
	private static final int setInterval() {
	    if (interval == 1)
	        time.cancel();
	    return --interval;
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JLabel jl = new JLabel();
		jf.setSize(500, 500);
		jf.add(jl);
		jf.setVisible(true);
		String seconds = "120";
		int delay = 1000;
	    int period = 1000;
	    time = new Timer();
	    interval = Integer.parseInt(seconds);
	    System.out.println(seconds);
	    time.scheduleAtFixedRate(new TimerTask() {
	    	public void run() {
	            jl.setText(setInterval() +"");
	        }
	    }, delay, period);
	}
}
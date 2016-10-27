package kr.co.jaejoo.project.view;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ClockMessage extends JPanel implements Runnable {

	int i = Calendar.getInstance().get(Calendar.AM_PM);
	String[] ampm = { "AM", "PM" };
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
	String time = simpleDateFormat.format(new Date());
	JLabel timeLabel, ampmLabel;

	public ClockMessage() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		timeLabel = new JLabel(time);

		add(timeLabel, BorderLayout.NORTH);
		add(timeLabel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		do{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timeLabel.setText(simpleDateFormat.format(new Date()));
		}while(true);
	}
	
	private JComponent setLable(JComponent component){
		return component;
		
		
	}
	
}

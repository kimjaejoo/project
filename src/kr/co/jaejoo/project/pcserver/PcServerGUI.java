package kr.co.jaejoo.project.pcserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PcServerGUI extends JFrame implements ActionListener{

	// 메세지를 죽고받기위한 gui를 만든다. 
	
	private JTextArea area = new JTextArea(40, 25);
	private JTextField field = new JTextField(25);
	private PCserverBackground pCserverBackground = new PCserverBackground();
	
	public static void main(String[] args) {
		new PcServerGUI();
	}
	
	public PcServerGUI() {
		
		
		setBounds(200, 100, 400, 600);
		setTitle("server");
		add(area , BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		field.addActionListener(this);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = field.getText() + "/n";
		area.append(msg);
		System.out.println(msg);
		field.setText("");
		
	}
	
	public void appendMsg(String msg){
		area.append(msg);
		System.out.println("날아온 메세지 : " + msg);
	}
	
	
}

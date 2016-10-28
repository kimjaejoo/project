package kr.co.jaejoo.project.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.jaejoo.project.pcserver.PCClientbackground;

public class PcClientGui extends JFrame implements ActionListener{

	private JTextArea area = new JTextArea(40, 25);
	private JTextField field = new JTextField(25);
	private PCClientbackground pcClientbackground = new PCClientbackground();
	
	public static void main(String[] args) {
		new PcClientGui();
	}
	
	public PcClientGui() {
		// TODO Auto-generated constructor stub
		setTitle("client");
		setBounds(800,100,400,600);
		
		add(area , BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		field.addActionListener(this);

		pcClientbackground.setGui(this);
		pcClientbackground.connect();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = field.getText() + "\n";
		area.append(msg);
		System.out.println(msg);
		field.setText("");
	}

}

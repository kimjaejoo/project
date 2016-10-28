package kr.co.jaejoo.project.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PcServerGui extends JFrame implements ActionListener{

	JTextArea chatarea;
	JTextField chattf;
	
	
	
	public static void main(String[] args) {
		new PcServerGui();
	}
	
	public PcServerGui() {
		setTitle("server");
		setBounds(200, 100, 400, 600);
		
		add(chatarea , BorderLayout.CENTER);
		add(chattf, BorderLayout.SOUTH);
		
		chattf.addActionListener(this);
		
		setVisible(true);
		// 창의 x버튼을 누르면 종료됨
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = chattf.getText() + "/n";
		chatarea.append(msg);
		System.out.println(msg);
		chattf.setText(""); // 메세지 작성후 textfield 초기화	
	}
	
	public void appendMsg(String msg){
		chatarea.append(msg);
		System.out.println("날아온 메세지 : " + msg);
	}

}

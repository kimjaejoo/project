package kr.co.jaejoo.project.view;



import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginMain extends JFrame {
	
	JButton btn1 = new JButton("로그인");
	JButton btn2 = new JButton("회원가입");
	
	public static void main(String[] args) {
		new LoginMain();
	}
	
	public LoginMain() {
		setTitle("AcornPcRoom");
		setBounds(0, 0, 500, 600);
		setLayout(null);
		btn1.setBounds(30, 400, 200, 50);
		btn2.setBounds(250, 400, 200, 50);
		add(btn1);
		add(btn2);
		setVisible(true);
	}
}

package kr.co.jaejoo.project.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

public class ManageView extends JFrame {
	// 메인화면 
	
	private JLayeredPane jLayeredPane = new JLayeredPane();
	
	
	public ManageView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1600, 900);
		setTitle("manageview");

		// 내 윈도우화면에 맞춰서 프레임이 중간에 들어온다. 기본 프레임을 설정
		Dimension frameSize = this.getSize();
		Dimension windowsize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowsize.width - frameSize.width) / 2, (windowsize.height - frameSize.height) / 2);
		
		JPanel myPanel = new JPanel();
		add(myPanel , BorderLayout.CENTER );
	}
	
	public static void main(String[] args) {
		new ManageView();
	}
	
	// 이미지를 추가하기 위해서 사용한다. 하지만 이미지는 나중에한다.
	class MyPanel extends JPanel {
		
	}
}

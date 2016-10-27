package kr.co.jaejoo.project.view;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainCliet extends JFrame {

	// 관리자 계정
	JPanel[] userPC = new JPanel[30];
	JPanel seat = new JPanel();
	int seatX, seatY; // 좌석의 간격을 조절하기 위해 설정함
	
	

	// 메인화면을 생성한다.
	public MainCliet() {
		// TODO Auto-generated constructor stub
		setTitle("메인화면");
		// main 페이지 생성()
		setBounds(0, 0, 1600, 1000);
		setLayout(null);
		
		seat.setLayout(null);
		seat.setOpaque(false);
		seat.setBounds(165, 109, 1368, 686);
		// 사용자의 화면 30개를 만든다.
		// 반복문을 통한 사용자의 pc controler를 만든다..
		// 우선 30개의 배열을 만든다.

		// 30개의 패널을 배열로 선언한다....이것을 나는 add해야한다.
		for (int i = 0; i < 30; i++) {
			userPC[i] = new JPanel(); // jpanel 30 개를 모두 초기화함
			// 30개의 배열을 만들었고 난 그것을 add해야함
			if (i % 10 == 0 && i != 0) {
				seatX = 0;
				seatY += 140;
			}

			userPC[i].setBounds(seatX, seatY, 99, 99);
			seatX += 135;
			seat.add(userPC[i]);
		}
		
		// 프레임안에 내용추가하기!! 근데 안보임!! 이건뭐 젠장맞을ㅋㅋㅋㅋㅋ
		add(seat, "seat");
		
		// 화면이 보일수 있게 해준다.
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	
	
}

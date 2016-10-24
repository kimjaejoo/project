package kr.co.jaejoo.project.view;

import java.awt.CardLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.jaejoo.project.dao.MemberDAO;

public class LoginMain extends JFrame implements ActionListener {
	// 로그인, 회원가입 버튼

	CardLayout lay;

	JPanel login, join;

	JButton loginbtn = new JButton("로그인");
	JButton joinbtn = new JButton("회원가입");
	JTextField idtf = new JTextField(); // 괄호안에 글을 넣으면 기본값으로 들어간다.
	JTextField pwtf = new JTextField();
	JLabel idlabel = new JLabel("ID");
	JLabel pwlabel = new JLabel("PW");
	JLabel mainlabel = new JLabel("Acorn PC Room");

	JLabel joinTit, joinName, joinId, joinPw1, joinPw2, copyright2;
	JTextField joinNameIn, joinIdIn;
	JPasswordField joinPwIn1, joinPwIn2;
	JButton joinIdCheckBtn, joinJoinBtn, joinCancelBtn;

	public static void main(String[] args) {
		new LoginMain();
	}

	public LoginMain() {

		lay = new CardLayout();

		// 회원가입 페이지 초기화
		joinTit = new JLabel("ACORN PC ROOM JOIN");
		joinName = new JLabel("이름");
		joinId = new JLabel("ID");
		joinPw1 = new JLabel("PW");
		joinPw2 = new JLabel("PW CHECK");
		joinNameIn = new JTextField();
		joinIdIn = new JTextField();
		joinIdCheckBtn = new JButton("Check");
		joinPwIn1 = new JPasswordField();
		joinPwIn2 = new JPasswordField();
		joinJoinBtn = new JButton("회원가입");
		joinCancelBtn = new JButton("취소");
		copyright2 = new JLabel("ⓒ광해가 욕심내는 카피라이트");

		login = new JPanel();
		join = new JPanel();

		// 로그인 페이지
		setTitle("AcornPcRoom");
		setBounds(0, 0, 500, 600);
		setLayout(lay);

		loginbtn.setBounds(30, 400, 200, 50);
		joinbtn.setBounds(250, 400, 200, 50);
		idtf.setBounds(170, 250, 250, 25);
		pwtf.setBounds(170, 300, 250, 25);
		idlabel.setBounds(110, 250, 250, 25);
		pwlabel.setBounds(110, 300, 250, 25);
		mainlabel.setBounds(200, 25, 250, 250);

		// 회원가입 페이지
		joinTit.setBounds(90, 35, 230, 70); // 회원가입 타이틀

		joinName.setBounds(120, 130, 60, 30); // 회원가입 이름 Label
		joinId.setBounds(120, 130 + 40, 60, 30); // 회원가입 아이디 Label
		joinPw1.setBounds(120, 130 + 80, 60, 30); // 회원가입 비밀번호 Label
		joinPw2.setBounds(120, 130 + 120, 120, 30); // 회원가입 비밀번호확인 Label

		joinNameIn.setBounds(220, 130, 160, 30); // 회원가입 이름 입력
		joinIdIn.setBounds(220, 130 + 40, 100, 30); // 회원가입 아이디 입력
		Font idCheck = new Font("Gothic", Font.PLAIN, 8);
		joinIdCheckBtn.setFont(idCheck);
		joinIdCheckBtn.setBounds(320, 130 + 40, 60, 30); // 회원가입 아이디 중복체크 버튼
		joinPwIn1.setBounds(220, 130 + 80, 160, 30); // 회원가입 비밀번호 입력
		joinPwIn2.setBounds(220, 130 + 120, 160, 30); // 회원가입 비밀번호 확인 입력
		joinJoinBtn.setBounds(30, 400, 200, 35); // 회원가입 버튼
		joinCancelBtn.setBounds(250, 400, 200, 35); // 회원가입 취소 버튼

		// 마우스 클릭으로 로그인, 회원가입 버튼을 작동시킴, this는 이 클래스안의 메소드를 사용하기 위함
		joinbtn.addActionListener(this);
		loginbtn.addActionListener(this);
		
		joinJoinBtn.addActionListener(this);
		joinCancelBtn.addActionListener(this);
		joinIdCheckBtn.addActionListener(this);
		
		// login panel위에 추가하기위함
		login.setLayout(null);
		login.setBounds(0, 0, 500, 600);
		login.add(idtf);
		login.add(pwtf);
		login.add(loginbtn);
		login.add(joinbtn);
		login.add(idlabel);
		login.add(pwlabel);
		login.add(mainlabel);

		// join panel에 추가하기 위함

		join.setLayout(null);
		join.add(joinTit);
		join.add(joinName);
		join.add(joinId);
		join.add(joinPw1);
		join.add(joinPw2);
		join.add(joinNameIn);
		join.add(joinIdIn);
		join.add(joinIdCheckBtn);
		join.add(joinPwIn1);
		join.add(joinPwIn2);
		join.add(joinJoinBtn);
		join.add(joinCancelBtn);

		// panel을 프레임위에 추가한다.
		add(login, "loginpanel");
		add(join, "joinpanel");

		// 프레임을 보이기위한것.
		setVisible(true);

	}

	////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		// id의 형식은 이메일로 !! 이메일은 정규식을 사용하여 작성한다.
		
		if (obj == joinbtn) {
			System.out.println("회원가입 버튼");
			lay.show(getContentPane(), "joinpanel");
		} else if (obj == joinIdCheckBtn) {
			// 페이지를 이동했다..이제는 위에 텍스트 필드안에 값을 가지고 와서 넣어야한다. 우선은 가지고 올수있는지 확인하자
			// db와 연결하기 위한 시도를 한다.
			System.out.println("난 체크버튼이지");
						
			MemberDAO memberdao = new MemberDAO();
			String name = joinNameIn.getText();
			String id = joinIdIn.getText();
			if(joinIdIn.equals(id)){
				System.out.println("존재하는 ID 입니다.");
			}
			
			
		}

	}
}

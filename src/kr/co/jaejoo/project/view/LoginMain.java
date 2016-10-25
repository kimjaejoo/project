package kr.co.jaejoo.project.view;

import java.awt.CardLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.jaejoo.project.dao.MemberDAO;
import kr.co.jaejoo.project.dao.member;
import kr.co.jaejoo.project.dto.MemberDTO;

public class LoginMain extends JFrame implements ActionListener {
	// 로그인, 회원가입 버튼

	CardLayout lay;

	JPanel login, join;
	JOptionPane jOptionPane;

	JButton loginbtn = new JButton("로그인");
	JButton joinbtn = new JButton("회원가입");
	JTextField idtf = new JTextField(); // 괄호안에 글을 넣으면 기본값으로 들어간다.
	JTextField pwtf = new JTextField();
	JLabel idlabel = new JLabel("ID");
	JLabel pwlabel = new JLabel("PW");
	JLabel mainlabel = new JLabel("Acorn PC Room");

	JLabel joinTit, joinName, joinId, joinPw1, joinPw2, copyright2, joinEmail, joinTel;
	JTextField joinNameIn, joinIdIn, joineEmailIn, joinTelIn;
	JPasswordField joinPwIn1, joinPwIn2;
	JButton joinIdCheckBtn, joinJoinBtn, joinCancelBtn;

	Pattern patternEmail, patternId, patternTel;
	Matcher matcherEmail, matcherId, matcherTel;
	Object obj;

	MemberDAO memberDAO = new MemberDAO();
	
	
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
		joineEmailIn = new JTextField();
		joinTelIn = new JTextField();
		joinEmail = new JLabel("Email");
		joinTel = new JLabel("전화번호");

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
		joinEmail.setBounds(120, 130 + 160, 60, 30);
		joinTel.setBounds(120, 130 + 200, 60, 30);

		joinNameIn.setBounds(220, 130, 160, 30); // 회원가입 이름 입력
		joinIdIn.setBounds(220, 130 + 40, 100, 30); // 회원가입 아이디 입력
		Font idCheck = new Font("Gothic", Font.PLAIN, 8);
		joinIdCheckBtn.setFont(idCheck);
		joinIdCheckBtn.setBounds(320, 130 + 40, 60, 30); // 회원가입 아이디 중복체크 버튼
		joinPwIn1.setBounds(220, 130 + 80, 160, 30); // 회원가입 비밀번호 입력
		joinPwIn2.setBounds(220, 130 + 120, 160, 30); // 회원가입 비밀번호 확인 입력

		joineEmailIn.setBounds(220, 130 + 160, 160, 30); // 회원 이메일 입력
		joinTelIn.setBounds(220, 130 + 200, 160, 30);

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
		join.add(joinEmail);
		join.add(joinTel);
		join.add(joinNameIn);
		join.add(joinIdIn);
		join.add(joinIdCheckBtn);
		join.add(joinPwIn1);
		join.add(joinPwIn2);
		join.add(joinJoinBtn);
		join.add(joinCancelBtn);
		join.add(joineEmailIn);
		join.add(joinTelIn);
		// panel을 프레임위에 추가한다.
		add(login, "loginpanel");
		add(join, "joinpanel");

		// 프레임을 보이기위한것.
		setVisible(true);

	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {

		obj = e.getSource();

		if (obj == joinbtn) {

			System.out.println("회원가입 버튼");
			lay.show(getContentPane(), "joinpanel");
		} else if (obj == joinJoinBtn) {

			// 회원가입 버튼을 누르고 가입을 할때 내가 넣어야 할 값은 ?
			// 이름, 아이디, 비번, 전화번호, 이메일,

			System.out.println("회원가입");
			if (joinNameIn.getText().equals("") || joinIdIn.getText().equals("") || joinPwIn1.getPassword().equals("")
					|| joineEmailIn.getText().equals("") || joinTelIn.getText().equals("")) {
				// 회원 가입의 이름, 아이디, 비밀번호칸이 빈칸일때 알림 메세지로 알려준다
				JOptionPane.showMessageDialog(this, "사용자의 값이 제대로 입력되지 않았습니다.");
			} else if (!(joinPwIn1.getText().equals(joinPwIn2.getText()))) {
				// System.out.println("굳"); // 사용은 할 수 있지만 권장은 하지않습니다.
				JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("사용자가 값을 입력함");

				String name = joinNameIn.getText();
				String id = joinIdIn.getText();
				String password = joinPwIn1.getText();
				String email = joineEmailIn.getText();
				String tel = joinTelIn.getText();
				System.out.println("사용자 입력갑 : " + name + id + password + email + tel);

				// 입력한 아이디, 이메일, 비번을 아래의 클래스를 사용하여 정규표현식을 사용한다.

				String emailregex = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
				String idregex = "^[a-zA-Z0-9]*$";
				String telregex = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$";

				patternEmail = Pattern.compile(emailregex);
				patternId = Pattern.compile(idregex);
				patternTel = Pattern.compile(telregex);

				matcherEmail = patternEmail.matcher(email);
				matcherId = patternId.matcher(id);
				matcherTel = patternTel.matcher(tel);

				System.out.println(matcherEmail.matches());
				System.out.println(matcherId.matches());
				System.out.println(matcherTel.matches());

				if (matcherEmail.matches() && matcherId.matches() && matcherTel.matches()) {
					System.out.println("정규표현식");

					
					MemberDTO joindto = new MemberDTO();
					
					// 모든 사용자의 값을 불러오기 위해서 selectAll을 사용한다. 
					
					
					joindto.setName(name);
					joindto.setId(id);
					joindto.setPassword(password);
					joindto.setEmail(email);
					joindto.setTel(tel);

					memberDAO.insertOne(joindto);

					System.out.println("가입완료");
					lay.show(getContentPane(), "loginpanel");

					// 입력한 이메일과 이름, 전화번호라면 경고창을 띄우고 값을 초기화한다.

				} else if (matcherEmail.matches() == false) {
					JOptionPane.showMessageDialog(this, "이메일 형식을 확인해주세요");
				} else if (matcherId.matches() == false ) {
					JOptionPane.showMessageDialog(this, "ID는 영어와 숫자로만 사용이 가능합니다.");
				} else if (matcherTel.matches() == false) {
					JOptionPane.showMessageDialog(this, "정확한 휴대폰번호를 작성해주세요");
				} else  {
					System.out.println("이미 사용중인 id입니다.");
				}
			}

		} else if (obj == joinIdCheckBtn) {
			System.out.println("회원가입 아이디 체크버튼");
		} else if (obj == joinCancelBtn) {
			System.out.println("회원가입 취소버튼");
			lay.show(getContentPane(), "loginpanel");
		} else if (obj == loginbtn){
			System.out.println("로그인 버튼눌림");
			MemberDTO logindto = memberDAO.loginData(idtf.getText(), pwtf.getText());
			
			if(idtf.getText().equals("")||pwtf.getText().equals("")){
				System.out.println("빈칸이네요");
			}else if (logindto.getId().equals(idtf.getText())){
			System.out.println("틀린 아이디");
			// 아.. 로그인은 selectAll로 해야하니...?
			}else{
				System.out.println(logindto.getId()); // 우선은 아이디를 가지고 오는 것을 성공함. 만약 입력한 값이 db안에 없다면 틀리다고 말해야함
				
			}
		}

	}
}

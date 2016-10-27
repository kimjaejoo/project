package kr.co.jaejoo.project.view;

public class MainProcess {

	// 여기서 내가 불러오고자 하는 클래스를 초기화한다.
	// 이클래스를 만들어 사용함으로서 나는 클래스의 코드길이를 통제한다. 그리고 유지보수를 쉽게할수있게 해준다.
	LoginMain login; // 로그인과 회원가입을 통제한다
	MainCliet client; // 로그인 성공시 메인클라이언트를 호출한다.
	ManageView manageView;
	
	public static void main(String[] args) {
		MainProcess main = new MainProcess();
		main.login = new LoginMain(); // 로그인, 회원가입창 보이기
		main.login.setMain(main);
	}
	
	public void showFrame(){
		login.dispose(); // 로그인창 닫기 로그인 패널을 닫고 새로운 프레임의 클래스를 열어준다.
		this.manageView = new ManageView(); // mainclient open
	}

	
	
}

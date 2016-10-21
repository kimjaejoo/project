package kr.co.jaejoo.project.dto;

public class MemberDTO {
	
	// 회원의 기본적인 정보를 주고받기위한 DTO클래스의 생성
	
	private int membernum; // 회원번호
	private String name; // 이름
	private String email; // 이메일
	private String id; // 아이디
	private String password; // 패스워드
	private String tel; // 전화번호
	private int mileage; // 마일리지
	private String time; // 시간
	
	// 기본생성자
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	// 매개변수있는 생성자
	public MemberDTO(int membernum, String name, String email, String id, String password, String tel, int mileage,
			String time) {
		super();
		this.membernum = membernum;
		this.name = name;
		this.email = email;
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.mileage = mileage;
		this.time = time;
	}

	//setter, getter
	public int getMembernum() {
		return membernum;
	}

	public void setMembernum(int membernum) {
		this.membernum = membernum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}

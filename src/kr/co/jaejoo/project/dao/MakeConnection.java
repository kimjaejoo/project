package kr.co.jaejoo.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	// singleton pattern 적용하기
	private static MakeConnection mc = new MakeConnection();
	
	// driver에 접속하기 위한 정보
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// aws주소
	private String url = "jdbc:oracle:thin:@pcproject01.cnvbvqxzbhla.us-west-2.rds.amazonaws.com:1521:orcl";
	private String user ="kimjaejoo"; // 드라이버 아이디
	private String password ="rlawown00"; // 드라이버 비번
	private Connection conn ;
	
	private MakeConnection(){}
	
	public static MakeConnection getInstance(){
		return mc;
	}
	
	public Connection getConnection(){
		if(conn == null){
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("드라이버 로딩실패");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("DB연결 실패");
			}
		}
		return conn;
	}
}

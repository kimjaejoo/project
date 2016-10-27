package kr.co.jaejoo.project.pcserver;

import java.io.IOException;
import java.net.Socket;

public class PCClientbackground {

	
	Socket socket;
	
	public void connect(){
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("클라이언트 : 서버 연결됨");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		PCClientbackground clientbackground = new PCClientbackground();
		clientbackground.connect();
	}
}

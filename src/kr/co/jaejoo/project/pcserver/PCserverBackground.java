package kr.co.jaejoo.project.pcserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PCserverBackground {
	
	// 소켓을 열어줌으로 통신이 가능하게 만들어준다..
	ServerSocket serverSocket;
	Socket socket;
	
	
	public void setting(){
		try {
			serverSocket = new ServerSocket(7777); // port 7777 외부포트 설정
			System.out.println("서버 대기중");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + "에게 접속했습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		PCserverBackground pCserverBackground = new PCserverBackground();
		pCserverBackground.setting();
	}
}


package kr.co.jaejoo.project.pcserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PCClientbackground {

	
	Socket socket;
	DataInputStream in; // 클라이언트가 보낸 메세지를 받을때 사용함
	DataOutputStream out; // 메세지를 줄때 사용함
	
	public void connect(){
		try {
			socket = new Socket("127.0.0.1", 7777); // localhost ip, port
			System.out.println("클라이언트 : 서버 연결됨");
			// 서버접속 확인 
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF("메세지를 작성하여 보냅니다.");
			System.out.println("메세지 전송완료ㅎ");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		PCClientbackground clientbackground = new PCClientbackground();
		clientbackground.connect();
	}
}

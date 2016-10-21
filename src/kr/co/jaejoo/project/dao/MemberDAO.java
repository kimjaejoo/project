package kr.co.jaejoo.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.jaejoo.project.dto.MemberDTO;

public class MemberDAO implements member {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private StringBuilder sb;

	// 기본생성자에 싱글톤을 불러옴으로서 연결을 시도한다.
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		conn = MakeConnection.getInstance().getConnection();
	}

	// 모든 정보를 불러오기위한 메서드
	public ArrayList<MemberDTO> selectAll() {
		// 리스트의 정보를 담기위해 Arraylist를 선언한다.
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		// 앞에서 사용한 sql문을 초기화 한다.
		sb.setLength(0);
		sb.append("SELECT membernum, name, tel, id, password, email, mileage, time ");
		sb.append("FROM member ");

		// 전체를 조회하기위해 결과값을 resultset에 넣어주고 그것을 list 안에 넣어주었다.
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int membernum = rs.getInt("membernum");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int mileage = rs.getInt("mileage");
				String time = rs.getString("time");

				MemberDTO memberdto = new MemberDTO(membernum, name, email, id, password, tel, mileage, time);
				list.add(memberdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 전체의 정보중에 하나만 조회하기 위함으로 사용한다. return은 dto로한다.
	@Override // 재정의 : interface의 메소드의 내용을 재정의 하여 사용할 수 있도록한다.
	public MemberDTO selectOne(int membernum) {
		// TODO Auto-generated method stub
		MemberDTO memberdto = null;

		sb.setLength(0);
		sb.append("SELECT membernum, name, tel, id, password, email, mileage, time ");
		sb.append("FROM member ");
		sb.append("WHERE membernum = ? ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int mileage = rs.getInt("mileage");
				String time = rs.getString("time");

				memberdto = new MemberDTO(membernum, name, email, id, password, tel, mileage, time);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberdto;
	}

	// login에대한 정보를 입력하는데 필요한 메서드를 만들어야한다.
	public MemberDTO loginData(String id, String password) {
		// 기본의 정보에 id와 password를 비교하여 로그인을 시도한다.
		MemberDTO memberdto = null;
		sb.setLength(0);
		sb.append(" SELECT id, password ");
		sb.append("FROM member ");
		sb.append("WHERE id = ? and password = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int membernum = rs.getInt("membernum");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				int mileage = rs.getInt("mileage");
				String time = rs.getString("time");
				memberdto = new MemberDTO(membernum, name, email, id, password, tel, mileage, time);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberdto;
	}

	@Override
	public void insertOne(MemberDTO memberdto) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append(" INSERT INTO member ");
		sb.append(" VALUES (sequence1.nextval , ? , ? , ? , ? , ? , 0 , sysdate) ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, memberdto.getName());
			pstmt.setString(2, memberdto.getEmail());
			pstmt.setString(3, memberdto.getId());
			pstmt.setString(4, memberdto.getPassword());
			pstmt.setString(5, memberdto.getTel());
			pstmt.setInt(6, memberdto.getMileage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//회원정보를 수정하는데 사용이 가능한 메서드 
	@Override
	public void updateOne(MemberDTO memberdto) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append("UPDATE member ");
		sb.append("SET (name = ? , email = ? , id = ? , password = ? , tel = ? , mileage = ? ) ");
		sb.append("WHERE membernum = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, memberdto.getName());
			pstmt.setString(2, memberdto.getEmail());
			pstmt.setString(3, memberdto.getId());
			pstmt.setString(4, memberdto.getPassword());
			pstmt.setString(5, memberdto.getTel());
			pstmt.setInt(6, memberdto.getMileage());
			pstmt.setInt(7, memberdto.getMembernum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 회원정보를 삭제하는 메서드 
	@Override
	public void deleteOne(int membernum) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append("DELETE FROM member ");
		sb.append("WHERE membernum = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1,	membernum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 사용한 자원을 닫아준다. 원래의 네트웤연결 방식과는 달리 한번만 닫아주면 된다.
	@Override
	public void close() {
		// TODO Auto-generated method stub
				try {
					if(conn != null)conn.close();
					if(rs!=null)rs.close();
					if(pstmt != null ) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
}

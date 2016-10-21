package kr.co.jaejoo.project.dao;

import java.util.ArrayList;

import kr.co.jaejoo.project.dto.MemberDTO;

public interface member {
	public ArrayList<MemberDTO> selectAll();
	public MemberDTO selectOne(int membernum);
	public void insertOne(MemberDTO memberdto);
	public void updateOne(MemberDTO memberdto);	
	public void deleteOne(int membernum);
	public void close();
}

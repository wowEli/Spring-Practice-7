package com.jang.biz.member;

import java.util.ArrayList;

public interface MemberService {
	void insertMember(MemberVO vo);
	void updateMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	MemberVO selectOneMember(MemberVO vo);
	ArrayList<MemberVO> selectAllMember(MemberVO vo);
}

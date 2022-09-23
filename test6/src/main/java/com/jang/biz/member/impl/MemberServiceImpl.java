package com.jang.biz.member.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.biz.member.MemberService;
import com.jang.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO; // 핵심로직을 수행할 객체
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
	}

	@Override
	public void deleteMember(MemberVO vo) {
	}

	@Override
	public MemberVO selectOneMember(MemberVO vo) {
		  if(vo.getMid().equals("timo")) {
		         throw new IllegalArgumentException("[실행시예외]");
		      }
		return memberDAO.selectOneMember(vo);
	}

	@Override
	public ArrayList<MemberVO> selectAllMember(MemberVO vo) {
		return null;
	}

}

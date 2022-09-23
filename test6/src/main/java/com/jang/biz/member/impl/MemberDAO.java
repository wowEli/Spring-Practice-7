package com.jang.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.jang.biz.member.MemberVO;

@Repository("MemberDAO")
public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_login ="SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";
	final String sql_signUp ="INSERT INTO MEMBER VALUES (?,?,?,?)";
	final String sql_update = "UPDATE MEMBER SET MPW=? WHERE MID=?";
	final String sql_delete ="DELETE FROM MEMBER WHERE MID=?";
	
	public void deleteMember(MemberVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getMid());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public void updateMember(MemberVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMid());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public void insertMember(MemberVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_signUp);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			
			int num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public MemberVO selectOneMember(MemberVO vo) {
		System.out.println("시작!");
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_login);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			
			ResultSet rs = pstmt.executeQuery();
			MemberVO vo1 = new MemberVO();
			
			if(rs.next()) {
				vo1.setMid(rs.getString("MID"));
				vo1.setMpw(rs.getString("MPW"));
				vo1.setName(rs.getString("NAME"));
				vo1.setRole(rs.getString("ROLE"));
				System.out.println("끝!");
				return vo1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
		
		return null;
	}
	
}

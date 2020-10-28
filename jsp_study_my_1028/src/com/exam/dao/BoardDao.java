package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.BoardVo;

public class BoardDao {
	// 싱글톤
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	/////////////

	private BoardDao() {} // 싱글톤패턴으로 인해 new 생성자 접근제한.
	
	public int getNextNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int nextNum = 0;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "SELECT IFNULL(MAX(num), 0) + 1 AS next_num ";
			sql += "FROM board ";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				nextNum = rs.getInt("next_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return nextNum;
	} // getNextNum()
	
	
	public void addBoard(BoardVo boardVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "INSERT INTO board (num, name, passwd, subject, content, readcount, reg_date, ip, file, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getNum());
			pstmt.setString(2, boardVo.getName());
			pstmt.setString(3, boardVo.getPasswd());
			pstmt.setString(4, boardVo.getSubject());
			pstmt.setString(5, boardVo.getContent());
			pstmt.setInt(6, boardVo.getReadcount());
			pstmt.setTimestamp(7, boardVo.getRegDate());
			pstmt.setString(8, boardVo.getIp());
			pstmt.setString(9, boardVo.getFile());
			pstmt.setInt(10, boardVo.getReRef());
			pstmt.setInt(11, boardVo.getReLev());
			pstmt.setInt(12, boardVo.getReSeq());
			// 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} 					// addBoard()
	
	
	public BoardVo getBoardByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVo boardVo = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM board WHERE num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				boardVo = new BoardVo();
				
				boardVo.setNum(rs.getInt("num"));
				boardVo.setName(rs.getString("name"));
				boardVo.setPasswd(rs.getString("passwd"));
				boardVo.setSubject(rs.getString("subject"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setReadcount(rs.getInt("readcount"));
				boardVo.setRegDate(rs.getTimestamp("reg_date"));
				boardVo.setIp(rs.getString("ip"));
				boardVo.setFile(rs.getString("file"));
				boardVo.setReRef(rs.getInt("re_ref"));
				boardVo.setReLev(rs.getInt("re_lev")); 
				boardVo.setReSeq(rs.getInt("re_seq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return boardVo;
	} 					// getBoardByNum()
	
	public void updateReadcount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtils.getConnection();
			String sql = "";
			sql = "UPDATE board ";
			sql += "SET readcount = readcount + 1 ";
			sql += "WHERE num = ? ";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
		
		
	}				//updateReadcount
	
	//전체글갯수 가져오기
	public int getCount() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT COUNT(num) FROM board ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return count;
	}				// getCount
	
	
	public List<BoardVo> getBoards(int startRow, int pageSize) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVo> list = new ArrayList<>();
		String sql = "";
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM board ORDER BY re_ref DESC, re_seq ASC LIMIT ? , ? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setNum(rs.getInt("num"));
				boardVo.setName(rs.getString("name"));
				boardVo.setPasswd(rs.getString("passwd"));
				boardVo.setSubject(rs.getString("subject"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setReadcount(rs.getInt("readcount"));
				boardVo.setRegDate(rs.getTimestamp("reg_date"));
				boardVo.setIp(rs.getString("ip"));
				boardVo.setFile(rs.getString("file"));
				boardVo.setReRef(rs.getInt("re_ref"));
				boardVo.setReLev(rs.getInt("re_lev")); 
				boardVo.setReSeq(rs.getInt("re_seq"));
				
				list.add(boardVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		
		return list;
	}				// getBoards
	
	public boolean pwdCheck(int num, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean pwdCheck = false;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			sql = "SELECT COUNT(*) FROM board WHERE num = ? AND passwd = ? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1) {
					pwdCheck = true;
				} else {
					pwdCheck = false;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		return pwdCheck;
	}				// pwdCheck
	
	public void updateBoard(BoardVo boardVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "UPDATE board ";
			sql += "SET name = ?, subject = ?, content = ?, file = ? ";
			sql += "WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardVo.getName());
			pstmt.setString(2, boardVo.getSubject());
			pstmt.setString(3, boardVo.getContent());
			pstmt.setString(4, boardVo.getFile());
			pstmt.setInt(5, boardVo.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateBoard
	
	public void deleteBoardByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			con = JdbcUtils.getConnection();
			// 실무에서는 워크벤치 등 에서 select 문으로 확인할대상을 직접보고 delete 문을 사용한다
			sql = "DELETE FROM board WHERE num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
		
		
		
		
	}				// deleteBoard
	
	public void updateAndAddReply(BoardVo boardVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";  // null 로 초기화해도되지만 에러의 가지수를 줄이기위해서 빈문자열로 준다
		
		try {
			con = JdbcUtils.getConnection();
			
			con.setAutoCommit(false); // 수동커밋으로 변경 (디폴트가 자동 커밋)
			
			sql  = "UPDATE board ";
			sql += "SET re_seq = re_seq + 1 ";
			sql += "WHERE re_ref = ? ";
			sql += "AND re_seq > ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getReRef());
			pstmt.setInt(2, boardVo.getReSeq());
			
			pstmt.executeUpdate(); // 작업 예약
			
			// update문장을 가진 pstmt객체 닫기
			pstmt.close();
			
			sql  = "INSERT INTO board (num, name, passwd, subject, content, readcount, reg_date, ip, file, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getNum());
			pstmt.setString(2, boardVo.getName());
			pstmt.setString(3, boardVo.getPasswd());
			pstmt.setString(4, boardVo.getSubject());
			pstmt.setString(5, boardVo.getContent());
			pstmt.setInt(6, boardVo.getReadcount());
			pstmt.setTimestamp(7, boardVo.getRegDate());
			pstmt.setString(8, boardVo.getIp());
			pstmt.setString(9, boardVo.getFile());
			pstmt.setInt(10, boardVo.getReRef());     // 같은 그룹
			pstmt.setInt(11, boardVo.getReLev() + 1); // 답글쓰는 대상글의 들여쓰기 + 1
			pstmt.setInt(12, boardVo.getReSeq() + 1); // 답글쓰는 대상글의 그룹내 순번 + 1
			
			pstmt.executeUpdate(); // 작업 예약
			
			con.commit(); // 예약된 작업수행
			
			con.setAutoCommit(true); // 커밋다시 자동으로 되돌리기
			
			//return true;	// 잘되는지 확인용
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback(); // 단위작업에 문제가 생기면 롤백(취소)하기
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//return false;
		} finally {
			JdbcUtils.close(con, pstmt);
		}
		
		
		
	}				// updateAndAddReply
	
//	public static void main(String[] args) {
//		BoardDao boardDao = BoardDao.getInstance();
//		
//		for (int i=0; i<100; i++) { // 샘플데이터 100개 삽입
//			BoardVo boardVo = new BoardVo();
//			
//			int num = boardDao.getNextNum();
//			boardVo.setNum(num);
//			boardVo.setName("홍길동클론"+i);
//			boardVo.setPasswd("123");
//			boardVo.setSubject("클론제목"+i);
//			boardVo.setContent("클론내용"+i);
//			boardVo.setReadcount(0);
//			boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
//			boardVo.setIp("127.0.0.1");
//			boardVo.setReRef(num);
//			boardVo.setReLev(0);
//			boardVo.setReSeq(0);
//			
//			System.out.println(boardVo); // 확인용 출력
//			
//			boardDao.addBoard(boardVo); // sql에 데이터 넣기
//		}
//		
//	}			// M  A  I  N
	
}

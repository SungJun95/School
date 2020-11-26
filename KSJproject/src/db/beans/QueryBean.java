package db.beans;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryBean {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public QueryBean()
	{
		conn = null;
		stmt = null;
		rs = null;
	}	// QueryBean()
	
	public void getConnection()
	{
		try 
		{
			conn = DBConnection.getConnection(); // 연결
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			stmt = conn.createStatement(); // 데이터베이스로 SQL 문을 보내기 위한 SQLServerStatement 개체 생성
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	// getConnection()
	
	public void closeConnection()
	{
		if (stmt != null)
		{
			try 
			{
				stmt.close();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		if (conn != null)
		{
			try 
			{
				conn.close();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}		// closeConnection()
	
	public int insertPerson (String id, String password , String name, String birth , String sex, String email, String tel)
	{
		int result = 0;
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
		sb.append(" INSERT INTO ");
		sb.append("		Person (P_ID, P_PWD, P_NAME, P_BIRTH, P_SEX, P_EMAIL, P_TEL) ");
		sb.append(" 	VALUES ");
		sb.append("		('" + id +"','" + password + "', '" + name + "', '" + birth +  "', '" + sex + "', '" + email + "', '" + tel + "')");
		
		System.out.println(sb.toString());
		
		try {
			
			pstmt = conn.prepareStatement(sb.toString());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(pstmt != null){
					pstmt.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;  // 0 or 1 인트형정수로 결과값 리턴
	}		// setUserInfo
	
	
	
	public int PersonLogin(String id, String password)
	{
		StringBuffer sb = new StringBuffer();
				
		sb.append(" SELECT COUNT(*) FROM person WHERE P_ID = '" + id + "' and P_PWD = '" + password + "' ");
		
		int num = 0;
		try {
			
			rs = stmt.executeQuery(sb.toString());
			if(rs.next()) {
				num = rs.getInt(1);
				System.out.println(num);
			}
			
			System.out.println(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}	// PersonLogin
	
	public boolean  PersonIdDupCheck(String id)
	{
		boolean bool = false;
		
		StringBuffer sb = new StringBuffer();
				
		sb.append(" SELECT COUNT(*) FROM person WHERE P_ID = '" + id + "' ");
		
		int num = 0;
		try {
			
			rs = stmt.executeQuery(sb.toString());
			if(rs.next()) {
				num = rs.getInt(1);
				System.out.println(num);
			}
			
			System.out.println(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(num == 1) {
			bool = false; // 중복이다
		} else {
			bool = true; // 중복이아니다
		}
		
		return bool;
	}	// PersonIdDupCheck
	
	
	public ArrayList getPlistInfo() throws Exception
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT TITLE, CONTENT, JOB, AREA FROM PLISTINFO ORDER BY number ASC ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while(rs.next())
		{
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.println(sb.toString());
		return res;
	}		// getUserInfo()
	
	public ArrayList getPlistInfo(String title) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT TITLE, CONTENT, JOB, AREA FROM PLISTINFO WHERE TITLE LIKE '%" + title + "%' ORDER BY number ASC ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while(rs.next())
		{
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.println(sb.toString());
		return res;
	}		// getUserInfo()
	
	
//	public static void main(String[] args) {
//		QueryBean qb = new QueryBean();
//		qb.getConnection();
//		qb.PersonLogin("ksj", "123");
//	}
}

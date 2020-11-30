package db.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() throws Exception
	{
		System.out.println("DB연결 시도");

		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로드
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
//		String dbPwd = "mypwd";
		String dbPwd = "1234";
				
		return DriverManager.getConnection(dbUrl, dbId, dbPwd); // 연결을 얻는다
	}
	
}

package db.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() throws Exception
	{
		System.out.println("DB���� �õ�");

		Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹� �ε�
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
//		String dbPwd = "mypwd";
		String dbPwd = "1234";
				
		return DriverManager.getConnection(dbUrl, dbId, dbPwd); // ������ ��´�
	}
	
}

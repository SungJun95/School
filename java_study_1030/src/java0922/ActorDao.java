package java0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// SELECT , INSERT , UPDATE , DELETE SQL�� ���� ���
// DAO(Date Access Object) : �����͸� ��ȸ,�߰�,����,���� ������ ��ü
public class ActorDao {
	public Connection getConnection() throws Exception {
		// DB��������
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		Connection con = null;

		// 1�ܰ�. DB����̹� Ŭ���� �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2�ܰ�. DB�� ���� �õ�. ������ Connection��ü�� ������.
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);

		return con;
	}

	public List<ActorVo> getActors() {
		List<ActorVo> list = new ArrayList<>();

		// SELECT�� ���࿡ �ʿ��� JDBC ��ü 3����
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			// 3�ܰ�. sql���尴ü �غ�
			sql = "SELECT * FROM actor ORDER BY actor_id DESC";
			pstmt = con.prepareStatement(sql);
			// ���� �� select����� ResultSet���� ����
			rs = pstmt.executeQuery(); // SELECT�� ����� ȣ����.

			// 4�ܰ�. ResultSet ������ ������ ���
			while (rs.next()) {
				ActorVo actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));

				list.add(actorVo);

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} // getActors

	public ActorVo getActorById(int actorId) {
		ActorVo actorVo = null; 

		// SELECT�� ���࿡ �ʿ��� JDBC ��ü 3����
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			// 3�ܰ�. sql���尴ü �غ�
			sql = "SELECT * FROM actor WHERE actor_id = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, actorId);
			// ���� �� select����� ResultSet���� ����
			rs = pstmt.executeQuery(); // SELECT�� ����� ȣ����.

			// 4�ܰ�. ResultSet ������ ������ ���
			if (rs.next()) {
				actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}

		return actorVo;
	} // getActorById

	public int addActor(ActorVo actorVo) {
		int count = 0;

		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			// sql�� �غ�
			sql = "INSERT INTO actor (first_name, last_name, last_update) ";
			sql += "VALUES (?, ?, now())";

			// 3�ܰ�. sql���尴ü �غ�
			pstmt = con.prepareStatement(sql);
			// �� ����
			pstmt.setString(1, actorVo.getFirstName());
			pstmt.setString(2, actorVo.getLastName());

			// sql���� ����
			count = pstmt.executeUpdate(); // INSERT,UPDATE,DELETE���� ����� ȣ��

			System.out.println(count + "�� ���� �߰���.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	} // addActor

	public ActorVo getActorByFirstName(String firstName) {
		ActorVo actorVo = null;

		// SELECT�� ���࿡ �ʿ��� JDBC ��ü 3����
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			// 3�ܰ�. sql���尴ü �غ�
			sql = "SELECT * FROM actor WHERE first_name = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, firstName);
			// ���� �� select����� ResultSet���� ����
			rs = pstmt.executeQuery(); // SELECT�� ����� ȣ����.

			// 4�ܰ�. ResultSet ������ ������ ���
			if (rs.next()) {
				actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}

		return actorVo;
	}

	public int deleteActorByFirstName(String firstName) {
		// DELETE�� �����ϱ�
		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;

		int count = 0;

		try {
			con = getConnection();

			// sql�� �غ�
			sql = "DELETE FROM actor ";
			sql += "WHERE first_name = ? ";

			// 3�ܰ�. sql���尴ü �غ�
			pstmt = con.prepareStatement(sql);
			// �� ����
			pstmt.setString(1, firstName);

			// sql���� ����
			count = pstmt.executeUpdate(); // INSERT,UPDATE,DELETE���� ����� ȣ��

			System.out.println(count + "�� ���� ������.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	} // deleteActorByFirstName()
	
	public void updateActorByFirstName(ActorVo actorVo) {

		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			// sql�� �غ�
			sql = "UPDATE actor ";
			sql += "SET last_name = ? ";
			sql += "WHERE first_name = ? ";

			// 3�ܰ�. sql���尴ü �غ�
			pstmt = con.prepareStatement(sql);
			// �� ����
			pstmt.setString(1, actorVo.getLastName());
			pstmt.setString(2, actorVo.getFirstName());

			// sql���� ����
			int count = pstmt.executeUpdate(); // INSERT,UPDATE,DELETE���� ����� ȣ��

			System.out.println(count + "�� ���� ������.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // updateActorByFirstName()

	public static void main(String[] args) {
		ActorDao actorDao = new ActorDao();
//		List<ActorVo> list = actorDao.getActors();
//		
//		for(ActorVo actorVo: list)
//		{
//			System.out.println(actorVo);
//		}

//		ActorVo actorVo1 = actorDao.getActorById(203);
//		System.out.println("actorVo1 : "+ actorVo1);
//		ActorVo actorVo2 = actorDao.getActorById(204);
//		System.out.println("actorVo1 : "+ actorVo2);
		
		ActorVo actorVo3 = new ActorVo();
		actorVo3.setFirstName("�浿");
		actorVo3.setLastName("ȫ");

		ActorVo actorVo4 = new ActorVo("���Ӵ�", "��");

		actorDao.addActor(actorVo3);
		actorDao.addActor(actorVo4);
		
		System.out.println("================== INSERT ���Ȯ�� ================");

		ActorVo actorVoDb1 = actorDao.getActorByFirstName(actorVo3.getFirstName());
		ActorVo actorVoDb2 = actorDao.getActorByFirstName(actorVo4.getFirstName());

		System.out.println(actorVoDb1.toString());
		System.out.println(actorVoDb2.toString());
		
		System.out.println("================== UPDATE �׽�Ʈ ================");
		
		actorVo3.setLastName("��"); // ������ ������ ������ ����
		actorVo4.setLastName("��");
		
		actorDao.updateActorByFirstName(actorVo3);
		actorDao.updateActorByFirstName(actorVo4);
		
		System.out.println("================== UPDATE ���Ȯ�� ================");
		
		ActorVo actorVoDb3 = actorDao.getActorByFirstName(actorVo3.getFirstName());
		ActorVo actorVoDb4 = actorDao.getActorByFirstName(actorVo4.getFirstName());
		
		System.out.println(actorVo3.toString());
		System.out.println(actorVo4.toString());

		System.out.println("================== DELETE ���Ȯ�� ================");

		actorDao.deleteActorByFirstName(actorVo3.getFirstName());
		actorDao.deleteActorByFirstName(actorVo4.getFirstName());
	}// Main
} // ActorDao

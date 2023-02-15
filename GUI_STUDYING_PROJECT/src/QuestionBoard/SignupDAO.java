package QuestionBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import LogData.SignupVo;

public class SignupDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	PreparedStatement pstmt = null;

	public ArrayList<SignupVo> list() {
		ArrayList<SignupVo> list = new ArrayList<SignupVo>();

		try {
			con = getConn();
			String query = "select * from profile ";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(); // ���� ����
			while (rs.next()) { // �����ͺ��̽����İ� java ������ �ٸ�.

				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String resid = rs.getString(3);
				String name = rs.getString(4);
				String PhoneNums = rs.getString(5);
				String teacher = rs.getString(6);

				list.add(new SignupVo(id, pwd, resid, name, PhoneNums, teacher));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection success.");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driver); // 1. ����̹� �ε�
			con = DriverManager.getConnection(url, user, pwd); // 2. ����̹� ����

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getconnDB() {
		// TODO Auto-generated method stub
		return null;
	}

}
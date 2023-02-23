package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CheckQ01DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	PreparedStatement pstmt = null;

	public ArrayList<CheckQ01Vo> list() {
		ArrayList<CheckQ01Vo> list = new ArrayList<CheckQ01Vo>();

		try {
			con = getConn();
			String query = "select * from Question1 ";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(); // 쿼리 실행
			while (rs.next()) { // 데이터베이스형식과 java 형식이 다름.

				String reading1 = rs.getString(1);
				String reading2 = rs.getString(2);
				String reading3 = rs.getString(3);
				String reading4 = rs.getString(4);
				String reading5 = rs.getString(5);

				list.add(new CheckQ01Vo(reading1, reading2, reading3 , reading4 ,reading5 ));
				
				query = "insert into Question1 ( reading5 )" + " VALUES('" + reading5 + "')";

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
			Class.forName(driver); // 1. 드라이버 로딩
			con = DriverManager.getConnection(url, user, pwd); // 2. 드라이버 연결

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
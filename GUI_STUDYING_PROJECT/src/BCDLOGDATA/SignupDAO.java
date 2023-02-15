package BCDLOGDATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SignupDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<SignupVo> list(String id, String pwd, String resid, String name, String PhoneNums,
			String teacher) {
		ArrayList<SignupVo> list = new ArrayList<SignupVo>();
		try {
			connDB();
			String query = "select * from profile ";

			if (id != null && pwd != null && resid != null && name != null && PhoneNums != null && teacher != null) {
				query += " where id = '" + id.toLowerCase() + "'";
				query += " and pwd = '" + pwd.toLowerCase() + "'";
				query += " and resid = '" + resid.toLowerCase() + "'";
				query += " and name = '" + name.toLowerCase() + "'";
				query += " and PhoneNums = '" + PhoneNums.toLowerCase() + "'";
				query += " and teacher = '" + teacher.toLowerCase() + "'";

			}

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected....");
				rs.previous();
				query = "insert into profile(id, pwd,resid ,name, PhoneNums , teacher) ";
				query += "VALUES('" + id + "', '" + pwd + "', '" + resid + "', '" + name + "', ' " + PhoneNums + "', ' "
						+ teacher + "')";
				System.out.println(query);

				stmt.executeQuery(query);
				System.out.println("Join complete");

			} else {
				System.out.println(rs.getRow() + "rows selected...");
				System.out.println("can not join");
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
}
package BCDLOGDATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String pwd = "green1234";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet resulty = null;

//   public ArrayList<LoginVo> list(String id, String pwd) {
//      ArrayList<LoginVo> list = new ArrayList<LoginVo>();
//      try {
//         connDB();
//         String query = "select *from profile ";
//         if (id != null && pwd != null) {
//            query += "where id = '" + id.toLowerCase() + "'";
//            query += "and pwd = '" + pwd.toLowerCase() + "'";
//
//         }
//         System.out.println("SQL : " + query);
//
//         resulty = stmt.executeQuery(query);
//         resulty.last();
//
//         if (resulty.getRow() == 0) {
//            System.out.println("0 row selected.....");
//         } else {
//            System.out.println(resulty.getRow() + "rows selected.....");
//            resulty.previous();
//            while (resulty.next()) {
//               String pid = resulty.getString("id");
//               String ppwd = resulty.getString("pwd");
//
//               LoginVo data = new LoginVo(pid, ppwd);
//               list.add(data);
//            }
//         }
//
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      return list;
//
//   }

	public int login(String userID, String userPassword) {
		String SQL = "SELECT pwd FROM profile WHERE id = ?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			resulty = pstmt.executeQuery();
			if (resulty.next()) {
				if (resulty.getString(1).contentEquals(userPassword)) {
					return 1; // 濡쒓?���씤 �꽦?�듭?�� 1 諛섑?��
				} else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return -2;
	}

	public int logincheck(String userID) {
		String SQL = "select tjob FROM profile where id = ?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			resulty = pstmt.executeQuery();
			if (resulty.next()) {
				if (resulty.getString(1).contentEquals("Admin")) {
					return 1;
				} else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}

//	private Connection connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("jdbc driver loading success.");
//			conn = DriverManager.getConnection(url, user, pwd);
//			System.out.println("oracle connection success.");
//
//			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			System.out.println("statement create success.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return con;
//	}

	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driver); // 1. �뱶�씪�씠踰� 濡쒕�?
			con = DriverManager.getConnection(url, user, pwd); // 2. �뱶�씪�씠踰� �뿰寃�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
package VocabQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import User_Content1VocabQuiz.SubimitVo;

public class VocabQuizDAO1 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<VocabiQuizVo1> list(String Output1, String Output2, String Output3, String Output4, String Output5,
			String Output6, String Output7, String Output8, String Output9, String Output10, String Output11,
			String Output12, String Output13, String Output14, String Output15, String Output16) {
		ArrayList<VocabiQuizVo1> list = new ArrayList<VocabiQuizVo1>();
		try {

			System.out.println(Output1 + " " + Output2 + " " + Output3);
			connDB();
			String query;
			String ct1 = Output1;
			String ct2 = Output2;
			String ct3 = Output3;
			String ct4 = Output4;
			String ct5 = Output5;
			String ct6 = Output6;
			String ct7 = Output7;
			String ct8 = Output8;
			String ct9 = Output9;
			String ct10 = Output10;
			String ct11 = Output11;
			String ct12 = Output12;
			String ct13 = Output13;
			String ct14 = Output14;
			String ct15 = Output15;
			String ct16 = Output16;

//				query = "select * from instruction1  where contentsA = '" + contentsA + "'"+
//				" and contentsB = '" + contentsB.toLowerCase() + "'"+
//				" and contentsC = '" + contents3.toLowerCase() + "'";
			query = "insert into VocabQuizFinished1(Output1, Output2, Output3, Output4, Output5, Output6, Output7, Output8, Output9, Output10, Output11, Output12, Output13, Output14, Output15, Output16)"
					+ " VALUES('" + ct1 + "', '" + ct2 + "', '" + ct3 + "', '" + ct4 + "', '" + ct5 + "', '" + ct6
					+ "', '" + ct7 + "', '" + ct8 + "', '" + ct9 + "', '" + ct10 + "', '" + ct11 + "', '" + ct12
					+ "', '" + ct13 + "', '" + ct14 + "', '" + ct15 + "', '" + ct16 + "')";

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);

//			if (rs.getRow() == 0) {
//				System.out.println("0 row selected....");
//				
//				System.out.println(query);
//
//				System.out.println("Join complete");
//
//			} else {
//				System.out.println(rs.getRow() + "rows selected...");
//				System.out.println("can not join");
//			}

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

			String sql2 = "SELECT Output1, Output2, Output3, Output4, Output5, Output6, Output7, Output8, Output9, Output10, Output11, Output12, Output13, Output14, Output15, Output16 FROM VocabQuizFinished1";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}
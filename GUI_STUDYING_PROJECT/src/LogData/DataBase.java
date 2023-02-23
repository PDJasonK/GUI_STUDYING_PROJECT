package LogData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBase {

public static Connection dbConn;

public static Connection getConnection() {

    Connection conn = null;
     String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521/xe";
   String user = "c##green";
   String password = "green1234";
    
    try {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
//        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("Database 연결 성공");

    } catch (Exception e) {
        System.out.println("Database 연결 실패");
        e.printStackTrace();
    }
    return conn;     
}

public static void close(PreparedStatement stmt, Connection conn) {
    if (stmt != null) {
        try {
            if (!stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
    }

    if (conn != null) {
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
    if (rs != null) {
        try {
            if (!rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    if (stmt != null) {
        try {
            if (!stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
    }
    if (conn != null) {
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

public static void main(String[] args) {
    getConnection();
  }
}
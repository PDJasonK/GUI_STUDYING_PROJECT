package UserToeicTestPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import UserPage.HomeScreen;
import UserToeicReadingContent.ReadingMain2DAO;
import UserToeicReadingContent.ReadingMain3;

public class SubmitResult extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel title1;
	private JLabel title2;
	private JLabel title3;
	private JLabel title4;
	private JButton Submit, btn1, btn2, btn0, btn3;
	private JLabel title0;

	ReadingMain2DAO dao = new ReadingMain2DAO();
	/*
	 * private JTextArea gainer1 = new JTextArea(); // private JTextArea gainer2 =
	 * new JTextArea(); // private JTextArea gainer3 = new JTextArea();
	 * 
	 * 
	 * private JTextArea sending1 = new JTextArea(); private JTextArea sending2 =
	 * new JTextArea(); private JTextArea sending3 = new JTextArea();
	 */

	public static JTextArea gainer1 = new JTextArea();
	public static JTextArea gainer2 = new JTextArea();
	public static JTextArea gainer3 = new JTextArea();

	public static JTextArea sending1 = new JTextArea();
	public static JTextArea sending2 = new JTextArea();
	public static JTextArea sending3 = new JTextArea();

	private Statement stmt;
	private Connection conn;

	public SubmitResult() {

		f = new JFrame("[�빐�꽍臾� �븳踰덉뿉蹂닿린] - ALL");
		f.setBackground(Color.GRAY);
		p = new JPanel();
		p.setLayout(null);

		// -----

		title0 = new JLabel("�닔�젙�븷 �궡�슜�씠 �엳�쓣寃쎌슦 �닔�젙�썑 �삤瑜몄そ�븯�떒�쓽 踰꾪듉�쓣 �넻�빐 �뵾�뱶諛� �떊泥� �슂留�");
		title0.setBounds(30, -15, 800, 90);
		title0.setFont(new Font("Gothic", Font.BOLD, 15));

		title1 = new JLabel("泥ル쾲吏� 由щ뵫");
		title1.setBounds(30, 5, 800, 90);

		title2 = new JLabel("�몢踰덉㎏ 由щ뵫", JLabel.LEFT);
		title2.setBounds(30, 100, 500, 500);
		title3 = new JLabel("�꽭踰덉㎏ 由щ뵫", JLabel.LEFT);
		title3.setBounds(30, 380, 500, 500);

		gainer1.setLayout(null);
		gainer1.setBounds(30, 55, 800, 280);
		gainer1.setEditable(false);
		gainer1.setFont(new Font("Gothic", Font.ITALIC, 10));

		gainer2.setLayout(null);
		gainer2.setBounds(30, 360, 800, 260);
		gainer2.setFont(new Font("Gothic", Font.ITALIC, 10));

		gainer3.setLayout(null);
		gainer3.setBounds(30, 640, 800, 240);
		gainer3.setFont(new Font("Gothic", Font.ITALIC, 10));

		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);

		btn1 = new JButton("�떆�뿕蹂닿린");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);

		btn3 = new JButton("�뵾�뱶諛� �슂泥�");
		btn3.setLayout(null);
		btn3.setBounds(850, 750, 100, 60);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				SignupChecker su = new SignupChecker();

				// fn.startframe();
			}

		});

		btn0 = new JButton("�뮘濡� �룎�븘媛�湲�");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ReadingResult();
				p.setVisible(false);
				f.setVisible(false);

			}

		});

		startframe();
		method();
		method1();
		method2();

//		Submit.setBackground(Color.gray);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReadingMain3();
				f.setVisible(false);

			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				f.setVisible(false);
				hs.startFrame();

			}

		});

	}

	/*
	 * @Override public void actionPerformed(ActionEvent e) { HomeScreen hs = new
	 * HomeScreen(); signup.setVisible(false);
	 * 
	 * hs.startFrame(); }
	 * 
	 * });
	 * 
	 * }
	 */
	public void startframe() {
		f.setSize(1000, 1200);
		f.add(title1);
		f.add(title2);
		f.add(title3);
		f.add(title0);

		f.add(Submit);

		f.add(gainer1);
		f.add(gainer2);
		f.add(gainer3);

		p.add(btn1);
		p.add(btn2);
		p.add(btn0);
		p.add(btn3);

		// f.add(title, "North");

		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		// p.add(Practice);

		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		SubmitResult RM2 = new SubmitResult();
		RM2.startframe();
	}

	// ------------------------------------------------------------------------------------
	public void method() {

		try {
			String driver1 = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "c##green";
			String pwd = "green1234";
			Class.forName(driver1);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT contentsArMy FROM instruction1My";
			// String sql3 = "SELECT contentsAr FROM instruction1Read";
			// String sql4 = "SELECT gain1 FROM ReadingMainGain";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("contentsArMy") + "\t");

				gainer1.setText(rs2.getString("contentsArMy"));
				// gainer2.setText(rs2.getString("contentsAr"));
				// gainer3.setText(rs2.getString("gain3"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void method1() {

		String driver2 = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##green";
		String pwd = "green1234";

		try {
			Class.forName(driver2);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT send1 FROM ReadingMainSend";
			// String sql3 = "SELECT contentsAr FROM instruction1Read";
			// String sql4 = "SELECT gain1 FROM ReadingMainGain";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("send1") + "\t");

				// gainer1.setText(rs2.getString("gain1"));
				gainer2.setText(rs2.getString("send1"));
				// gainer3.setText(rs2.getString("gain3"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void method2() {

		String driver3 = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##green";
		String pwd = "green1234";

		try {
			Class.forName(driver3);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT sendC1 FROM ReadingMainSend3";
			// String sql3 = "SELECT contentsAr FROM instruction1Read";
			// String sql4 = "SELECT gain1 FROM ReadingMainGain";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("sendC1") + "\t");

				// gainer1.setText(rs2.getString("gain1"));
				// gainer2.setText(rs2.getString("contentsAr"));
				gainer3.setText(rs2.getString("sendC1"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
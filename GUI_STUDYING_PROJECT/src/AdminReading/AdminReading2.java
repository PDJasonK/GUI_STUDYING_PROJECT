package AdminReading;

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

import AdminOptionPage.AdminOptionPage;
import Use_rPage.HomeScreen;

//ReadingMainGain3

public class AdminReading2 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
	private JLabel title;
	private Statement stmt;
	private Connection conn;

	AdminReading2DAO dao = new AdminReading2DAO();

	private JButton Submit, btn1, btn2, btn0, btn3;

	public static JTextArea review2 = new JTextArea();
	public static JTextArea yoyo4 = new JTextArea();

	public AdminReading2() {

		f = new JFrame("Add Second Article by Admin");
		f.setLayout(null);
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("[두번째 리딩 지문] Second Reading");
		title.setBounds(30, 0, 800, 90);

		review2.setLayout(null);
		review2.setBounds(30, 50, 800, 350);

		PContent1 = new JLabel("[두번째 리딩 지문] Second Reading ", JLabel.LEFT);
		PContent1.setBounds(30, 240, 500, 500);
		/*
		 * PContent2 = new JLabel("[Write Second] �몢 踰덉㎏ 臾몃떒 �옉�꽦 ", JLabel.LEFT);
		 * PContent2.setBounds(30, 380, 500, 500); PContent3 = new
		 * JLabel("[Write Third] �꽭踰덉㎏ 臾몃떒 �옉�꽦", JLabel.LEFT); PContent3.setBounds(30,
		 * 520, 500, 500);
		 */
		yoyo4 = new JTextArea();
		yoyo4.setBounds(30, 500, 800, 370);

		// yoyo5 = new JTextArea();
		// yoyo5.setBounds(30, 640, 8000, 90);

		// yoyo6 = new JTextArea();
		// yoyo6.setBounds(30, 780, 8000, 90);

		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);

		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);

		btn0 = new JButton("Back to Admin Main Page");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);

		btn3 = new JButton("Back ");
		btn3.setLayout(null);
		btn3.setBounds(850, 750, 100, 60);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminReading1();
				f.setVisible(false);
			}

		});

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminOptionPage AP = new AdminOptionPage();
				AP.startFrame();
				f.setVisible(false);

			}

		});

		startframe();
		method();
 
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(yoyo4.getSelectedText());
				if (yoyo4.getText() != null) {
					String syoyo4 = yoyo4.getText();

					dao.list(syoyo4);
				}
			}

		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminReading3();
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

		f.add(title);

		f.add(PContent1);

		f.add(Submit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn0);
		f.add(btn3);

		f.add(review2);

		f.add(yoyo4);

		// f.add(title, "North");

		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		// p.add(Practice);

		f.setVisible(true);
		p.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		AdminReading2 sm = new AdminReading2();
		sm.startframe();
	}

	public void method() {
		String list = "";
		String driver1 = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##green";
		String pwd = "green1234";

		try {
			Class.forName(driver1);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT sending1  FROM readingadmin2";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("sending1") + "\t");

				review2.setText(rs2.getString("sending1"));

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

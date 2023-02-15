package AdminReadingQuiz;

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
import AdminReading.AdminReading2;
import UserPage.HomeScreen;

public class GiveFeedback extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1, PContent2, PContent3, PContent4;
	private JLabel title;
	private Statement stmt;
	private Connection conn;

	GiveFeedbackDAO1 dao = new GiveFeedbackDAO1();

	private JButton Submit, btn1, btn2, btn0;

	public static JTextArea review1 = new JTextArea();
	public static JTextArea question1 = new JTextArea();
	public static JTextArea yoyo4 = new JTextArea();

	public GiveFeedback() {

		f = new JFrame("Add First Article by Admin");
		f.setLayout(null);
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("[첫번째 문제 생성] First Question");
		title.setBounds(30, 0, 800, 90);

		review1.setLayout(null);
		review1.setBounds(30, 50, 800, 200);
		review1.setEditable(false);

		PContent1 = new JLabel("[지문 해석 및 요약] Conprehensive", JLabel.LEFT);
		PContent1.setBounds(30, 150, 500, 500);

		PContent2 = new JLabel("[지문을 기반한 문제생성] Conprehensive Questions", JLabel.LEFT);
		PContent2.setBounds(30, 20, 500, 500);

		PContent3 = new JLabel("[정답 적기]");
		PContent3.setBounds(30, 180, 500, 500);

		PContent4 = new JLabel("[정답의 근거가되는 문장 적기]");
		PContent4.setBounds(30, 260, 500, 500);
 
	 
		question1 = new JTextArea();
		question1.setBounds(30, 280, 800, 100);

		yoyo4 = new JTextArea();
		yoyo4.setBounds(30, 420, 800, 370);

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

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminOptionPage AP = new AdminOptionPage();
				AP.startFrame();
				f.setVisible(false);
				p.setVisible(false);

			}

		});

		startframe();
		method();

//		Submit.setBackground(Color.gray);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(question1.getSelectedText());
				if (question1.getText() != null) {
					String syoyo4 = question1.getText();

					dao.list(syoyo4);
				}
			}

		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminReading2();
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
		f.add(PContent2);

		f.add(title);
		f.add(question1);

		f.add(PContent1);
		f.add(PContent3);
		f.add(PContent4);

		f.add(Submit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn0);

		f.add(review1);

		f.add(yoyo4);

		// f.add(title, "North");

		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		// p.add(Practice);

		f.setVisible(true);
		p.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		GiveFeedback GF = new GiveFeedback();
		GF.startframe();
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

			String sql2 = "SELECT sending1  FROM readingadmin1";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("sending1") + "\t");

				review1.setText(rs2.getString("sending1"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Class.forName(driver1);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT sending1  FROM readq1";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("sending1") + "\t");

				question1.setText(rs2.getString("sending1"));

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

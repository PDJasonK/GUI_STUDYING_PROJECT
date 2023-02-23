package UserVocab;

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
import User_Content1VocabQuiz.SubmitDAO;
import VocabQuiz.VocabQuiz1;
import VocabQuiz.VocabQuiz3;

public class UserVocab3 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;
	/*
	 * private JLabel PContent1; private JLabel PContent2; private JLabel PContent3;
	 */

	private JLabel title;
	private Statement stmt;
	private Connection conn;
	private JButton Submit, btn1, btn2, btn3, btn0;

	SubmitDAO dao = new SubmitDAO();

	public static JTextArea Out1 = new JTextArea();
	public static JTextArea Out2 = new JTextArea();
	public static JTextArea Out3 = new JTextArea();
	public static JTextArea Out4 = new JTextArea();
	public static JTextArea Out5 = new JTextArea();
	public static JTextArea Out6 = new JTextArea();
	public static JTextArea Out7 = new JTextArea();
	public static JTextArea Out8 = new JTextArea();
	public static JTextArea Out9 = new JTextArea();
	public static JTextArea Out10 = new JTextArea();
	public static JTextArea Out11 = new JTextArea();
	public static JTextArea Out12 = new JTextArea();
	public static JTextArea Out13 = new JTextArea();
	public static JTextArea Out14 = new JTextArea();
	public static JTextArea Out15 = new JTextArea();
	public static JTextArea Out16 = new JTextArea();

	public UserVocab3() {

		f = new JFrame(" Third ONe");
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("단어 출제 [3] [VocabList]본문");
		title.setBounds(30, 1, 800, 90);
		// ------------

		Out1.setLayout(null);
		Out1.setBounds(30, 55, 350, 60);
		Out1.setEditable(false);

		Out2.setLayout(null);
		Out2.setBounds(430, 55, 350, 60);
		Out2.setEditable(false);

		Out3.setLayout(null);
		Out3.setBounds(30, 155, 350, 60);
		Out3.setEditable(false);

		Out4.setLayout(null);
		Out4.setBounds(430, 155, 350, 60);
		Out4.setEditable(false);

		Out5.setLayout(null);
		Out5.setBounds(30, 255, 350, 60);
		Out5.setEditable(false);

		Out6.setLayout(null);
		Out6.setBounds(430, 255, 350, 60);
		Out6.setEditable(false);

		Out7.setLayout(null);
		Out7.setBounds(30, 355, 350, 60);
		Out7.setEditable(false);

		Out8.setLayout(null);
		Out8.setBounds(430, 355, 350, 60);
		Out8.setEditable(false);

		Out9.setLayout(null);
		Out9.setBounds(30, 455, 350, 60);
		Out9.setEditable(false);

		Out10.setLayout(null);
		Out10.setBounds(430, 455, 350, 60);
		Out10.setEditable(false);

		Out11.setLayout(null);
		Out11.setBounds(30, 555, 350, 60);
		Out11.setEditable(false);

		Out12.setLayout(null);
		Out12.setBounds(430, 555, 350, 60);
		Out12.setEditable(false);

		Out13.setLayout(null);
		Out13.setBounds(30, 655, 350, 60);
		Out13.setEditable(false);

		Out14.setLayout(null);
		Out14.setBounds(430, 655, 350, 60);
		Out14.setEditable(false);

		Out15.setLayout(null);
		Out15.setBounds(30, 755, 350, 60);
		Out15.setEditable(false);

		Out16.setLayout(null);
		Out16.setBounds(430, 755, 350, 60);
		Out16.setEditable(false);

		// -------------------
		/*
		 * PContent1 = new JLabel("첫번째 문단의 해석문", JLabel.LEFT); PContent1.setBounds(30,
		 * 240, 500, 500); PContent2 = new JLabel("두번째 문단의 해석문", JLabel.LEFT);
		 * PContent2.setBounds(30, 380, 500, 500); PContent3 = new
		 * JLabel("세번째 첫번째 문단의 해석문 ", JLabel.LEFT); PContent3.setBounds(30, 520, 500,
		 * 500);
		 */
		/*
		 * yoyo4 = new JTextArea(); yoyo4.setBounds(30, 500, 800, 90);
		 * yoyo4.addFocusListener(new FocusAdapter() { public void
		 * focusGained(FocusEvent e) { yoyo4.setBackground(Color.ORANGE); }
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * yoyo4.setBackground(Color.YELLOW); } });
		 * 
		 * yoyo5 = new JTextArea(); yoyo5.setBounds(30, 640, 800, 90);
		 * yoyo5.addFocusListener(new FocusAdapter() { public void
		 * focusGained(FocusEvent e) { yoyo5.setBackground(Color.ORANGE); }
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * yoyo5.setBackground(Color.YELLOW); } });
		 * 
		 * yoyo6 = new JTextArea(); yoyo6.setBounds(30, 780, 800, 90);
		 * yoyo6.addFocusListener(new FocusAdapter() { public void
		 * focusGained(FocusEvent e) { yoyo6.setBackground(Color.ORANGE); }
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * yoyo6.setBackground(Color.YELLOW); } });
		 */
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);

		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);

		btn3 = new JButton("뒤로 돌아가기");
		btn3.setLayout(null);
		btn3.setBounds(830, 750, 130, 60);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new UserVocab2();

				// fn.startframe();
			}

		});

		btn0 = new JButton("시험보러가기");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VocabQuiz3();

				f.setVisible(false);

			}

		});

		startframe();
		method();

//		Submit.setBackground(Color.gray);

		/*
		 * Submit.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { System.out.println(yoyo4.getSelectedText() +
		 * yoyo5.getSelectedText() + yoyo6.getSelectedText()); if (yoyo4.getText() !=
		 * null && yoyo5.getText() != null && yoyo6.getText() != null) { String syoyo4 =
		 * yoyo4.getText(); String syoyo5 = yoyo5.getText(); String syoyo6 =
		 * yoyo6.getText(); dao.list(syoyo4, syoyo5, syoyo6); } }
		 * 
		 * });
		 * 
		 */

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VocabQuiz1();
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
		p.add(title);

		/*
		 * p.add(PContent1); p.add(PContent2); p.add(PContent3);
		 */
		// p.add(Submit);

		p.add(Out1);
		p.add(Out2);
		p.add(Out3);
		p.add(Out4);
		p.add(Out5);
		p.add(Out6);
		p.add(Out7);
		p.add(Out8);
		p.add(Out9);
		p.add(Out10);
		p.add(Out11);
		p.add(Out12);
		p.add(Out13);
		p.add(Out14);
		p.add(Out15);
		p.add(Out16);
		p.add(btn0);

		// p.add(yoyo2);
		// p.add(yoyo3);

		//p.add(btn1);
		p.add(btn2);
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
		UserVocab3 sm = new UserVocab3();
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

			String sql2 = "SELECT Output1, Output2, Output3, Output4, Output5, Output6, Output7, Output8, Output9, Output10, Output11, Output12 , Output13 ,Output14 ,Output15 ,Output16 FROM VocabOut3";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("Output1") + "\t");
				System.out.print(rs2.getString("Output2") + "\t");
				System.out.print(rs2.getString("Output3"));

				Out1.setText(rs2.getString("Output1"));
				Out2.setText(rs2.getString("Output2"));
				Out3.setText(rs2.getString("Output3"));
				Out4.setText(rs2.getString("Output4"));
				Out5.setText(rs2.getString("Output5"));
				Out6.setText(rs2.getString("Output6"));
				Out7.setText(rs2.getString("Output7"));
				Out8.setText(rs2.getString("Output8"));
				Out9.setText(rs2.getString("Output9"));
				Out10.setText(rs2.getString("Output10"));
				Out11.setText(rs2.getString("Output11"));
				Out12.setText(rs2.getString("Output12"));
				Out13.setText(rs2.getString("Output13"));
				Out14.setText(rs2.getString("Output14"));
				Out15.setText(rs2.getString("Output15"));
				Out16.setText(rs2.getString("Output16"));

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
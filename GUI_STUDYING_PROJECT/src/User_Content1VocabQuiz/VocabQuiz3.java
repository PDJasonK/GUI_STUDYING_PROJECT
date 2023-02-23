package User_Content1VocabQuiz;

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
import UserPage.HomeScreen;

public class VocabQuiz3 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;
	/*
	 * private JLabel PContent1; private JLabel PContent2; private JLabel PContent3;
	 */

	private JLabel title;
	private Statement stmt;
	private Connection conn;
	private JButton Submit, btn1, btn2, btn0;

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
//-------------------------
	public static JTextArea Out1a = new JTextArea();
	public static JTextArea Out2a = new JTextArea();
	public static JTextArea Out3a = new JTextArea();
	public static JTextArea Out4a = new JTextArea();
	public static JTextArea Out5a = new JTextArea();
	public static JTextArea Out6a = new JTextArea();
	public static JTextArea Out7a = new JTextArea();
	public static JTextArea Out8a = new JTextArea();
	public static JTextArea Out9a = new JTextArea();
	public static JTextArea Out10a = new JTextArea();
	public static JTextArea Out11a = new JTextArea();
	public static JTextArea Out12a = new JTextArea();
	public static JTextArea Out13a = new JTextArea();
	public static JTextArea Out14a = new JTextArea();
	public static JTextArea Out15a = new JTextArea();
	public static JTextArea Out16a = new JTextArea();

	public VocabQuiz3() {

		f = new JFrame("Quiz1");
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("ÔøΩÎñéÔøΩÍº´ÔøΩÍ∂éÔßùÔøΩ ÔøΩÍΩ≠Ë∏∞Ïàà?ò±");
		title.setBounds(15, 1, 800, 90);
		// ------------

		Out1.setLayout(null);
		Out1.setBounds(15, 55, 100, 50);

		Out2.setLayout(null);
		Out2.setBounds(480, 55, 100, 50);

		Out3.setLayout(null);
		Out3.setBounds(15, 155, 100, 50);

		Out4.setLayout(null);
		Out4.setBounds(480, 155, 100, 50);

		Out5.setLayout(null);
		Out5.setBounds(15, 255, 100, 50);

		Out6.setLayout(null);
		Out6.setBounds(480, 255, 100, 50);

		Out7.setLayout(null);
		Out7.setBounds(15, 355, 100, 50);

		Out8.setLayout(null);
		Out8.setBounds(480, 355, 100, 50);

		Out9.setLayout(null);
		Out9.setBounds(15, 455, 100, 50);

		Out10.setLayout(null);
		Out10.setBounds(480, 455, 100, 50);

		Out11.setLayout(null);
		Out11.setBounds(15, 555, 100, 50);

		Out12.setLayout(null);
		Out12.setBounds(480, 555, 100, 50);

		Out13.setLayout(null);
		Out13.setBounds(15, 655, 100, 50);

		Out14.setLayout(null);
		Out14.setBounds(480, 655, 100, 50);

		Out15.setLayout(null);
		Out15.setBounds(15, 755, 100, 50);

		Out16.setLayout(null);
		Out16.setBounds(480, 755, 100, 50);

		// ---------------------------------------------------------
		Out1a.setLayout(null);
		Out1a.setBounds(125, 55, 300, 50);
		Out1a.setEditable(false);

		Out2a.setLayout(null);
		Out2a.setBounds(600, 55, 300, 50);
		Out2a.setEditable(false);

		Out3a.setLayout(null);
		Out3a.setBounds(125, 155, 300, 50);
		Out3a.setEditable(false);

		Out4a.setLayout(null);
		Out4a.setBounds(600, 155, 300, 50);
		Out4a.setEditable(false);

		Out5a.setLayout(null);
		Out5a.setBounds(125, 255, 300, 50);
		Out5a.setEditable(false);

		Out6a.setLayout(null);
		Out6a.setBounds(600, 255, 300, 50);
		Out6a.setEditable(false);

		Out7a.setLayout(null);
		Out7a.setBounds(125, 355, 300, 50);
		Out7a.setEditable(false);

		Out8a.setLayout(null);
		Out8a.setBounds(600, 355, 300, 50);
		Out8a.setEditable(false);

		Out9a.setLayout(null);
		Out9a.setBounds(125, 455, 300, 50);
		Out9a.setEditable(false);

		Out10a.setLayout(null);
		Out10a.setBounds(600, 455, 300, 50);
		Out10a.setEditable(false);

		Out11a.setLayout(null);
		Out11a.setBounds(125, 555, 300, 50);
		Out11a.setEditable(false);

		Out12a.setLayout(null);
		Out12a.setBounds(600, 555, 300, 50);
		Out12a.setEditable(false);

		Out13a.setLayout(null);
		Out13a.setBounds(125, 655, 300, 50);
		Out13a.setEditable(false);

		Out14a.setLayout(null);
		Out14a.setBounds(600, 655, 300, 50);
		Out14a.setEditable(false);

		Out15a.setLayout(null);
		Out15a.setBounds(125, 755, 300, 50);
		Out15a.setEditable(false);

		Out16a.setLayout(null);
		Out16a.setBounds(600, 755, 300, 50);
		Out16a.setEditable(false);

		// -------------------
		/*
		 * PContent1 = new JLabel("Ôß£„É´Ïæ≤ÔßûÔø? ?áæÎ™ÉÎñíÔøΩÏìΩ ÔøΩÎπêÔøΩÍΩç?áæÔø?", JLabel.LEFT); PContent1.setBounds(15,
		 * 240, 500, 500); PContent2 = new JLabel("ÔøΩÎ™¢Ë∏∞Îçâ?éè ?áæÎ™ÉÎñíÔøΩÏìΩ ÔøΩÎπêÔøΩÍΩç?áæÔø?", JLabel.LEFT);
		 * PContent2.setBounds(15, 380, 500, 500); PContent3 = new
		 * JLabel("ÔøΩÍΩ≠Ë∏∞Îçâ?éè Ôß£„É´Ïæ≤ÔßûÔø? ?áæÎ™ÉÎñíÔøΩÏìΩ ÔøΩÎπêÔøΩÍΩç?áæÔø? ", JLabel.LEFT); PContent3.setBounds(15, 520, 500,
		 * 500);
		 */
		/*
		 * yoyo4 = new JTextArea(); yoyo4.setBounds(15, 500, 800, 90);
		 * yoyo4.addFocusListener(new FocusAdapter() { public void
		 * focusGained(FocusEvent e) { yoyo4.setBackground(Color.ORANGE); }
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * yoyo4.setBackground(Color.YELLOW); } });
		 * 
		 * yoyo5 = new JTextArea(); yoyo5.setBounds(15, 640, 800, 90);
		 * yoyo5.addFocusListener(new FocusAdapter() { public void
		 * focusGained(FocusEvent e) { yoyo5.setBackground(Color.ORANGE); }
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * yoyo5.setBackground(Color.YELLOW); } });
		 * 
		 * yoyo6 = new JTextArea(); yoyo6.setBounds(15, 780, 800, 90);
		 * yoyo6.addFocusListener(new FocusAdapter() { public void
		 * focusGained(FocusEvent e) { yoyo6.setBackground(Color.ORANGE); }
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * yoyo6.setBackground(Color.YELLOW); } });
		 */
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 50);

		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 50);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 50);

		btn0 = new JButton("?ÑøÔøΩÁî±?äÏòÑ ÔøΩÎüπÔøΩÏî†ÔßûÔøΩÊø°ÔøΩ ÔøΩÎ£éÔøΩÎ∏òÂ™õÔøΩÊπ≤ÔøΩ");
		btn0.setLayout(null);
		btn0.setBounds(500, 890, 200, 50);

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
				new VocabQuiz3();
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

		p.add(Out1a);
		p.add(Out2a);
		p.add(Out3a);
		p.add(Out4a);
		p.add(Out5a);
		p.add(Out6a);
		p.add(Out7a);
		p.add(Out8a);
		p.add(Out9a);
		p.add(Out10a);
		p.add(Out11a);
		p.add(Out12a);
		p.add(Out13a);
		p.add(Out14a);
		p.add(Out15a);
		p.add(Out16a);

		p.add(btn0);

		// p.add(yoyo2);
		// p.add(yoyo3);

		p.add(btn1);
		p.add(btn2);

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
		VocabQuiz3 sm = new VocabQuiz3();
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

			String sql2 = "SELECT Output1, Output2, Output3, Output4, Output5, Output6, Output7, Output8, Output9, Output10, Output11, Output12 , Output13 ,Output14 ,Output15 ,Output16 FROM ReadingQuiz1";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("Output1") + "\t");
				System.out.print(rs2.getString("Output2") + "\t");
				System.out.print(rs2.getString("Output3"));

				Out1a.setText(rs2.getString("Output1"));
				Out2a.setText(rs2.getString("Output2"));
				Out3a.setText(rs2.getString("Output3"));
				Out4a.setText(rs2.getString("Output4"));
				Out5a.setText(rs2.getString("Output5"));
				Out6a.setText(rs2.getString("Output6"));
				Out7a.setText(rs2.getString("Output7"));
				Out8a.setText(rs2.getString("Output8"));
				Out9a.setText(rs2.getString("Output9"));
				Out10a.setText(rs2.getString("Output10"));
				Out11a.setText(rs2.getString("Output11"));
				Out12a.setText(rs2.getString("Output12"));
				Out13a.setText(rs2.getString("Output13"));
				Out14a.setText(rs2.getString("Output14"));
				Out15a.setText(rs2.getString("Output15"));
				Out16a.setText(rs2.getString("Output16"));

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
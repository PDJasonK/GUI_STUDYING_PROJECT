package QuestionBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import Query.CheckQ01;
import User_Page.HomeScreen;
import VocabQuiz.VocabQuiz2;

public class QuestionSubmitBoard01 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;
	/*
	 * private JLabel PContent1; private JLabel PContent2; private JLabel PContent3;
	 */

	private JLabel title;
	private Statement stmt;
	private Connection conn;
	private JButton Submit, btn1, btn2, btn3, btn0;

	QuestionSubmitBoard01DAO dao = new QuestionSubmitBoard01DAO();

	public static JTextArea Out1 = new JTextArea();
	public static JTextArea Out2 = new JTextArea();
	public static JTextArea Out3 = new JTextArea();
	public static JTextArea IDTEXT = new JTextArea();
	public static JTextArea TITLETEXT = new JTextArea();
	public static JTextArea QUESTIONTEXT = new JTextArea();
	public static JTextArea PWDTEXT = new JTextArea();
	public static JTextArea ANSWER = new JTextArea();
	public static JTextArea Out4 = new JTextArea();
	public static JTextArea Out5 = new JTextArea();
	
	public static JTextArea Out16a = new JTextArea();
	public static JTextArea answer = new JTextArea();

	public QuestionSubmitBoard01() {

		f = new JFrame("QuizAnswerChecker");
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("질문사항 제출");
		title.setFont(new Font("Gothic", Font.BOLD, 40));
		title.setBounds(15, 1, 800, 40);
		// ------------

		Out1.setLayout(null);
		Out1.setBounds(130, 100, 140, 20);
		Out1.setSelectedTextColor(Color.yellow);
		Out1.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				Out1.setBackground(Color.ORANGE);
			}

			public void focusLost(FocusEvent e) {
				Out1.setBackground(Color.YELLOW);
			}
		});

		Out2.setLayout(null);
		Out2.setBounds(130, 130, 600, 20);
//		Out2.setEchoChar('*');
		Out2.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				Out2.setBackground(Color.ORANGE);
			}

			public void focusLost(FocusEvent e) {
				Out2.setBackground(Color.YELLOW);
			}
		});

		Out3.setLayout(null);
		Out3.setBounds(130, 170, 600, 350);
		Out3.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				Out3.setBackground(Color.WHITE);
			}

			public void focusLost(FocusEvent e) {
				Out3.setBackground(Color.YELLOW);
			}
		});

		Out4.setLayout(null);
		Out4.setBounds(480, 100, 140, 20);
		Out4.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				Out4.setBackground(Color.ORANGE);
			}

			public void focusLost(FocusEvent e) {
				Out4.setBackground(Color.YELLOW);
			}
		});
		
		Out5.setLayout(null);
		Out5.setBounds(130, 560, 600, 220);
		Out5.setEditable(false);
		Out5.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				Out5.setBackground(Color.ORANGE);
			}

			public void focusLost(FocusEvent e) {
				Out5.setBackground(Color.YELLOW);
			}
		});

		IDTEXT = new JTextArea("아이디 입력 :");
		IDTEXT.setEditable(false);
		IDTEXT.setLayout(null);
		IDTEXT.setBounds(20, 100, 80, 20);

		TITLETEXT = new JTextArea("제목 입력 : ");
		TITLETEXT.setEditable(false);
		TITLETEXT.setLayout(null);
		TITLETEXT.setBounds(20, 130, 80, 20);

		QUESTIONTEXT = new JTextArea("질문 입력 : ");
		QUESTIONTEXT.setLayout(null);
		QUESTIONTEXT.setEditable(false);
		QUESTIONTEXT.setBounds(20, 170, 80, 20);

		PWDTEXT = new JTextArea("비밀번호 입력 : ");
		PWDTEXT.setLayout(null);
		PWDTEXT.setEditable(false);
		PWDTEXT.setBounds(350, 100, 95, 20);

		ANSWER = new JTextArea("관리자 답글: ");
		ANSWER.setLayout(null);
		ANSWER.setEditable(false);
		ANSWER.setBounds(20, 560, 95, 20);
		
		Out16a.setLayout(null);
		Out16a.setBounds(130, 800, 600, 50);
		Out16a.setEditable(false);
		Out16a.setFont(new Font("Gothic", Font.BOLD, 20));

		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 50);

		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 50);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 50);

		btn3 = new JButton("내질문확인");
		btn3.setLayout(null);
		btn3.setBounds(850, 810, 100, 60);
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckQ01();

			}

		});

		btn0 = new JButton("Back to Main Page");

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

		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Out1.getSelectedText() + Out2.getSelectedText() + Out3.getSelectedText()
						+ Out4.getSelectedText());

				if (Out1.getText() != null && Out2.getText() != null && Out3.getText() != null
						&& Out4.getText() != null) {

					String outta1 = Out1.getText();
					String outta2 = Out2.getText();
					String outta3 = Out3.getText();
					String outta4 = Out4.getText();

					dao.list(outta1, outta2, outta3, outta4);
				}
			}

		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VocabQuiz2();
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

	public void startframe() {
		f.setSize(1000, 1200);
		p.add(title);

		p.add(Submit);

		p.add(Out1);
		p.add(Out2);
		p.add(Out3);
		p.add(IDTEXT);
		p.add(TITLETEXT);
		p.add(QUESTIONTEXT);
		p.add(PWDTEXT);
		p.add(Out4);
		p.add(Out5);
		
		p.add(ANSWER);

		p.add(Out16a);
		p.add(answer);

		p.add(btn0);

		p.add(btn1);
		p.add(btn2);
		p.add(btn3);

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
		QuestionSubmitBoard01 sm = new QuestionSubmitBoard01();
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

			String sql2 = "SELECT noti1 FROM notify";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("noti1") + "\t");

				Out16a.setText(rs2.getString("noti1"));

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
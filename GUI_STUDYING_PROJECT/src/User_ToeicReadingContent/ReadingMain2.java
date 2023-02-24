package User_ToeicReadingContent;

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
 

public class ReadingMain2 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
	private JLabel title;
	private Statement stmt;
	private Connection conn;

	ReadingMain2DAO dao = new ReadingMain2DAO();

	private JButton Submit, btn1, btn2, btn0;

	public static JTextArea review1 = new JTextArea();
	public static JTextArea yoyo4 = new JTextArea();

	public ReadingMain2() {

		f = new JFrame("Second Reading Page");
		f.setLayout(null);
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("두번째 리딩 지문");
		title.setBounds(30, 0, 800, 90);

		review1.setLayout(null);
		review1.setBounds(30, 50, 800, 350);

		PContent1 = new JLabel("[Write First] 세번째 지문 해석문 적기 - [입력 후 Submit 버튼으로 해당내용을 전송해주세요.] ", JLabel.LEFT);
		PContent1.setBounds(30, 240, 500, 500);
 
		yoyo4 = new JTextArea();
		yoyo4.setBounds(30, 500, 800, 370);
 
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);

		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);

		btn0 = new JButton("뒤로 [페이지 1] 돌아가기.");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ReadingMain1 AP = new ReadingMain1();
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
	public void startframe() {

		f.setSize(1000, 1200);

		f.add(title);

		f.add(PContent1);

		f.add(Submit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn0);

		f.add(review1);

		f.add(yoyo4); 
		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this); 

		f.setVisible(true);
		p.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		ReadingMain2 sm = new ReadingMain2();
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

				review1.setText(rs2.getString("sending1"));

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
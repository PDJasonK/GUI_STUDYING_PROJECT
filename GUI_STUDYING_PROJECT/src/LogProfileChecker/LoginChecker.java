package LogProfileChecker;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminChat.ClientGui;
import User_Page.HomeScreen;



public class LoginChecker {
	private JFrame f;
	private JPanel p;
	private JButton btn1, btn2 , btn3;
	private Statement stmt;
	private Connection conn;

	public static JTextArea Outa1 = new JTextArea();
	public static JTextArea Outa2 = new JTextArea();
	public static JTextArea Outa3 = new JTextArea();
	public static JTextArea Outa4 = new JTextArea();
	public static JTextArea Outa5 = new JTextArea();

	public LoginChecker(String id) {

		f = new JFrame("개인정보 확인 ㅎ");
		f.setLayout(null);
		f.setSize(1000, 1000);
		f.setVisible(true);

		// p = new JPanel();

		JTextArea txtA = new JTextArea("아이디");
		txtA.setLayout(null);
		// txtA = new JTextArea();
		txtA.setEditable(false);
		txtA.setBounds(60, 60, 100, 15);
		txtA.setVisible(true);

	
		Outa1.setLayout(null);
		// txtA = new JTextArea();
		Outa1.setEditable(true);
		Outa1.setBounds(190, 60, 200, 15);
		Outa1.setVisible(true);

		JTextArea txtB = new JTextArea("비밀번호 : ");
		// txtB = new JTextArea();
		txtB.setEditable(false);
		txtB.setBounds(60, 90, 100, 15);
		txtB.setVisible(true);

		Outa2 = new JTextArea();
		// txtB = new JTextArea();
		Outa2.setEditable(true);
		Outa2.setBounds(190, 90, 200, 15);
		Outa2.setVisible(true);

		JTextArea txtC = new JTextArea("이름 : ");
		txtC.setEditable(false);
		txtC.setBounds(60, 120, 100, 15);
		txtC.setVisible(true);

		Outa3 = new JTextArea();
		Outa3.setEditable(true);
		Outa3.setBounds(190, 120, 200, 15);
		Outa3.setVisible(true);

		JTextArea txtD = new JTextArea("주소 : ");
		txtD.setEditable(false);
		txtD.setBounds(60, 150, 100, 15);
		txtD.setVisible(true);

		Outa4 = new JTextArea();
		Outa4.setEditable(true);
		Outa4.setBounds(190, 150, 200, 15);
		Outa4.setVisible(true);

		JTextArea txtE = new JTextArea("휴대폰번호 : ");
		txtE.setEditable(false);
		txtE.setBounds(60, 180, 100, 15);
		txtE.setVisible(true);

		Outa5 = new JTextArea();
		Outa5.setEditable(true);
		Outa5.setBounds(190, 180, 200, 15);
		Outa5.setVisible(true);
		
		btn3 = new JButton("알림 및 채팅 확인");
		btn3.setBounds(650, 650, 300, 100);
		btn3.setVisible(true);
		btn3.setBackground(Color.white);
		btn3.setFont(new Font("Gothic", Font.BOLD, 20));
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientGui CG = new ClientGui();
				

			}
			

		});

		btn1 = new JButton("메인화면으로");
		btn1.setBounds(650, 50, 300, 200);
		btn1.setVisible(true);
		btn1.setBackground(Color.white);
		btn1.setFont(new Font("Gothic", Font.BOLD, 40));
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();

				hs.startFrame();
			}

		});
		btn2 = new JButton("로그아웃");
		btn2.setBounds(650, 300, 300, 100);
		btn2.setVisible(true);
		btn2.setBackground(Color.white);
		btn2.setFont(new Font("Gothic", Font.BOLD, 40));
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginMain LM = new LoginMain();
				f.setVisible(false);

				LM.startframe();
			}

		});
		f.add(txtA);
		f.add(txtB);
		f.add(txtC);
		f.add(txtD);
		f.add(txtE);

		f.add(Outa1);
		f.add(Outa2);
		f.add(Outa3);
		f.add(Outa4);
		f.add(Outa5);

		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		method(id);
		f.setVisible(true);

	}

	public void method(String id) {
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
			System.out.println(id);

			String sql2 = "SELECT ID, pwd , resid , name , PhoneNums FROM profile WHERE id = '"+id+"'";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

//				System.out.print(rs2.getString("id") + "\t");
//				System.out.print(rs2.getString("pwd") + "\t");
//				System.out.print(rs2.getString("resid"));

				Outa1.setText(rs2.getString("id"));
				Outa2.setText(rs2.getString("pwd"));
				Outa3.setText(rs2.getString("resid"));
				Outa4.setText(rs2.getString("name"));
				Outa5.setText(rs2.getString("PhoneNums"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
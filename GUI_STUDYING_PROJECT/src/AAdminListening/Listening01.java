package AAdminListening;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminOptionPage.AdminOptionPage;
import AdminReading.AdminReading2;
import UserPage.HomeScreen;
	
public class Listening01 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
	private JLabel title, title1, title2;
	private Statement stmt;
	private Connection conn;

	Listening01DAO dao = new Listening01DAO();

	private JButton Submit, btn1, btn2, btn0, lbtn1;

	public static JTextArea review1 = new JTextArea();
	public static JTextArea review2 = new JTextArea();
	public static JTextArea inserting01 = new JTextArea();
	public static JTextArea inserting02 = new JTextArea();

	public Listening01() {

		f = new JFrame("Listening First");
		f.setLayout(null);
		p = new JPanel();
		p.setLayout(null);
 
		title = new JLabel("[리스닝 질문] First Listening");
		title.setBounds(30, -30, 800, 90);

		title1 = new JLabel("First Question");
		title1.setBounds(30, -5, 800, 90);

		title2 = new JLabel("Second Listening");
		title2.setBounds(430, -5, 800, 90);

		review1.setLayout(null);
		review1.setBounds(30, 50, 350, 250);
		review1.setEditable(false);

		review2.setLayout(null);
		review2.setBounds(430, 50, 350, 250);
		review2.setEditable(false);

		PContent1 = new JLabel("[리스닝 문제] Conprehensive", JLabel.LEFT);
		PContent1.setBounds(30, 90, 500, 500);
	 
		inserting01 = new JTextArea();
		inserting01.setBounds(30, 350, 750, 200);

		inserting02 = new JTextArea();
		inserting02.setBounds(30, 600, 750, 200); 
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);

		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);

		lbtn1 = new JButton("Listen1");
		lbtn1.setLayout(null);
		lbtn1.setBounds(850, 50, 100, 60);
		lbtn1.addActionListener(this);
 
		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);

		btn0 = new JButton("Listening");
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
 
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(inserting01.getSelectedText() + inserting02.getSelectedText());
				if (inserting01.getText() != null) {
					String sinserting01 = inserting01.getText();
					String sinserting02 = inserting02.getText();

					dao.list(sinserting01, sinserting02);
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
 
	public void startframe() {

		f.setSize(1000, 1200);

		f.add(title);

		f.add(PContent1);

		f.add(Submit);
		//f.add(btn1);
		f.add(btn2);
		//f.add(btn0);
		f.add(lbtn1);
		f.add(review2);
		f.add(title1);
		f.add(title2);
		f.add(inserting02);

		f.add(review1);
		f.add(inserting01);

		// f.add(title, "North");

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
		Listening01 sm = new Listening01();
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

			String sql2 = "SELECT listen1 ,listen2 FROM listening1";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("listen1") + "\t");

				review1.setText(rs2.getString("listen1"));
				review2.setText(rs2.getString("listen2"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		String filepath = "C:\\Users\\Administrator\\Desktop\\img\\voice.wav";
		if (e.getSource() == lbtn1) {
		 
			try {
				File MusicPath = new File(filepath);

				if (MusicPath.exists()) {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(MusicPath);
					Clip clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();
					JOptionPane.showMessageDialog(null, "리스닝을 멈추기 위해 OK를 눌러주세요.");
					clip.stop();
				} else {

					System.out.println("Can't find file");
				}
			} catch (Exception a) {
				System.out.println(a);

			}
		}

	}
}
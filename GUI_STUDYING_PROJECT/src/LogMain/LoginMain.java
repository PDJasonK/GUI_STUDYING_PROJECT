
/*CREATE TABLE profile ( 
id varchar2(20) , pwd varchar2(20) , resid varchar2(20) , name  varchar2(20) , Phonenums varchar2(20)
)

DROP TABLE PROFILE 

CREATE TABLE image (
image1 blob()
)

SELECT * FROM profile
*/

package LogMain;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;

import AdminOptionPage.AdminOptionPage;
import LogData.LoginDAO;
import UserPage.HomeScreen;

public class LoginMain extends WindowAdapter implements ActionListener {
	private Frame f;
	private Frame suf;
	private Frame faf;
	private Label lid;
	private Label lpwd;
	private Panel p;
	private Panel p2;

	private TextField id;
	private TextField pwd;

	private Label lsulog;
	private JButton ToMain;
	private JButton CheckProfile;

	private Button falog;
	private Button log;
	private Button signup;
	private Button BackToLogin;

	private JTextArea FailText;

//*------------------------------------------------------------
	public LoginMain() {
	 
		f = new Frame("Login");
		f.setSize(300, 150);
		f.setBackground(Color.white);

	 
		suf = new Frame("로그인 성공");
		suf.setFont(new Font("Gothic", Font.BOLD, 20));
		suf.setSize(550, 100);

		faf = new Frame("로그인 실패");
		faf.setLayout(null);
		faf.setSize(450, 150);
		faf.setBackground(Color.gray);

		FailText = new JTextArea("00002 ");
 
		FailText.setBounds(20, 50, 160, 40);
		FailText.setVisible(true);
		faf.add(FailText);

		BackToLogin = new Button("00003");
		BackToLogin.setBounds(250, 50, 180, 30);
		BackToLogin.setBackground(Color.yellow);
		BackToLogin.setFont(new Font("Gothic", Font.BOLD, 10));
		faf.add(BackToLogin);
		BackToLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				faf.setVisible(false);
				LoginMain lg = new LoginMain();
				lg.startframe();
			}

		});

		p = new Panel();
		p2 = new Panel();
		lid = new Label("로그인 완료 ", Label.CENTER);
		lpwd = new Label("로그인 실패", Label.CENTER);

		id = new TextField(20);
		pwd = new TextField(20);
		log = new Button("로그인");
		log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				faf.setVisible(false);

			}

		});

		signup = new Button("회원가입");

		lsulog = new Label("로그인 성공");

		ToMain = new JButton("메인 화면으로 넘어가기");
		ToMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				ToMain.setVisible(true);

				hs.startFrame();

			}

		});
		CheckProfile = new JButton("개인정보 확인");
//		CheckProfile.setBackground(Color.gray);
		CheckProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginChecker LG = new LoginChecker(id.getText());

			}

		});
	}

	public void startframe() {

		f.add(p, "Center");
		f.addWindowListener(this);
		log.addActionListener(this);
		signup.addActionListener(this);
		suf.addWindowListener(this);
		faf.addWindowListener(this);

		ToMain.addActionListener(this);
		CheckProfile.addActionListener(this);
		pwd.setEchoChar('*');

		suf.add(p2, "Center");
		p2.add(lsulog);
		p2.add(ToMain);
		p2.add(CheckProfile);

		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(log);
		p.add(signup);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == log) {
			LoginDAO dao = new LoginDAO();

			int daoidcheck = dao.logincheck(id.getText());
			int daoid = dao.login(id.getText(), pwd.getText());
			System.out.println(id.getText());
			System.out.println(pwd.getText());
			System.out.println(daoidcheck);
			System.out.println(daoid);
			if (daoidcheck == 1) {
				if (daoid == 1) {
					f.dispose();
					new AdminOptionPage();
				}
			} else {
				if (daoid == 1) {
					f.dispose();
					new HomeScreen();
				}
			}

		}
		if (signup.equals(e.getSource())) {
			Signup sg = new Signup();
			sg.startframe();
			f.setVisible(false);
		}

		if (ToMain.equals(e.getSource())) {
			suf.setVisible(false);
			f.setVisible(false);
		}

		if (CheckProfile.equals(e.getSource())) {
			suf.setVisible(false);
			f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		LoginMain lg = new LoginMain();
		lg.startframe();
	}
}

/*CREATE TABLE profile ( 
id varchar2(20) , pwd varchar2(20) , resid varchar2(20) , name  varchar2(20) , Phonenums varchar2(20)
)

DROP TABLE PROFILE 

CREATE TABLE image (
image1 blob()
)

SELECT * FROM profile
*/

package LogProfileChecker;
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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

import LogMain.Signup;
import User_Page.HomeScreen;

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
	private JButton btnH;
	private JButton btnProf;

	private Button falog;
	private Button log;
	private Button signup;
	private Button fafout1;

	private String myid;
	private String mypwd;

	private JTextArea fafout;

//*------------------------------------------------------------
	public LoginMain() {
		// 로그인 화면
		f = new Frame("Login");
		f.setSize(300, 150);
		f.setBackground(Color.white);

		// 로그인 성공 화면
		suf = new Frame("로그인 성공");
		suf.setFont(new Font("Gothic", Font.BOLD, 20));
		suf.setSize(550, 100);

		faf = new Frame("로그인 실패");
		faf.setLayout(null);
		faf.setSize(450, 150);
		faf.setBackground(Color.gray);

		fafout = new JTextArea("비밀번호가 틀렸습니다. " + "\n로그인을 다시 시도하세요.");
//		fafout.setLayout(null);
		fafout.setBounds(20, 50, 160, 40);
		fafout.setVisible(true);
		faf.add(fafout);

		fafout1 = new Button("로그인 창으로 돌아가기");
		fafout1.setBounds(250, 50, 180, 30);
		fafout1.setBackground(Color.yellow);
		fafout1.setFont(new Font("Gothic", Font.BOLD, 10));
		faf.add(fafout1);
		fafout1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				faf.setVisible(false);
				LoginMain lg = new LoginMain();
				lg.startframe();
			}

		});

		p = new Panel();
		p2 = new Panel();
		lid = new Label("아이디 : ", Label.CENTER);
		lpwd = new Label("비밀번호: ", Label.CENTER);

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

		btnH = new JButton("메인 화면으로 넘어가기");
		btnH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				btnH.setVisible(true);

				hs.startFrame();

			}

		});
		btnProf = new JButton("개인정보 확인");
//		btnProf.setBackground(Color.gray);
		btnProf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginChecker LG = new LoginChecker(id.getText());

			}

		});
	}

	private JButton addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		return null;
	}

	public void startframe() {

		f.add(p, "Center");
		f.addWindowListener(this);
		log.addActionListener(this);
		signup.addActionListener(this);
		suf.addWindowListener(this);
		faf.addWindowListener(this);

		btnH.addActionListener(this);
		btnProf.addActionListener(this);
		pwd.setEchoChar('*');

		suf.add(p2, "Center");
		p2.add(lsulog);
		p2.add(btnH);
		p2.add(btnProf);

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
		if (e.getActionCommand().equals("로그인")) {
			LoginDAO dao = new LoginDAO();
			ArrayList<LoginVo> list = dao.list(id.getText(), pwd.getText());
			for (int i = 0; i < list.size(); i++) {
				LoginVo data = (LoginVo) list.get(i);
				myid = data.getId();
				mypwd = data.getPwd();
			}
			System.out.println(myid);
			System.out.println(mypwd);
			if (id.getText().equals(myid) && pwd.getText().equals(mypwd)) {
				suf.setVisible(true);
			} else {
				faf.setVisible(true);
				f.setVisible(false);
			}
		}

		if (e.getActionCommand().equals("회원가입")) {
			Signup sg = new Signup();
			sg.startframe();
			f.setVisible(false);
		}

		if (btnH.equals(e.getSource())) {
			suf.setVisible(false);
			f.setVisible(false);
		}

		if (btnProf.equals(e.getSource())) {
			suf.setVisible(false);
			f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		LoginMain lg = new LoginMain();
		lg.startframe();
	}
}
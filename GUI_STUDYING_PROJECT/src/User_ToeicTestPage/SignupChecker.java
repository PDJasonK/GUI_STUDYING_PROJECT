package UserToeicTestPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminChat.ServerGui;
import LogMain.LoginMain;
import UserPage.HomeScreen;

public class SignupChecker {
	private JFrame f;
	private JPanel p;
	private JTextArea txtA;
	private JButton btn1, btn2, btn3;

	public SignupChecker() {

		f = new JFrame("씨버럴");
		f.setLayout(null);
		f.setSize(1000, 800);
		f.setVisible(true);

		// p = new JPanel();

		JTextArea txtA = new JTextArea("피드백 요청이 완료되었습니다.\n \n " + "FeedBack Update 후 \n 세부사항은 채팅연락 부탁드립니다.\n "
				+ "\n \n 알림 및 채팅은 개인정보 확인에서 \n알림 확인 부탁드립니다.");
		txtA.setLayout(null);
		txtA.setFont(new Font("Gothic", Font.BOLD, 20));

		// txtA = new JTextArea();
		txtA.setEditable(false);
		txtA.setBounds(60, 60, 400, 250);
		txtA.setVisible(true);
		btn3 = new JButton("알림 및 채팅 확인");
		btn3.setBounds(650, 650, 300, 100);
		btn3.setVisible(true);
		btn3.setBackground(Color.white);
		btn3.setFont(new Font("Gothic", Font.BOLD, 20));
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ServerGui();

			}

		});

		btn2 = new JButton("개인정보 확인");
		btn2.setBounds(650, 320, 300, 200);
		btn2.setVisible(true);
		btn2.setBackground(Color.white);
		btn2.setFont(new Font("Gothic", Font.BOLD, 40));
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginMain lg = new LoginMain();
				f.setVisible(false);
				lg.startframe();

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

		f.add(txtA);

		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.setVisible(true);

	}

}

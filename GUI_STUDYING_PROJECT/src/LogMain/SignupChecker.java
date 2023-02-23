package LogMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminChat.ClientGui;
import UserPage.HomeScreen;

public class SignupChecker {
	private JFrame f;
	private JPanel p;
	private JTextArea txtA, txtB, txtC, txtD, txtE, txtF, txtA1, txtB1, txtC1, txtD1, txtE1, txtF1;
	private JButton btn1, btn2, btn3;

	public SignupChecker() {

		f = new JFrame("개인정보 확인");
		f.setLayout(null);
		f.setSize(1000, 1000);
		f.setVisible(true);

		// p = new JPanel();

		JTextArea txtA = new JTextArea("이름 :  ");
		txtA.setLayout(null);
		// txtA = new JTextArea();
		txtA.setEditable(false);
		txtA.setBounds(60, 60, 100, 15);
		txtA.setVisible(true);

		JTextArea txtA1 = new JTextArea("이름 :   ");
		txtA1.setLayout(null);
		// txtA = new JTextArea();
		txtA1.setEditable(true);
		txtA1.setBounds(190, 60, 200, 15);
		txtA1.setVisible(true);

		JTextArea txtB = new JTextArea("ID : ");
		// txtB = new JTextArea();
		txtB.setEditable(false);
		txtB.setBounds(60, 90, 100, 15);
		txtB.setVisible(true);

		JTextArea txtB1 = new JTextArea(" ");
		// txtB = new JTextArea();
		txtB1.setEditable(false);
		txtB1.setBounds(190, 90, 200, 15);
		txtB1.setVisible(true);

		JTextArea txtC = new JTextArea("비밀번호 : ");
		txtC.setEditable(false);
		txtC.setBounds(60, 120, 100, 15);
		txtC.setVisible(true);

		JTextArea txtC1 = new JTextArea(" ");
		txtC1.setEditable(false);
		txtC1.setBounds(190, 120, 200, 15);
		txtC1.setVisible(true);

		JTextArea txtD = new JTextArea("전화번호 : ");
		txtD.setEditable(false);
		txtD.setBounds(60, 150, 100, 15);
		txtD.setVisible(true);

		JTextArea txtD1 = new JTextArea(" ");
		txtD1.setEditable(false);
		txtD1.setBounds(190, 150, 200, 15);
		txtD1.setVisible(true);

		JTextArea txtE = new JTextArea("주소 :  ");
		txtE.setEditable(false);
		txtE.setBounds(60, 180, 100, 15);
		txtE.setVisible(true);

		JTextArea txtE1 = new JTextArea(" ");
		txtE1.setEditable(false);
		txtE1.setBounds(190, 180, 200, 15);
		txtE1.setVisible(true);

		JTextArea txtF = new JTextArea("휴대폰 번호");
		txtF.setEditable(false);
		txtF.setBounds(60, 210, 100, 15);
		txtF.setVisible(true);

		JTextArea txtF1 = new JTextArea(" ");
		txtF1.setEditable(false);
		txtF1.setBounds(190, 210, 200, 15);
		txtF1.setVisible(true);

 

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
				LoginMain lg = new LoginMain();
				f.setVisible(false);
				lg.startframe();
			}

		});
		f.add(txtA);
		f.add(txtB);
		f.add(txtC);
		f.add(txtD);
		f.add(txtE);
		f.add(txtF);

		f.add(txtA1);
		f.add(txtB1);
		f.add(txtC1);
		f.add(txtD1);
		f.add(txtE1);
		f.add(txtF1);

		f.add(btn1);
		f.add(btn2);
		f.add(btn3);

		f.setVisible(true);

	}

}

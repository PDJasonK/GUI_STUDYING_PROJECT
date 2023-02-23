package AdminOptionPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminReading.AdminReading1;
import AdminVocab.VocabToeic1MainOut;
import Query.CheckQ01;
import QuestionBoard.ListFrame;
import UserVocab.UserVocab1;
import User_ContentCheck.CheckRead01;
import User_ContentCheck.CheckVocab01;
import VocabQuiz.VocabQuiz1;

public class AdminOptionPage implements ActionListener {

	private JFrame frameAP;
	private JButton b2, b3, b4, b5, b6, b7, ch1, ch2, ch3, ch4;
	private JTextArea MainNotice;

	public AdminOptionPage() {

		frameAP = new JFrame("Admin Option Maker");
//		frame.setLayout(new FlowLayout());
		frameAP.setLayout(null);
		frameAP.setSize(1050, 1200);

		ScrollPane sp = new ScrollPane();
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);

		MainNotice = new JTextArea(
				"    관리자 권한으로 지문,단어 수정 및 확인 가능합니다.\n                                    (Admin Page)");
		MainNotice.setBounds(150, 30, 800, 90);
		MainNotice.setFont(new Font("Gothic", Font.BOLD, 30));

//--------------------------------------b3-----------------------------------------------------------

		b2 = new JButton("[게시글 확인] ");
		b2.setBounds(310, 400, 250, 80);
		b2.setFont(new Font("Gothic", Font.BOLD, 15));

		// b3.setSize(100, 80);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// f3.setVisible(true);
				frameAP.setVisible(false);
				new CheckQ01();

			}

		});

		b3 = new JButton("[단어시험 확인] ");
		b3.setBounds(560, 260, 250, 80);
		b3.setFont(new Font("Gothic", Font.BOLD, 15));

		// b3.setSize(100, 80);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// f3.setVisible(true);
				frameAP.setVisible(false);
				new UserVocab1();

			}

		});

		ch2 = new JButton("[리딩 문제 답 확인] ");
		ch2.setBounds(560, 500, 250, 80);
		ch2.setFont(new Font("Gothic", Font.BOLD, 15));

		// b3.setSize(100, 80);
		ch2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameAP.setVisible(false);
				new CheckRead01();

			}

		});
//--------------------------------------b4-----------------------------------------------------------

		b4 = new JButton("[입력된 단어시험 확인]");
		b4.setBounds(60, 260, 250, 80);
		b4.setFont(new Font("Gothic", Font.BOLD, 20));
		// b4.setSize(100, 80);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				f4.setVisible(true);
				frameAP.setVisible(false);
				new VocabQuiz1();
			}

		});

		ch1 = new JButton("[입력된 단어 답 확인]");
		ch1.setBounds(60, 500, 250, 80);
		ch1.setFont(new Font("Gothic", Font.BOLD, 20));
		// b4.setSize(100, 80);
		ch1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckVocab01();

				frameAP.setVisible(false);
			}

		});
//--------------------------------------b5-----------------------------------------------------------

		b5 = new JButton("[회원 정보 확인] ");
		b5.setBounds(10, 30, 155, 90);
		b5.setFont(new Font("Gothic", Font.BOLD, 16));

		// b5.setSize(100, 80);
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new ListFrame();

			}
		});

		b6 = new JButton("[단어 추가 페이지]  ");
		b6.setBounds(560, 160, 250, 80);
		b6.setFont(new Font("Gothic", Font.BOLD, 15));

		// b5.setSize(100, 80);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new VocabToeic1MainOut();
				// f5.setVisible(true);

//				frame.setVisible(false);

			}
		});

		b7 = new JButton("[읽기 지문 추가 페이지] ");
		b7.setBounds(60, 160, 250, 80);
		b7.setFont(new Font("Gothic", Font.BOLD, 15));

		// b5.setSize(100, 80);
		b7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frameAP.setVisible(false);
				new AdminReading1();

			}
		});
		startFrame();

	}

	public void startFrame() {

//		frameAP.add(b1);
		frameAP.add(b2);
		frameAP.add(b3);
		frameAP.add(b4);
		frameAP.add(b5);
		frameAP.add(b6);
		frameAP.add(b7);
		frameAP.add(ch1);
		frameAP.add(ch2);
		frameAP.add(MainNotice);

		frameAP.setVisible(true);
	}

	public static void main(String[] args) {
		AdminOptionPage AP = new AdminOptionPage();

		AP.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameAP.setVisible(true);

	}
}
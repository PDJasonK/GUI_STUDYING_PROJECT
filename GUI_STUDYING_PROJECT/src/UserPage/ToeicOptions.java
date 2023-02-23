package UserPage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import AAdminListening.Listening01;
import UserVocab.UserVocab1;
import User_ToeicReadingContent.ReadingMain1;

public class ToeicOptions {
	private JButton tbtn1, tbtn2, tbtn3, /* tbtn4 */ tbtn5, tbtn0;

	public ToeicOptions() {

		JFrame toframe = new JFrame("ToeicOptions");
		toframe.setSize(1000, 1000);
		toframe.setLayout(new FlowLayout());

		toframe.setVisible(true);

		tbtn1 = new JButton("지문 읽기");
		toframe.add(tbtn1);
		tbtn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new ReadingMain1();
				toframe.setVisible(false);

			}
		});

		tbtn2 = new JButton("단어 체크 [Check List of Vocab]");
		toframe.add(tbtn2);
		tbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserVocab1();
				toframe.setVisible(false);

//				new VocabAcceptMain1();
			}
		});

		tbtn3 = new JButton("2022년 토익 기출 문제 풀기");
		toframe.add(tbtn3);
		tbtn3.setBounds(60, 260, 800, 180);

		tbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toframe.setVisible(false);

				new TakeTest01(null);
			}
		});

		tbtn0 = new JButton("리스닝");
		toframe.add(tbtn0);
		tbtn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Listening01 ();
				// TODO Auto-generated method stub
				// PlayMusicJavaSuperSimple PS = new PlayMusicJavaSuperSimple();
			}

		});

		/*
		 * tbtn4 = new JButton("�떆�뿕 蹂닿린"); toframe.add(tbtn4);
		 * tbtn4.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { toframe.setVisible(false); new
		 * ToeicTest(null);
		 */
		/*
		 * tbtn5 = new JButton(""); toframe.add(tbtn5); tbtn5.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) {
		 * toframe.setVisible(false); // new TestOption(); }
		 * 
		 * });
		 */
	}

}
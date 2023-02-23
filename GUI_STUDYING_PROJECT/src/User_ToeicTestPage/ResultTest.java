package User_ToeicTestPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import UserPage.HomeScreen;

public class ResultTest extends JFrame implements ActionListener {

	JFrame frame = new JFrame("ToeicTest");

	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2, b3;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[5];

	public ResultTest(String s) {
		super(s);
		l = new JLabel();
		add(l);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1 = new JButton("?‹¤?Œ");
		b2 = new JButton("?Œ¨?Š¤");
		b3 = new JButton("HomeScreen?œ¼ë¡? ?Œ?•„ê°?ê¸?");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		add(b1);
		add(b2);
		add(b3);

		set();
		l.setBounds(30, 40, 450, 20);
		jb[0].setBounds(50, 80, 450, 20);
		jb[1].setBounds(50, 110, 450, 20);
		jb[2].setBounds(50, 140, 450, 20);
		jb[3].setBounds(50, 170, 450, 20);
		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);
		b3.setBounds(480, 240, 100, 30);

		b3.setVisible(true);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				hs.startFrame();
				frame.setVisible(false);

			}

		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
//		setLocation(250, 100);
		setVisible(true);
		setSize(1200, 1200);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 4) {
				b1.setEnabled(false);
				b2.setText("ê²°ê³¼");
			}
		}

		if (e.getActionCommand().equals("ê²°ê³¼")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "? •?‹µ?ˆ˜=" + count);
			System.exit(0);
		}
	}

	void set() {

		l.setText("111111.First thing you have to do when you get home is ");
		jb[0].setText("?‘  take shit.");
		jb[1].setText("?‘¡ take off your clothes");
		jb[2].setText("?‘¢ wash yourself");
		jb[3].setText("?‘£ Feb bitch");

	}

	boolean check() {// ?‹µ?? jb[2]?•œë¶?ë¶„ìœ¼ë¡? 2,3,1,2,0 ì¦? 3,4,2,3,1,
		if (current == 0)
			return (jb[2].isSelected());

		return false;
	}
}
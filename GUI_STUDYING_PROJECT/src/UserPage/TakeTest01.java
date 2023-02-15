package UserPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class TakeTest01 extends JFrame implements ActionListener {
	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[5];

	TakeTest01(String s) {
		super(s);
		l = new JLabel();
		add(l);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1 = new JButton("����");
		b2 = new JButton("�н�");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		set();
		l.setBounds(30, 40, 450, 20);
		jb[0].setBounds(50, 80, 450, 20);
		jb[1].setBounds(50, 110, 450, 20);
		jb[2].setBounds(50, 140, 450, 20);
		jb[3].setBounds(50, 170, 450, 20);
		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 400);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 4) {
				b1.setEnabled(false);
				b2.setText("���");
			}
		}
		if (e.getActionCommand().equals("�н�")) {
			JButton bk = new JButton("�н�" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 4)
				b2.setText("���");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("�н�" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("���")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "�����=" + count);
			System.exit(0);
		}
	}

	void set() {
		jb[4].setSelected(true);
		if (current == 0) {
			l.setText("1.Why would you ____ about it when you shouldn't talk ");
			jb[0].setText("�� conversation");
			jb[1].setText("�� commucation");
			jb[2].setText("�� speach");
			jb[3].setText("�� talk ");

		}
		if (current == 1) {
			l.setText("2. You shouldn't be ___ class , because it it all over");
			jb[0].setText("come in");
			jb[1].setText("�� stay out");
			jb[2].setText("�� stalking");
			jb[3].setText("�� in");
		}
		if (current == 2) {
			l.setText("I do not know point of having communcation ___ you ");
			jb[0].setText("�� to");
			jb[1].setText("�� toward");
			jb[2].setText("�� with ");
			jb[3].setText("�� on");
		}
		if (current == 3) {
			l.setText("I do not know point of having communcation ___ you ");
			jb[0].setText("�� to");
			jb[1].setText("�� toward");
			jb[2].setText("�� with ");
			jb[3].setText("�� on");		}
		if (current == 4) {
			l.setText("2. You shouldn't be ___ class , because it it all over");
			jb[0].setText("come in");
			jb[1].setText("�� stay out");
			jb[2].setText("�� stalking");
			jb[3].setText("�� in");
		}

		l.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			jb[j].setBounds(50, 80 + i, 400, 20);
	}

	boolean check() {
		if (current == 0)
			return (jb[2].isSelected());
		if (current == 1)
			return (jb[3].isSelected());
		if (current == 2)
			return (jb[1].isSelected());
		if (current == 3)
			return (jb[2].isSelected());
		if (current == 4)
			return (jb[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new TakeTest01("�ڹ� �¶��� ����");
	}
}
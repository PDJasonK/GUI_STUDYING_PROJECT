package UserPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class TakeTest02 extends JFrame implements ActionListener {
	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[5];

	TakeTest02(String s) {
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
			l.setText("1.�ڹ� ������ Ÿ�Կ� ���� ���� �� Ʋ�� ���� ���ÿ�. ");
			jb[0].setText("�� String Ÿ���� ��ü���̴�.");
			jb[1].setText("�� char Ÿ�� ������ 2 byte�� �޸� ������ ����Ѵ�.");
			jb[2].setText("�� Boolean Ÿ�� ������ 1 byte�� �޸� ������ �����Ѵ�");
			jb[3].setText("�� int Ÿ�� ������ 4 byte�� �޸� ������ ����Ѵ�. ");

		}
		if (current == 1) {
			l.setText("2. ___ class ATestClass {  �� �� �� ���� Ű���带 ���ÿ�.");
			jb[0].setText("�� public");
			jb[1].setText("�� private");
			jb[2].setText("�� abstract");
			jb[3].setText("�� final");
		}
		if (current == 2) {
			l.setText("3.�ڹٿ��� �޼ҵ� �����ε��� ���� �������� Ʋ�� ����? ");
			jb[0].setText("�� ����Ŭ���������� �߻��Ѵ�.");
			jb[1].setText("�� �Ű������� ���� �����ؾ� �Ѵ�.");
			jb[2].setText("�� �������� �����ϱ����� ��ġ�̴�.");
			jb[3].setText("�� �޼ҵ��̸��� �����ؾ� �Ѵ�.");
		}
		if (current == 3) {
			l.setText("4. ���� �ڵ� �� ��Ÿ�� ������ �߻��ϴ� ����.");
			jb[0].setText("��int a = 3.5; ");
			jb[1].setText("��int a1 = 5; double a2 = (float)a1;");
			jb[2].setText("��int a = 9 / 0; ");
			jb[3].setText("��float a = Integer.parseInt('30');");
		}
		if (current == 4) {
			l.setText("5.���� ���� �� Ʋ�� ���� ���ÿ�.");
			jb[0].setText("�� �߻� Ŭ������ �ϳ� �̻��� �߻� �޼ҵ带 �����ϰ� �־�� �Ѵ�.");
			jb[1].setText("�� �߻� Ŭ������ ��ü�� ������ �� ����.");
			jb[2].setText("�� protected �޼ҵ�� ��� ���� Ŭ�������� ȣ���� �� �ִ�.");
			jb[3].setText("�� �ڹ��� ��� Ŭ������ Object Ŭ������ �ڽ� Ŭ�����̴�.");
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
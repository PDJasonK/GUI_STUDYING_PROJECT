package QuestionBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LogData.SignupVo;
import LogMain.LoginMain;

public class ListFrame extends JFrame {

	private JPanel panel;
	private JTable table;
	private JLabel lilabel;
	private JButton logout, point;
	private DefaultTableModel tModel;

	public ListFrame() {
		super("List");
		super.setResizable(true);
		setSize(1300, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);

		lilabel = new JLabel("회원 리스트");
		lilabel.setFont(new Font("Serif", Font.BOLD, 50));
		lilabel.setHorizontalAlignment(SwingConstants.CENTER);
		lilabel.setPreferredSize(new Dimension(400, 80));
		panel.add(lilabel, BorderLayout.NORTH);

		SignupDAO SDAO = new SignupDAO();
		ArrayList<SignupVo> list = SDAO.list();

		String[] member = { "아이디",  "이름", "주소", " 연락처 ", " 직업" };

		tModel = new DefaultTableModel(member, 0);

		for (int i = 0; i < list.size(); i++) {

			String id = list.get(i).getId();
			//String pwd = list.get(i).getPwd();
			String resid = list.get(i).getresid();
			String name = list.get(i).getname();
			String PhoneNums = list.get(i).getPhoneNums();
			String teacher = list.get(i).getteacher();

			Object[] data = { id,/* pwd,*/ resid, name, PhoneNums, teacher };

			tModel.addRow(data);

		}

		table = new JTable(tModel);
		table.setFont(new Font("돋움", Font.PLAIN, 20));
		table.setRowHeight(30);

		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1, 1, 1, 1));
		logout = new JButton("로그아웃");
 
		pan.add(logout);
 
		panel.add(pan, BorderLayout.SOUTH);

 
 
		setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ListFrame();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
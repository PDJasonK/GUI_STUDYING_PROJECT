package UserPage;

package Brand;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class Volkswagen  extends WindowAdapter implements ActionListener {
   private JFrame frame;
   private int index;
   private JTextArea Area = new JTextArea();

   
   
   private String[] images = { "image/ID4.png", "image/ID5.png", "image/ID6.png", "image/ID3.png"};
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Volkswagen vk = new Volkswagen();
               vk.getFrame().setVisible(true);
               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Volkswagen() {
      ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
      arr = VolkswagenF();
      setFrame(new JFrame());
      getFrame().setBounds(100, 100, 800, 800);
      getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getFrame().getContentPane().setLayout(null);
      getFrame().setLocationRelativeTo(null);
      getFrame().setResizable(false);

      Font font = new Font("����", Font.BOLD, 48);

      JLabel lblImage = new JLabel();
      lblImage.setBounds(0, 0, 980, 370);

      Area = new JTextArea();
      Area.setBounds(0, 400, 800, 240);
      Area.setFocusable(false);
      Area.setFont(new Font("Gothic", Font.BOLD, 22));

      getFrame().add(Area);

      lblImage.setIcon(new ImageIcon(images[getIndex()])); // index ó�� 0, IMAGES[0] �� ��� ����
      getFrame().getContentPane().add(lblImage);
      Area.append("  �ѹ�: " + arr.get(getIndex()).getNo() + "\n" + "  ��: " + arr.get(getIndex()).getModel() + "\n"
            + "  ����:" + arr.get(getIndex()).getPrice() + "\n" + "  ����Ÿ��: " + arr.get(getIndex()).getType() + "\n"
            + "  ���͸��뷮:" + arr.get(getIndex()).getBcapacity() + "\n" + "  ����:" + arr.get(getIndex()).getPower()
            + "\n" + "  ����:" + arr.get(getIndex()).getMileage() + "\n" + "  1ȸ ��������Ÿ�:"
            + arr.get(getIndex()).getMaxdistance() + "\n");

// frame �ȿ� �̹����߰�

      JButton btnPrev = new JButton("��");
      btnPrev.setBackground(Color.CYAN);
      btnPrev.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
            arr = VolkswagenF();
            if (getIndex() > 0) { // ���� �ε����� 0���� ũ��
               setIndex(getIndex() - 1); // �ε����� ����
               Area.setText(null);
               Area.append("  �ѹ�: " + arr.get(getIndex()).getNo() + "\n" + "  ��: "
                     + arr.get(getIndex()).getModel() + "\n" + "  ����:" + arr.get(getIndex()).getPrice() + "\n"
                     + "  ����Ÿ��: " + arr.get(getIndex()).getType() + "\n" + "  ���͸��뷮:"
                     + arr.get(getIndex()).getBcapacity() + "\n" + "  ����:" + arr.get(getIndex()).getPower()
                     + "\n" + "  ����:" + arr.get(getIndex()).getMileage() + "\n" + "  1ȸ ��������Ÿ�:"
                     + arr.get(getIndex()).getMaxdistance() + "\n");
            } else { // ���� �ε����� 0�̸�
               setIndex(images.length - 1); // �迭�� ���� ū �ε��� ��ȣ�� ����
               if (getIndex() == 6) {
                  Area.setText(null);
                  Area.append("  �ѹ�: " + arr.get(getIndex()).getNo() + "\n" + "  ��: "
                        + arr.get(getIndex()).getModel() + "\n" + "  ����:" + arr.get(getIndex()).getPrice()
                        + "\n" + "  ����Ÿ��: " + arr.get(getIndex()).getType() + "\n" + "  ���͸��뷮:"
                        + arr.get(getIndex()).getBcapacity() + "\n" + "  ����:" + arr.get(getIndex()).getPower()
                        + "\n" + "  ����:" + arr.get(getIndex()).getMileage() + "\n" + "  1ȸ ��������Ÿ�:"
                        + arr.get(getIndex()).getMaxdistance() + "\n");
               }
            }
            lblImage.setIcon(new ImageIcon(images[getIndex()])); // ��ư ���������� ���� �̹����� �̵�
         }

      });
      btnPrev.setFont(font);
      btnPrev.setBounds(10, 665, 200, 80);
      getFrame().getContentPane().add(btnPrev);

      JButton logo = new JButton(new ImageIcon("image\\�����ٰ�.jpg"));
      logo.setBackground(Color.WHITE);
      logo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }

      });
      logo.setFont(font);
      logo.setBounds(275, 645, 200, 117);
      getFrame().getContentPane().add(logo);
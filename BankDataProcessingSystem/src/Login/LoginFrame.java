package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class LoginFrame extends JFrame {

	JPanel loginPane= new JPanel();
	
	JLabel idLabel = new JLabel("���̵�");//textView
	JLabel pwdLabel = new JLabel("��й�ȣ");
	
	JTextField id = new JTextField();//�Է��ʵ�
	JTextField pwd = new JTextField();
	
	JButton exitBtn = new JButton("����");
	JButton joinBtn = new JButton("ȸ������");
	JButton loginBtn = new JButton("�α���");
	
	LoginMain o = null;

	LoginFrame(LoginMain _o) {
		o = _o;
		
		setTitle("login");
		
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������â ����� ���μ������� ����ϰ� close
		setBounds(100, 100, 480, 230);
		
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPane);
		loginPane.setLayout(null);
		
		idLabel.setFont(new Font("����", Font.PLAIN, 25));
		idLabel.setBounds(24, 26, 86, 39);
		loginPane.add(idLabel);
		
		pwdLabel.setFont(new Font("����", Font.PLAIN, 25));
		pwdLabel.setBounds(24, 75, 99, 39);
		loginPane.add(pwdLabel);
		
		id.setColumns(10);
		id.setBounds(136, 26, 214, 39);
		loginPane.add(id);
		
		pwd.setColumns(10);
		pwd.setBounds(135, 75, 215, 39);
		loginPane.add(pwd);
		
		exitBtn.setFont(new Font("����", Font.BOLD, 20));
		exitBtn.setBounds(219, 143, 146, 39);
		loginPane.add(exitBtn);
		
		joinBtn.setFont(new Font("����", Font.BOLD, 20));
		joinBtn.setBounds(24, 143, 146, 39);
		loginPane.add(joinBtn);
		
		loginBtn.setFont(new Font("����", Font.BOLD, 18));
		loginBtn.setBounds(362, 26, 92, 87);
		loginPane.add(loginBtn);
		
		ButtonListener bl = new ButtonListener();
		
		loginBtn.addActionListener(bl);
		exitBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			String uid = id.getText();
			String upwd = pwd.getText();
			
			if(b.getText().equals("����")) {
				System.out.println("���α׷� ����");
				System.exit(0);
			}
			
			else if(b.getText().equals("ȸ������")) {
				JoinFrame jf = new JoinFrame(o);
			}
			
			else if(b.getText().equals("�α���")) {
				if(uid.equals("") || upwd.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ ��� �Է����ּ���", "�α��� ����", JOptionPane.ERROR_MESSAGE);
					System.out.println("�α��� ���� : �α��� ���� ���Է�");
				}
				
				else if(uid != null && upwd != null) {
					if(o.db.logincheck(uid, upwd)) {
						System.out.println("�α��� ����");
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");
						MenuFrame cf = new MenuFrame(o);
					}
					else {
						System.out.println("�α��� ���� : �α��� ���� ����ġ");
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");
					}
				}
			}
		}
	}
}
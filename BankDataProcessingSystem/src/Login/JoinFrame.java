package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
   private int limit;
   private boolean toUppercase = false;
   
   JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
   }

   JTextFieldLimit(int limit, boolean upper) {
      super();
      this.limit = limit;
      this.toUppercase = upper;
   }

   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
      if (str == null) {
         return;
      }

      if ( (getLength() + str.length()) <= limit) {
         if (toUppercase) {
            str = str.toUpperCase();
         }
         super.insertString(offset, str, attr);
      }
   }
}

public class JoinFrame extends JFrame {

	JPanel contentPane = new JPanel();
	
	JLabel idLabel = new JLabel("���̵� :");
	JLabel pwdLabel = new JLabel("��й�ȣ :");
	JLabel pwdCheckLabel = new JLabel("��й�ȣ Ȯ�� :");
	JLabel nameLabel = new JLabel("�̸� :");
	JLabel residentLabel = new JLabel("�ֹι�ȣ :");
	JLabel hypenLabel = new JLabel("-");
	JLabel lastNumberLabel = new JLabel("******");
	JLabel bankLabel = new JLabel("�������� :");
	JLabel accountNumberLabel = new JLabel("���¹�ȣ :");
	JLabel accountpwdLabel = new JLabel("���� ��й�ȣ :");
	
	JTextField id = new JTextField();
	JTextField name = new JTextField();
	JTextField accountNumber = new JTextField();

	JPasswordField pwd = new JPasswordField();
	JPasswordField pwdCheck = new JPasswordField();
	JPasswordField accountpwd = new JPasswordField();
	
	JFormattedTextField firstNumber = new JFormattedTextField();
	JFormattedTextField lastNumber = new JFormattedTextField();
	
	JComboBox<?> bankbox = new JComboBox();
	
	JButton overlapCheckBtn = new JButton("�ߺ� Ȯ��");
	JButton signInBtn = new JButton("ȸ������");
	
	LoginMain p = null;
	public JoinFrame(LoginMain _p) {
		p = _p;
		
		setTitle("Join in");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 664);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idLabel.setFont(new Font("����", Font.PLAIN, 25));
		idLabel.setBounds(97, 52, 90, 24);
		contentPane.add(idLabel);
		
		id.setBounds(199, 50, 255, 36);
		contentPane.add(id);
		id.setColumns(10);
		
		overlapCheckBtn.setFont(new Font("����", Font.PLAIN, 20));
		overlapCheckBtn.setBounds(479, 50, 125, 36);
		contentPane.add(overlapCheckBtn);
		
		pwdLabel.setFont(new Font("����", Font.PLAIN, 25));
		pwdLabel.setBounds(72, 116, 115, 24);
		contentPane.add(pwdLabel);
		
		pwdCheckLabel.setFont(new Font("����", Font.PLAIN, 25));
		pwdCheckLabel.setBounds(12, 182, 185, 24);
		contentPane.add(pwdCheckLabel);
		
		nameLabel.setFont(new Font("����", Font.PLAIN, 25));
		nameLabel.setBounds(121, 245, 66, 24);
		contentPane.add(nameLabel);
		
		name.setColumns(10);
		name.setBounds(199, 243, 255, 36);
		contentPane.add(name);
		
		residentLabel.setFont(new Font("����", Font.PLAIN, 25));
		residentLabel.setBounds(72, 313, 115, 24);
		contentPane.add(residentLabel);
		
		pwd.setBounds(199, 116, 257, 36);
		contentPane.add(pwd);
		
		pwdCheck.setBounds(199, 182, 255, 36);
		contentPane.add(pwdCheck);
		
		hypenLabel.setFont(new Font("����", Font.PLAIN, 25));
		hypenLabel.setBounds(326, 318, 16, 15);
		contentPane.add(hypenLabel);
		
		lastNumberLabel.setFont(new Font("����", Font.PLAIN, 25));
		lastNumberLabel.setBounds(386, 311, 83, 28);
		contentPane.add(lastNumberLabel);
		
		firstNumber.setColumns(6);
		firstNumber.setBounds(199, 313, 115, 36);
		contentPane.add(firstNumber);
		firstNumber.setDocument((new JTextFieldLimit(6)));
		
		lastNumber.setColumns(1);
		lastNumber.setBounds(354, 311, 31, 36);
		contentPane.add(lastNumber);
		lastNumber.setDocument((new JTextFieldLimit(1)));
		
		signInBtn.setFont(new Font("����", Font.PLAIN, 20));
		signInBtn.setBounds(199, 556, 222, 36);
		contentPane.add(signInBtn);
		
		bankLabel.setFont(new Font("����", Font.PLAIN, 25));
		bankLabel.setBounds(72, 378, 115, 24);
		contentPane.add(bankLabel);
		
		bankbox.setFont(new Font("����", Font.PLAIN, 20));
		bankbox.setModel(new DefaultComboBoxModel(new String[] {"�λ� ����", "���� ����", "īī�� ����", "���� ����", "�츮 ����"}));
		bankbox.setBounds(199, 375, 255, 36);
		contentPane.add(bankbox);
		
		accountNumberLabel.setFont(new Font("����", Font.PLAIN, 25));
		accountNumberLabel.setBounds(72, 444, 115, 24);
		contentPane.add(accountNumberLabel);
		
		accountpwdLabel.setFont(new Font("����", Font.PLAIN, 25));
		accountpwdLabel.setBounds(12, 505, 185, 24);
		contentPane.add(accountpwdLabel);
		
		accountpwd.setBounds(199, 505, 255, 36);
		contentPane.add(accountpwd);
		accountpwd.setDocument((new JTextFieldLimit(4)));
		
		accountNumber.setColumns(10);
		accountNumber.setBounds(199, 444, 255, 36);
		contentPane.add(accountNumber);
		accountNumber.setDocument((new JTextFieldLimit(3)));
		
		ButtonListener bl = new ButtonListener();
		
		overlapCheckBtn.addActionListener(bl);
		signInBtn.addActionListener(bl);
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			String uid = id.getText();
			
			@SuppressWarnings("deprecation")
			String upwd = pwd.getText();
			@SuppressWarnings("deprecation")
			String upwdc = pwdCheck.getText();
			@SuppressWarnings("deprecation")
			String uaccpwd = accountpwd.getText();
			String uname = name.getText();
			String ufn = firstNumber.getText();
			String uln = lastNumber.getText();
			String uaccn = accountNumber.getText();
			String ubank = bankbox.getSelectedItem().toString();
			
			
			boolean flag = p.db.overlapCheck(uid);
			
			if(b.getText().equals("�ߺ� Ȯ��")) {
				if(uid.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.", "���̵� ���Է�", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(flag) {
						System.out.println("��� ���� ���̵�");
						System.out.println(flag);
						JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.");
					}
					else {
						System.out.println("��� �Ұ����� ���̵�");
						System.out.println(flag);
						JOptionPane.showMessageDialog(null, "����� �Ұ����� ���̵��Դϴ�. �ٽ� �Է��ϼ���.", "���̵� �ߺ�", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
			else if(b.getText().equals("ȸ������")) {
				if(uid.equals("") || upwd.equals("") || upwdc.equals("") || uname.equals("") || ufn.equals("") || uln.equals("") || uaccpwd.equals("") || uaccn.equals("") || ubank.equals("")) {
					JOptionPane.showMessageDialog(null, "��ĭ�� ��� �Է����ּ���.", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
					System.out.println("ȸ������ ���� : ���� ���Է�");
				}
				
				else {
					if(flag == false) {
						JOptionPane.showMessageDialog(null, "���̵� �ߺ�Ȯ���� ���ּ���", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
						System.out.println("ȸ������ ���� : ���̵� �ߺ�Ȯ�� �ʿ�");
					}
					
					else if(!(upwd.equals(upwdc))) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���.", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
						System.out.println("ȸ������ ���� : ��й�ȣ ����ġ");
					}
					
					else {
						p.db.addMember(uid, upwd, upwdc, uname, ufn, uln, uaccpwd, uaccn, ubank);
						JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ��߽��ϴ�.");
						
						dispose();
					}
				}
			}
			
		}
	}
}

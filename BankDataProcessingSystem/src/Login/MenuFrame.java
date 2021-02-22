package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import Login.LoginFrame.ButtonListener;

import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class MenuFrame extends JFrame {
	
	JPanel MenuPane= new JPanel();	

	private final JButton withdrawBtn = new JButton("��������");
	private final JButton checkDepositBtn = new JButton("������ȸ");
	private final JButton depositBtn = new JButton("������ü");
	private final JButton depositMyBtn = new JButton("�Ա�/�������Ա�");
	private final JButton loanBtn = new JButton("�����ȯ");
	private final JButton clearBankbookBtn = new JButton("��������");
	private final JButton modifyInfoBtn = new JButton("��������");
	
	LoginMain o = null;

	MenuFrame(LoginMain _o) {
		o = _o;
		
		setTitle("Menu");
		
		setForeground(Color.BLACK); //ȭ�鱸��(27~31)
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������â ����� ���μ������� ����ϰ� close
		setBounds(100, 100, 600, 480);//��ü ������ ����ũ�� ����(x��ǥ, y��ǥ, ����ũ��, ����ũ��)
		
		MenuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MenuPane);
		MenuPane.setLayout(null);
		
		checkDepositBtn.setFont(new Font("����", Font.PLAIN, 20));
		checkDepositBtn.setBounds(50, 250, 170, 55);
		MenuPane.add(checkDepositBtn);

		
		depositBtn.setFont(new Font("����", Font.PLAIN, 20));
		depositBtn.setBounds(50, 350, 170, 55);
		MenuPane.add(depositBtn);

		ButtonListener bl = new ButtonListener();
		
		checkDepositBtn.addActionListener(bl);
		depositBtn.addActionListener(bl);

		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		//
		withdrawBtn.setFont(new Font("����", Font.PLAIN, 20));
		withdrawBtn.setBounds(50, 150, 170, 55);
		MenuPane.add(withdrawBtn);
		
		depositMyBtn.setFont(new Font("����", Font.PLAIN, 16));
		depositMyBtn.setBounds(350, 50, 170, 55);
		MenuPane.add(depositMyBtn);
		
		loanBtn.setFont(new Font("����", Font.PLAIN, 20));
		loanBtn.setBounds(350, 150, 170, 55);
		MenuPane.add(loanBtn);
		
		clearBankbookBtn.setFont(new Font("����", Font.PLAIN, 20));
		clearBankbookBtn.setBounds(350, 250, 170, 55);
		MenuPane.add(clearBankbookBtn);
		
		modifyInfoBtn.setFont(new Font("����", Font.PLAIN, 20));
		modifyInfoBtn.setBounds(350, 350, 170, 55);
		MenuPane.add(modifyInfoBtn);
	
		//
		
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			
			if(b.getText().equals("������ȸ")) {
				CheckDeposit cd = new CheckDeposit(o);
			}
			
		}
	}
}




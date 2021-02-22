package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import Login.LoginFrame.ButtonListener;

import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class MenuFrame extends JFrame {
	
	JPanel MenuPane= new JPanel();	

	private final JButton withdrawBtn = new JButton("예금인출");
	private final JButton checkDepositBtn = new JButton("예금조회");
	private final JButton depositBtn = new JButton("계좌이체");
	private final JButton depositMyBtn = new JButton("입금/무통장입금");
	private final JButton loanBtn = new JButton("대출상환");
	private final JButton clearBankbookBtn = new JButton("통장정리");
	private final JButton modifyInfoBtn = new JButton("정보수정");
	
	LoginMain o = null;

	MenuFrame(LoginMain _o) {
		o = _o;
		
		setTitle("Menu");
		
		setForeground(Color.BLACK); //화면구성(27~31)
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우창 종료시 프로세스까지 깔끔하게 close
		setBounds(100, 100, 600, 480);//전체 프레임 절대크기 고정(x좌표, y좌표, 가로크기, 세로크기)
		
		MenuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MenuPane);
		MenuPane.setLayout(null);
		
		checkDepositBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		checkDepositBtn.setBounds(50, 250, 170, 55);
		MenuPane.add(checkDepositBtn);

		
		depositBtn.setFont(new Font("돋움", Font.PLAIN, 20));
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
		withdrawBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		withdrawBtn.setBounds(50, 150, 170, 55);
		MenuPane.add(withdrawBtn);
		
		depositMyBtn.setFont(new Font("돋움", Font.PLAIN, 16));
		depositMyBtn.setBounds(350, 50, 170, 55);
		MenuPane.add(depositMyBtn);
		
		loanBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		loanBtn.setBounds(350, 150, 170, 55);
		MenuPane.add(loanBtn);
		
		clearBankbookBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		clearBankbookBtn.setBounds(350, 250, 170, 55);
		MenuPane.add(clearBankbookBtn);
		
		modifyInfoBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		modifyInfoBtn.setBounds(350, 350, 170, 55);
		MenuPane.add(modifyInfoBtn);
	
		//
		
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			
			if(b.getText().equals("예금조회")) {
				CheckDeposit cd = new CheckDeposit(o);
			}
			
		}
	}
}




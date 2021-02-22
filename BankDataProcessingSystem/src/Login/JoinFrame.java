package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class JoinFrame extends JFrame {

	JPanel contentPane = new JPanel();
	
	JLabel idLabel = new JLabel("아이디 :");
	JLabel pwdLabel = new JLabel("비밀번호 :");
	JLabel pwdCheckLabel = new JLabel("비밀번호 확인 :");
	JLabel nameLabel = new JLabel("이름 :");
	JLabel residentLabel = new JLabel("주민번호 :");
	JLabel hypenLabel = new JLabel("-");
	JLabel lastNumberLabel = new JLabel("******");
	
	JTextField id = new JTextField();
	JTextField name = new JTextField();

	JPasswordField pwd = new JPasswordField();
	JPasswordField pwdCheck = new JPasswordField();
	
	JFormattedTextField firstNumber = new JFormattedTextField();
	JFormattedTextField lastNumber = new JFormattedTextField();
	
	JButton overlapCheckBtn = new JButton("중복 확인");
	JButton signInBtn = new JButton("회원가입");
	

	
	LoginMain p = null;
	public JoinFrame(LoginMain _p) {
		p = _p;
		
		setTitle("Join in");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 474);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		idLabel.setBounds(97, 52, 90, 24);
		contentPane.add(idLabel);
		
		id.setBounds(199, 50, 255, 36);
		contentPane.add(id);
		id.setColumns(10);
		
		overlapCheckBtn.setFont(new Font("굴림", Font.PLAIN, 20));
		overlapCheckBtn.setBounds(479, 50, 125, 36);
		contentPane.add(overlapCheckBtn);
		
		pwdLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		pwdLabel.setBounds(72, 116, 115, 24);
		contentPane.add(pwdLabel);
		
		pwdCheckLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		pwdCheckLabel.setBounds(12, 182, 185, 24);
		contentPane.add(pwdCheckLabel);
		
		nameLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		nameLabel.setBounds(121, 245, 66, 24);
		contentPane.add(nameLabel);
		
		name.setColumns(10);
		name.setBounds(199, 243, 255, 36);
		contentPane.add(name);
		
		residentLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		residentLabel.setBounds(72, 313, 115, 24);
		contentPane.add(residentLabel);
		
		pwd.setBounds(199, 116, 257, 36);
		contentPane.add(pwd);
		
		pwdCheck.setBounds(199, 182, 255, 36);
		contentPane.add(pwdCheck);
		
		hypenLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		hypenLabel.setBounds(326, 318, 16, 15);
		contentPane.add(hypenLabel);
		
		lastNumberLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lastNumberLabel.setBounds(386, 311, 83, 28);
		contentPane.add(lastNumberLabel);
		
		firstNumber.setColumns(6);
		firstNumber.setBounds(199, 313, 115, 36);
		contentPane.add(firstNumber);
		
		lastNumber.setColumns(1);
		lastNumber.setBounds(354, 311, 31, 36);
		contentPane.add(lastNumber);
		
		signInBtn.setFont(new Font("굴림", Font.PLAIN, 20));
		signInBtn.setBounds(199, 376, 222, 36);
		contentPane.add(signInBtn);
		
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
			String uname = name.getText();
			String ufn = firstNumber.getText();
			String uln = lastNumber.getText();
			
			
			boolean flag = p.db.overlapCheck(uid);
			
			if(b.getText().equals("중복 확인")) {
				if(uid.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "아이디 미입력", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(flag) {
						System.out.println("사용 가능 아이디");
						System.out.println(flag);
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					}
					else {
						System.out.println("사용 불가능한 아이디");
						System.out.println(flag);
						JOptionPane.showMessageDialog(null, "사용이 불가능한 아이디입니다. 다시 입력하세요.", "아이디 중복", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			 
			else if(b.getText().equals("회원가입")) {
				if(uid.equals("") || upwd.equals("") || upwdc.equals("") || uname.equals("") || ufn.equals("") || uln.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 입력해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("회원가입 실패 : 정보 미입력");
				}
				
				else {
					if(flag == false) {
						JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
						System.out.println("회원가입 실패 : 아이디 중복확인 필요");
					}
					
					else if(!(upwd.equals(upwdc))) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 다시 확인해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
						System.out.println("회원가입 실패 : 비밀번호 불일치");
					}
					
					else {
						p.db.addMember(uid, upwd, upwdc, uname, ufn, uln);
						JOptionPane.showMessageDialog(null, "회원가입을 완료했습니다.");
						
						dispose();
					}
				}
			}
			
		}
	}
}

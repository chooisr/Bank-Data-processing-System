package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class LoginFrame extends JFrame {

	JPanel loginPane= new JPanel();
	
	JLabel idLabel = new JLabel("아이디");//textView
	JLabel pwdLabel = new JLabel("비밀번호");
	
	JTextField id = new JTextField();//입력필드
	JTextField pwd = new JTextField();
	
	JButton exitBtn = new JButton("종료");
	JButton joinBtn = new JButton("회원가입");
	JButton loginBtn = new JButton("로그인");
	
	LoginMain o = null;

	LoginFrame(LoginMain _o) {
		o = _o;
		
		setTitle("login");
		
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우창 종료시 프로세스까지 깔끔하게 close
		setBounds(100, 100, 480, 230);
		
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPane);
		loginPane.setLayout(null);
		
		idLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		idLabel.setBounds(24, 26, 86, 39);
		loginPane.add(idLabel);
		
		pwdLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		pwdLabel.setBounds(24, 75, 99, 39);
		loginPane.add(pwdLabel);
		
		id.setColumns(10);
		id.setBounds(136, 26, 214, 39);
		loginPane.add(id);
		
		pwd.setColumns(10);
		pwd.setBounds(135, 75, 215, 39);
		loginPane.add(pwd);
		
		exitBtn.setFont(new Font("굴림", Font.BOLD, 20));
		exitBtn.setBounds(219, 143, 146, 39);
		loginPane.add(exitBtn);
		
		joinBtn.setFont(new Font("굴림", Font.BOLD, 20));
		joinBtn.setBounds(24, 143, 146, 39);
		loginPane.add(joinBtn);
		
		loginBtn.setFont(new Font("굴림", Font.BOLD, 18));
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
			
			if(b.getText().equals("종료")) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
			else if(b.getText().equals("회원가입")) {
				JoinFrame jf = new JoinFrame(o);
			}
			
			else if(b.getText().equals("로그인")) {
				if(uid.equals("") || upwd.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("로그인 실패 : 로그인 정보 미입력");
				}
				
				else if(uid != null && upwd != null) {
					if(o.db.logincheck(uid, upwd)) {
						System.out.println("로그인 성공");
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
						MenuFrame cf = new MenuFrame(o);
					}
					else {
						System.out.println("로그인 실패 : 로그인 정보 불일치");
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
					}
				}
			}
		}
	}
}
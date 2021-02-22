package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class CheckDeposit extends JFrame {

	JPanel CheckDepositPane= new JPanel();
	
	
	
	LoginMain o = null;
	private JTable table;

	CheckDeposit(LoginMain _o) {
		o = _o;
		
		setTitle("예금조회(test)");
		
		setForeground(Color.BLACK); //화면구성(27~31)
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우창 종료시 프로세스까지 깔끔하게 close
		setBounds(100, 100, 600, 480);//전체 프레임 절대크기 고정(x좌표, y좌표, 가로크기, 세로크기)
		
		String header[]= {"one", "two", "three"}; //컬렴명
		String cells[][] = {{"111", "222", "333"}, {"444", "555", "666"}}; // 2,3행
		getContentPane().setLayout(null);
		

		table = new JTable(cells, header);
		table.setBounds(0, 0, 579, 452);
		getContentPane().add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(579, 0, 17, 452);
		getContentPane().add(scrollBar);
		
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//

		}
	}
}
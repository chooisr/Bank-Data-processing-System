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
		
		setTitle("������ȸ(test)");
		
		setForeground(Color.BLACK); //ȭ�鱸��(27~31)
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������â ����� ���μ������� ����ϰ� close
		setBounds(100, 100, 600, 480);//��ü ������ ����ũ�� ����(x��ǥ, y��ǥ, ����ũ��, ����ũ��)
		
		String header[]= {"one", "two", "three"}; //�÷Ÿ�
		String cells[][] = {{"111", "222", "333"}, {"444", "555", "666"}}; // 2,3��
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
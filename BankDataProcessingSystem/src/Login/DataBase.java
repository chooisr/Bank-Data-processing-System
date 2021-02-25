package Login;

import java.sql.*;

public class DataBase {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost:3306/bankdb?serverTimezone=Asia/Seoul";
    String user = "root";
    String passwd = "1234";

    DataBase() {    //�����ͺ��̽��� �����Ѵ�.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("MySQL ���� ���� ����");
        } catch(Exception e) {
            System.out.println("MySQL ���� ���� ���� > " + e.toString());
        }
    }

    /* �α��� ������ Ȯ�� */
    boolean logincheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String checkingStr = "SELECT userpw FROM user WHERE userid='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            int count = 0;
            while(result.next()) {
                if(pw.equals(result.getString("userpw"))) {
                    flag = true;
                    System.out.println("�α��� ����");
                }

                else {
                    flag = false;
                    System.out.println("�α��� ����");
                }
                count++;
            }
        } catch(Exception e) {
            flag = false;
            System.out.println("�α��� ���� > " + e.toString());
        }

        return flag;
    }
    
    boolean overlapCheck(String _i){
    	boolean flag = false;
    	
    	String id = _i;
    	
    	try {
    		String checkingStr = "SELECT count(*) FROM user WHERE userid='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);
            
            while(result.next()) {
            	if(result.getInt("count(*)") == 0) {
                	flag = true;
                	System.out.println("�α��� ��� ����");
                }
            	
                else {
                	flag = false;
                	System.out.println("�α��� ��� �Ұ���");
                }
            }
    	} catch(Exception e) {
    		flag = false;
    		System.out.println("Ȯ�� ���� > " + e.toString());
    	}
    	return flag;
    }
    
    void addMember(String _id, String _pwd, String _pwdc, String _name, String _fn, String _ln, String _accpwd, String _accn, String _bank) {
    	String resd = _fn + "-" + _ln;
    	String bk = "";
    	switch(_bank) {
    	case "�λ� ����":
    		bk = "01";
    		break;
    	case "���� ����":
    		bk = "02";
    		break;
    	case "īī�� ����":
    		bk = "03";
    		break;
    	case "���� ����":
    		bk = "04";
    		break;
    	case "�츮 ����":
    		bk = "05";
    		break;
    	}
    	String act = bk + "-" + _accn;
    	
    	int _balance = 0;
    	
    	try {
    		String checkingStr = "INSERT INTO user (userid, userpw, username, userresident) VALUES( '" + _id +"', '" + _pwd +"', '" + _name + "', '" + resd + "' )";
            stmt.executeUpdate(checkingStr);
            String checkingStr2 = "INSERT INTO passbook (userid, bankName, account, balance, accountpwd) VALUES( '" + _id +"', '" + _bank +"', '" + act + "', '" + _balance +"', '" + _accpwd + "' )";
            stmt.executeUpdate(checkingStr2);
            System.out.println("ȸ������ ����");
    	} catch(Exception e) {
    		System.out.println("ȸ������ ���� > " + e.toString());
    	}
    	
    }
}

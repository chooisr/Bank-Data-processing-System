package Login;

import java.sql.*;

public class DataBase {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost:3306/bankdb?serverTimezone=Asia/Seoul";
    String user = "root";
    String passwd = "1234";

    DataBase() {    //데이터베이스에 연결한다.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("MySQL 서버 연동 성공");
        } catch(Exception e) {
            System.out.println("MySQL 서버 연동 실패 > " + e.toString());
        }
    }

    /* 로그인 정보를 확인 */
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
                    System.out.println("로그인 성공");
                }

                else {
                    flag = false;
                    System.out.println("로그인 실패");
                }
                count++;
            }
        } catch(Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
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
                	System.out.println("로그인 사용 가능");
                }
            	
                else {
                	flag = false;
                	System.out.println("로그인 사용 불가능");
                }
            }
    	} catch(Exception e) {
    		flag = false;
    		System.out.println("확인 오류 > " + e.toString());
    	}
    	return flag;
    }
    
    void addMember(String _id, String _pwd, String _pwdc, String _name, String _fn, String _ln, String _accpwd, String _accn, String _bank) {
    	String resd = _fn + "-" + _ln;
    	String bk = "";
    	switch(_bank) {
    	case "부산 은행":
    		bk = "01";
    		break;
    	case "국민 은행":
    		bk = "02";
    		break;
    	case "카카오 은행":
    		bk = "03";
    		break;
    	case "농협 은행":
    		bk = "04";
    		break;
    	case "우리 은행":
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
            System.out.println("회원가입 성공");
    	} catch(Exception e) {
    		System.out.println("회원가입 오류 > " + e.toString());
    	}
    	
    }
}

package Login;

import java.sql.*;

public class DataBase {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost:3306/bankdb?serverTimezone=UTC";
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
}
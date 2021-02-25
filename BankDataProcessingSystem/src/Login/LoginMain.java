package Login;

public class LoginMain {
	DataBase db = null;
    LoginFrame lf = null;

    public static void main(String[] args) {
        LoginMain opt = new LoginMain();
        opt.db = new DataBase();
        opt.lf = new LoginFrame(opt);
        
    }
}
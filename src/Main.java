import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start application");
        DBManager dbManager = new DBManager("root", "password", "Voting", "localhost", 3306, "com.mysql.cj.jdbc.Driver");

        new Login(dbManager);
    }
}
import Domain.ElectionClerk;

import javax.swing.*;
import java.util.Arrays;

public class Login extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JButton loginButton;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPanel labelsPanel;
    private JPanel fieldsPanel;
    private JPasswordField passwordField;

    public Login(DBManager dbManager) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.loginPanel);
        this.setVisible(true);
        this.pack();

        loginButton.addActionListener(e -> {
            //new Home(dbManager, 1);
            //dispose();
            String username = usernameTextField.getText().trim();
            char[] passwordArray = passwordField.getPassword();
            StringBuilder password = new StringBuilder();
            for (char c : passwordArray) {
                password.append(c);
            }
            
            System.out.println(password);
            int id = ElectionClerk.validateLogin(dbManager.getConnection(), username, password.toString());
            if (id  !=0) {
                new Home(dbManager, id);
                dispose();
            }
        });
    }
}

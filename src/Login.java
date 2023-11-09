import Domain.ElectionClerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Login extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPanel labelsPanel;
    private JPanel fieldsPanel;

    public Login(DBManager dbManager) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.loginPanel);
        this.setVisible(true);
        this.pack();

        loginButton.addActionListener(e -> {
            new Home(dbManager, 1);
            dispose();
            /*
            String username = usernameTextField.getText().trim();
            String password = passwordTextField.getText().trim();
            int id = ElectionClerk.validateLogin(dbManager.getConnection(), username, password);
            if (id  !=0) {
                new Home(dbManager, id);
                dispose();
            }
             */
        });
    }
}

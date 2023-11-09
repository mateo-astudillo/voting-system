import Domain.ElectionClerk;
import Domain.Voter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    private JPanel homePanel;
    private JButton validateButton;
    private JTextField documentTextField;
    private JLabel documentLabel;
    private JButton closeTableButton;

    public Home(DBManager dbManager, int id) {
        ElectionClerk electionClerk = new ElectionClerk(id);
        electionClerk.saveOpeningTime(dbManager.getConnection());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sistema de votos");
        //this.setMinimumSize(new Dimension(400, 400));
        this.setContentPane(this.homePanel);
        this.setVisible(true);
        this.pack();

        closeTableButton.addActionListener(e -> {
            electionClerk.closeTable(dbManager.getConnection());
            dbManager.closeConnection();
            dispose();
        });

        validateButton.addActionListener(e -> {
            int document = Integer.parseInt(documentTextField.getText());
            System.out.println(document);
            Voter voter = new Voter(dbManager.getConnection(), document);
            new Validate(voter);
        });
    }
}

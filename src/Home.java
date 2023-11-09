import Domain.ElectionClerk;

import javax.swing.*;

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
        this.setVisible(true);
    }
}

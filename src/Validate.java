import Domain.Voter;

import javax.swing.*;

public class Validate extends JFrame{
    private JPanel validatePanel;
    private JButton cancelButton;
    private JButton validateButton;
    private JLabel valueFirstNameLabel;
    private JLabel valueLastNameLabel;
    private JLabel valueBirthdateLabel;
    private JLabel documentLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel birthdateLabel;
    private JLabel addressLabel;
    private JLabel valueDocumentLabel;
    private JLabel valueAddressLabel;

    public Validate(Voter voter) {
        this.valueDocumentLabel.setText(voter.getDocument());
        this.valueFirstNameLabel.setText(voter.getFirstName());
        this.valueLastNameLabel.setText(voter.getLastName());
        this.valueAddressLabel.setText(voter.getAddress());
        this.valueBirthdateLabel.setText(voter.getBirthdate());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setContentPane(validatePanel);
        setVisible(true);
        pack();
    }
}

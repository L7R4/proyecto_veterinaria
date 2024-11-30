package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AuthorizationPopup extends JDialog {
    private JTextField employeeIdField;
    private boolean isAuthorized = false;

    public AuthorizationPopup(JFrame parent) {
        super(parent, "Authorization Required", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel label = new JLabel("Enter Employee ID:");
        employeeIdField = new JTextField(15);
        JButton submitButton = new JButton("Submit");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(employeeIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(submitButton, gbc);

        add(panel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredId = employeeIdField.getText();
                //DEMO
                if ("43747611".equals(enteredId)) {
                    isAuthorized = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AuthorizationPopup.this,
                            "Invalid Employee ID. Access Denied.",
                            "Authorization Failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
}
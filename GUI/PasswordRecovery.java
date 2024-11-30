package GUI;

import Design.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordRecovery extends JFrame {

    private JTextField usernameField;
    private JTextField securityAnswerField;
    private JButton submitButton;
    private JButton backToLoginButton;
    private JLabel instructionslbl1;
    private JLabel instructionslbl2;

    public PasswordRecovery() {
        
        setTitle("Password Recovery");
        setSize(500, 500);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel setup
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(247, 247, 247));

        // Title Label
        JLabel toplbl = new JLabel("Forgot your password?");
        toplbl.setBounds(110, 38, 270, 35);
        toplbl.setBackground(new Color(214, 217, 223));
        toplbl.setForeground(new Color(0, 0, 0));
        toplbl.setFont(new Font("SansSerif", Font.BOLD, 23));
        contentPane.add(toplbl);

        // Employee ID label and field
        JLabel employeeIDlbl = new JLabel("Employee ID");
        employeeIDlbl.setBounds(192, 90, 120, 35);
        employeeIDlbl.setFont(new Font("SansSerif", Font.PLAIN, 16));
        contentPane.add(employeeIDlbl);

        usernameField = new JTextField();
        usernameField.setBounds(127, 135, 250, 35);
        usernameField.setFont(new Font("sansserif", Font.PLAIN, 12));
        contentPane.add(usernameField);

        // Instructions label
        instructionslbl1 = new JLabel();
	instructionslbl1.setBounds(140,96,250,35);
	instructionslbl1.setBackground(new Color(214,217,223));
	instructionslbl1.setForeground(new Color(128,128,128));
	instructionslbl1.setEnabled(true);
	instructionslbl1.setFont(new Font("SansSerif",2,15));
	instructionslbl1.setText("Please, enter your ID and answer");
	instructionslbl1.setVisible(true);
	
	instructionslbl2 = new JLabel();
	instructionslbl2.setBounds(95,121,340,35);
	instructionslbl2.setBackground(new Color(214,217,223));
	instructionslbl2.setForeground(new Color(128,128,128));
	instructionslbl2.setEnabled(true);
	instructionslbl2.setFont(new Font("SansSerif",2,15));
	instructionslbl2.setText("the security question to change your password");
	instructionslbl2.setVisible(true);

        // Security question label and field
        JLabel securityqlbl = new JLabel("What was the name of your first pet?");
        securityqlbl.setBounds(135, 210, 260, 35);
        securityqlbl.setFont(new Font("SansSerif", Font.PLAIN, 16));
        contentPane.add(securityqlbl);

        securityAnswerField = new JTextField();
        securityAnswerField.setBounds(128, 255, 250, 35);
        securityAnswerField.setFont(new Font("sansserif", Font.PLAIN, 12));
        contentPane.add(securityAnswerField);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(205, 310, 90, 35);
        submitButton.setBackground(new Color(31, 70, 59));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        contentPane.add(submitButton);

        // Button to go back to login
        backToLoginButton = new JButton("Back to Login");
        backToLoginButton.setBounds(172, 370, 150, 35);
        backToLoginButton.setBackground(new Color(31, 70, 59));
        backToLoginButton.setForeground(Color.WHITE);
        backToLoginButton.setEnabled(false);  // Disabled initially
        backToLoginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        contentPane.add(backToLoginButton);

        // Add action listener for submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePasswordRecovery();
            }
        });

        // Add action listener for back to login button
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginWindow();
            }
        });

        // Set content pane and make visible
        this.setContentPane(contentPane);
        this.setVisible(true);
    }

    // Handles the password recovery logic
    private void handlePasswordRecovery() {
        String username = usernameField.getText();
        String securityAnswer = securityAnswerField.getText();

        // Check if the username and security question answer are correct
        User user = User.findUserBySecurityQuestion(username, securityAnswer);

        if (user != null) {
            // Prompt for new password
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            if (newPassword != null && !newPassword.isEmpty()) {
                user.setPassword(newPassword);
                user.updateInFile();  // Update the password in the file
                JOptionPane.showMessageDialog(this, "Password updated successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID or security answer.");
        }
    }

    // Opens the login window after password recovery
    private void openLoginWindow() {
        this.dispose();  // Close the recovery window
        new Login();  // Open the login window again
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordRecovery();
            }
        });
    }
}


package GUI;

import Design.Employee;
import Design.User;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class Sign_Up extends JFrame {
    private JTextField registrarIdField, nameField, lastNameField, emailField, addressField, phoneField, employeeIdField, securityAnswerField;
    private JPasswordField passwordField;
    private JComboBox<String> positionCombo, workAreaCombo;
    private JSpinner birthDateSpinner, entryDateSpinner;
    private JButton submitButton, backToLoginButton;

    public Sign_Up() {
        setTitle("Sign Up");
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel("Register New Employee");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Personal Info Section
        JLabel personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        personalInfoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(personalInfoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        mainPanel.add(createFormField("ID:", registrarIdField = new JTextField()));
        mainPanel.add(createFormField("First Name:", nameField = new JTextField()));
        mainPanel.add(createFormField("Last Name:", lastNameField = new JTextField()));
        mainPanel.add(createFormField("Date of Birth:", birthDateSpinner = createDateSpinner()));
        mainPanel.add(createFormField("Email:", emailField = new JTextField()));
        mainPanel.add(createFormField("Address:", addressField = new JTextField()));
        mainPanel.add(createFormField("Phone Number:", phoneField = new JTextField()));
        mainPanel.add(createFormField("Position:", positionCombo = createComboBox(new String[]{"Veterinary Assistant", "Pharmacy Manager", "Administrator", "Receptionist"})));
        mainPanel.add(createFormField("Work Area:", workAreaCombo = createComboBox(new String[]{"Customer Service", "Administration", "Reception", "Veterinary Services", "Laboratory", "Pharmacy"})));
        mainPanel.add(createFormField("Entry Date:", entryDateSpinner = createDateSpinner()));

        // Separator
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(new JSeparator());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // User Account Section
        JLabel userAccountLabel = new JLabel("User Account Information");
        userAccountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userAccountLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(userAccountLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        mainPanel.add(createFormField("Employee ID:", employeeIdField = new JTextField()));
        mainPanel.add(createFormField("Password:", passwordField = new JPasswordField()));
        mainPanel.add(createFormField("Security Question: What was the name of your first pet?", securityAnswerField = new JTextField()));

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(31, 70, 59));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(e -> submitForm());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(submitButton);

        // Back to Login button
        backToLoginButton = new JButton("Back to Login");
        backToLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backToLoginButton.setBackground(Color.BLACK);
        backToLoginButton.setForeground(Color.WHITE);
        backToLoginButton.setFocusPainted(false);
        backToLoginButton.addActionListener(e -> backToLogin());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(backToLoginButton);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setContentPane(scrollPane);
    }

    private JPanel createFormField(String label, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBackground(Color.WHITE);

        JLabel jLabel = new JLabel(label);
        jLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(jLabel);

        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        if (field instanceof JTextField || field instanceof JPasswordField) {
            ((JTextField) field).setBorder(new RoundedBorder(10));
        }
        panel.add(field);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        return panel;
    }

    private JComboBox<String> createComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }

    private JSpinner createDateSpinner() {
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
        return spinner;
    }

    private void submitForm() {
    if (validateForm()) {
        try {
            // Create and save Employee
            Employee employee = new Employee(
                registrarIdField.getText(), // ID from Person
                nameField.getText(), // name from Person
                lastNameField.getText(), // last_Name from Person
                LocalDate.parse(((JSpinner.DateEditor) birthDateSpinner.getEditor()).getTextField().getText()), // birth from Person
                "", // address from Person (not collected in form)
                "", // cel_Number from Person (not collected in form)
                employeeIdField.getText(), // employee_ID
                0.0, // salary
                workAreaCombo.getSelectedItem().toString(), // work_Area
                positionCombo.getSelectedItem().toString(), // position
                LocalDate.parse(((JSpinner.DateEditor) entryDateSpinner.getEditor()).getTextField().getText()) // hire_Date
            );

            // Check if employee ID is unique and save
            

            // Create and save User
            User user = new User(
                employeeIdField.getText(),
                new String(passwordField.getPassword()),
                securityAnswerField.getText()
            );
            user.saveToFile();

            JOptionPane.showMessageDialog(this, 
                "Employee registered successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            backToLogin();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error registering employee: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

   private boolean validateForm() {
    if (registrarIdField.getText().isEmpty() || 
        nameField.getText().isEmpty() || 
        lastNameField.getText().isEmpty() || 
        emailField.getText().isEmpty() || 
        addressField.getText().isEmpty() ||
        phoneField.getText().isEmpty() ||
        employeeIdField.getText().isEmpty() || 
        new String(passwordField.getPassword()).isEmpty() ||
        securityAnswerField.getText().isEmpty() ||
        positionCombo.getSelectedIndex() == -1 || 
        workAreaCombo.getSelectedIndex() == -1) {
        
        JOptionPane.showMessageDialog(this, 
            "All fields are required.", 
            "Validation Error", 
            JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

    private void backToLogin() {
        Login loginForm = new Login();
        loginForm.setVisible(true);
        this.dispose();
    }

    // Custom rounded border for text fields
    public static class RoundedBorder extends AbstractBorder {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.GRAY);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sign_Up form = new Sign_Up();
            form.setVisible(true);
        });
    }
}
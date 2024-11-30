package GUI;

import Design.User;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    
    // Components 
    private JLabel IDlbl_login;
    private JLabel Background_login;
    private JPanel headimage_login;
    private JLabel headlbl_login;
    private JPanel imagen_login;
    private JButton login_btb;
    private JLabel logoklinsy_login;
    private JLabel passforgotlbl_login;
    private JLabel passlbl_login;
    private JPasswordField passwordfield_login;
    private JButton recovlbl_login;
    private JButton register_btn;
    private JLabel separation_login;
    private JLabel textregis_login;
    private JTextField userfield_login;
    private JPanel contentPane_login;
    private JPanel leftPanel_login;
    private JPanel rightPanel_login;
    private JLabel logoPlaceholder_login;
    private JLabel imagePlaceholder_login;
    private JLabel imagePlaceholderRight_login;
    
    // Load the images for the Login's background 
    ImageIcon originalLogo = new ImageIcon("C:/Users/aleja/OneDrive/Documentos/GUIVETAPP/VetLogo_Login/VelesAnimalClinic_Logo.png");
    Image resizedImage = originalLogo.getImage().getScaledInstance(300, 60, Image.SCALE_SMOOTH);
    ImageIcon logoVet_Icon = new ImageIcon(resizedImage);
   
    ImageIcon originalLogo3 = new ImageIcon("C:/Users/aleja/OneDrive/Documentos/GUIVETAPP/Background_Login/Background_Right.png");
    Image resizedImage3 = originalLogo3.getImage().getScaledInstance(500, 700, Image.SCALE_SMOOTH);
    ImageIcon rightBackground_Icon = new ImageIcon(resizedImage3);
    
    public Login() {
        setTitle("Login");
        setSize(1000, 700);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Removes gap between panels
        contentPane_login = new JPanel(new GridLayout(1, 2, 0, 0));  
        setContentPane(contentPane_login);
        
        // LEFT SIDE OF THE LOGIN:
        leftPanel_login = new JPanel();
        leftPanel_login.setLayout(new BoxLayout(leftPanel_login, BoxLayout.Y_AXIS));
        leftPanel_login.setBackground(new Color(247, 247, 247));
        leftPanel_login.setBorder(new EmptyBorder(40, 60, 40, 60));  
       
        // Label to set the Veterinary's Logo
        logoPlaceholder_login = new JLabel(logoVet_Icon);
        logoPlaceholder_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(logoPlaceholder_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 60)));  

        headlbl_login = new JLabel("Welcome Back");
        headlbl_login.setFont(new Font("SansSerif", Font.BOLD, 37));  
        headlbl_login.setForeground(new Color(51, 51, 51));  
        headlbl_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(headlbl_login);

        JLabel subLabel_login = new JLabel("Get Started");
        subLabel_login.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subLabel_login.setForeground(new Color(128, 128, 128));
        subLabel_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(subLabel_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 30)));

        IDlbl_login = new JLabel("ID");
        IDlbl_login.setFont(new Font("SansSerif", 1, 14));
        IDlbl_login.setForeground(new Color(71, 71, 71));
        IDlbl_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(IDlbl_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 8)));

        userfield_login = new JTextField(20);
        userfield_login.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));  
        userfield_login.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        userfield_login.setBorder(new Sign_Up.RoundedBorder(10));
        leftPanel_login.add(userfield_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 20)));

        passlbl_login = new JLabel("Password");
        passlbl_login.setFont(new Font("SansSerif", 1, 14));
        passlbl_login.setForeground(new Color(71, 71, 71));
        passlbl_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(passlbl_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 8)));

        passwordfield_login = new JPasswordField(20);
        passwordfield_login.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        passwordfield_login.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        passwordfield_login.setBorder(new Sign_Up.RoundedBorder(10));
        leftPanel_login.add(passwordfield_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 16)));

        JPanel forgotPanel_login = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        forgotPanel_login.setOpaque(false);
        forgotPanel_login.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        passforgotlbl_login = new JLabel("Forgot Password? Click on ");
        passforgotlbl_login.setFont(new Font("SansSerif", Font.ITALIC, 13));
        passforgotlbl_login.setForeground(new Color(128, 128, 128));
        passforgotlbl_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        forgotPanel_login.add(passforgotlbl_login);
        
        recovlbl_login = new JButton("Recovery");
        recovlbl_login.setFont(new Font("SansSerif", Font.BOLD, 14));
        recovlbl_login.setForeground(new Color(31, 70, 59));
        recovlbl_login.setBorderPainted(false);
        recovlbl_login.setContentAreaFilled(false);
        recovlbl_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPanel_login.add(Box.createHorizontalStrut(-10));
        forgotPanel_login.add(recovlbl_login);
        recovlbl_login.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel_login.add(forgotPanel_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 30)));

        // Add action listener for recovery button
        recovlbl_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPasswordRecoveryWindow();
            }
        });

        login_btb = new JButton("Login");
        login_btb.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        login_btb.setPreferredSize(new Dimension(Integer.MAX_VALUE, 35));
        login_btb.setBackground(new Color(31, 70, 59));
        login_btb.setForeground(Color.WHITE);
        login_btb.setFont(new Font("SansSerif", Font.BOLD, 18));
        login_btb.setBorderPainted(false);
        login_btb.setFocusPainted(false);
        login_btb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login_btb.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Add action listener for login button
        login_btb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userfield_login.getText();
                String password = new String(passwordfield_login.getPassword());

                User user = User.findUser(username, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(Login.this, "Login Successful! Welcome " + username);
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password. Please try again.");
                }
            }
        });
        
        leftPanel_login.add(login_btb);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 30)));

        separation_login = new JLabel("───────────── OR ─────────────");
        separation_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        separation_login.setFont(new Font("SansSerif", Font.PLAIN, 12));
        separation_login.setForeground(new Color(160, 160, 160));
        leftPanel_login.add(separation_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 20)));

        textregis_login = new JLabel("Don't have an account?");
        textregis_login.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textregis_login.setForeground(new Color(71, 71, 71));
        textregis_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(textregis_login);
        leftPanel_login.add(Box.createRigidArea(new Dimension(0, 10)));

        register_btn = new JButton("SIGN UP");
        register_btn.setMaximumSize(new Dimension(200, 40));
        register_btn.setPreferredSize(new Dimension(200, 40));
        register_btn.setBackground(Color.BLACK);
        register_btn.setForeground(Color.WHITE);
        register_btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        register_btn.setBorderPainted(false);
        register_btn.setFocusPainted(false);
        register_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        register_btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel_login.add(register_btn);

        // Add action listener for sign up button
        register_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AuthorizationPopup authPopup = new AuthorizationPopup(Login.this);
                authPopup.setVisible(true);
                
                if (authPopup.isAuthorized()) {
                    Sign_Up registrationForm = new Sign_Up();
                    registrationForm.setVisible(true);
                    Login.this.dispose(); // Close the login window
                }
            }
        });
        
        rightPanel_login = new JPanel(new GridBagLayout());  
        rightPanel_login.setBackground(new Color(31, 70, 59));
        
        // Label to set the Veterinary's Logo
        imagePlaceholderRight_login = new JLabel(rightBackground_Icon);
        imagePlaceholderRight_login.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel_login.add(imagePlaceholderRight_login);
        rightPanel_login.add(Box.createRigidArea(new Dimension(0, 60)));
 
        contentPane_login.add(leftPanel_login);
        contentPane_login.add(rightPanel_login);

        setVisible(true);
    }

    private void openPasswordRecoveryWindow() {
        this.dispose();  // Close the Login window
        new PasswordRecovery();  // Open the recovery window
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
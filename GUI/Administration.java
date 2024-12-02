package GUI;

import Design.DatabaseConfig;
import Design.DataBaseManager;
import Design.*;
import javax.swing.*;
import javax.swing.border.TitledBorder; // Import necesario
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administration extends JFrame {

    private DataBaseManager<Client> clientDB;
    private DataBaseManager<Employee> employeeDB;

    public Administration() {
        // Initialize database managers
        clientDB = new DataBaseManager<>(DatabaseConfig.CLIENTS_FILE);
        employeeDB = new DataBaseManager<>(DatabaseConfig.EMPLOYEES_FILE);

        // Set up the JFrame
        setTitle("Administration");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         setLayout(new BorderLayout()); // Usar BorderLayout para dividir título y panel principal

        // Crear el título como JLabel
        JLabel titleLabel = new JLabel("Administration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.decode("#000"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el título
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Margen alrededor del título

        // Crear el panel principal con botones
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Alinear los botones a la izquierda con márgenes
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#1a1a194d"), 1)); // 1px de borde

        // Add buttons to the panel
        addDatabaseButton("Client Database", clientDB, ClientWindow.class, mainPanel);
        addDatabaseButton("Employee Database", employeeDB, EmployeeWindow.class, mainPanel);

        add(titleLabel, BorderLayout.NORTH); // Título en la parte superior
        add(mainPanel, BorderLayout.CENTER); // Panel de botones en el centro

        setVisible(true);
    }

    private <T> void addDatabaseButton(String label, DataBaseManager<?> db, Class<?> windowClass, JPanel parentPanel) {
        JButton button = new JButton(label);

        // Set icon for the button
        ImageIcon icon = new ImageIcon("resources/icons/file_icon.png");
        Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(scaledImage));

        // Style the button
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setPreferredSize(new Dimension(120, 120));
        button.setContentAreaFilled(false); // Remove background
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusPainted(false); // Remove focus effect
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Pointer cursor

        // Change font of button label
        button.setFont(new Font("Verdana", Font.PLAIN, 12));
        button.setForeground(Color.decode("#1F463A")); // Change text color

        // Add hover effect for the border
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBorder(BorderFactory.createLineBorder(Color.decode("#1F463A"), 2, true));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBorder(BorderFactory.createEmptyBorder());
            }
        });

        // Add action listener for the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame window = (JFrame) windowClass.getDeclaredConstructor(DataBaseManager.class).newInstance(db);
                    window.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the button to the parent panel
        parentPanel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Administration());
    }
}

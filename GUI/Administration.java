package GUI;

import Design.DatabaseConfig;
import Design.DataBaseManager;
import Design.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administration extends JFrame {

    private DataBaseManager<Client> clientDB;
    private DataBaseManager<Employee> employeeDB;
    private DataBaseManager<Canine> canineDB;
    private DataBaseManager<Feline> felineDB;
    private DataBaseManager<Avian> avianDB;
    private DataBaseManager<Rodent> rodentDB;
    private DataBaseManager<Reptile> reptileDB;
    private DataBaseManager<Special> specialDB;

    public Administration() {
        // Initialize database managers
        clientDB = new DataBaseManager<>(DatabaseConfig.CLIENTS_FILE);
        employeeDB = new DataBaseManager<>(DatabaseConfig.EMPLOYEES_FILE);
        canineDB = new DataBaseManager<>(DatabaseConfig.CANINES_FILE);
        felineDB = new DataBaseManager<>(DatabaseConfig.FELINES_FILE);
        avianDB = new DataBaseManager<>(DatabaseConfig.AVIANS_FILE);
        rodentDB = new DataBaseManager<>(DatabaseConfig.RODENTS_FILE);
        reptileDB = new DataBaseManager<>(DatabaseConfig.REPTILES_FILE);
        specialDB = new DataBaseManager<>(DatabaseConfig.SPECIALS_FILE);

        // Set up the JFrame
        setTitle("Administration");
        setLayout(new FlowLayout());
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add buttons for each database
        addDatabaseButton("Client Database", clientDB, ClientWindow.class);
        addDatabaseButton("Employee Database", employeeDB, EmployeeWindow.class);

        setVisible(true);
    }

    private <T> void addDatabaseButton(String label, DataBaseManager<?> db, Class<?> windowClass) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Open the corresponding window for each database
                    JFrame window = (JFrame) windowClass.getDeclaredConstructor(DataBaseManager.class).newInstance(db);
                    window.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();  // Handle reflection issues or class not found errors
                }
            }
        });
        add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Administration();  // Launch the administration window
            }
        });
    }
}

package GUI;

import Design.DatabaseConfig;
import Design.DataBaseManager;
import Design.Client;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientWindow extends JFrame {

    private DataBaseManager<Client> clientsDB;
    private JList<String> clientsList;
    private DefaultListModel<String> listModel;

    public ClientWindow(DataBaseManager<Client> clientsDB) {
        this.clientsDB = clientsDB;

        // Set up the JFrame
        setTitle("Clients Management");
        setLayout(new BorderLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set up the JList to display client data
        listModel = new DefaultListModel<>();
        clientsList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(clientsList);
        add(scrollPane, BorderLayout.CENTER);

        // Load data from the client database
        loadData();

        // Add buttons for CRUD operations
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add Client");
        JButton modifyButton = new JButton("Modify Client");
        JButton deleteButton = new JButton("Delete Client");

        // Add action listeners to the buttons

        // Add new client
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter the client's name
                String name = JOptionPane.showInputDialog("Enter client name:");
                if (name != null && !name.trim().isEmpty()) {
                    // Request the other fields required for the Client
                    String email = JOptionPane.showInputDialog("Enter client email:");
                    boolean hasCurrTreat = JOptionPane.showConfirmDialog(null, "Has Current Treatment?", "Current Treatment", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    boolean hasDebt = JOptionPane.showConfirmDialog(null, "Has Debt?", "Debt Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    String addInfo = JOptionPane.showInputDialog("Enter additional information:");

                    // Generate a simple unique client ID (you can replace this with better ID generation logic)
                    String clientID = "C" + (clientsDB.list().size() + 1); // Example ID generation

                    // Create a new Client instance with the entered and default values
                    Client newClient = new Client(clientID, name, "LastName", LocalDate.now(), "Address", "PhoneNumber", email, hasCurrTreat, hasDebt, addInfo);
                    try {
                        // Add the new client to the database
                        clientsDB.add(newClient);
                        loadData(); // Update the displayed data
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Modify existing client
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClient = clientsList.getSelectedValue();
                if (selectedClient != null) {
                    // Get the client ID from the list selection
                    String clientID = selectedClient.split(",")[0];  // Assuming the list is in "ID, Name" format
                    Client clientToModify = clientsDB.consult(clientID);

                    if (clientToModify != null) {
                        // Modify the client fields
                        String newName = JOptionPane.showInputDialog("Enter new name for client:", clientToModify.getName());
                        if (newName != null) {
                            clientToModify.setName(newName); // Update client name

                            // Additional modifications for email, debt status, etc.
                            String newEmail = JOptionPane.showInputDialog("Enter new email:", clientToModify.getEmail());
                            clientToModify.setEmail(newEmail);

                            try {
                                // Modify the client in the database
                                clientsDB.modify(clientToModify);
                                loadData(); // Update the displayed data
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        // Delete existing client
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClient = clientsList.getSelectedValue();
                if (selectedClient != null) {
                    String clientID = selectedClient.split(",")[0];
                    try {
                        // Delete the client from the database
                        clientsDB.delete(clientID);
                        loadData(); // Update the displayed data
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
    }

    // Load client data into the JList
    private void loadData() {
        listModel.clear();
        List<Client> clients = clientsDB.list();
        for (Client client : clients) {
            listModel.addElement(client.getID() + ", " + client.getName()); 
        }
    }

    public static void main(String[] args) {
        DataBaseManager<Client> clientsDB = new DataBaseManager<>(DatabaseConfig.CLIENTS_FILE);
        new ClientWindow(clientsDB).setVisible(true);
    }
}

package GUI;

import Design.DatabaseConfig;
import Design.DataBaseManager;
import Design.Client;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientWindow extends JFrame {

    private DataBaseManager<Client> clientsDB;
    private JTable modelTable;
    private DefaultTableModel tableModel;

    public ClientWindow(DataBaseManager<Client> clientsDB) {
        this.clientsDB = clientsDB;

        // Configuración del JFrame
        setTitle("Clients Management");
        setLayout(new BorderLayout());
        setSize(1000, 500); // Ajustar tamaño para acomodar la tabla
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#F7F6F6")); // Fondo general
        
        // Panel para la tabla (con padding de 40px)
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.decode("#F7F6F6"));
        tablePanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40)); // Padding alrededor de la tabla

        // Configurar el modelo de la tabla
        String[] columnNames = {"ID", "Name", "Last Name", "Email", "Current Treatment", "Debt", "Additional Info"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas no sean editables directamente
            }
        };
        modelTable = new JTable(tableModel);

        // Ajustar tamaños de columnas
        modelTable.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        modelTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
        modelTable.getColumnModel().getColumn(2).setPreferredWidth(150); // Last Name
        modelTable.getColumnModel().getColumn(3).setPreferredWidth(200); // Email
        
         // Estilo de la tabla
        modelTable.setBackground(Color.decode("#FFFFFF")); // Fondo blanco para la tabla
        modelTable.setForeground(Color.decode("#000000")); // Texto en negro
        modelTable.getTableHeader().setBackground(Color.decode("#1F463A")); // Cabecera verde oscuro
        modelTable.getTableHeader().setForeground(Color.decode("#F7F6F6")); // Texto blanco en cabecera
        modelTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Fuente en negrita para la cabecera
        
        modelTable.setFont(new Font("Arial", Font.BOLD, 13));
        modelTable.setForeground(Color.BLACK);  // Establecer color de la fuente a negro

        
        JScrollPane scrollPane = new JScrollPane(modelTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
                
        // Añadir el panel de la tabla a la ventana
        add(tablePanel, BorderLayout.CENTER);

        // Cargar los datos de la base de datos
        loadData();

        // Panel de botones para operaciones CRUD (con padding de 40px)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.decode("#F7F6F6"));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40)); // Padding en el panel de botones

        // Estilo de los botones
        JButton addButton = new JButton("Add Client");
        addButton.setBackground(Color.decode("#1F463A"));
        addButton.setForeground(Color.decode("#F7F6F6"));
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setFocusPainted(false);
        addButton.setPreferredSize(new Dimension(150, 40));

        JButton modifyButton = new JButton("Modify Client");
        modifyButton.setBackground(Color.decode("#1F463A"));
        modifyButton.setForeground(Color.decode("#F7F6F6"));
        modifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        modifyButton.setFocusPainted(false);
        modifyButton.setPreferredSize(new Dimension(150, 40));

        JButton deleteButton = new JButton("Delete Client");
        deleteButton.setBackground(Color.decode("#1F463A"));
        deleteButton.setForeground(Color.decode("#F7F6F6"));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFocusPainted(false);
        deleteButton.setPreferredSize(new Dimension(150, 40));
        

        // Funcionalidad de los botones

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createClientDialog(null, false);
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = modelTable.getSelectedRow();
                if (selectedRow != -1) {
                    String clientID = (String) tableModel.getValueAt(selectedRow, 0);
                    Client clientToModify = clientsDB.consult(clientID);
        
                    if (clientToModify != null) {
                        createClientDialog(clientToModify, true);
                    }
                } else {
                    JOptionPane.showMessageDialog(ClientWindow.this, "Please select a client to modify.");
                }
            }
        });

        // Eliminar cliente existente
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = modelTable.getSelectedRow();
                if (selectedRow != -1) {
                    String clientID = (String) tableModel.getValueAt(selectedRow, 0);
                    try {
                        clientsDB.delete(clientID);
                        loadData(); // Actualizar datos en la tabla
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a client to delete.");
                }
            }
        });

        // Añadir los botones al panel
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);

        // Añadir el panel de botones a la ventana
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Cargar datos en el modelo de la tabla
    private void loadData() {
        tableModel.setRowCount(0); // Limpiar la tabla
        List<Client> clients = clientsDB.list();
        for (Client client : clients) {
            tableModel.addRow(new Object[]{
                client.getID(),
                client.getName(),
                client.getLast_Name(),
                client.getEmail(),
                client.isHasCurrTreat() ? "Yes" : "No",
                client.isHasDebt() ? "Yes" : "No",
                client.getAdd_Info()
            });
        }
    }
    
    private void createClientDialog(Client client, boolean isEditMode) {
        JDialog clientDialog = new JDialog(ClientWindow.this, isEditMode ? "Edit Client" : "Add Client", true);
        clientDialog.setLayout(new BorderLayout());
        clientDialog.setSize(400, 400);
        clientDialog.setLocationRelativeTo(ClientWindow.this);
    
        JPanel fieldsPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        // Campos del formulario
        
        JTextField nameField = createStyledTextField(isEditMode ? client.getName() : "");
        JTextField lastNameField = createStyledTextField(isEditMode ? client.getLast_Name() : "");
        JTextField emailField = createStyledTextField(isEditMode ? client.getEmail() : "");

        fieldsPanel.add(new JLabel("Name:"));
        fieldsPanel.add(nameField);
        fieldsPanel.add(new JLabel("Last Name:"));
        fieldsPanel.add(emailField);
        fieldsPanel.add(new JLabel("Email:"));
        fieldsPanel.add(lastNameField);
        
    
        fieldsPanel.add(new JLabel("Current Treatment:"));
        JCheckBox treatmentCheckBox = new JCheckBox("", isEditMode && client.isHasCurrTreat());
        fieldsPanel.add(treatmentCheckBox);
    
        fieldsPanel.add(new JLabel("Debt:"));
        JCheckBox debtCheckBox = new JCheckBox("", isEditMode && client.isHasDebt());
        fieldsPanel.add(debtCheckBox);
    
        fieldsPanel.add(new JLabel("Additional Info:"));
        JTextArea additionalInfoArea = new JTextArea(isEditMode ? client.getAdd_Info() : "");
        additionalInfoArea.setRows(3);
        JScrollPane scrollPane = new JScrollPane(additionalInfoArea);
        fieldsPanel.add(scrollPane);
    
        clientDialog.add(fieldsPanel, BorderLayout.CENTER);
    
        // Botones de acción
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton(isEditMode ? "Save" : "Add");
        JButton cancelButton = new JButton("Cancel");
    
        saveButton.addActionListener(event -> {
            // Validar datos básicos
            if (nameField.getText().trim().isEmpty() || lastNameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(clientDialog, "All fields are required.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
    
            if (isEditMode) {
                // Actualizar los datos del cliente existente
                client.setName(nameField.getText().trim());
                client.setLast_Name(lastNameField.getText().trim());
                client.setEmail(emailField.getText().trim());
                client.setHasCurrTreat(treatmentCheckBox.isSelected());
                client.setHasDebt(debtCheckBox.isSelected());
                client.setAdd_Info(additionalInfoArea.getText().trim());
    
                try {
                    clientsDB.modify(client);
                    loadData(); // Actualizar la tabla
                    clientDialog.dispose(); // Cerrar el diálogo
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(clientDialog, "Error saving client data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Crear un nuevo cliente
                String clientID = "C" + (clientsDB.list().size() + 1); // Generar un nuevo ID
                Client newClient = new Client(clientID, nameField.getText().trim(), lastNameField.getText().trim(), null, "", "", emailField.getText().trim(), treatmentCheckBox.isSelected(), debtCheckBox.isSelected(), additionalInfoArea.getText().trim());
    
                try {
                    clientsDB.add(newClient);
                    loadData(); // Actualizar la tabla
                    clientDialog.dispose(); // Cerrar el diálogo
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(clientDialog, "Error adding client.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
        cancelButton.addActionListener(event -> clientDialog.dispose()); // Cerrar el popup sin guardar
    
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
    
        clientDialog.add(buttonPanel, BorderLayout.SOUTH);
    
        // Mostrar el diálogo
        clientDialog.setVisible(true);
    }
    
    private JTextField createStyledTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        textField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        textField.setBorder(new Sign_Up.RoundedBorder(10));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        return textField;
    }

    public static void main(String[] args) {
        DataBaseManager<Client> clientsDB = new DataBaseManager<>(DatabaseConfig.CLIENTS_FILE);
        SwingUtilities.invokeLater(() -> new ClientWindow(clientsDB).setVisible(true));
    }
}




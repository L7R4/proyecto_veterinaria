package GUI;

import Design.DatabaseConfig;
import Design.DataBaseManager;
import Design.Employee;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeWindow extends JFrame {

    private DataBaseManager<Employee> employeeDB;
    private JList<String> employeeList;
    private DefaultListModel<String> listModel;

    public EmployeeWindow(DataBaseManager<Employee> employeeDB) {
        this.employeeDB = employeeDB;

        // Set up the JFrame
        setTitle("Employee Management");
        setLayout(new BorderLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set up the JList to display employee data
        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(employeeList);
        add(scrollPane, BorderLayout.CENTER);

        // Load data from the employee database
        loadData();

        // Add buttons for CRUD operations
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add Employee");
        JButton modifyButton = new JButton("Modify Employee");
        JButton deleteButton = new JButton("Delete Employee");

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Prompt the user to enter the employee's name
        String name = JOptionPane.showInputDialog("Enter employee name:");
        
        if (name != null && !name.trim().isEmpty()) {
            // Generate a simple unique employee ID (you can replace this with a better ID generation logic)
            String employeeID = "E" + (employeeDB.list().size() + 1); // Example simple ID generation (incremental)
            
            // Assuming default values for the other fields:
            double salary = 50000.0;  // Default salary
            String workArea = "General"; // Default work area
            String position = "Staff"; // Default position
            LocalDate hireDate = LocalDate.now(); // Use today's date as the hire date

            // Create a new Employee instance with the given and default values
            Employee newEmployee = new Employee("ID", name, "LastName", LocalDate.now(), "Address", "PhoneNumber", employeeID, salary, workArea, position, hireDate);

            try {
                // Add the new employee to the database
                employeeDB.add(newEmployee);
                loadData(); // Update the displayed data
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
});

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = employeeList.getSelectedValue();
                if (selectedId != null) {
                    // Modify the selected employee
                    String newName = JOptionPane.showInputDialog("Enter new name for employee:", selectedId);
                    if (newName != null) {
                        Employee employeeToModify = employeeDB.consult(selectedId.split(",")[0]);
                        if (employeeToModify != null) {
                            employeeToModify.setName(newName); // Assuming Employee class has a setter for name
                            try {
                                employeeDB.modify(employeeToModify);
                                loadData();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = employeeList.getSelectedValue();
                if (selectedId != null) {
                    try {
                        employeeDB.delete(selectedId.split(",")[0]);
                        loadData();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
    }

    private void loadData() {
        listModel.clear();
        List<Employee> employees = employeeDB.list();
        for (Employee employee : employees) {
            listModel.addElement(employee.getID() + ", " + employee.getName()); 
        }
    }

    public static void main(String[] args) {
        DataBaseManager<Employee> employeeDB = new DataBaseManager<>(DatabaseConfig.EMPLOYEES_FILE);
        new EmployeeWindow(employeeDB).setVisible(true);
    }
}

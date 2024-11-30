package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VeterinaryDashboard extends JFrame {
    private DefaultListModel<String> taskModel;
    private JTextArea agendaArea;

    public VeterinaryDashboard() {
       
        setTitle("Veles Veterinary Management System");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Panel for Sections
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setPreferredSize(new Dimension(220, 720));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); 
        addUserSection(leftPanel);  
        addSectionButtons(leftPanel);  
        addSettingsOption(leftPanel);  
        
    
        //Panel for Main Dashboard - Agenda
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(247, 247, 247));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        addProfileComponents(rightPanel);  

  
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
        loadAgendaAndTasks();  
    }

    private void addUserSection(JPanel leftPanel) {
    // Load and resize user image
    ImageIcon originalImage = new ImageIcon("C:/Users/aleja/OneDrive/Documentos/GUIVETAPP/User_DefaultPic/default_pic.png");
    Image resizedImage = originalImage.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
    ImageIcon userImageIcon = new ImageIcon(resizedImage);

    // User icon and name
    JLabel userIcon = new JLabel(userImageIcon);
    userIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel userName = new JLabel("Ryan Gosling");
    userName.setAlignmentX(Component.CENTER_ALIGNMENT);
    userName.setForeground(Color.WHITE);
    userName.setFont(new Font("SansSerif", Font.BOLD, 18));

    // Add components with spacing
    leftPanel.add(Box.createVerticalGlue()); // Push everything down
    leftPanel.add(userIcon);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    leftPanel.add(userName);
    leftPanel.add(Box.createRigidArea(new Dimension(0, 40))); // Extra space before sections
}

private void addSectionButtons(JPanel leftPanel) {
    String[] sections = {
        "Administration", "Clinical Records", "Appointments",
        "Inventory", "Billing and Payments", "Reports and Statistics"
    };

    Color[] hoverColors = {
        new Color(204, 163, 0),
        new Color(153, 102, 255),
        new Color(102, 204, 0),
        new Color(255, 102, 102),
        new Color(255, 153, 51),
        new Color(51, 153, 255)
    };

    
    for (int i = 0; i < sections.length; i++) {
        JLabel button = new JLabel(sections[i]);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.PLAIN, 16));
        button.setOpaque(true);
        button.setBackground(Color.BLACK);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        final Color hoverColor = hoverColors[i];
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
                button.setFont(new Font("SansSerif", Font.BOLD, 18));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.BLACK);
                button.setFont(new Font("SansSerif", Font.PLAIN, 16));
            }
        });

        leftPanel.add(button);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 25))); 
    }

    leftPanel.add(Box.createVerticalGlue()); 
}


    private void addSettingsOption(JPanel leftPanel) {
        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsLabel.setForeground(Color.LIGHT_GRAY);
        settingsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        settingsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        settingsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                settingsLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingsLabel.setForeground(Color.LIGHT_GRAY);
            }
        });

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(settingsLabel);
    }
    
    private void addSeparator(JPanel leftPanel){
        JPanel separator = new JPanel();
        separator.setBackground(new Color(247, 247, 247));
        separator.setPreferredSize(new Dimension(50, 50));
        separator.setAlignmentX(Component.RIGHT_ALIGNMENT);
    }

    private void addProfileComponents(JPanel rightPanel) {
        JLabel dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        dateTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy HH:mm:ss");
            dateTimeLabel.setText(sdf.format(new Date()));
        });
        timer.start();
        rightPanel.add(dateTimeLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel agendaLabel = new JLabel("Agenda:");
        agendaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        agendaArea = new JTextArea(5, 5);
        agendaArea.setLineWrap(true);
        agendaArea.setWrapStyleWord(true);
        agendaArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(agendaLabel);
        rightPanel.add(new JScrollPane(agendaArea));
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel taskLabel = new JLabel("Today Tasks:");
        taskLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        taskModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskModel);
        JButton addTaskButton = new JButton("Add Task");
        JTextField taskInput = new JTextField(15);
        JButton deleteTaskButton = new JButton("Delete Task");
        JButton saveButton = new JButton("Save");

        addTaskButton.addActionListener(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                taskModel.addElement(task);
                taskInput.setText("");
                JOptionPane.showMessageDialog(this, "The task was added succesfully");
            } else {
                JOptionPane.showMessageDialog(this, "Add Task", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteTaskButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskModel.remove(selectedIndex);
                JOptionPane.showMessageDialog(this, "The task was deleted");
            } else {
                JOptionPane.showMessageDialog(this, "Please, select a task to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        saveButton.addActionListener(e -> saveAgendaAndTasks());

        rightPanel.add(taskLabel);
        rightPanel.add(new JScrollPane(taskList));
        rightPanel.add(taskInput);
        rightPanel.add(addTaskButton);
        rightPanel.add(deleteTaskButton);
        rightPanel.add(saveButton);
    }

    private void saveAgendaAndTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("agenda.txt"))) {
            writer.write(agendaArea.getText());
            writer.newLine();
            for (int i = 0; i < taskModel.size(); i++) {
                writer.write(taskModel.getElementAt(i));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Agenda and tasks saved succesfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadAgendaAndTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("agenda.txt"))) {
            String line;
            if ((line = reader.readLine()) != null) {
                agendaArea.setText(line);
            }
            taskModel.clear();
            while ((line = reader.readLine()) != null) {
                taskModel.addElement(line);
            }
        } catch (IOException e) {
            System.out.println("Could not load agenda and tasks");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VeterinaryDashboard::new);
    }
}

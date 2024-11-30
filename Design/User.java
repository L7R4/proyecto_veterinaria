package Design;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    
    //Attributes
    private String username;
    private String password;
    private String security_Answer;
    
    private static final String USERS_FILE = "USERS_FILE";
    
    //Empty Constructor
    public User() {
    }
    
    //Constructor
    public User(String username, String password, String security_Answer) {
        this.username = username;
        this.password = password;
        this.security_Answer = security_Answer;
    }
    
    //Getters and Setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity_Answer() {
        return this.security_Answer;
    }

    public void setSecurity_Answer(String security_Answer) {
        this.security_Answer = security_Answer;
    }

    //Methods
    
    // Save the user data to USERS_FILE
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(username + "," + password + "," + security_Answer);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Load all users from USERS_FILE
    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    users.add(new User(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    // Find user for login purposes
    public static User findUser(String username, String password) {
        List<User> users = loadUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Find user by username and security answer
    public static User findUserBySecurityQuestion(String username, String securityAnswer) {
        List<User> users = loadUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getSecurity_Answer().equals(securityAnswer)) {
                return user;
            }
        }
        return null;
    }

    // Update user information in the file
    public void updateInFile() {
        List<User> users = loadUsers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                if (user.getUsername().equals(this.username)) {
                    writer.write(this.username + "," + this.password + "," + this.security_Answer);
                } else {
                    writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getSecurity_Answer());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package auth;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

import adminmodules.AdminDashboard;
import models.User;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AuthFunctions {
    public static void login(String userRole, String userEmail, String userPassword, JFrame frame) throws FileNotFoundException {
        File file = new File("src\\storage\\userDetails.csv");
        Scanner scan = new Scanner(file);
    
        // Authenticate the user
        User loggedInUser = userAuthentication(scan, userRole, userEmail, userPassword, ",");
    
        if (loggedInUser != null) {
            // Show success message
            JOptionPane.showMessageDialog(null, "Successfully logged in!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
    
            // Check if the logged-in user is an admin
            if (loggedInUser.getUserType().equals("Admin")) {
                frame.dispose();
                new AdminDashboard(loggedInUser);  // Proceed to the Admin Dashboard
            }
        } 
        // If login fails, the error messages are already handled inside userAuthentication
    }
    
    

    public static User userAuthentication(Scanner scan, String userType, String userEmail, String userPassword, String regex) {
        boolean emailExists = false;
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] credentials = line.split(regex);
            
            // Ensure the line has the expected number of fields (8 fields)
            if (credentials.length < 8) {
                continue; // Skip lines that don't have the right number of fields
            }
    
            // Extract user details
            String emailFromFile = credentials[0];
            String passwordFromFile = credentials[1];
            String phoneNumberFromFile = credentials[2];
            String userTypeFromFile = credentials[3];
            String firstNameFromFile = credentials[4];
            String lastNameFromFile = credentials[5];
            String driversLicenseFromFile = credentials[6];
            String userIDFromFile = credentials[7];
    
            // Check for matching email
            if (userEmail.equals(emailFromFile)) {
                emailExists = true;
                // Check for matching password and role
                if (userPassword.equals(passwordFromFile) && userType.equals(userTypeFromFile)) {
                    // Return a new User object if authentication is successful
                    return new User(emailFromFile, passwordFromFile, phoneNumberFromFile, userTypeFromFile, firstNameFromFile, lastNameFromFile, driversLicenseFromFile, userIDFromFile);
                }
            }
        }
    
        if (!emailExists) {
            JOptionPane.showMessageDialog(null, "Email does not exist", "Login Failed", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password or user type", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    
        // Return null if authentication fails
        return null;
    }    
    
}

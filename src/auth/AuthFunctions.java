package auth;

import java.io.*;
import java.util.Scanner;

import adminmodules.AdminDashboard;
import models.User;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import ownermodules.OwnerDashboard;

public class AuthFunctions {
    public static void login(String userRole, String userEmail, String userPassword, JFrame frame) throws FileNotFoundException, UnsupportedLookAndFeelException {
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

            if (loggedInUser.getUserType().equals("Car owner")) {
                frame.dispose();
                new OwnerDashboard(loggedInUser);
            }
        } 
        // If login fails, the error messages are already handled inside userAuthentication
    }
    
    

    public static User userAuthentication(Scanner scan, String userType, String userEmail, String userPassword, String regex) {
        boolean emailExists = false;
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();  // Trim leading and trailing spaces
            
            // Skip empty lines or lines with only spaces
            if (line.isEmpty()) {
                continue;  // Move to the next iteration
            }
            
            // Split the line into credentials using the regex
            String[] credentials = line.split(regex);
            
            // Ensure the line has the expected number of fields (e.g., 9 fields)
            if (credentials.length < 9) {
                continue;  // Skip lines that don't have enough fields
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
            String userStatusFromFile = credentials[8];
        
            // Check for matching email
            if (userEmail.equals(emailFromFile)) {
                emailExists = true;
                // Check for matching password and role
                if (userPassword.equals(passwordFromFile) && userType.equals(userTypeFromFile)) {
                    // Trim spaces from userStatusFromFile before comparison
                    String trimmedStatus = userStatusFromFile.trim();
                    if (trimmedStatus.equals("approved")) {
                        // Return a new User object if authentication is successful
                        return new User(emailFromFile, passwordFromFile, phoneNumberFromFile, userTypeFromFile, firstNameFromFile, lastNameFromFile, driversLicenseFromFile, userIDFromFile, userStatusFromFile);
                    } else if (trimmedStatus.equals("pending")) {
                        JOptionPane.showMessageDialog(null, "The user was not approved yet", "Pending approval", JOptionPane.ERROR_MESSAGE);
                        return null;
                    } else {
                        JOptionPane.showMessageDialog(null, "This user has the access declined", "Invalid user", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                }
            }
        }
    
        if (!emailExists) {
            JOptionPane.showMessageDialog(null, "Email does not exist in the system", "Login Failed", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password or user type", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    
        // Return null if authentication fails
        return null;
    }    

    static int generateUserID() {
        int userID = 0;
        String filePath = "src/storage/userDetails.csv"; // Ensure this path is correct

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;  // To identify the header line
            while ((line = br.readLine()) != null) {
                // Skip the header line
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;  // Skip this iteration for the header
                }

                String[] details = line.split(",");
                // Check if the last column (userID) is available
                if (details.length > 7) {  // Ensure there are enough columns
                    String userIdStr = details[7].trim();  // Assuming the userID is in the 8th column (index 7)
                    if (!userIdStr.isEmpty()) {  // Only parse if it's not empty
                        try {
                            int id = Integer.parseInt(userIdStr);
                            if (id > userID) {
                                userID = id;  // Keep track of the highest ID
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error parsing user ID: " + userIdStr);
                        }
                    }
                } else {
                    System.out.println("Row does not have enough fields: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return userID + 1;  // Return the next available ID
    }
}

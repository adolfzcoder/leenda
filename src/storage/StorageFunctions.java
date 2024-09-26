package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StorageFunctions {
    // Function to count the number of records in the CSV file
    public static int countRecords(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        int recordCount = 0;
        
        // Skip the first line if it's a header
        if (scan.hasNextLine()) {
            scan.nextLine();  // Skip the header line
        }

        // Loop through the file and count each record
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // You can add conditions to skip comment lines or empty lines if needed
            if (!line.startsWith("#") && !line.trim().isEmpty()) {
                recordCount++;
            }
        }
        
        scan.close();
        return recordCount;
    }

    // Function to count the number of inactive users in the CSV file
    public static int countInactiveUsers(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        int inactiveUsersCount = 0;
    
        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
    
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] userDetails = line.split(",");
    
            // Check if the line has enough columns before accessing
            if (userDetails.length > 8) { // Assuming the status is the 9th column (index 8)
                String status = userDetails[8].trim(); // Adjust index if necessary
                if (!status.equalsIgnoreCase("approved")) {
                    inactiveUsersCount++;
                }
            } else {
                System.out.println("Skipping line due to insufficient columns: " + line);
            }
        }
        scan.close();
        return inactiveUsersCount;
    }
    

    public static int countBookedCars(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        int availableCarsCount = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");
            
            // Assuming the status is at the 7th index (status column)
            String status = carDetails[6].trim();

            if (status.equalsIgnoreCase("booked")) {
                availableCarsCount++;
            }
        }

        scan.close();
        return availableCarsCount;
    }


    public static int countBookedCarsForCarOwner(String filePath, String userEmail) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        int availableCarsCount = 0;

        // Skip the first line (header)
        // first line has structure of  the file

        if (scan.hasNextLine()) {
            scan.nextLine();
        }


        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");
            
            // Assuming the status is at the 7th index (status column)
            String status = carDetails[6].trim();
            String email = carDetails[0];

            if (status.equalsIgnoreCase("booked") && email.equalsIgnoreCase(userEmail)) {
                availableCarsCount++;
            }
        }

        scan.close();
        return availableCarsCount;
    }

    // Function to count completed bookings
    public static int countCompletedBookings(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        int completedBookingsCount = 0;
        
        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bookingDetails = line.split(",");
            for(int i=0; i < bookingDetails.length; i ++){
                System.out.println(bookingDetails[i] + " index: " + i);
            }
            System.out.println();
            // Assuming the status is at the 8th index (status column)
            String status = bookingDetails[7].trim();

            if (status.equalsIgnoreCase("completed")) {
                completedBookingsCount++;
            }
        }

        scan.close();
        return completedBookingsCount;
    }

    public static int countActiveRentals(String carDetailsPath, String email) throws FileNotFoundException {

        var file = new File(carDetailsPath);
        Scanner scan = new Scanner(file);
        int availableCarsCount = 0;

        // Skip the first line (header)
        // first line has structure of  the file

        if (scan.hasNextLine()) {
            scan.nextLine();
        }


        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");
            
            // Assuming the status is at the 7th index (status column)
            String status = carDetails[6].trim();
            String emailFromFile = carDetails[0];

            if (status.equalsIgnoreCase("completed") && emailFromFile.equalsIgnoreCase(email)) {
                availableCarsCount++;
            }
        }

        scan.close();
        return availableCarsCount;

    }
    // Function to count cancelled bookings
    public static int countCancelledBookings(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        int cancelledBookingsCount = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bookingDetails = line.split(",");

            // Assuming the status is at the 8th index (status column)
            String status = bookingDetails[7].trim();

            if (status.equalsIgnoreCase("cancelled")) {
                cancelledBookingsCount++;
            }
        }

        scan.close();
        return cancelledBookingsCount;
    }

    // Function to calculate total revenue from completed bookings
    public static double calculateTotalRevenue(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        double totalRevenue = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bookingDetails = line.split(",");

            // Assuming the total price is at the 5th index (totalPrice column)
            // and the status is at the 8th index
            String status = bookingDetails[7].trim();
            if (status.equalsIgnoreCase("completed")) {
                double totalPrice = Double.parseDouble(bookingDetails[4].trim());
                totalRevenue += totalPrice;
                
            }
            // the admin (the company) gets 15% of all the revenue
            // totalRevenue = totalRevenue * 0.15;
        }

        scan.close();
        return totalRevenue;
    }

    public static double calculateOwnerRevenue(String carDetailsPath, String email) throws FileNotFoundException {
        File file = new File(carDetailsPath);
        Scanner scan = new Scanner(file);
        double totalRevenue = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bookingDetails = line.split(",");

            // Assuming the total price is at the 5th index (totalPrice column)
            // and the status is at the 8th index
            String status = bookingDetails[7].trim();
            String emailFromFile = bookingDetails[0].trim();
            if (status.equalsIgnoreCase("completed") && emailFromFile.equalsIgnoreCase(email)) {
                double totalPrice = Double.parseDouble(bookingDetails[4].trim());
                totalRevenue += totalPrice;
                
            }
            // the admin (the company) gets 15% of all the revenue
            // totalRevenue = totalRevenue * 0.15;
        }

        scan.close();
        return totalRevenue;
    }


    public static void updateUserRecord(User updatedUser) throws IOException {
        File file = new File("src\\storage\\userDetails.csv");
        List<String> fileContent = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(updatedUser.getEmail())) {
                    // Update the line with new user information
                    line = updatedUser.getEmail() + "," +
                           updatedUser.getPassword() + "," +
                           updatedUser.getPhoneNumber() + "," +
                           updatedUser.getUserType() + "," +
                           updatedUser.getFirstName() + "," +
                           updatedUser.getLastName() + "," +
                           updatedUser.getDriversLicense() + "," +
                           updatedUser.getUserID();
                }
                fileContent.add(line);
            }
        }

        // Write the updated content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void populateTable(JTable table, String filePath) throws FileNotFoundException {
        // Define the column names based on your table headers
        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Driver License", "User Type"};

        // Create a table model with the column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Open the CSV file
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        
        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        // Read each line and add rows to the table, excluding the password column
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] userDetails = line.split(",");
            
            // Only add the relevant columns in the specified order
            String[] rowData = {
                userDetails[7], // user ID
                userDetails[4], // first name
                userDetails[5], // last name
                userDetails[0], // email
                userDetails[2], // phone number
                userDetails[6], // driver's license
                userDetails[3]  // user type
            };

            // Add the row to the table model
            model.addRow(rowData);
        }

        scan.close();
        
        // Set the model to the JTable
        table.setModel(model);
    }

    public static void updateUser(String userIdToEdit, String newFirstName, String newLastName, 
                                   String newPhoneNumber, String newEmail, String loggedInUserId) throws IOException {
        File file = new File("src\\storage\\userDetails.csv");
        List<String> lines = new ArrayList<>();
        boolean emailExists = false;
        boolean isLoggedInUser = false;

        // Read the file and check for the constraints
        try (Scanner scan = new Scanner(file)) {
            // Skip the header
            if (scan.hasNextLine()) {
                lines.add(scan.nextLine()); // Keep the header
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] userDetails = line.split(",");

                // Check for existing email
                if (newEmail.equals(userDetails[0])) {
                    emailExists = true;
                }
                
                // Check if we are editing the logged-in user's record
                if (userIdToEdit.equals(loggedInUserId)) {
                    isLoggedInUser = true;
                }

                // Update the user details if userID matches the one to edit
                if (userDetails[6].equals(userIdToEdit)) {
                    line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                            userDetails[0],  // Email
                            userDetails[1],  // Password
                            newPhoneNumber,   // New phone number
                            userDetails[3],  // User type
                            newFirstName,     // New first name
                            newLastName,      // New last name
                            userDetails[6],   // Driver's license
                            userIdToEdit,     // ID remains the same
                            userDetails[8]);  // Status
                }

                lines.add(line);
            }
        }

        // Check constraints
        if (isLoggedInUser) {
            JOptionPane.showMessageDialog(null, "Cannot edit your own information.", "Update Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (emailExists) {
            JOptionPane.showMessageDialog(null, "Email already exists in the database.", "Update Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Write the updated data back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(null, "User information updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "File Write Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	

}


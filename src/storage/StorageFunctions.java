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
            scan.nextLine(); // Skip the header line
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
        int bookedCars = 1;

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
                bookedCars++;
            }

            
        }
        scan.close();
        

        if (bookedCars == 1){
            bookedCars = 0;
            return bookedCars;
        }
        return bookedCars;
    }

    
    // Function to count the currentl ybooked cars accoriding to the car owner 
    public static int currentlyBookedCars(String carOwnerEmail){
        String carDetailsPath = "src\\storage\\cars.csv";
        int bookedCars = 0;
        try {
            bookedCars = countBookedCarsForCarOwner(carDetailsPath, carOwnerEmail);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bookedCars;
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
            for (int i = 0; i < bookingDetails.length; i++) {
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
        String[] columnNames = { "ID", "First Name", "Last Name", "Email", "Phone Number", "Driver License",
                "User Type", "Status" };

        // Create a new table model
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Open the CSV file
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        // Clear the table model before populating it
        model.setRowCount(0);

        // Read each line and add rows to the table, excluding the password column
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] userDetails = line.split(",");

            // Ensure that each row has enough data to populate the table
            if (userDetails.length >= 9) {
                // Only add the relevant columns in the specified order
                String[] rowData = {
                        userDetails[7], // user ID
                        userDetails[4], // first name
                        userDetails[5], // last name
                        userDetails[0], // email
                        userDetails[2], // phone number
                        userDetails[6], // driver's license
                        userDetails[3], // user type
                        userDetails[8] // user status
                };

                // Add the row to the table model
                model.addRow(rowData);
            }
        }

        scan.close();

        // Clear the table before setting the new model (Step 1: Ensure existing rows
        // are removed)
        ((DefaultTableModel) table.getModel()).setRowCount(0);

        // Apply the new model to the table (Step 2: Set the new model explicitly)
        table.setModel(model);

        // Force the table to refresh its display (Step 3: Ensure the UI reflects the
        // changes)
        table.revalidate();
        table.repaint();
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
                            userDetails[0], // Email
                            userDetails[1], // Password
                            newPhoneNumber, // New phone number
                            userDetails[3], // User type
                            newFirstName, // New first name
                            newLastName, // New last name
                            userDetails[6], // Driver's license
                            userIdToEdit, // ID remains the same
                            userDetails[8]); // Status
                }

                lines.add(line);
            }
        }

        // Check constraints
        if (isLoggedInUser) {
            JOptionPane.showMessageDialog(null, "Cannot edit your own information.", "Update Failed",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (emailExists) {
            JOptionPane.showMessageDialog(null, "Email already exists in the database.", "Update Failed",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Write the updated data back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(null, "User information updated successfully!", "Update Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "File Write Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String getCurrentUserStatus(String userID) {
        String filePath = "src\\storage\\userDetails.csv";
        String line;
        String[] userDetails;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                userDetails = line.split(",");
                if (userDetails[7].trim().equals(userID)) {
                    return userDetails[8].trim(); // Return the current status
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return null; // User not found
    }

    public static void updateUserStatus(String userID, String newStatus) {
        String filePath = "src/storage/userDetails.csv"; // Adjust the file path as necessary
        StringBuilder updatedContent = new StringBuilder();
        String line;
        String[] userDetails;
        boolean userFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                userDetails = line.split(",");

                // Check if this is the user we want to update
                if (userDetails[7].trim().equals(userID)) {
                    userDetails[8] = newStatus;
                    userFound = true;
                }

                // Append the (possibly modified) line back to the updated content
                updatedContent.append(String.join(",", userDetails)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        if (userFound) {
            // Write the updated content back to the file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(updatedContent.toString());
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        } else {
            // Optionally handle the case where the user was not found
            JOptionPane.showMessageDialog(null, "User ID not found. Status update failed.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }



    /***
     * Car Owner dashbaord Functions
     *
     */


    /*
     * This method returns the number of currently booked cars. The user email for
     * the car owner is passed in as a parameter and it is used to go into the csv
     * file then extract all the data associated with that booking and the car owner
     */
    public static int countBookedCarsForCarOwner(String filePath, String userEmail) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        int availableCarsCount = 0;

        // Skip the first line (header)
        // first line has structure of the file

        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");

            // Assuming the status is at the 7th index (status column)
            String status = carDetails[6].trim();
            String email = carDetails[8];

            if (status.equalsIgnoreCase("booked") && email.equalsIgnoreCase(userEmail)) {
                availableCarsCount++;
            }
        }

        scan.close();
        return availableCarsCount;
    }


    public static double calculateOwnerRevenue(String carOwnerEmail) throws FileNotFoundException {
        File file = new File("src\\storage\\bookings.csv");
        Scanner scan = new Scanner(file);
        double totalRevenue = 0;

        // Skip the first line (header) as it contains the column details
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bookingDetails = line.split(",");

            // status is at the 7th index
            // total price is at the 4th index (totalPrice column)
            // car owner email at the 8th index
            String status = bookingDetails[7].trim();
            String emailFromFile = bookingDetails[8].trim();
            if (status.equalsIgnoreCase("completed") && emailFromFile.equalsIgnoreCase(carOwnerEmail)) {
                double price = Double.parseDouble(bookingDetails[4].trim());
                totalRevenue += price;

                /* Debugging statements, to check if have the right indexes */
                // System.out.println(price);
                // System.out.println(totalRevenue);
            }
            // the admin (the company) gets 15% of all the revenue
            // totalRevenue = totalRevenue - (totalRevenue * 0.15);
        }

        scan.close();
        return totalRevenue;
    }

    /*
     * This method allows to count the number of active rentals from the passed in
     * filePath, and it returns only the values for the currently logged in user
     * (the car owner(s))
     */
    public static int countActiveRentals(String carDetailsPath, String carOwnerEmail) throws FileNotFoundException {

        var file = new File(carDetailsPath);
        Scanner scan = new Scanner(file);
        int availableCarsCount = 0;

        // Skip the first line (header)
        // first line has structure of the file

        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");

            // Assuming the status is at the 7th index (status column)
            String status = carDetails[6].trim();
            String emailFromFile = carDetails[9];

            if (status.equalsIgnoreCase("booked") && emailFromFile.equalsIgnoreCase(carOwnerEmail)) {
                availableCarsCount++;
            }
        }

        scan.close();
        return availableCarsCount;

    }


    public static int countCarsByOwnerEmail(String CarOwnerEmail) throws FileNotFoundException {
        // TODO Auto-generated method stub
        String carDetailsPath = "src\\storage\\cars.csv";
        File file = new File(carDetailsPath);
        Scanner scan = new Scanner(file);
        int carCount = 1;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");
            // for(int i=0; i < bookingDetails.length; i ++){
            // System.out.println(bookingDetails[i] + " index: " + i);
            // }
            // System.out.println();
            // Assuming the status is at the 8th index (status column)
            String status = carDetails[6].trim();
            String carOwnerEmailFromFile = carDetails[9];

            if (status.equalsIgnoreCase("available") && CarOwnerEmail.equalsIgnoreCase(carOwnerEmailFromFile)) {
                carCount = carCount + 1;
            }
            
        }
        scan.close();

        if (carCount == 1){
            carCount = 0;
            return 0;
        }

        scan.close();
        return carCount;
    }
    // get the total number of bookings the user has made.
    public static int countBookingsByUserEmail(String userEmail) throws FileNotFoundException {
        // TODO Auto-generated method stub
        String bookingDetailsPath = "src\\storage\\bookings.csv";
        File file = new File(bookingDetailsPath);
        Scanner scan = new Scanner(file);
        int bookingCount = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bookingDetails = line.split(",");
            // for(int i=0; i < bookingDetails.length; i ++){
            // System.out.println(bookingDetails[i] + " index: " + i);
            // }
            // System.out.println();
            // Assuming the status is at the 8th index (status column)
            String status = bookingDetails[7].trim();
            String userEmailFromFile = bookingDetails[8];

            if (status.equalsIgnoreCase("booked") && userEmail.equalsIgnoreCase(userEmailFromFile)) {
                bookingCount++;
            }
        }

        scan.close();
        return bookingCount;

        
    }

    // Function is missing checking the car owners email, currently it is just fetching and adding all the values in the booking.csv
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




    /***
     * 
     * Booking page functions
     * @throws FileNotFoundException 
     * 
     */


    public static int countAvailableCars(String email) throws FileNotFoundException {
        // TODO Auto-generated method stub
        String carDetailsPath = "src\\storage\\cars.csv";
        File file = new File(carDetailsPath);
        Scanner scan = new Scanner(file);
        int carCount = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");
            // for(int i=0; i < bookingDetails.length; i ++){
            // System.out.println(bookingDetails[i] + " index: " + i);
            // }
            // System.out.println();
            // Assuming the status is at the 8th index (status column)
            String status = carDetails[6].trim();
            String carOwnerEmailFromFile = carDetails[9];

            if (status.equalsIgnoreCase("available") && email.equalsIgnoreCase(carOwnerEmailFromFile)) {
                carCount++;
            }
        }

        scan.close();
        return carCount;
    }


    /*
     * 
     * Customer page functions
     * 
     */
    public static double getCustomerSpening(String customerEmail) throws FileNotFoundException{

        File file = new File("src\\storage\\bookings.csv");
        Scanner scan = new Scanner(file);
        double totalSpending = 0;

        // Skip the first line (header) as it contains the column details
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            var line = scan.nextLine();
            String[] bookingDetails = line.split(",");

            // status is at the 7th index
            // total price is at the 4th index (totalPrice column)
            // car owner email at the 8th index
            String status = bookingDetails[7].trim();
            String emailFromFile = bookingDetails[0].trim();
            if (status.equalsIgnoreCase("completed") && emailFromFile.equalsIgnoreCase(customerEmail)) {
                double price = Double.parseDouble(bookingDetails[4].trim());
                totalSpending += price;

                /* Debugging statements, to check if have the right indexes */
                // System.out.println(price);
                // System.out.println(totalSpending);
            }
            // the admin (the company) gets 15% of all the revenue
            // totalSpending = totalSpending - (totalSpending * 0.15);
        }

        scan.close();
        return totalSpending;


    }

    public static int countTotalDaysRented(String customerEmail) throws FileNotFoundException {
        File file = new File("src\\storage\\bookings.csv");
        Scanner scan = new Scanner(file);
        int totalDaysRented = 0;
    
        // Skip the first line (header) as it contains the column details
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
    
        while (scan.hasNextLine()) {
            var line = scan.nextLine();
            String[] bookingDetails = line.split(",");
    
            // status is at the 7th index
            // total price is at the 4th index (totalPrice column)
            // car owner email at the 8th index
            String status = bookingDetails[7].trim();
            String emailFromFile = bookingDetails[8].trim();
            if (status.equalsIgnoreCase("completed") && emailFromFile.equalsIgnoreCase(customerEmail)) {
                int days = Integer.parseInt(bookingDetails[6].trim()); // Parse the string to an integer
                totalDaysRented += days;
            }
        }
    
        scan.close();
        return totalDaysRented; 
    }

    public static int countTotalBookings(String customerEmail) throws FileNotFoundException{
        File file = new File("src\\storage\\bookings.csv");
        Scanner scan = new Scanner(file);
        int totalBookings = 0;
    
        // Skip the first line (header) as it contains the column details
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
        while (scan.hasNextLine()) {
            var line = scan.nextLine();
            String[] bookingDetails = line.split(",");

            String emailFromFile = bookingDetails[0].trim();
            if (emailFromFile.equalsIgnoreCase(customerEmail)) {
                totalBookings ++;
            }
        }
    
        scan.close();
        return totalBookings;
    }

	public static int countCanceledBookings(String customerEmail) throws FileNotFoundException{
		// TODO Auto-generated method stub
        var carDetailsPath = "src\\storage\\bookings.csv";
        File file = new File(carDetailsPath);
        Scanner scan = new Scanner(file);
        int cancelledBookingCount = 0;

        // Skip the first line (header)
        if (scan.hasNextLine()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] carDetails = line.split(",");
            // for(int i=0; i < bookingDetails.length; i ++){
            // System.out.println(bookingDetails[i] + " index: " + i);
            // }
            // System.out.println();
            // Assuming the status is at the 8th index (status column)
            String status = carDetails[6].trim();
            String carOwnerEmailFromFile = carDetails[0];

            if (status.equalsIgnoreCase("cancelled") && customerEmail.equalsIgnoreCase(carOwnerEmailFromFile)) {
                cancelledBookingCount++;
            }
        }

        scan.close();
        return cancelledBookingCount;
	}


}

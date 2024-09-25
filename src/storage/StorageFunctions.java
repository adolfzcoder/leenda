package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.User;

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
                if (status.equalsIgnoreCase("inactive")) {
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
        }

        scan.close();
        return totalRevenue;
    }

    public static void updateUserRecord(User updatedUser) throws IOException {
        File file = new File("src/storage/userDetails.csv");
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
}

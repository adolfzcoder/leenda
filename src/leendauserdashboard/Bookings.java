package leendauserdashboard;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Bookings extends javax.swing.JFrame {
    private String userEmail;
    private DefaultTableModel tableModel;

    public Bookings(String userEmail) {
        this.userEmail = userEmail;
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Booking ID");
        tableModel.addColumn("Start Date");
        tableModel.addColumn("End Date");
        tableModel.addColumn("Total Price");
        tableModel.addColumn("Car Name");
        tableModel.addColumn("Days Renting");
        tableModel.addColumn("Status");
        tableModel.addColumn("Car Owner Email");

        jTable1.setModel(tableModel);

        readBookingsFromCSV();
    }

    private void readBookingsFromCSV() {
        String csvFile = "src/storage/bookings.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].equals(userEmail)) {
                    tableModel.addRow(new Object[] {
                        columns[1], // bookingID
                        columns[2], // startDate
                        columns[3], // endDate
                        columns[4], // totalPrice
                        columns[5], // carName
                        columns[6], // daysRenting
                        columns[7], // status
                        columns[8]  // carOwnerEmail
                    });
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
    private javax.swing.JTable jTable1;

}
package adminmodules;

import static adminmodules.Functions.changeColorOfTheLabelOfTheHeaderWhenEntering;
import static adminmodules.Functions.changeColorOfTheLabelOfTheHeaderWhenExiting;

import models.User;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import auth.LoginPage;

import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author kondwani
 */
public class BookingPage extends javax.swing.JFrame {
        public static User user;

        public BookingPage(User user) {
                // Set Nimbus look and feel
                try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                | UnsupportedLookAndFeelException e) {
                        e.printStackTrace(); // Handle any exceptions
                }

                this.setTitle("BookingPage");
                initComponents();

                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.user = user;

                try {
                        // Call the method and pass the path to your CSV file
                        populateTable(tblBooking);
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                }

                this.setVisible(true);
        }

        public static void populateTable(JTable table) throws FileNotFoundException {
                // Define the column names for the table
                String[] columnNames = { "Booking ID", "Renter Name", "Rentee Name", "Start Date", "End Date",
                                "Total Price", "Status", "Car Name" };

                // Create a new table model
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                // Load data from all three CSV files into Maps for easy lookup
                Map<String, String[]> userMap = loadUserDetails("src\\storage\\userDetails.csv");
                Map<String, String[]> carMap = loadCarDetails("src\\storage\\cars.csv");

                // Open and read the bookings CSV file
                File file = new File("src\\storage\\bookings.csv");
                Scanner scan = new Scanner(file);

                // Skip the first line (header)
                if (scan.hasNextLine()) {
                        scan.nextLine();
                }

                // Clear the table model before populating it
                model.setRowCount(0);

                // Read each line from bookings.csv and merge data from the other two files
                while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        String[] bookingDetails = line.split(",");

                        // Extract booking details
                        String bookingID = bookingDetails[1];
                        String renterEmail = bookingDetails[8]; // carOwnerEmail
                        String renteeEmail = bookingDetails[0]; // userEmail (customer)
                        String startDate = bookingDetails[2];
                        String endDate = bookingDetails[3];
                        String totalPrice = bookingDetails[4];
                        String status = bookingDetails[7]; // booking status

                        String carID = "NaN"; // car ID


                        // Look up renter and rentee names using the user map
                        String[] renterDetails = userMap.get(renterEmail);
                        String[] renteeDetails = userMap.get(renteeEmail);
                        String renterName = renterDetails != null ? renterDetails[0] + " " + renterDetails[1]
                                        : "Unknown";
                        String renteeName = renteeDetails != null ? renteeDetails[0] + " " + renteeDetails[1]
                                        : "Unknown";

                        // Look up car name using the car map
                        String[] carDetails = carMap.get(carID);

                        String carName = carDetails != null ? carDetails[2] : "Unknown";


                        // Add the merged data as a row in the table model
                        model.addRow(new Object[] { bookingID, renterName, renteeName, startDate, endDate, totalPrice,
                                        status, carName });
                }

                scan.close();

                // Apply the model to the table
                table.setModel(model);
                table.revalidate();
                table.repaint();
        }

        // Load user details into a map: key = userEmail, value = {firstName, lastName}
        private static Map<String, String[]> loadUserDetails(String filePath) throws FileNotFoundException {
                Map<String, String[]> userMap = new HashMap<>();
                File file = new File(filePath);
                Scanner scan = new Scanner(file);

                // Skip the header
                if (scan.hasNextLine()) {
                        scan.nextLine();
                }

                // Read each line and store user details
                while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        String[] userDetails = line.split(",");
                        if (userDetails.length >= 6) {
                                // Key is userEmail, value is {firstName, lastName}
                                userMap.put(userDetails[0], new String[] { userDetails[4], userDetails[5] });
                        }
                }

                scan.close();
                return userMap;
        }

        // Load car details into a map: key = carID, value = {carID, carName}
        private static Map<String, String[]> loadCarDetails(String filePath) throws FileNotFoundException {
                Map<String, String[]> carMap = new HashMap<>();
                File file = new File(filePath);
                Scanner scan = new Scanner(file);

                // Skip the header
                if (scan.hasNextLine()) {
                        scan.nextLine();
                }

                // Read each line and store car details
                while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        String[] carDetails = line.split(",");
                        if (carDetails.length >= 3) {
                                // Key is carID, value is {carID, carName}
                                carMap.put(carDetails[1], new String[] { carDetails[1], carDetails[2] });
                        }
                }

                scan.close();
                return carMap;
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                lblDashboard = new javax.swing.JLabel();
                lblBooking = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                lblCarListing = new javax.swing.JLabel();
                lblUsermanagement = new javax.swing.JLabel();
                btnLogOut = new javax.swing.JButton();
                jPanel4 = new javax.swing.JPanel();
                jLabel8 = new javax.swing.JLabel();
                btnPrintBookings = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                tblBooking = new javax.swing.JTable();
                jPanel5 = new javax.swing.JPanel();
                lblBookingID = new javax.swing.JLabel();
                txtBooking = new javax.swing.JTextField();
                lblRenteeID = new javax.swing.JLabel();
                txtRenteeID = new javax.swing.JTextField();
                lblRenterID = new javax.swing.JLabel();
                txtRenterID = new javax.swing.JTextField();
                lblCarID = new javax.swing.JLabel();
                txtCarID = new javax.swing.JTextField();
                lblStartDate = new javax.swing.JLabel();
                txtStartDate = new javax.swing.JTextField();
                lblEndDate = new javax.swing.JLabel();
                txtEndDate = new javax.swing.JTextField();
                lblStatus = new javax.swing.JLabel();
                lblTotalPrice = new javax.swing.JLabel();
                txtTotalPrice = new javax.swing.JTextField();
                btnEditBookingInformation = new javax.swing.JButton();
                jComboBox1 = new javax.swing.JComboBox<>();
                jPanel6 = new javax.swing.JPanel();
                jLabel5 = new javax.swing.JLabel();
                lblbooking = new javax.swing.JLabel();
                txtbooking = new javax.swing.JTextField();
                btnDeleteBookingInformation = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);

                jPanel2.setBackground(new java.awt.Color(237, 223, 205));

                jPanel3.setBackground(new java.awt.Color(217, 186, 164));
                jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

                lblDashboard.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblDashboard.setText("Dashboard");
                lblDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lblDashboardMouseClicked(evt);
                        }

                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                lblDashboardMouseEntered(evt);
                        }

                        public void mouseExited(java.awt.event.MouseEvent evt) {
                                lblDashboardMouseExited(evt);
                        }
                });

                lblBooking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblBooking.setText("Booking");
                lblBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
                jLabel3.setText("Leenda");

                lblCarListing.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblCarListing.setText("Car Listing");
                lblCarListing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                lblCarListing.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lblCarListingMouseClicked(evt);
                        }

                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                lblCarListingMouseEntered(evt);
                        }

                        public void mouseExited(java.awt.event.MouseEvent evt) {
                                lblCarListingMouseExited(evt);
                        }
                });

                lblUsermanagement.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblUsermanagement.setText("User Management");
                lblUsermanagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                lblUsermanagement.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lblUsermanagementMouseClicked(evt);
                        }

                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                lblUsermanagementMouseEntered(evt);
                        }

                        public void mouseExited(java.awt.event.MouseEvent evt) {
                                lblUsermanagementMouseExited(evt);
                        }
                });

                btnLogOut.setBackground(new java.awt.Color(237, 223, 205));
                btnLogOut.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                btnLogOut.setText("Log Out");
                btnLogOut.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                btnLogOutMouseClicked(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                130,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(lblDashboard)
                                                                .addGap(77, 77, 77)
                                                                .addComponent(lblCarListing)
                                                                .addGap(99, 99, 99)
                                                                .addComponent(lblBooking)
                                                                .addGap(109, 109, 109)
                                                                .addComponent(lblUsermanagement)
                                                                .addGap(137, 137, 137)
                                                                .addComponent(btnLogOut,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                120,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lblDashboard)
                                                                                .addComponent(lblCarListing)
                                                                                .addComponent(lblBooking)
                                                                                .addComponent(lblUsermanagement)
                                                                                .addComponent(btnLogOut,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                32,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel3))
                                                                .addContainerGap(13, Short.MAX_VALUE)));

                jPanel4.setBackground(new java.awt.Color(237, 223, 205));
                jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
                jLabel8.setText("Booking");

                btnPrintBookings.setBackground(new java.awt.Color(237, 223, 205));
                btnPrintBookings.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                btnPrintBookings.setText("Print Bookings");
                btnPrintBookings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnPrintBookings.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnPrintBookingsActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                113,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(346, 346, 346)
                                                                .addComponent(btnPrintBookings,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                132,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(btnPrintBookings))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                tblBooking.setBackground(new java.awt.Color(237, 223, 205));
                tblBooking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                tblBooking.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { "211", "eurico", null, "18-21-24", "18-5-25", "4000", "rented",
                                                                "BMW" },
                                                { "222", "timmy", null, "14-21-24", "14-18-24", "4000", "Not rented",
                                                                "Audi" },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null }
                                },
                                new String[] {
                                                "Booking ID", "Renter name", "Rentee name", "Start Date", "End Date",
                                                "Total Price", "Status",
                                                "Car ID"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane1.setViewportView(tblBooking);

                jPanel5.setBackground(new java.awt.Color(217, 186, 164));
                jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                lblBookingID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblBookingID.setText("Booking ID");

                txtBooking.setBackground(new java.awt.Color(237, 223, 205));
                txtBooking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                lblRenteeID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblRenteeID.setText("Rentee ID");

                txtRenteeID.setBackground(new java.awt.Color(237, 223, 205));
                txtRenteeID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                lblRenterID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblRenterID.setText("Renter ID");

                txtRenterID.setBackground(new java.awt.Color(237, 223, 205));
                txtRenterID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                lblCarID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblCarID.setText("Car ID");

                txtCarID.setBackground(new java.awt.Color(237, 223, 205));
                txtCarID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                lblStartDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblStartDate.setText("Start Date");

                txtStartDate.setBackground(new java.awt.Color(237, 223, 205));
                txtStartDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                lblEndDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblEndDate.setText("End Date");

                txtEndDate.setBackground(new java.awt.Color(237, 223, 205));
                txtEndDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                lblStatus.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblStatus.setText("Status");

                lblTotalPrice.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblTotalPrice.setText("Total Price");

                txtTotalPrice.setBackground(new java.awt.Color(237, 223, 205));
                txtTotalPrice.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                btnEditBookingInformation.setBackground(new java.awt.Color(133, 62, 52));
                btnEditBookingInformation.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                btnEditBookingInformation.setForeground(new java.awt.Color(255, 255, 255));
                btnEditBookingInformation.setText("Edit Booking Information");
                btnEditBookingInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                jComboBox1.setBackground(new java.awt.Color(237, 223, 205));
                jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                jComboBox1.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "Rented", "Not Rented", "" }));

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(lblBookingID)
                                                                                                                .addComponent(txtBooking)
                                                                                                                .addComponent(lblRenteeID)
                                                                                                                .addComponent(txtRenteeID,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                170,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(15, 15, 15)
                                                                                                                                .addComponent(lblCarID))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(lblRenterID)
                                                                                                                                                .addComponent(txtRenterID,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                170,
                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addComponent(txtCarID)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(lblEndDate)
                                                                                                                .addComponent(txtStartDate)
                                                                                                                .addComponent(lblStartDate)
                                                                                                                .addComponent(txtEndDate,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                170,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(15, 15, 15)
                                                                                                                                .addComponent(lblStatus))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(lblTotalPrice)
                                                                                                                                                .addComponent(txtTotalPrice)
                                                                                                                                                .addComponent(jComboBox1,
                                                                                                                                                                0,
                                                                                                                                                                170,
                                                                                                                                                                Short.MAX_VALUE)))))
                                                                                .addComponent(btnEditBookingInformation,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                716,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(20, Short.MAX_VALUE)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lblBookingID)
                                                                                .addComponent(lblRenterID)
                                                                                .addComponent(lblStartDate)
                                                                                .addComponent(lblStatus))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txtBooking,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtRenterID,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtStartDate,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lblRenteeID)
                                                                                .addComponent(lblCarID)
                                                                                .addComponent(lblEndDate)
                                                                                .addComponent(lblTotalPrice))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txtRenteeID,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtCarID,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtEndDate,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtTotalPrice,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEditBookingInformation)
                                                                .addContainerGap(31, Short.MAX_VALUE)));

                jPanel6.setBackground(new java.awt.Color(217, 186, 164));
                jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(255, 0, 0));
                jLabel5.setText("If you want to clear Booking Information:");

                lblbooking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                lblbooking.setText("Booking ID");

                txtbooking.setBackground(new java.awt.Color(237, 223, 205));
                txtbooking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

                btnDeleteBookingInformation.setBackground(new java.awt.Color(237, 223, 205));
                btnDeleteBookingInformation.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
                btnDeleteBookingInformation.setForeground(new java.awt.Color(255, 0, 0));
                btnDeleteBookingInformation.setText("Delete Booking Information");
                btnDeleteBookingInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel6Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(txtbooking,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel5))
                                                                                .addComponent(btnDeleteBookingInformation,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                238,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblbooking))
                                                                .addGap(33, 33, 33)));
                jPanel6Layout.setVerticalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(jLabel5)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(lblbooking)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtbooking,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnDeleteBookingInformation)
                                                                .addGap(24, 24, 24)));

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane1)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jPanel5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jPanel6,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))
                                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jPanel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                259,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel2Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jPanel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel6,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(0, 6, Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnEditPersonalInformationOnClick(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditPersonalInformationOnClick
                // Regular expressions
                String nameRegex = "^(?!.*\\s)(!?[A-Z][a-zA-Z]*)$"; // First letter uppercase, then letters or '!'
                String renteeIDRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$"; // Basic renteeID validation
                String phoneRegex = "^\\+\\d{1,4}\\d+$"; // Phone number starts with + followed by digits

                // Variables declaration and assignment (trim input to remove leading/trailing
                // spaces)
                String bookingID = txtBooking.getText().trim();
                String renterID = txtRenteeID.getText().trim(); // Use getText(), not getName() for JTextField
                String renteeID = txtRenteeID.getText().trim();
                String carID = txtCarID.getText().trim();

                // Check if at least one field is filled
                if (bookingID.equals("") && renterID.equals("") && renteeID.equals("") && carID.equals("")) {
                        JOptionPane.showMessageDialog(null, "At least one field must be filled to update!",
                                        "Update Failed",
                                        JOptionPane.ERROR_MESSAGE);
                } else {
                        // Check if at least one field is filled
                        if (bookingID.equals("") && renterID.equals("") && renteeID.equals("") && carID.equals("")) {
                                JOptionPane.showMessageDialog(null, "At least one field must be filled to update!",
                                                "Update Failed",
                                                JOptionPane.ERROR_MESSAGE);
                        } else {
                                // Validation for each non-empty field
                                if (!bookingID.equals("") && !bookingID.matches(nameRegex)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Booking ID is invalid. \nOnly numbers and  are allowed.",
                                                        "Invalid Booking ID", JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }
                                if (!renterID.equals("") && !renterID.matches(nameRegex)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Renter ID is invalid. \nOnly numbers allowed.",
                                                        "Invalid Renter ID", JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }
                                if (!renteeID.equals("") && !renteeID.matches(renteeIDRegex)) {
                                        JOptionPane.showMessageDialog(this, "Please enter a valid renteeID .",
                                                        "Invalid renteeID",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }
                                if (!carID.equals("") && !carID.matches(phoneRegex)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Car ID should contain only numbers \nand contain only numbers.",
                                                        "Invalid Car ID", JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }

                        }
                }
        }// GEN-LAST:event_btnEditPersonalInformationOnClick

        private void btnEditBookingInformationOnClick(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditPersonalInformationOnClick
                // Regular expressions
                String nameRegex = "^(?!.*\\s)(!?[A-Z][a-zA-Z]*)$"; // First letter uppercase, then letters or '!'
                String CarIDRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$"; // Basic CarID validation
                String phoneRegex = "^\\+\\d{1,4}\\d+$"; // Phone number starts with + followed by digits

                // Variables declaration and assignment (trim input to remove leading/trailing
                // spaces)
                String book = txtBooking.getText().trim();
                int bookingID = Integer.parseInt(book);
                String RenteeID = txtRenteeID.getText().trim(); // Use getText(), not getName() for JTextField
                int Rentee = Integer.parseInt(RenteeID);
                ;
                String CarID = txtCarID.getText().trim();
                int Car = Integer.parseInt(CarID);
                String RenterID = txtRenterID.getText().trim();
                int Renter = Integer.parseInt(RenterID);

                // Check if at least one field is filled
                if (book.isEmpty() && RenteeID.isEmpty() && CarID.isEmpty() && RenterID.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "At least one field must be filled to update!",
                                        "Update Failed",
                                        JOptionPane.ERROR_MESSAGE);
                } else {
                        // Check if at least one field is filled
                        if (book.isEmpty() && RenteeID.isEmpty() && CarID.isEmpty() && RenterID.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "At least one field must be filled to update!",
                                                "Update Failed",
                                                JOptionPane.ERROR_MESSAGE);
                        } else {
                                // Validation for each non-empty field
                                // if (!book.isEmpty() && !bookingID.matches(nameRegex)) {
                                // JOptionPane.showMessageDialog(this,
                                // "Booking ID is invalid \nOnly numbers are allowed, ",
                                // "Invalid Booking ID", JOptionPane.ERROR_MESSAGE);
                                // return; // Stop if validation fails
                                // }
                                if (!RenteeID.equals("") && !RenteeID.matches(nameRegex)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Rentee ID is invalid. \nOnly numbers  are allowed.",
                                                        "Invalid Rentee ID", JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }
                                if (!CarID.equals("") && !CarID.matches(CarIDRegex)) {
                                        JOptionPane.showMessageDialog(this, "Please enter a valid CarID .",
                                                        "Invalid CarID",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }
                                if (!RenterID.equals("") && !RenterID.matches(phoneRegex)) {
                                        JOptionPane.showMessageDialog(this,
                                                        " Renter ID is invalid.\nOnly numbers are allowed",
                                                        "Invalid Car ID", JOptionPane.ERROR_MESSAGE);
                                        return; // Stop if validation fails
                                }

                        }
                }
        }// GEN-LAST:event_btnEditPersonalInformationOnClick

        private void btnPrintBookingsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrintBookingsActionPerformed
                try {
                        // Define the title (header) to display at the top of the printed page
                        String title = "Leenda - Bookings";

                        // Get the current date and time to display at the bottom (footer) of the page
                        String footer = "Generated on: "
                                        + new SimpleDateFormat("EEEE, d MMM yyyy hh:mm:ss a").format(new Date());

                        // Use the JTable's print method, adding both a header and a footer
                        boolean complete = tblBooking.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(title),
                                        new MessageFormat(footer));
                        if (complete) {
                                // If printing is complete, show a success message
                                JOptionPane.showMessageDialog(null, "Printing Complete", "Print",
                                                JOptionPane.INFORMATION_MESSAGE);
                        } else {
                                // If printing was cancelled, show a message
                                JOptionPane.showMessageDialog(null, "Printing Cancelled", "Print",
                                                JOptionPane.WARNING_MESSAGE);
                        }
                } catch (HeadlessException | PrinterException ex) {
                        // If an error occurs during printing, show an error message
                        JOptionPane.showMessageDialog(null, "Error printing table: " + ex.getMessage(), "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
        }// GEN-LAST:event_btnPrintBookingsActionPerformed

        private void lblCarListingMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCarListingMouseClicked
                this.dispose();
                new CarListing(user);
                // new CarListing();
        }// GEN-LAST:event_lblCarListingMouseClicked

        private void lblCarListingMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCarListingMouseEntered
                Functions.changeColorOfTheLabelOfTheHeaderWhenEntering(lblCarListing);
        }// GEN-LAST:event_lblCarListingMouseEntered

        private void lblCarListingMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCarListingMouseExited
                Functions.changeColorOfTheLabelOfTheHeaderWhenExiting(lblCarListing);
        }// GEN-LAST:event_lblCarListingMouseExited

        private void lblUsermanagementMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblUsermanagementMouseEntered
                changeColorOfTheLabelOfTheHeaderWhenEntering(lblUsermanagement);// TODO add your handling code here:
        }// GEN-LAST:event_lblUsermanagementMouseEntered

        private void lblUsermanagementMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblUsermanagementMouseExited
                changeColorOfTheLabelOfTheHeaderWhenExiting(lblUsermanagement); // TODO add your handling code here:
        }// GEN-LAST:event_lblUsermanagementMouseExited

        private void lblDashboardMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDashboardMouseExited
                changeColorOfTheLabelOfTheHeaderWhenExiting(lblDashboard);// TODO add your handling code here:
        }// GEN-LAST:event_lblDashboardMouseExited

        private void lblDashboardMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDashboardMouseEntered
                changeColorOfTheLabelOfTheHeaderWhenEntering(lblDashboard);// TODO add your handling code here:
        }// GEN-LAST:event_lblDashboardMouseEntered

        private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDashboardMouseClicked
                this.dispose();
                new AdminDashboard(user);
        }// GEN-LAST:event_lblDashboardMouseClicked

        private void lblUsermanagementMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblUsermanagementMouseClicked
                this.dispose();
                new UserManagementPage(user);
        }// GEN-LAST:event_lblUsermanagementMouseClicked

        private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnLogOutMouseClicked
                this.dispose();
                new LoginPage();
        }// GEN-LAST:event_btnLogOutMouseClicked

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new BookingPage(user);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnDeleteBookingInformation;
        private javax.swing.JButton btnEditBookingInformation;
        private javax.swing.JButton btnLogOut;
        private javax.swing.JButton btnPrintBookings;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lblBooking;
        private javax.swing.JLabel lblBookingID;
        private javax.swing.JLabel lblCarID;
        private javax.swing.JLabel lblCarListing;
        private javax.swing.JLabel lblDashboard;
        private javax.swing.JLabel lblEndDate;
        private javax.swing.JLabel lblRenteeID;
        private javax.swing.JLabel lblRenterID;
        private javax.swing.JLabel lblStartDate;
        private javax.swing.JLabel lblStatus;
        private javax.swing.JLabel lblTotalPrice;
        private javax.swing.JLabel lblUsermanagement;
        private javax.swing.JLabel lblbooking;
        private javax.swing.JTable tblBooking;
        private javax.swing.JTextField txtBooking;
        private javax.swing.JTextField txtCarID;
        private javax.swing.JTextField txtEndDate;
        private javax.swing.JTextField txtRenteeID;
        private javax.swing.JTextField txtRenterID;
        private javax.swing.JTextField txtStartDate;
        private javax.swing.JTextField txtTotalPrice;
        private javax.swing.JTextField txtbooking;
        // End of variables declaration//GEN-END:variables

        private void changeColorOfTheLabelOfTheHeaderWhenEntered(JLabel lblCarListing) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                               // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package leendauserdashboard;
import models.User;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;

import auth.LoginPage;
import java.util.Date;
/**
 *
 * @author Jaden
 */
public class ViewCars extends javax.swing.JFrame {
    public User user;
    private JPanel carListing;
    private JScrollPane ListingScollingPanel;
    /**
     * Creates new form UserDashboard
     */
    public ViewCars(User user) {
        this.user = user;
        initComponents();
        this.setVisible(true);
        displayCars();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        NavPanel = new javax.swing.JPanel();
        Leenda = new javax.swing.JLabel();
        Booking = new javax.swing.JButton();
        Dashboard = new javax.swing.JButton();
        Booking1 = new javax.swing.JButton();
        BookingsPanel = new javax.swing.JPanel();
        Bookings14B = new javax.swing.JLabel();
        ListingScollingPanel = new javax.swing.JScrollPane();
        carListing = new javax.swing.JPanel();
        carListing1 = new javax.swing.JPanel();
        carImageBox = new javax.swing.JPanel();
        CarImage = new javax.swing.JLabel();
        CarModel = new javax.swing.JLabel();
        CarYear = new javax.swing.JLabel();
        CarBrand = new javax.swing.JLabel();
        CarRating = new javax.swing.JLabel();
        CarOwner = new javax.swing.JLabel();
        TextCarBooked = new javax.swing.JLabel();
        NumberOfBookings = new javax.swing.JLabel();
        TextCarRatings = new javax.swing.JLabel();
        TextCarDateListed = new javax.swing.JLabel();
        DateCarListed = new javax.swing.JLabel();
        carListing2 = new javax.swing.JPanel();
        carImageBox1 = new javax.swing.JPanel();
        CarImage1 = new javax.swing.JLabel();
        CarModel1 = new javax.swing.JLabel();
        CarYear1 = new javax.swing.JLabel();
        CarBrand1 = new javax.swing.JLabel();
        CarRating1 = new javax.swing.JLabel();
        CarOwner1 = new javax.swing.JLabel();
        CarOwnerRating1 = new javax.swing.JLabel();
        TextCarBooked1 = new javax.swing.JLabel();
        NumberOfBookings1 = new javax.swing.JLabel();
        TextCarRatings1 = new javax.swing.JLabel();
        TextCarComments1 = new javax.swing.JLabel();
        NumberOfComments1 = new javax.swing.JLabel();
        TextCarDateListed1 = new javax.swing.JLabel();
        DateCarListed1 = new javax.swing.JLabel();
        TextOwnerRating1 = new javax.swing.JLabel();
        carListing3 = new javax.swing.JPanel();
        carImageBox2 = new javax.swing.JPanel();
        CarImage2 = new javax.swing.JLabel();
        CarModel2 = new javax.swing.JLabel();
        CarYear2 = new javax.swing.JLabel();
        CarBrand2 = new javax.swing.JLabel();
        CarRating2 = new javax.swing.JLabel();
        CarOwner2 = new javax.swing.JLabel();
        CarOwnerRating2 = new javax.swing.JLabel();
        TextCarBooked2 = new javax.swing.JLabel();
        NumberOfBookings2 = new javax.swing.JLabel();
        TextCarRatings2 = new javax.swing.JLabel();
        TextCarComments2 = new javax.swing.JLabel();
        NumberOfComments2 = new javax.swing.JLabel();
        TextCarDateListed2 = new javax.swing.JLabel();
        DateCarListed2 = new javax.swing.JLabel();
        TextOwnerRating2 = new javax.swing.JLabel();
        carListing4 = new javax.swing.JPanel();
        carImageBox3 = new javax.swing.JPanel();
        CarImage3 = new javax.swing.JLabel();
        CarModel3 = new javax.swing.JLabel();
        CarYear3 = new javax.swing.JLabel();
        CarBrand3 = new javax.swing.JLabel();
        CarRating3 = new javax.swing.JLabel();
        CarOwner3 = new javax.swing.JLabel();
        CarOwnerRating3 = new javax.swing.JLabel();
        TextCarBooked3 = new javax.swing.JLabel();
        NumberOfBookings3 = new javax.swing.JLabel();
        TextCarRatings3 = new javax.swing.JLabel();
        TextCarComments3 = new javax.swing.JLabel();
        NumberOfComments3 = new javax.swing.JLabel();
        TextCarDateListed3 = new javax.swing.JLabel();
        DateCarListed3 = new javax.swing.JLabel();
        TextOwnerRating3 = new javax.swing.JLabel();
        carListing5 = new javax.swing.JPanel();
        carImageBox4 = new javax.swing.JPanel();
        CarImage4 = new javax.swing.JLabel();
        CarModel4 = new javax.swing.JLabel();
        CarYear4 = new javax.swing.JLabel();
        CarBrand4 = new javax.swing.JLabel();
        CarRating4 = new javax.swing.JLabel();
        CarOwner4 = new javax.swing.JLabel();
        CarOwnerRating4 = new javax.swing.JLabel();
        TextCarBooked4 = new javax.swing.JLabel();
        NumberOfBookings4 = new javax.swing.JLabel();
        TextCarRatings4 = new javax.swing.JLabel();
        TextCarComments4 = new javax.swing.JLabel();
        NumberOfComments4 = new javax.swing.JLabel();
        TextCarDateListed4 = new javax.swing.JLabel();
        DateCarListed4 = new javax.swing.JLabel();
        TextOwnerRating4 = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        EditProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(237, 223, 205));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        Background.setBackground(new java.awt.Color(237, 223, 205));

        NavPanel.setBackground(new java.awt.Color(217, 186, 164));
        NavPanel.setForeground(new java.awt.Color(217, 186, 164));

        Leenda.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Leenda.setForeground(new java.awt.Color(133, 62, 52));
        Leenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Leenda.setText("Leenda");

        Booking.setBackground(new java.awt.Color(237, 223, 205));
        Booking.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Booking.setForeground(new java.awt.Color(133, 62, 52));
        Booking.setText("Bookings");
        Booking.setToolTipText("Check out the catalog, something might catch your eye.");
        Booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookingMouseClicked(evt);
            }
        });
        Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingActionPerformed(evt);
            }
        });

        Dashboard.setBackground(new java.awt.Color(237, 223, 205));
        Dashboard.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(133, 62, 52));
        Dashboard.setText("Dashboard");
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
        });
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });

        Booking1.setBackground(new java.awt.Color(237, 223, 205));
        Booking1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Booking1.setForeground(new java.awt.Color(133, 62, 52));
        Booking1.setText("View Cars");
        Booking1.setToolTipText("Check out the catalog, something might catch your eye.");
        Booking1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Booking1MouseClicked(evt);
            }
        });
        Booking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCarsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavPanelLayout = new javax.swing.GroupLayout(NavPanel);
        NavPanel.setLayout(NavPanelLayout);
        NavPanelLayout.setHorizontalGroup(
            NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Leenda, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Booking1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NavPanelLayout.setVerticalGroup(
            NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavPanelLayout.createSequentialGroup()
                .addGroup(NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Leenda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Booking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Booking1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        BookingsPanel.setBackground(new java.awt.Color(237, 223, 205));
        BookingsPanel.setForeground(new java.awt.Color(237, 223, 205));

        Bookings14B.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Bookings14B.setForeground(new java.awt.Color(133, 62, 52));
        Bookings14B.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bookings14B.setText("View Cars");

        javax.swing.GroupLayout BookingsPanelLayout = new javax.swing.GroupLayout(BookingsPanel);
        BookingsPanel.setLayout(BookingsPanelLayout);
        BookingsPanelLayout.setHorizontalGroup(
            BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bookings14B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BookingsPanelLayout.setVerticalGroup(
            BookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bookings14B)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

       

        ListingScollingPanel.setViewportView(carListing);

        LogOut.setBackground(new java.awt.Color(217, 186, 164));
        LogOut.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LogOut.setForeground(new java.awt.Color(133, 62, 52));
        LogOut.setText("Log Out");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        EditProfile.setBackground(new java.awt.Color(217, 186, 164));
        EditProfile.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        EditProfile.setForeground(new java.awt.Color(133, 62, 52));
        EditProfile.setText("Edit Profile");
        EditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditProfileMouseClicked(evt);
            }
        });
        EditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addComponent(NavPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ListingScollingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1167, Short.MAX_VALUE)
            .addComponent(BookingsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addComponent(NavPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListingScollingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    
    private int calculateDaysRenting(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // This will throw an exception if the date is not in the correct format
    
        try {
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
    
            if (end.before(start)) {
                System.err.println("Error: end date is before start date.");
                return 0;
            }
    
            long diff = end.getTime() - start.getTime();
            return (int) (diff / (1000 * 60 * 60 * 24)) + 1; // Add 1 to include the end date
        } catch (ParseException e) {
            System.err.println("Error: date is not in the correct format.");
            return 0;
        }
    }

    private int getNextBookingId() {
        int nextBookingId = 1;
        File file = new File("src\\storage\\bookings.csv");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] bookingDetails = line.split(",");
                    if (bookingDetails.length > 0) {
                        try {
                            nextBookingId = Integer.parseInt(bookingDetails[1]) + 1;
                        } catch (NumberFormatException e) {
                            // Ignore invalid booking IDs
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading bookings.csv: " + e.getMessage());
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating bookings.csv: " + e.getMessage());
            }
        }

        return nextBookingId;
    }   
    private void EditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditProfileActionPerformed

    private void EditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EditProfileMouseClicked

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        this.dispose();
        new LoginPage();
    }//GEN-LAST:event_LogOutActionPerformed

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        this.dispose();
        new LoginPage();
    }//GEN-LAST:event_LogOutMouseClicked

    private void viewCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Booking1ActionPerformed
        this.dispose();
        new ViewCars(user);
    }//GEN-LAST:event_Booking1ActionPerformed

    private void Booking1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Booking1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Booking1MouseClicked

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardActionPerformed

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked
        this.dispose();
        new CustomerDashboard(user);
    }//GEN-LAST:event_DashboardMouseClicked

    private void BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookingActionPerformed

    private void BookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingMouseClicked
        this.dispose();
        new Bookings(user);
    }//GEN-LAST:event_BookingMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewCars(null).setVisible(true);
        });
    }
    // Populates the carListing panel with the cars from the cars.csv file and includes images of the cars while respecting the layout.
    private void displayCars() {
        carListing = new JPanel();
        carListing.setLayout(new BoxLayout(carListing, BoxLayout.Y_AXIS));
        boolean carsFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src\\storage\\cars.csv"))) {
            String line;
            br.readLine(); // skip the header
            while ((line = br.readLine()) != null) {
                String[] carDetails = line.split(",");
                if (carDetails[6].equals("available")) {
                    carsFound = true;
                    JPanel carPanel = createCarPanel(carDetails);
                    carListing.add(carPanel);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading cars.csv: " + e.getMessage());
        }
        if (!carsFound) {
            JLabel noCarsLabel = new JLabel("No cars available.");
            noCarsLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
            noCarsLabel.setHorizontalAlignment(JLabel.CENTER);
            carListing.add(noCarsLabel);
        }

        ListingScollingPanel.setViewportView(carListing);
    }

    private JPanel createCarPanel(String[] carDetails) {
        JPanel carPanel = new JPanel();
        carPanel.setLayout(new FlowLayout());
        carPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel carImage = new JLabel();
        carImage.setIcon(new ImageIcon("src\\carImages\\" + carDetails[0] + ".jpeg")); // Assuming the first column is the car ID and images are named as carID.jpg

        JLabel carModel = new JLabel("Car Name: " + carDetails[2]);
        JLabel carYear = new JLabel("Car Year: " + carDetails[3]);
        JLabel carBrand = new JLabel("Car Type: " + carDetails[4]);
        JLabel carRating = new JLabel("Daily Rate: " + carDetails[5]);
        JLabel carOwner = new JLabel("Status: " + carDetails[6]);

        JButton bookButton = new JButton("Book");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a popup with fields for Start Date and End Date
                JDialog dialog = new JDialog();
                dialog.setTitle("Book Car");
                dialog.setModal(true);

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JLabel startDateLabel = new JLabel("Start Date:");
                JTextField startDateField = new JTextField(10);
                panel.add(startDateLabel);
                panel.add(startDateField);

                JLabel endDateLabel = new JLabel("End Date:");
                JTextField endDateField = new JTextField(10);
                panel.add(endDateLabel);
                panel.add(endDateField);

                JButton bookNowButton = new JButton("Book Now");
                bookNowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the values from the fields
                        String startDate = startDateField.getText();
                        String endDate = endDateField.getText();

                        // Calculate the total price
                        int daysRenting = calculateDaysRenting(startDate, endDate);
                        double totalPrice = daysRenting * Double.parseDouble(carDetails[5]);

                        // Get the next booking ID
                        int nextBookingId = getNextBookingId();

                        // Write the booking details to the bookings.csv file
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\storage\\bookings.csv", true))) {
                            bw.write(user.getEmail() + "," + nextBookingId + "," + startDate + "," + endDate + "," + totalPrice + "," + carDetails[2] + "," + daysRenting + "," + "booked" + "," + carDetails[9] + "," + carDetails[1]);
                            bw.newLine();
                        } catch (IOException ex) {
                            System.err.println("Error writing to bookings.csv: " + ex.getMessage());
                        }

                        // Close the dialog
                        dialog.dispose();
                    }
                });
                panel.add(bookNowButton);

                dialog.add(panel);
                dialog.pack();
                dialog.setVisible(true);
            }
        });

        carPanel.add(carImage);
        carPanel.add(carModel);
        carPanel.add(carYear);
        carPanel.add(carBrand);
        carPanel.add(carRating);
        carPanel.add(carOwner);
        carPanel.add(bookButton);

        return carPanel;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton Booking;
    private javax.swing.JButton Booking1;
    private javax.swing.JLabel Bookings14B;
    private javax.swing.JPanel BookingsPanel;
    private javax.swing.JLabel CarBrand;
    private javax.swing.JLabel CarBrand1;
    private javax.swing.JLabel CarBrand2;
    private javax.swing.JLabel CarBrand3;
    private javax.swing.JLabel CarBrand4;
    private javax.swing.JLabel CarImage;
    private javax.swing.JLabel CarImage1;
    private javax.swing.JLabel CarImage2;
    private javax.swing.JLabel CarImage3;
    private javax.swing.JLabel CarImage4;
    private javax.swing.JLabel CarModel;
    private javax.swing.JLabel CarModel1;
    private javax.swing.JLabel CarModel2;
    private javax.swing.JLabel CarModel3;
    private javax.swing.JLabel CarModel4;
    private javax.swing.JLabel CarOwner;
    private javax.swing.JLabel CarOwner1;
    private javax.swing.JLabel CarOwner2;
    private javax.swing.JLabel CarOwner3;
    private javax.swing.JLabel CarOwner4;
    private javax.swing.JLabel CarOwnerRating1;
    private javax.swing.JLabel CarOwnerRating2;
    private javax.swing.JLabel CarOwnerRating3;
    private javax.swing.JLabel CarOwnerRating4;
    private javax.swing.JLabel CarRating;
    private javax.swing.JLabel CarRating1;
    private javax.swing.JLabel CarRating2;
    private javax.swing.JLabel CarRating3;
    private javax.swing.JLabel CarRating4;
    private javax.swing.JLabel CarYear;
    private javax.swing.JLabel CarYear1;
    private javax.swing.JLabel CarYear2;
    private javax.swing.JLabel CarYear3;
    private javax.swing.JLabel CarYear4;
    private javax.swing.JButton Dashboard;
    private javax.swing.JLabel DateCarListed;
    private javax.swing.JLabel DateCarListed1;
    private javax.swing.JLabel DateCarListed2;
    private javax.swing.JLabel DateCarListed3;
    private javax.swing.JLabel DateCarListed4;
    private javax.swing.JButton EditProfile;
    private javax.swing.JLabel Leenda;
    private javax.swing.JButton LogOut;
    private javax.swing.JPanel NavPanel;
    private javax.swing.JLabel NumberOfBookings;
    private javax.swing.JLabel NumberOfBookings1;
    private javax.swing.JLabel NumberOfBookings2;
    private javax.swing.JLabel NumberOfBookings3;
    private javax.swing.JLabel NumberOfBookings4;
    private javax.swing.JLabel NumberOfComments1;
    private javax.swing.JLabel NumberOfComments2;
    private javax.swing.JLabel NumberOfComments3;
    private javax.swing.JLabel NumberOfComments4;
    private javax.swing.JLabel TextCarBooked;
    private javax.swing.JLabel TextCarBooked1;
    private javax.swing.JLabel TextCarBooked2;
    private javax.swing.JLabel TextCarBooked3;
    private javax.swing.JLabel TextCarBooked4;
    private javax.swing.JLabel TextCarComments1;
    private javax.swing.JLabel TextCarComments2;
    private javax.swing.JLabel TextCarComments3;
    private javax.swing.JLabel TextCarComments4;
    private javax.swing.JLabel TextCarDateListed;
    private javax.swing.JLabel TextCarDateListed1;
    private javax.swing.JLabel TextCarDateListed2;
    private javax.swing.JLabel TextCarDateListed3;
    private javax.swing.JLabel TextCarDateListed4;
    private javax.swing.JLabel TextCarRatings;
    private javax.swing.JLabel TextCarRatings1;
    private javax.swing.JLabel TextCarRatings2;
    private javax.swing.JLabel TextCarRatings3;
    private javax.swing.JLabel TextCarRatings4;
    private javax.swing.JLabel TextOwnerRating1;
    private javax.swing.JLabel TextOwnerRating2;
    private javax.swing.JLabel TextOwnerRating3;
    private javax.swing.JLabel TextOwnerRating4;
    private javax.swing.JPanel carImageBox;
    private javax.swing.JPanel carImageBox1;
    private javax.swing.JPanel carImageBox2;
    private javax.swing.JPanel carImageBox3;
    private javax.swing.JPanel carImageBox4;
    private javax.swing.JPanel carListing1;
    private javax.swing.JPanel carListing2;
    private javax.swing.JPanel carListing3;
    private javax.swing.JPanel carListing4;
    private javax.swing.JPanel carListing5;
    // End of variables declaration//GEN-END:variables
}

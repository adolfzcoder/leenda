package leendauserdashboard;


import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import models.User;

public class CarBooking extends javax.swing.JFrame {
    public User user;

    public CarBooking(User user) {
        this.user = user;
        initComponents();
        this.setVisible(true);
        this.setResizable(false);

        loadCarData();
    }

    private void initComponents() {
        Background = new javax.swing.JPanel();
        NavPanel = new javax.swing.JPanel();
        Leenda = new javax.swing.JLabel();
        Booking = new javax.swing.JButton();
        Dashboard = new javax.swing.JButton();
        BookingsPanel = new javax.swing.JPanel();
        Bookings14B = new javax.swing.JLabel();
        ListingScollingPanel = new javax.swing.JScrollPane();
        carListing = new javax.swing.JPanel();

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
        Booking.setText("Book a Car");
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

        javax.swing.GroupLayout NavPanelLayout = new javax.swing.GroupLayout(NavPanel);
        NavPanel.setLayout(NavPanelLayout);
        NavPanelLayout.setHorizontalGroup(
            NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Leenda, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NavPanelLayout.setVerticalGroup(
            NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavPanelLayout.createSequentialGroup()
                .addGroup(NavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Leenda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Booking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BookingsPanel.setBackground(new java.awt.Color(237, 223, 205));
        BookingsPanel.setForeground(new java.awt.Color(237, 223, 205));

        Bookings14B.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Bookings14B.setForeground(new java.awt.Color(133, 62, 52));
        Bookings14B.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bookings14B.setText("Bookings");

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

        carListing.setBackground(new java.awt.Color(217, 186, 164));
        carListing.setLayout(new BoxLayout(carListing, BoxLayout.Y_AXIS));

        ListingScollingPanel.setViewportView(carListing);

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NavPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BookingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ListingScollingPanel)
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(NavPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListingScollingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        getContentPane().add(Background, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void loadCarData() {
        String filePath = "src/storage/cars.csv";
        String line;
        String[] row;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                row = line.split(",");
                addCarCard(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCarCard(String[] carData) {
        JPanel carCard = new JPanel();
        carCard.setLayout(new BorderLayout());
        carCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        carCard.setBackground(new Color(217, 186, 164));

        // Load car image
        JLabel carImageLabel = new JLabel();
        try {
            URL url = new URL(carData[7]); // Assuming carImageUrl is at index 7
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 150, Image.SCALE_SMOOTH));
            carImageLabel.setIcon(icon);
        } catch (IOException e) {
            carImageLabel.setText("Image not available");
        }

        // Car details
        JLabel carDetails = new JLabel("<html>"
                + "Car Name: " + carData[2] + "<br>"
                + "Car Year: " + carData[3] + "<br>"
                + "Car Type: " + carData[4] + "<br>"
                + "Daily Rate: N$" + carData[5] + "<br>"
                + "Status: " + carData[6] + "<br>"
                + "VIN: " + carData[8] + "<br>"
                + "Owner Email: " + carData[9] + "<br>"
                + "</html>");

        carCard.add(carImageLabel, BorderLayout.WEST);
        carCard.add(carDetails, BorderLayout.CENTER);

        carListing.add(carCard);
        carListing.revalidate();
        carListing.repaint();
    }

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle Dashboard button click
    }

    private void EditProfileActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle Edit Profile button click
    }

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle Log Out button click
    }

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {
        // Handle Dashboard button click
    }

    private void BookingMouseClicked(java.awt.event.MouseEvent evt) {
        // Handle Booking button click
    }

    private void EditProfileMouseClicked(java.awt.event.MouseEvent evt) {
        // Handle Edit Profile button click
    }

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {
        // Handle Log Out button click
    }

    private void BookingActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle Booking button click
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CarBooking(null).setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel Background;
    private javax.swing.JButton Booking;
    private javax.swing.JLabel Bookings14B;
    private javax.swing.JPanel BookingsPanel;
    private javax.swing.JButton Dashboard;
    private javax.swing.JLabel Leenda;
    private javax.swing.JScrollPane ListingScollingPanel;
    private javax.swing.JPanel NavPanel;
    private javax.swing.JPanel carListing;
    // End of variables declaration
}
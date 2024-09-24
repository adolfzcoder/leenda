package adminmodules;

import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import validations.Validation;

public class UserManagementPage extends javax.swing.JFrame {

    /**
     * Creates new form UserManagementPage
     */
    public UserManagementPage() {
        // Set Nimbus look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();  // Handle any exceptions
        }
        
        this.setTitle("User management");
        this.setResizable(false);
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblLeenda = new javax.swing.JLabel();
        lblDashboard = new javax.swing.JLabel();
        lblCarListing = new javax.swing.JLabel();
        lblBookings = new javax.swing.JLabel();
        lblUserManagement = new javax.swing.JLabel();
        btnLogout = new javax.swing.JToggleButton();
        pnlSubHeader = new javax.swing.JPanel();
        lblDashboardHeader = new javax.swing.JLabel();
        cboUserType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        pnlEditUserPersonalInformation = new javax.swing.JPanel();
        lblUserID = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblDriverLicense = new javax.swing.JLabel();
        txtDriverLicense = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btnEditUsersPersonalInformation = new javax.swing.JToggleButton();
        cboUserTypeEdit = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblIfYouWantToDeleteTheUsersPersonalDetails = new javax.swing.JLabel();
        txtUserIDToDelete = new javax.swing.JTextField();
        btnDeletePersonalInformation = new javax.swing.JToggleButton();
        lblUserIDToDelete = new javax.swing.JLabel();
        btnPrintUserRecords = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(237, 223, 205));

        pnlHeader.setBackground(new java.awt.Color(217, 186, 164));

        lblLeenda.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblLeenda.setText("Leenda");

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

        lblCarListing.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCarListing.setText("Car listing");
        lblCarListing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCarListing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCarListingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCarListingMouseExited(evt);
            }
        });

        lblBookings.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblBookings.setText("Bookings");
        lblBookings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBookingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBookingsMouseExited(evt);
            }
        });

        lblUserManagement.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUserManagement.setText("User management");
        lblUserManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLogout.setBackground(new java.awt.Color(237, 223, 205));
        btnLogout.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutOnClick(evt);
            }
        });

        pnlSubHeader.setBackground(new java.awt.Color(237, 223, 205));
        pnlSubHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDashboardHeader.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblDashboardHeader.setText("User management");

        javax.swing.GroupLayout pnlSubHeaderLayout = new javax.swing.GroupLayout(pnlSubHeader);
        pnlSubHeader.setLayout(pnlSubHeaderLayout);
        pnlSubHeaderLayout.setHorizontalGroup(
            pnlSubHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubHeaderLayout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(lblDashboardHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSubHeaderLayout.setVerticalGroup(
            pnlSubHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDashboardHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblLeenda)
                .addGap(167, 167, 167)
                .addComponent(lblDashboard)
                .addGap(54, 54, 54)
                .addComponent(lblCarListing)
                .addGap(58, 58, 58)
                .addComponent(lblBookings)
                .addGap(59, 59, 59)
                .addComponent(lblUserManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(16, 16, 16))
            .addComponent(pnlSubHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeenda, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblUserManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarListing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSubHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cboUserType.setBackground(new java.awt.Color(237, 223, 205));
        cboUserType.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cboUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Search users by their user type ---", "admin", "car_owner", "customer" }));
        cboUserType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tblUsers.setBackground(new java.awt.Color(217, 186, 164));
        tblUsers.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Kondwani Kunkwenzu", "kk30@gmail.com", "+264813450987", "08658773MA767", "admin"},
                {"2", "Ben 10", "ben10@outlook.com", "+264857747284", "0948758875ZI909", "onwer"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Phone number", "Driver license", "User type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsers.setGridColor(new java.awt.Color(237, 223, 205));
        tblUsers.setSelectionBackground(new java.awt.Color(237, 223, 205));
        jScrollPane1.setViewportView(tblUsers);
        if (tblUsers.getColumnModel().getColumnCount() > 0) {
            tblUsers.getColumnModel().getColumn(0).setResizable(false);
            tblUsers.getColumnModel().getColumn(1).setResizable(false);
            tblUsers.getColumnModel().getColumn(2).setResizable(false);
            tblUsers.getColumnModel().getColumn(3).setResizable(false);
            tblUsers.getColumnModel().getColumn(4).setResizable(false);
            tblUsers.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlEditUserPersonalInformation.setBackground(new java.awt.Color(217, 186, 164));

        lblUserID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUserID.setText("User ID");

        txtUserID.setBackground(new java.awt.Color(237, 223, 205));
        txtUserID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Role");

        lblEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setBackground(new java.awt.Color(237, 223, 205));
        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtName.setBackground(new java.awt.Color(237, 223, 205));
        txtName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblName.setText("Name");

        lblDriverLicense.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblDriverLicense.setText("Driver license");

        txtDriverLicense.setBackground(new java.awt.Color(237, 223, 205));
        txtDriverLicense.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblPhoneNumber.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPhoneNumber.setText("Phone number");

        txtPhoneNumber.setBackground(new java.awt.Color(237, 223, 205));
        txtPhoneNumber.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnEditUsersPersonalInformation.setBackground(new java.awt.Color(133, 62, 52));
        btnEditUsersPersonalInformation.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEditUsersPersonalInformation.setForeground(new java.awt.Color(237, 223, 205));
        btnEditUsersPersonalInformation.setText("Edit user's personal information");
        btnEditUsersPersonalInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditUsersPersonalInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUsersPersonalInformationOnClick(evt);
            }
        });

        cboUserTypeEdit.setBackground(new java.awt.Color(237, 223, 205));
        cboUserTypeEdit.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cboUserTypeEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "car_owner", "customer" }));
        cboUserTypeEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlEditUserPersonalInformationLayout = new javax.swing.GroupLayout(pnlEditUserPersonalInformation);
        pnlEditUserPersonalInformation.setLayout(pnlEditUserPersonalInformationLayout);
        pnlEditUserPersonalInformationLayout.setHorizontalGroup(
            pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserID)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(173, 173, 173))
                            .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                                .addComponent(cboUserTypeEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName)))
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoneNumber)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDriverLicense)
                            .addComponent(txtDriverLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEditUsersPersonalInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pnlEditUserPersonalInformationLayout.setVerticalGroup(
            pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addComponent(lblUserID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31))
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboUserTypeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditUserPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addComponent(lblPhoneNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditUserPersonalInformationLayout.createSequentialGroup()
                        .addComponent(lblDriverLicense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDriverLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnEditUsersPersonalInformation)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(217, 186, 164));

        lblIfYouWantToDeleteTheUsersPersonalDetails.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblIfYouWantToDeleteTheUsersPersonalDetails.setForeground(new java.awt.Color(255, 51, 51));
        lblIfYouWantToDeleteTheUsersPersonalDetails.setText("If you want to delete the user's personal details:");

        txtUserIDToDelete.setBackground(new java.awt.Color(237, 223, 205));
        txtUserIDToDelete.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnDeletePersonalInformation.setBackground(new java.awt.Color(237, 223, 205));
        btnDeletePersonalInformation.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnDeletePersonalInformation.setText("Delete personal information");
        btnDeletePersonalInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletePersonalInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePersonalInformationOnClick(evt);
            }
        });

        lblUserIDToDelete.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUserIDToDelete.setText("User ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserIDToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblUserIDToDelete, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblIfYouWantToDeleteTheUsersPersonalDetails)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lblIfYouWantToDeleteTheUsersPersonalDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblUserIDToDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserIDToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeletePersonalInformation)
                .addGap(20, 20, 20))
        );

        btnPrintUserRecords.setBackground(new java.awt.Color(237, 223, 205));
        btnPrintUserRecords.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPrintUserRecords.setText("Print user records");
        btnPrintUserRecords.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintUserRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintUserRecordsOnClick(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(cboUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintUserRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlEditUserPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrintUserRecords)
                    .addComponent(cboUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEditUserPersonalInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCarListingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCarListingMouseEntered
        Functions.changeColorOfTheLabelOfTheHeaderWhenEntering(lblCarListing);
    }//GEN-LAST:event_lblCarListingMouseEntered

    private void lblCarListingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCarListingMouseExited
        Functions.changeColorOfTheLabelOfTheHeaderWhenExiting(lblCarListing);
    }//GEN-LAST:event_lblCarListingMouseExited

    private void lblBookingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookingsMouseEntered
        Functions.changeColorOfTheLabelOfTheHeaderWhenEntering(lblBookings);
    }//GEN-LAST:event_lblBookingsMouseEntered

    private void lblBookingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookingsMouseExited
        Functions.changeColorOfTheLabelOfTheHeaderWhenExiting(lblBookings);
    }//GEN-LAST:event_lblBookingsMouseExited

    private void btnLogoutOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutOnClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutOnClick

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        this.dispose();
        new AdminDashboard();
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void lblDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseEntered
         Functions.changeColorOfTheLabelOfTheHeaderWhenEntering(lblDashboard);
    }//GEN-LAST:event_lblDashboardMouseEntered

    private void lblDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseExited
        Functions.changeColorOfTheLabelOfTheHeaderWhenExiting(lblDashboard);
    }//GEN-LAST:event_lblDashboardMouseExited

    private void btnDeletePersonalInformationOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePersonalInformationOnClick
        String userID = txtUserIDToDelete.getText();
        Validation.checkIfTheTextFieldIsEmpty(userID, "user id");
    }//GEN-LAST:event_btnDeletePersonalInformationOnClick

    private void btnEditUsersPersonalInformationOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUsersPersonalInformationOnClick
        String userID = txtUserID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String driverLicense = txtDriverLicense.getText();
        
        // Check if the first field (id) is empty
        if(!Validation.checkIfTheTextFieldIsEmpty(userID, "user id")){
            // If the first field is not empty, check the second field (name)
            if(!Validation.checkIfTheTextFieldIsEmpty(name, "name")){
                // If both first and second fields are not empty, check the third field (email)
                if(!Validation.checkIfTheTextFieldIsEmpty(email, "email")){
                    // If the first, second, and third fields are not empty, check the fourth field (phone number)
                    if(!Validation.checkIfTheTextFieldIsEmpty(phoneNumber, "phone number")){
                        // If the first, second, third, and fourth fields are not empty, check the fifth field (driver license)
                        Validation.checkIfTheTextFieldIsEmpty(driverLicense, "driver license");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEditUsersPersonalInformationOnClick

    private void btnPrintUserRecordsOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintUserRecordsOnClick
        try {
            // Define the title (header) to display at the top of the printed page
            String title = "Leenda - User Data Report";

            // Get the current date and time to display at the bottom (footer) of the page
            String footer = "Generated on: " + new SimpleDateFormat("EEEE, d MMM yyyy hh:mm:ss a").format(new Date());

            // Use the JTable's print method, adding both a header and a footer
            boolean complete = tblUsers.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(title), new MessageFormat(footer));
            if (complete) {
                // If printing is complete, show a success message
                JOptionPane.showMessageDialog(null, "Printing Complete", "Print", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // If printing was cancelled, show a message
                JOptionPane.showMessageDialog(null, "Printing Cancelled", "Print", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException | PrinterException ex) {
            // If an error occurs during printing, show an error message
            JOptionPane.showMessageDialog(null, "Error printing table: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPrintUserRecordsOnClick

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagementPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDeletePersonalInformation;
    private javax.swing.JToggleButton btnEditUsersPersonalInformation;
    private javax.swing.JToggleButton btnLogout;
    private javax.swing.JToggleButton btnPrintUserRecords;
    private javax.swing.JComboBox<String> cboUserType;
    private javax.swing.JComboBox<String> cboUserTypeEdit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBookings;
    private javax.swing.JLabel lblCarListing;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblDashboardHeader;
    private javax.swing.JLabel lblDriverLicense;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIfYouWantToDeleteTheUsersPersonalDetails;
    private javax.swing.JLabel lblLeenda;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUserIDToDelete;
    private javax.swing.JLabel lblUserManagement;
    private javax.swing.JPanel pnlEditUserPersonalInformation;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSubHeader;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtDriverLicense;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserIDToDelete;
    // End of variables declaration//GEN-END:variables
}

/**
 *
 * @author: <edande - 223134902/>
 */
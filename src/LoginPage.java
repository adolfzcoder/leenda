import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginPage extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private static final String FILE_PATH = "users.csv";

    public LoginPage() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Create UI components
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 50, 160, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        add(loginButton);

        // Add action listener to the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        setVisible(true);
    }

    private void handleLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Validate login credentials
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                String[] userDetails = line.split(",");
                if (userDetails[1].equals(email) && userDetails[2].equals(password)) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    new Dashboard();
                    this.dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Login Failed: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SignupPage extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private static final String FILE_PATH = "users.csv";

    public SignupPage() {
        setTitle("Signup");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Create UI components
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 160, 25);
        add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 160, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 160, 25);
        add(passwordField);

        signupButton = new JButton("Signup");
        signupButton.setBounds(150, 200, 80, 25);
        add(signupButton);

        // Add action listener to the button
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignup();
            }
        });

        setVisible(true);
    }

    private void handleSignup() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Check for non-empty fields
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        // Check for valid email format
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return;
        }

        // Check for password strength
        if (!isStrongPassword(password)) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long and contain a number and a special character.");
            return;
        }

        // Store user details in the file
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                String[] userDetails = line.split(",");
                if (userDetails[1].equals(email)) {
                    JOptionPane.showMessageDialog(this, "Email already registered.");
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(username + "," + email + "," + password);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Signup Successful for: " + username);
                new LoginPage();
                this.dispose();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Signup Failed: " + ex.getMessage());
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    private boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        new SignupPage();
    }
}
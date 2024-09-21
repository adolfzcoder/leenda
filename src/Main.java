import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Rental System");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 50, 100, 30);
        frame.add(loginButton);

        // Signup button
        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(200, 50, 100, 30);
        frame.add(signupButton);

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                frame.dispose();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupPage();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}

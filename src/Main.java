import javax.swing.*;

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

        // Action listeners wait until button is clicked then it does function/job
        loginButton.addActionListener(e -> {
            // once clicks login button, close the current window, then open login page
            frame.dispose(); 
            new LoginPage(); 
        });

        signupButton.addActionListener(e -> {
            // once clicks signin button, close th ecurrent windown then open the sign up Window
            frame.dispose(); 
            new SignupPage(); 
        });

        frame.setVisible(true); // Make frame visible
    }
}

package validations;

import javax.swing.JOptionPane;

/**
 *
 * @author: <edande - 223134902/>
 */
public class Validation {
    // Check if the text field is empty(returns true if the text field is empty and
    // false if it's not.
    public static boolean checkIfTheTextFieldIsEmpty(String string, String contentName) {
        if (string.equals("")) {
            JOptionPane.showMessageDialog(null, "The " + contentName + " must not be empty");// Error message
            return true;
        }
        return false;
    }

    // Fields validation
    // Static method to validate first name
    public static boolean validateName(String name) {
        String nameRegex = "^(?!.*\\s)(!?[A-Z][a-zA-Z]*)$"; // First letter uppercase, then letters or '!'

        // Check if the first name matches the regex
        if (!name.matches(nameRegex)) {
            JOptionPane.showMessageDialog(null, "First name is invalid. \nOnly letters and '!' are allowed.",
                    "Invalid First Name", JOptionPane.ERROR_MESSAGE);
            return false; // Validation failed
        }
        return true; // Validation successful
    }

    // Static method to validate email
    public static boolean validateEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$"; // Basic email validation

        // Check if the email matches the regex
        if (!email.matches(emailRegex)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Invalid Email",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Validation failed
        }
        return true; // Validation successful
    }

    // Static method to validate phone number
    public static boolean validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\+\\d{1,4}\\d+$"; // Phone number validation

        // Check if the phone number matches the regex
        if (!phoneNumber.matches(phoneRegex)) {
            JOptionPane.showMessageDialog(null,
                    "Phone number must start with +country code \nand contain only numbers.", "Invalid Phone Number",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Validation failed
        }
        return true; // Validation successful
    }
}

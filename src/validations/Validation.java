package validations;

import javax.swing.JOptionPane;

/**
 *
 * @author: <edande - 223134902/>
 */
public class Validation {
    //Check if the text field is empty(returns true if the text field is empty and false if it's not.
    public static boolean checkIfTheTextFieldIsEmpty(String string, String contentName){
        if(string.equals("")){
            JOptionPane.showMessageDialog(null, "The " + contentName + " must not be empty");//Error message
            return true;
        }
        return false;
    }
}

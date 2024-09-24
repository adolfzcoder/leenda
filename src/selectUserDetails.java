/*
 * 
 * Class is for when you need to find a user, and their details, simply
 * pass the email to selectUserByEmail(), it will return the users information.
 * 
 * Returns the whole line where the email match occured.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectUserDetails {



    

    
    public static String findUserByEmail(String userEmail) throws FileNotFoundException{
        File file = new File("src\\storage\\userDetails.csv");

        try (Scanner scan = new Scanner(file)) {
            // split the line every where the ',' is
            String regex = "[,]";
            String fullLine = "";
            while (scan.hasNextLine()) {

                
                // read each line in the text file
                String line = scan.nextLine();
                
                String[] credentials = line.split(regex);
                
                String emailFromFile = credentials[0];

                if (userEmail.equals(emailFromFile)) {
                    // isFound = true;
                    fullLine = line;
                    break;
                }
                else{
                    // isFound = false;
                    System.out.println("User does not exist");
                }
                
            }
            return fullLine; // return the whole user info e.g hangula@gmail.com:123:081773443:Car owner
        }


    }
}

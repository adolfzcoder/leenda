package adminmodules;

import java.util.Scanner;

public class StorageFunctions {
    public static int fetchNumberOfUsers(Scanner scan) {
        int userCount = 0;

        // Loop through the file until no lines are left
        while (scan.hasNextLine()) {
            scan.nextLine();  // Read each line (user record)
            userCount++;  // Increment the count for each line
        }
    
        return userCount;  // Return the total number of users
    }
}

import java.io.FileNotFoundException;

public class FindUserType {

    public static String findUserType(String userEmail) throws FileNotFoundException{
        
        SplitByIndex splitByIndex = new SplitByIndex();

        String userType = splitByIndex.splitByIndex(userEmail, 3);

        return userType;
    }
    
}

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dashboard {
    public  void displayUserData(String userEmail) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);

        SplitByIndex splitByIndex = new SplitByIndex();

        AddCar addCar = new AddCar();
        SelectUserDetails selectUserDetails = new SelectUserDetails();
        ViewAvailableCars viewAvailableCars = new ViewAvailableCars();
        ViewCurrentlyBookedCars viewCurrentlyBookedCars = new ViewCurrentlyBookedCars();
        String userDetails =  selectUserDetails.findUserByEmail(userEmail);


        String userType = splitByIndex.splitByIndex(userEmail, 3);
        // System.out.println(userType);

        if (userType.equals("Car owner")){
            System.out.println("Car owner view");

            int choice = carOwnerChoice(scan);
            System.out.println("\n What would you like to do?\n 1. Add a car Enter 1\n 2.View currently booked cars Enter 2\n 3.Available Cars Enter 3");

            switch (choice) {
                case 1:
                    addCar.addCar(userEmail);
                    break;
                case 2:
                    viewCurrentlyBookedCars.viewCurrentlyBookedCars(userEmail);
                    break;
                case 3:
                    viewAvailableCars.viewAvailableCars(userEmail);
                    break;
                default:
                    break;
            }

            
            
            
            
        }else if (userType.equals("Customer")){

            System.out.println("Customer view");

        }else {

            System.out.println("Admin view");
            
        }

        // System.out.println(userDetails);



        
    }



    private void viewAvailableCars() {


    }



    private void viewCurrentlyBookedCars() {

    }



    private void addCar() {


    }

    public static int carOwnerChoice(Scanner scan){
        System.out.println("\n What would you like to do?\n 1. Add a car Type: 1\n 2.View currently booked cars Type: 2\n 3.Available Cars Type: 3");
        int choice = scan.nextInt();

        return choice;
            
    }
}

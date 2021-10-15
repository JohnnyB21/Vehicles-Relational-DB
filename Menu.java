import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private CarDao carDao = new CarDao();
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList("Display Cars",
    "Create A Car", "Delete A Car", "Update Year Of Car");

    public void start() {
        String selection = "";
        do {
            printMenu();
            selection = scanner.nextLine();
         try{
            if(selection.equals("1")){
                displayCars();

            }
            else if(selection.equals("2")){
                createNewCar();
            }
            else if(selection.equals("3")){
                deleteCar();
            }
            else if(selection.equals("4")){
                updateYear();
            }
         }catch(SQLException e){
             e.printStackTrace();
         }
         System.out.print("Select enter to continue: ");
         scanner.nextLine();
        }while (!selection.equals("-1"));
    }

    private void updateYear() throws SQLException {
        System.out.println("Enter in new Year Manufactured: ");
        int year_manufactured = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter in Car id on which you'd like to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        carDao.updateYear(year_manufactured, id);
    }

    private void deleteCar() throws SQLException {
        System.out.print("Enter in Car id to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        carDao.deleteCar(id);
    }

    private void createNewCar() throws SQLException {
        System.out.print("Enter in the Make of new vehicle:  ");
        String make = scanner.nextLine();
        System.out.print("Enter in the Model of new vehicle:  ");
        String model = scanner.nextLine();
        System.out.print("Enter in the Year Manufactured of new vehicle:  ");
        int year_manufactured = Integer.parseInt(scanner.nextLine());
        carDao.createNewCar(make, model, year_manufactured);
    }

    private void displayCars() throws SQLException {
        List<Cars> cars = carDao.getCars();
        for(Cars car : cars) {
            System.out.println(car.getId() + " Make: " + car.getMake() + " Model: " + car.getModel() + " Year: " + car.getYear());
        }
    }

    private void printMenu() {
        System.out.println("Select an option:\n-------------------");
        for(int i = 0; i < options.size(); i++){
            System.out.println(i + 1 + ") " + options.get(i));
        }
    }

}

import models.Product;
import dao.ProductDAO;
import services.InventoryService;
import java.util.Scanner;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();
        InventoryService is = new InventoryService();

        printStart();
        int userInput = 0;

        while(userInput != 7){
            System.out.println("1) Create a new product.\n2) Get product information.\n3) Update an existing product.\n4) Delete an existing product." +
                    "\n5) Reorder Low Stock\n6) Check Low Stock\n7) Quit");
            userInput = scan.nextInt();

            switch (userInput) {
                case 1: //Creating and inserting a new product
                    System.out.println("Create a new product...");
                    scan.nextLine();
                    System.out.println("Enter product name: ");
                    String nName = scan.nextLine();
                    System.out.println("Enter product price: ");
                    double nPrice = scan.nextDouble();
                    System.out.println("Enter product quantity: ");
                    int nQuantity = scan.nextInt();
                    System.out.println("New product created.");
                    dao.createProduct(nName, nPrice,  nQuantity);
                    break;

                case 2: //Get product information
                    System.out.println("Get product information...");
                    System.out.println("1) Specific product?\n2) All products?");
                    int choice = scan.nextInt();
                    if(choice == 1) {

                        System.out.println("Enter product id: ");
                        int id = scan.nextInt();
                        System.out.println(dao.getProduct(id));

                    } else if(choice == 2){

                        System.out.println("Returning all products...");
                        System.out.println(dao.getAllProducts());

                    }
                    break;

                case 3: //Update an existing product
                    System.out.println("Update an existing product...");
                    System.out.println("Enter product id: ");
                    int id = scan.nextInt();
                    System.out.println("What are you updating?\n1) Name\n2) Price\n3) Quantity\n4) Quit");
                    int userChoice = scan.nextInt();
                    scan.nextLine();

                    if(userChoice == 1){
                        System.out.println("Enter updated product name: ");
                        String updatedName = scan.nextLine();
                        dao.updateName(id, updatedName);

                    } else if(userChoice == 2){
                        System.out.println("Enter updated price: ");
                        double updatedPrice = scan.nextDouble();
                        dao.updatePrice(id, updatedPrice);

                    } else if(userChoice == 3){
                        System.out.println("Enter updated quantity: ");
                        int updatedQuantity = scan.nextInt();
                        dao.updateQuantity(id, updatedQuantity);

                    } else if(userChoice == 4){
                        break;
                    }
                    break;

                case 4: //Delete an existing product
                    System.out.println("Delete an existing product...");
                    System.out.println("Enter product id: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Are you sure you want to delete this product? [Y / N]: ");
                    System.out.println(dao.getProduct(id));
                    String userResponse = scan.nextLine();
                    if(userResponse.equals("Y")){
                        System.out.println("removing...");
                        dao.deleteProduct(id);
                    } else if(userResponse.equals("N")){
                        System.out.println("exiting.");
                        break;
                    }
                    break;

                case 5: //reorder
                    System.out.println("Reorder stock");
                    System.out.println("Would you like to: 1) Reorder for a specific product? 2) Reorder all low stock products?");
                    choice = scan.nextInt();
                    if(choice == 1){
                        System.out.println("Reorder for specific product...");
                        System.out.println("Enter product id");
                        int pid = scan.nextInt();
                        is.reorderStock(pid);
                        break;
                    } else if (choice == 2){
                        System.out.println("Reorder for all low products...");
                        is.reorderAllLow();
                        break;

                    } else {
                        System.out.println("Quitting...");
                        break;
                    }

                case 6: //check low stock
                    System.out.println("Checking low stock...");
                    System.out.println(is.checkLowStock());
            }
        }


    }

    private static int getTerminalWidth(){
        Console console = System.console();
        if(console != null){
            try {
                return Integer.parseInt(System.getenv("COLUMNS"));
            } catch (Exception e) {
                //ignore
            }
        }
        //this value will be used if it cannot detect the terminal width.
        return 80;
    }

    private static void printStart(){
        String message = "Welcome to CLI Inventory Manager!";
        int terminalWidth = getTerminalWidth();
        int boxWidth = Math.max(message.length() + 10, terminalWidth);

        String border = "x" + ":".repeat(boxWidth - 2) + "x";
        String emptyLine = "|" + " ".repeat(boxWidth -2) + "|";

        int padding = (boxWidth - 2 - message.length()) / 2;
        String centeredLine = "|" + " ".repeat(padding) + message + " ".repeat(boxWidth - 2 - padding - message.length()) + "|";

        System.out.println(border);
        System.out.println(emptyLine);
        System.out.println(centeredLine);
        System.out.println(emptyLine);
        System.out.println(border);
    }
}
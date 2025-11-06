import models.Product;
import dao.ProductDAO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        System.out.println("Welcome to CLI Inventory Manager!\nWhat can we help you with?");
        int userInput = 0;

        while(userInput != 5){
            System.out.println("1) Create a new product.\n2) Get product information.\n3) Update an existing product.\n4) Delete an existing product.\n5) Quit");
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
                    if(scan.nextInt() == 1) {

                        System.out.println("Enter product id: ");
                        int id = scan.nextInt();
                        System.out.println(dao.getProduct(id));

                    } else if(scan.nextInt() == 2){

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
            }
        }


    }
}
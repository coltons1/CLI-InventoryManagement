package services;
import dao.ProductDAO;
import models.Product;
import java.util.ArrayList;

//business logic, check low stock etc
public class InventoryService {
    ProductDAO dao = new ProductDAO();

    public ArrayList<Product> checkLowStock(){
        ArrayList<Product> list = new ArrayList<>();
        for(Product p : dao.getAllProducts()){
            if(p.getQuantity() <= 5){
                list.add(p);
            }
        }
        System.out.println("Returning list of products with a quantity of 5 or less.");
        return list;
    }

    public void reorderStock(int id){
        dao.addQuantity(id, 30);
    }

    public void reorderAllLow(){
        for (Product p : checkLowStock()){
            dao.addQuantity(p.getProductID(), 30);
        }
    }





}

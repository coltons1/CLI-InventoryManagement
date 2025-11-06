import models.Product;
import dao.ProductDAO;

import dao.ProductDAO;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Product product = new Product("test 4", 20, 67);
        dao.addProduct(product);
        dao.getProduct(4);
        //dao.updateName(1, "newTest1");
        //dao.updatePrice(1, 39.99);
        //dao.updateQuantity(1, 1);
        //dao.deleteProduct(4);
        //System.out.println(dao.getProduct(1));
    }
}
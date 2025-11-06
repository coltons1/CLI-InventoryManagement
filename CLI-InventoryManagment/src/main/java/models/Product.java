package models;
//Product Item Objects
public class Product {
    private int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(){}

    public Product(String pName, double pPrice, int pQuantity) {
        productName = pName;
        price = pPrice;
        quantity = pQuantity;
    }

    //accessor methods
    public int getProductID(){
        return productID;
    }

    public String getProductName(){
        return productName;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    //mutator methods
    public void setProductID(int pID){
        productID = pID;
    }

    public void setProductName(String pName){
        productName = pName;
    }

    public void setPrice(double pPrice){
        price = pPrice;
    }

    public void setQuantity(int pQuantity){
        quantity = pQuantity;
    }

    @Override
    public String toString(){
        return("Product ID: " + productID + "\nProduct Name: " + productName + "\nPrice: " + price + "\nQuantity: " + quantity);
    }

}

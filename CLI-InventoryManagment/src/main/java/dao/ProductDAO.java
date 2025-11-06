package dao;

import models.Product;
import utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//class to handle database actions and operations
public class ProductDAO {

    public static void connectDB(){
        try (Connection conn = DBConnection.getConnection()){
            System.out.println("connected to database");
        } catch (SQLException e){
            System.out.println("connection failed: " + e.getMessage());
        }
    }

    //SQL statement : insert into products (name, price, quantity) values ('name', price, quantity);
    public boolean addProduct(Product product){
        String sql = "insert into products (name, price, quantity) values (?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e){
            System.out.println("there was an error inserting.");
            return false;
        }
    };

    public Product getProduct(int id){
        String sql = "select * from products where productid = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            //this will store the result of the query
            ResultSet rS = stmt.executeQuery();
            Product prod;
            if(rS.next()){
                prod = new Product(rS.getString("name"), rS.getDouble("price"), rS.getInt("quantity"));
                prod.setProductID(rS.getInt("productid"));
                return prod;
            }
        } catch (SQLException e){
            System.out.println("Could not get product.");
        }
        return null;
    };

    //public void getAllProducts(){};

    public boolean updateName(int id, String name){
        String sql = "update products set name = ? where productid = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, name);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Update successful.");
            System.out.println("rows affected: " + rowsAffected);
            return true;
        } catch (SQLException e){
            System.out.println("Update failed.");
            return false;
        }
    }

    public boolean updatePrice(int id, Double price){
        String sql = "update products set price = ? where productid = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1, price);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Update successful.");
            System.out.println("rows affected: " + rowsAffected);
            return true;
        } catch (SQLException e){
            System.out.println("Update failed.");
            return false;
        }
    }

    public boolean updateQuantity(int id, int quantity){
        String sql = "update products set quantity = ? where productid = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, quantity);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Update successful.");
            System.out.println("rows affected: " + rowsAffected);
            return true;

        } catch (SQLException e){
            System.out.println("Update failed.");
            return false;
        }
    }

    public boolean deleteProduct(int id){
        String sql = "delete from products where productid = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Delete successful.");
            System.out.println("rows affected: " + rowsAffected);
            return true;

        } catch (SQLException e){
            System.out.println("Delete failed.");
            return false;
        }
    };


    public static void main(String args[]) {
        connectDB();
    }
}

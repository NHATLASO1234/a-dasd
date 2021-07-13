/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.products;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nhatvdm.utils.DBConnect;

/**
 *
 * @author ACER
 */
public class ProductsDAO implements Serializable{
    
    public List<ProductsDTO> getProductListByCateID(int cateID) 
            throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductsDTO> list = new ArrayList<>();
        
        try{
        //1.Connect DB
            con=DBConnect.makeConnection();
            if(con!=null){
                //2. Create SQL String
                String sql= "Select ProductID, ProductName, SupplierID, QuantityPerUnit, UnitPrice, ProductImage "
                        + "From Products "
                        + "Where CategoryID = ?";
                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setInt(1, cateID);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while(rs.next()){
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProductName");
                    int supplierID = rs.getInt("SupplierID");
                    int quantityPerUnit = rs.getInt("QuantityPerUnit");
                    double unitPrice = rs.getDouble("UnitPrice");
                    String productImage = rs.getString("ProductImage");
                    
                    ProductsDTO dto = new ProductsDTO(
                            productID, productName, supplierID, cateID, quantityPerUnit, unitPrice, productImage);
                    
                    list.add(dto);
                }//end while traversion is executed
                return list;
            }//end if con is opened
            return null;
        } finally{ 
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
             if(con != null){
                con.close();
            }
        }
        
    }
    
    public boolean addProduct(ProductsDTO product) 
        throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        String sql = "INSERT INTO Products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, ProductImage) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getProductName());
                stm.setInt(2, product.getSupplierID());
                stm.setInt(3, product.getCategoryID());
                stm.setInt(4, product.getQuantityPerUnit());
                stm.setDouble(5, product.getUnitPrice());
                stm.setString(6, product.getProductImage());
                
                int rowEffects = stm.executeUpdate();
                if (rowEffects > 0) {
                    return true;
                }
            }
        } finally{
            if(stm != null){
                stm.close();
            }
             if(con != null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean deleteProduct(String id) 
        throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        String sql = "DELETE FROM Products "
                + "WHERE ProductID=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                
                int rowEffects = stm.executeUpdate();
                if (rowEffects > 0) {
                    return true;
                }
            }
        } finally{
            if(stm != null){
                stm.close();
            }
             if(con != null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateProduct(ProductsDTO product)  
        throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        String sql = "UPDATE Products SET ProductName=?, SupplierID=?, "
                + "CategoryID=?, QuantityPerUnit=?, "
                + "UnitPrice=?, ProductImage=? "
                + "WHERE ProductID=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getProductName());
                stm.setInt(2, product.getSupplierID());
                stm.setInt(3, product.getCategoryID());
                stm.setInt(4, product.getQuantityPerUnit());
                stm.setDouble(5, product.getUnitPrice());
                stm.setString(6, product.getProductImage());
                stm.setInt(7, product.getProductID());
                
                int rowEffects = stm.executeUpdate();
                if (rowEffects > 0) {
                    return true;
                }
            }
        } finally{
            if(stm != null){
                stm.close();
            }
             if(con != null){
                con.close();
            }
        }
        return false;
    }
    public ProductsDTO getProductByProductID(String id) 
        throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO dto = null;
        
        try{
        //1.Connect DB
            con=DBConnect.makeConnection();
            if(con!=null){
                //2. Create SQL String
                String sql= "Select ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, ProductImage "
                        + "From Products "
                        + "Where ProductID = ?";
                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                if (rs.next()){
                    String productName = rs.getString("ProductName");
                    int supplierID = rs.getInt("SupplierID");
                    int cateID = rs.getInt("CategoryID");
                    int quantityPerUnit = rs.getInt("QuantityPerUnit");
                    double unitPrice = rs.getDouble("UnitPrice");
                    String productImage = rs.getString("ProductImage");
                    
                    dto = new ProductsDTO(
                            Integer.parseInt(id), productName, supplierID, cateID, quantityPerUnit, unitPrice, productImage);
                }//end while traversion is executed
                return dto;
            }//end if con is opened
            return null;
        } finally{ 
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
             if(con != null){
                con.close();
            }
        }
    }
}

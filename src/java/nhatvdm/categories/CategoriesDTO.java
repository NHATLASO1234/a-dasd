/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.categories;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import nhatvdm.products.ProductsDAO;
import nhatvdm.products.ProductsDTO;

/**
 *
 * @author ACER
 */
public class CategoriesDTO implements Serializable{
    private int categoryID;
    private String categoryName;
    private String description;
    private List<ProductsDTO> listProduct;

    public List<ProductsDTO> getListProduct() {
        ProductsDAO dao = new ProductsDAO();
        try{
            listProduct = dao.getProductListByCateID(categoryID);
        } catch (NamingException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listProduct;
    }

    public void setListProduct(List<ProductsDTO> listProduct) {
        this.listProduct = listProduct;
    }

    public CategoriesDTO(int categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

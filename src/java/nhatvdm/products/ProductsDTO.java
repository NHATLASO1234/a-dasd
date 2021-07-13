/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.products;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class ProductsDTO implements Serializable{
    private int productID;
    private String productName;
    private int supplierID;
    private int categoryID;
    private int quantityPerUnit;
    private double unitPrice;
    private String productImage;

    public ProductsDTO() {
        this.productID = 0;
        this.productName = "";
        this.supplierID = 0;
        this.categoryID = 0;
        this.quantityPerUnit = 0;
        this.unitPrice = 0;
        this.productImage = "";
    }

    public ProductsDTO(int productID, String productName, int supplierID, int categoryID, int quantityPerUnit, double unitPrice, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.productImage = productImage;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
    
}
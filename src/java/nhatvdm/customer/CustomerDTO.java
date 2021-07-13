/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.customer;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class CustomerDTO implements Serializable{
    private int CustomerID;
    private String username;
    private String password;
    private String fullname;
    private int type;

    public CustomerDTO(int accountID, String username, String password, String fullname, int type) {
        this.CustomerID = accountID;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.type = type;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}

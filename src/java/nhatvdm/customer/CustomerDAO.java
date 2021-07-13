/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import nhatvdm.utils.DBConnect;

/**
 *
 * @author ACER
 */
public class CustomerDAO implements Serializable{
    public CustomerDTO checkLogin(String username, String password) 
    throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBConnect.makeConnection();
            String sql = "SELECT CustomerID, FullName, Type "
                    + "FROM ContactName "
                    + "WHERE Username = ? and Password = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                int accountID = rs.getInt("AccountID");
                String fullname = rs.getString("FullName");
                int type = rs.getInt("Type");
                CustomerDTO dto = new CustomerDTO(accountID, username, password, fullname, type);
                return dto;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return null;
    }
}

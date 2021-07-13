/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.suppliers;

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
public class SuppliersDAO implements Serializable{
    public List<Integer> getSupplierIDs() 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Integer> list = null;
        try {
            con = DBConnect.makeConnection();
            String sql = "Select SupplierID "
                    + "From Suppliers";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int supplierID = rs.getInt("SupplierID");
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(supplierID);
            }
            return list;
        } finally {
            if(con != null){
                con.close();
            }
            if(stm != null){
                stm.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
}

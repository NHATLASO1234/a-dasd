/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.categories;

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
public class CategoriesDAO implements Serializable{
    private List<CategoriesDTO> cateList;
    
    public List<CategoriesDTO> getCategoriesList() {
        return cateList;
    }
    
    public void addCategories() 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
        //1.Connect DB
            con=DBConnect.makeConnection();
            if(con!=null){
                //2. Create SQL String
                String sql= "Select CategoryID, CategoryName, Description "
                        + "From Categories ";
                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while(rs.next()){
                    int cateID = rs.getInt("CategoryID");
                    String cateName = rs.getString("CategoryName");
                    String desciption = rs.getString("Description");
                    CategoriesDTO dto = new CategoriesDTO(
                            cateID, cateName, desciption);
                    
                    if(this.cateList == null) {
                        this.cateList = new ArrayList<>();
                        
                    }//end if account is not allocated
                    this.cateList.add(dto);
                }//end while traversion is executed
            }//end if con is opened
        } finally{
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

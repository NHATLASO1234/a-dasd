/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhatvdm.categories.CategoriesDAO;
import nhatvdm.categories.CategoriesDTO;
import nhatvdm.products.ProductsDAO;
import nhatvdm.products.ProductsDTO;
import nhatvdm.suppliers.SuppliersDAO;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
public class AddProductServlet extends HttpServlet {
    private String ADD_PRODUCT_PAGE = "addProduct.jsp";
    private String PRODUCT_PAGE = "product.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String name = request.getParameter("txtProductName");
        String supplierID = request.getParameter("supplierID");
        String categoryID = request.getParameter("categoryID");
        String quantity = request.getParameter("txtQuantityPerUnit");
        String price = request.getParameter("txtUnitPrice");
        String image = request.getParameter("txtProductImage");
        String url = ADD_PRODUCT_PAGE;      
        boolean result = false;
        try{  
            if (name.trim().length() > 0 && quantity.trim().length() > 0 
                    && price.trim().length() >0 && image.trim().length() > 0){
                ProductsDAO dao = new ProductsDAO();

                ProductsDTO product = new ProductsDTO(0, name, Integer.parseInt(supplierID), Integer.parseInt(categoryID), Integer.parseInt(quantity), Double.parseDouble(price), image);
                result = dao.addProduct(product);
                request.setAttribute("MSG", "Product is added successfully.");
            } else {
                request.setAttribute("MSG", "Fail to add product. All information field is required.");
            }
            if (result) {
                url = ADD_PRODUCT_PAGE;
            }
            SuppliersDAO supDao = new SuppliersDAO();
            List<Integer> listSupplier = supDao.getSupplierIDs();
            request.setAttribute("SUPPLIERS_LIST", listSupplier);
                
            CategoriesDAO cateDao = new CategoriesDAO();
            cateDao.addCategories();
            List<CategoriesDTO> cateList = cateDao.getCategoriesList();
            request.setAttribute("CATEGORIES_LIST", cateList);
           
        } catch (SQLException e) {
            log("AddProductServlet _ SQL: " + e.getMessage());
        } catch (NamingException e) {
            log("AddProductServlet _ Naming: " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

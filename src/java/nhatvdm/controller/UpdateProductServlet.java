/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatvdm.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhatvdm.products.ProductsDAO;
import nhatvdm.products.ProductsDTO;

/**
 *
 * @author ACER
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {
    private final String DISPATCH_SERVLET = "DispatchServlet"; 
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
        String id = request.getParameter("txtProductID");
        String name = request.getParameter("txtProductName");
        String supplierID = request.getParameter("supplierID");
        String categoryID = request.getParameter("categoryID");
        String quantity = request.getParameter("txtQuantityPerUnit");
        String price = request.getParameter("txtUnitPrice");
        String image = request.getParameter("txtProductImage");
        String url = DISPATCH_SERVLET;
        try{  
            ProductsDAO dao = new ProductsDAO();
            ProductsDTO product = new ProductsDTO(Integer.parseInt(id), name, Integer.parseInt(supplierID), 
                    Integer.parseInt(categoryID), Integer.parseInt(quantity), Double.parseDouble(price), image);
            boolean result = dao.updateProduct(product);
            if (result){
                url = DISPATCH_SERVLET;
            }
        } catch (SQLException e) {
            log("UpdateProductServlet _ SQL: " + e.getMessage());
        } catch (NamingException e) {
            log("UpdateProductServlet _ Naming: " + e.getMessage());
        } finally {
            response.sendRedirect(url);
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

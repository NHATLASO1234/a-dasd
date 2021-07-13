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
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String LOGIN_PAGE = "login.html";
    private final String START_UP_CONTROLLER = "StartUpServlet";
    private final String ADD_PRODUCT_PAGE = "addProduct.jsp";
    private final String UPDATE_PRODUCT_PAGE = "updateProduct.jsp";
    private final String ADD_PRODUCT_CONTROLLER = "AddProductServlet";
    private final String DELETE_PRODUCT_CONTROLLER = "DeleteProductServlet";
    private final String LOG_OUT_CONTROLLER = "LogOutServlet";
    private final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductServlet";
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
        String url = LOGIN_PAGE;
        try {
            String button = request.getParameter("btAction");
            if (button == null) {
                url = START_UP_CONTROLLER;
           
            } else if (button.equals("Login")) {
                url = LOGIN_CONTROLLER;
                
            } else if (button.equals("Add")) {
                url = ADD_PRODUCT_CONTROLLER;
          
            } else if (button.equals("delete")) {
                url = DELETE_PRODUCT_CONTROLLER;
                
            } else if (button.equals("Update")) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (button.equals("addform")) {
                url = ADD_PRODUCT_PAGE;
                SuppliersDAO supDao = new SuppliersDAO();
                List<Integer> listSupplier = supDao.getSupplierIDs();
                request.setAttribute("SUPPLIERS_LIST", listSupplier);
                
                CategoriesDAO dao = new CategoriesDAO();
                dao.addCategories();
                List<CategoriesDTO> cateList = dao.getCategoriesList();
                request.setAttribute("CATEGORIES_LIST", cateList);
            } else if (button.equals("updateform")) {
                url = UPDATE_PRODUCT_PAGE;
                String id = request.getParameter("pid");
                
                ProductsDAO dao = new ProductsDAO();
                ProductsDTO product = dao.getProductByProductID(id);
                request.setAttribute("PRODUCT", product);
                
                SuppliersDAO supDao = new SuppliersDAO();
                List<Integer> listSupplier = supDao.getSupplierIDs();
                request.setAttribute("SUPPLIERS_LIST", listSupplier);
                
                CategoriesDAO cateDao = new CategoriesDAO();
                cateDao.addCategories();
                List<CategoriesDTO> cateList = cateDao.getCategoriesList();
                request.setAttribute("CATEGORIES_LIST", cateList);
            } else if (button.equals("logout")) {
                url = LOG_OUT_CONTROLLER;
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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

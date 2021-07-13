<%-- 
    Document   : updateProduct
    Created on : Apr 18, 2021, 10:56:00 PM
    Author     : win 10
--%>

<%@page import="nhatvdm.categories.CategoriesDTO"%>
<%@page import="java.util.List"%>
<%@page import="nhatvdm.products.ProductsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update product page</title>
    </head>
    <body>
        <h1>Update product information</h1>
        <form action="DispatchServlet" name="updateProduct" method="POST">
            <table width="600px" border="0px solid">
                <%  
                    ProductsDTO product =(ProductsDTO) request.getAttribute("PRODUCT");
                %>
                    <tr>
                        <td>ProductID</td>
                        <td>: <input type="text" name="txtProductID" value="<%= product.getProductID() %>" readonly/> </td>
                    </tr>
                    <tr>
                        <td>ProductName</td>
                        <td>: <input type="text" name="txtProductName" value="<%= product.getProductName() %>" /> </td>
                    </tr>
                    <tr>
                        <td>SupplierID</td>
                        <td>: <select name="supplierID">
                            <% 
                                List<Integer> supplierList = (List<Integer>) request.getAttribute("SUPPLIERS_LIST");
                                for (int supplierID : supplierList) {
                            %>
                            <option
                            <% if (supplierID == product.getSupplierID()) {
                                %>
                                selected="selected"
                                <% 
                                    } 
                                %>
                            ><%= supplierID%></option>
                            <% 
                                }
                            %>
                        </select> </td>
                    </tr>
                    <tr>
                        <td>CategoryID</td>
                        <td>: <select name="categoryID">
                            <% 
                                List<CategoriesDTO> categoryList = (List<CategoriesDTO>) request.getAttribute("CATEGORIES_LIST");
                                for (CategoriesDTO category : categoryList) {
                            %>
                            <option 
                                <% if (category.getCategoryID() == product.getCategoryID()) {
                                %>
                                selected="selected"
                                <% 
                                    } 
                                %>
                                ><%= category.getCategoryID() %></option>
                            <% 
                                }
                            %>
                        </select> </td>
                    </tr>
                    <tr>
                        <td>QuantityPerUnit</td>
                        <td>: <input type="number" name="txtQuantityPerUnit" value="<%= product.getQuantityPerUnit() %>" /> </td>
                    </tr>
                    <tr>
                        <td>UnitPrice</td>
                        <td>: <input type="number" name="txtUnitPrice" value="<%= product.getUnitPrice() %>" /> </td>
                    </tr>
                    <tr>
                        <td>ProductImage</td>
                        <td>: <input type="text" name="txtProductImage" value="<%= product.getProductImage() %>" /> </td>
                    </tr>
            </table>
            <input type="submit" value="Update" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>


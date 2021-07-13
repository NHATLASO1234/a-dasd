<%-- 
    Document   : addProduct
    Created on : Apr 14, 2021, 10:10:32 AM
    Author     : win 10
--%>

<%@page import="nhatvdm.categories.CategoriesDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product page</title>
    </head>
    <body>
        <h1>Add product information</h1>
        <form action="DispatchServlet" name="addProduct" method="POST">
            <table width="600px" border="0px solid">
                    <tr>
                        <td>ProductName</td>
                        <td>: <input type="text" name="txtProductName" value="<%= (request.getParameter("txtProductName") == null) ? "" : request.getParameter("txtProductName") %>" /> </td>
                    </tr>
                    <tr>
                        <td>SupplierID</td>
                        <td>: <select name="supplierID">
                            <% 
                                List<Integer> supplierList = (List<Integer>) request.getAttribute("SUPPLIERS_LIST");
                                for (int supplier : supplierList) {
                            %>
                            <option><%= supplier %></option>
                            <% 
                                }
                            %>
                            <%--                            <c:set var="supplierList" value="${requestScope.SUPPLIERS_LIST}"/>
                            <c:forEach var="supplierID" items="${supplierList}" >
                                <option>${supplierID}</option>
                            </c:forEach> --%>
                        </select> </td>
                    </tr>
                    <tr>
                        <td>CategoryID</td>
                        <td>: <select name="categoryID">
                            <% 
                                List<CategoriesDTO> categoryList = (List<CategoriesDTO>) request.getAttribute("CATEGORIES_LIST");
                                for (CategoriesDTO category : categoryList) {
                            %>
                            <option><%= category.getCategoryID() %></option>
                            <% 
                                }
                            %>
<%--                            <c:set var="categoryList" value="${requestScope.CATEGORIES_LIST}"/>
                            <c:forEach var="category" items="${categoryList}" >
                                <option>${category.categoryID}</option>
                            </c:forEach> --%>
                        </select> </td>
                    </tr>
                    <tr>
                        <td>QuantityPerUnit</td>
                        <td>: <input type="number" name="txtQuantityPerUnit" value="<%= request.getParameter("txtQuantityPerUnit") %>" /> </td>
                    </tr>
                    <tr>
                        <td>UnitPrice</td>
                        <td>: <input type="number" name="txtUnitPrice" value="<%= request.getParameter("txtUnitPrice") %>" /> </td>
                    </tr>
                    <tr>
                        <td>ProductImage</td>
                        <td>: <input type="text" name="txtProductImage" value="<%= (request.getParameter("txtProductImage") == null) ? "" : request.getParameter("txtProductImage") %>" /> </td>
                    </tr>
            </table>
            <input type="submit" value="Add" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
        <a href="DispatchServlet">Back to product page.</a>
    </body>
    <% 
        String msg = (String) request.getAttribute("MSG");
        if (msg != null) {
    %>
        <div><%= msg %></div>
    <% 
        }
    %>
</html>

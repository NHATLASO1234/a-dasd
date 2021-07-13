<%-- 
    Document   : product
    Created on : Apr 13, 2021, 8:14:39 PM
    Author     : win 10
--%>

<%@page import="nhatvdm.products.ProductsDTO"%>
<%@page import="nhatvdm.categories.CategoriesDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <font color="red">
        Welcome, <%= session.getAttribute("FULLNAME") %>
        </font>
        (<a href="DispatchServlet?btAction=logout">Logout</a>) <br/>
        <h1>Product Page</h1> <br/>
        <a href="DispatchServlet?btAction=addform">Add a new product information.</a> <br/>
        <%
            List<CategoriesDTO> cateList =(List<CategoriesDTO>) request.getAttribute("CATEGORIES_LIST");
            if (cateList != null) {
                for (CategoriesDTO category: cateList) {
                    
        %>
<%--        <c:set var="cateList" value="${requestScope.CATEGORIES_LIST}"/>
        <c:if test="${not empty cateList}">
            <c:forEach var="category" items="${cateList}"> --%>
                <h2><%= category.getCategoryName() %></h2>
                <%
                    List<ProductsDTO> productList = category.getListProduct();
                    if (!productList.isEmpty()) {
                %>
<%--                <c:set var="listProduct" value="${category.listProduct}"/>
                <c:if test="${not empty listProduct}"> --%>
                    <table border="1">
                    <thead>
                        <tr>
                            <th>ProductID</th>
                            <th>ProductName</th>
                            <th>SupplierID</th>
                            <th>CategoryID</th>
                            <th>QuantityPerUnit</th>
                            <th>UnitPrice</th>
                            <th>ProductImage</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (ProductsDTO product:productList) {
                        %>
<%--                        <c:forEach var="product" items="${listProduct}"> --%>
                        <form action="DispatchServlet" name="UDProduct">
                            <tr>
                                <td><%= product.getProductID() %></td>
                                <td><%= product.getProductName() %></td>
                                <td><%= product.getSupplierID() %></td>
                                <td><%= product.getCategoryID() %></td>
                                <td><%= product.getQuantityPerUnit() %></td>
                                <td><%= product.getUnitPrice() %></td>
                                <td><%= product.getProductImage() %></td>
                                <td>
                                    <a href="DispatchServlet?btAction=updateform&pid=<%= product.getProductID() %>">Edit</a>
                                </td>
                                <td>
                                    <a href="DispatchServlet?btAction=delete&pid=<%= product.getProductID() %>" onclick="return confirm('Delete entry?')">Delete</a>
                                </td>
                            </tr>
                        </form>
                        <%
                            }
                        %>
<%--                        </c:forEach> --%>
                    </tbody>
                </table>
                <%
                    } else {
                %>
                    <h3>No product is found in this category.</h3>
                <%        
                    }
                }
            }
                %>
<%--                </c:if>
                <c:if test="${empty listProduct}">
                    <h3>No product is found in this category.</h3>
                </c:if> 
            </c:forEach>
        </c:if> --%>
        
    </body>
</html>

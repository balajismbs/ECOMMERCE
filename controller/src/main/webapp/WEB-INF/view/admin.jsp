<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <nav>
      <table>
       <tr>
       <td>
       <c:url value="productdetails" var="Product"/>
       <c:url value="supplier" var="supplier"/>
    <a href="${Product}" >Product</a>  
       </td>
       <td>
        <c:url value="categorydetails" var="Categories"/>
     <a href="${Categories}">Category</a>
       </td>
       <td>
       <c:url value="supplierdetails" var="Suppliers"/>
    <a href="${Suppliers}">Supplier</a>
       </td>
       </tr>
      </table>
   </nav>
</body>
</html>
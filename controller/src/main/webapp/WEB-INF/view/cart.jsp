<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<center>Hello  <%String usename=(String)session.getAttribute("usename") ;
 out.println(usename);
 %></center>
<c:url value="/resources/images/" var="image"/>
  <table class="table">
   <thead class="thead-dark">
   <th>image</th>
   <th>amount</th>
   <th>option</th>
   <c:forEach items="${cartlist}" var="cart">
     <tr class="table-success">
        <td>
           ${cart.productid}
           <img src="${image}${cart.productid}.jpg" height="50px" width="50px"/>
         </td> 
          <td>
             ${cart.amount}
          </td>
          <td>
           <a href='deletecart?id=${cart.id}'>delete</a>
          </td>
      </tr>
   </c:forEach>
   Total amount ${carttotal}
</table>
<c:url value="paymentdetails" var="payment"/>
<a href="${payment}">payment</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
Product Details
<f:form method="post" action="updatesupplier" modelAttribute="addsupplier">
<table>
<tr>
<td>
<f:input path="id" value="${currproduct.id}"/>
</td>
<td>
Enter Supplier Name
</td>
<td>
<f:input path="paymentmethod" value="${currproduct.paymentmethod}" />
</td>
</tr>
<tr>
<td>
Enter Address
</td>
<td>
<f:textarea path="shippingaddress" value="${currproduct.shippingaddress}"/>
</td>
</tr>

</table>
<tr>
<td>
<input type='submit' value="save"/>
</td>
</tr>
</f:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
.error{color:red}
</style>
</head>
<body>
<c:url value="/resources/images/" var="image"/>
<center><h1>Product Details</h1></center>
<f:form method="post" action="addproduct" modelAttribute="addproduct" enctype="multipart/form-data">
<table class="table table-dark">
<tr>
<td>
<center>Enter Product Name :</center>
</td>
<td>
<div class="form-group">
<f:input path="productname" class="form-control"/>
<f:errors path="productname" class="error"/>
</div>
</td>
</tr>
<tr>
<td>
<center>Enter Amount :</center>
</td>
<td>
<div class="form-group">
<f:input path="amount" class="form-control"/>
<f:errors path="amount" class="error"/>
</div>
</td>
</tr>
<tr>
<td>
<center>Enter Quantity :</center>
</td>
<td>
<div class="form-group">
<f:input path="quantity" class="form-control"/>
<f:errors path="quantity" class="error"/>
</div>
</td>
</tr>
<tr>
<td>
<center>Enter description :</center>
</td>
<td>
<div class="form-group">
<f:textarea path="description" class="form-control"/>
<f:errors path="description" class="error"/>
</div>
</td>
</tr>
<tr>
<td>
<center>Select Category Id :</center>
</td>
<td>
<div class="form-group">
<f:input path="categoryid" class="form-control"/>
<f:errors path="categoryid" class="error"/>
</div>
</td>
</tr>
<tr>
<td>
<center>Select Supplier Id :</center>
</td>
<td>
<div class="form-group">
<select name="supplierId">
<c:forEach items="${supplierlist}" var="supplier">
    <option value="${supplier.supplierId}" class="form-control">
       ${supplier.suppliername}
    </option>
</c:forEach>
</select>
</div>
</td>
</tr>
<tr>
<td>
<center>Select Product Image :</center>
</td>
<td>
<div class="form-group">
<input type="file" name="image" class="form-control"/>
</div>
</td>
</tr>
</table>
<tr>
<td>
<center><input type='submit' value="save" class="btn btn-dark btn-lg"/></center>
</td>
</tr>
</f:form><br>
<table class="table">
 <thead class="thead-dark">
<th>
Product Name
</th>
<th>
Price
</th>
<th>
Quantity
</th>
<th>image</th>
<th>option</th>
<th>option</th>
</thead>
<c:forEach items="${productlist}" var="product">
<tr class="table-success">
<td>
${product.productname}
</td>
<td>
${product.amount}
</td>
<td>
${product.quantity}
</td>
<td>
<img src="${image}${product.id}.jpg" height="50" width="50"/>
</td>
<td>
<a href="productdetails?id=${product.id}">edit</a>
</td>
<td>
<a href='deleteproduct?id=${product.id}'>delete</a>
</td>
</tr>

</c:forEach>
</table>

</body>
</html>
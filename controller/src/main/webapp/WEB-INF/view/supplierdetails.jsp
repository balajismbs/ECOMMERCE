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
</head>
<body>
<center><h1>Supplier Details</h1></center>
<f:form method="post" action="addsupplier" modelAttribute="addsupplier" >
<table class="table table-dark">
<tr>
<td>
<center>Enter Supplier Name :</center>
</td>
<td>
<div class="form-group">
<f:input path="suppliername" class="form-control" />
</div>
</td>
</tr>

<tr>

<td>
<center>Enter Address :</center>
</td>
<td>
<div class="form-group">
<f:textarea path="supplieraddress" class="form-control"/>
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
Supplier Name
</th>
<th>
Supplier Address
</th>
<th>option</th>
<th>option</th>
</thead>
<c:forEach items="${supplierlist}" var="supplier">
<tr class="table-success">
<td>
${supplier.suppliername}
</td>
<td>
${supplier.supplieraddress}
</td>
<td>
<a href="supplierdetails?id=${supplier.supplierId}">edit</a>
</td>
<td>
<a href='deletesupplier?id=${supplier.supplierId}'>delete</a>
</td>
</tr>

</c:forEach>
</table>

</body>
</html>
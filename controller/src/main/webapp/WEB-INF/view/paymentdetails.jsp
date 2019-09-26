<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("slow");
  });
});
</script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style> 
#panel, #flip {
  padding: 5px;
  text-align: center;
  background-color:white;
  
}

#panel {
  padding: 50px;
   border: solid 1px #c3c3c3;
  display: none;
  
}
</style>
</head>
<body>
<c:url value="/resources/images/" var="image"/>
<c:url value="invoice" var="invoice"/>
<center>
<img src="${image}card.jpg"/>
PAYMENT DETAILS
<f:form method="post" action="bill" modelAttribute="addpayment" >
<table>
<tr>
<td>
Enter payment method :
</td>
<td><div id="flip">
<f:radiobutton path="paymentmethod" value="card" />CARD </div><br>
<div id="panel">Enter the account no:<f:input path="accountno" value="${currproduct.accountno}" /><br><br>
<input type='text' placeholder='CARD.NO'/>
<input type='text' placeholder='CCV' />
</div>
<f:radiobutton path="paymentmethod" value="cash" />CASH ON DELIVERY<br>
</td>
</tr>
<br>
<tr>
<td>
Enter  shipping Address
</td>
<td>
<f:textarea path="shippingaddress" value="${currproduct.shippingaddress}" />
</td>
</tr>
</table><br><br>
<tr>
<td>
<input type='submit' class="btn btn-success" value="save"/>&nbsp &nbsp
<a href="${invoice}" type="button" class="btn btn-success" font-size="15px">By now</a>
</td>
</tr>
</f:form>
</center>

</body>
</html>
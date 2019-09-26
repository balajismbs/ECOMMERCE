<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$("hi").click(function){
    $("figure").addClass("hi");
    $("img").addClass("hello");
  });
});
</script>
<title>Insert title here</title>
<style>
.hi
{
width:250;
height:250;
-webkit-transition: width 1s, height 1s;
transition: width 1s, height 1s;
}
.hello
{
width:300;
height:300;
}
</style>
</head>
<body>

<c:if test="${logoutstatus}==true"> 
<jsp:forward page="/login"/>
</c:if><center>
Hello  <%String usename=(String)session.getAttribute("usename") ;
 out.println(usename);
 %>
</center>
 <c:url value="/resources/images/" var="image"/>
<c:url value="cart" var="gotocart"/>
<c:url value="signup" var="sign"/>
<div class="jumbotron text-center">
<h1>shopping site</h1><br>
<div class="container">
<div class="input-group">
<form class="navbar-form" role="search">
    <div class="input-group-addon">
     <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text" size="130px">
      <div class="input-group-btn">
        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search" style="font-size:20px;"></i></button>
</div></div></form><br><br>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<a href="${gotocart}" class="btn btn-info" role="button"><span class="glyphicon glyphicon-shopping-cart" style="font-size:18px;">cart<label class="badge" id="count" >${cartsize}</label></a>&nbsp &nbsp &nbsp &nbsp&nbsp 
<a href="#" class="btn btn-info" role="button"><span class="glyphicon glyphicon-globe" style="font-size:18px;">aboutus</a>&nbsp &nbsp &nbsp &nbsp&nbsp 
<a href="logout" class="btn btn-info" role="button"><span class="glyphicon glyphicon-log-out" style="font-size:18px;">logout</a>&nbsp &nbsp &nbsp &nbsp&nbsp 
</div></div></div></div></div></div></div></div></div></form>
<br><br>
<div class="container">
<div class="row">
<c:forEach items="${productlist}" var="product" varStatus="vs">
<div class="col-md-4">
       <figure><a href="#" data-toggle="modal" data-target="#myModal${vs.index}"><img src="${image}${product.id}.jpg" class="img-rounded" alt="Cinque Terre" width="300" height="300"></a>
<figcaption><center>headphones ax1000 wireless and bluetooth connectivity and some other options</center></figcaption></figure>
<div class="modal fade" id="myModal${vs.index}" role="dialog">
<div class="modal-dialog modal-lg">
    <div class="modal-content"><br><br>
   <center> <img src="${image}${product.id}.jpg" class="img-rounded" alt="Cinque Terre" width="300" height="300"></center><br><br>
   <center>Description:${product.description}</center>
   <center>Amount:${product.amount}<br><br>
    <div>
<f:form method="post" action="addtocart" modelAttribute="mycart">
 <input type='hidden' name="email" value=<%=usename%>/>
 <input type='hidden' name='productid' value='${product.id}'/>
 <input type='hidden' name='amount' value='${product.amount}'/>
 <center><input type='submit' value='addtocart' class="btn btn-info" role="button"/></div></center><br><br>
        </f:form></div>
</div>
</div>
    </div>
</c:forEach>
<c:forEach items="${productlist}" var="product">
</c:forEach>

</body>
</html>
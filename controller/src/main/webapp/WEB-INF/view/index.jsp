 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width:100% 
      height: 100%;
  }
  </style>
</head>
<body>
<c:url value="/resources/images/" var="image"/>
<c:url value="userhome" var="home"/>
<div class="jumbotron text-center">
<h1><strong>SHOPPING SITE</strong></h1><br>
<div class="container">
<div class="input-group">
<form class="navbar-form" role="search">
    <div class="input-group-addon">
     
      <div class="input-group-btn">
        
</div></div></form><br><br>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp 

<a href="${home}" class="btn btn-info" role="button"><span class="glyphicon glyphicon-home" style="font-size:18px;">home<label class="badge" id="count" >${cartsize}</label></a>&nbsp &nbsp &nbsp &nbsp&nbsp 
<a href="/userhome" class="btn btn-info" role="button"><span class="glyphicon glyphicon-globe" style="font-size:18px;">aboutus</a>&nbsp &nbsp &nbsp &nbsp&nbsp 

</div></div></div></div></div></div></div></div></div></form>
<div id="demo" class="carousel slide" data-ride="carousel" data-interval="2000">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${image}a.jpg" alt="Los Angeles" width="2000" height="400">
    </div>
    <div class="carousel-item">
      <img src="${image}b.jpg" alt="Chicago" width="2000" height="400">
    </div>
    <div class="carousel-item">
      <img src="${image}c.jpg" alt="New York" width="2000" height="400">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

</body>
</html>



<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
            body {
                overflow-x: hidden;
                font-family: 'Roboto Slab', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';
            }
            .signature{
                font-family: 'Kaushan Script', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';
                color: #0099D5;
            }

            .table thead th {
                vertical-align: bottom;
                border-bottom: 2px solid transparent;
                background: #0099D5;
                color: #fff;
            }
            .font-weight-lighter{
                font-weight: 300;
                background: #0099D5;
                color: #fff;
            }
            .inv{
                background: #E6E4E7;
            }
            .my-3 {
                margin-bottom: 1rem !important;
                margin-top: 1rem !important;
            }
            .my-5 {
                margin-bottom: 3rem !important;
                margin-top: 3rem !important;
            }
            .py-5 {
                padding-bottom: 3rem !important;
                padding-top: 3rem !important;
            }
            .px-3 {
                padding-left: 3rem !important;
                padding-right: 3rem !important;
            }
            .border-bottom{
                border-bottom: 2px solid #000 !important;
                /*width: 35%;*/
                padding: 0px 0px 5px 0px;
            }
</style>
</head>
<body>
<c:url value="/resources/images/" var="image"/>
        <div class="container inv my-5 py-5">
            <div class="row">
                <div class="col-lg-6"></div>
                <div class="col-lg-6">
                    <h1 class="font-weight-lighter py-1 px-3">INVOICE</h1>
                </div>
            </div>
            
            <div class="row my-3">
                <div class="col-lg-6">
                    <p class="mb-0">INVOICE TO</p> 
                    <h5 class="mb-0"><b>  <%String usename=(String)session.getAttribute("usename") ;
 out.println(usename);
 %></b></h5>
                    <c:forEach items="${paymentlist}" var="pay">
                <p class="mb-0">${pay.shippingaddress} </p>
                    </c:forEach>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-12">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Invoice No</td>
                                        <td class="px-3">:</td>
                                        <td>123456</td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
            
                <div class="col-lg-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th >Image</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                                <th >Amount</th>
                             
                                
                            
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            <c:forEach items="${cartlist}" var="cart">
                                <td><img src="${image}${cart.productid}.jpg" height="50px" width="50px"/></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                   ${cart.amount}
                                </td>
                                
                             
                            </tr>
                            </c:forEach>
                            <tr style="background: #E6E4E7; color: #0099D5;">
                                <td colspan="3"></td>
                                <td><b>GRAND TOTAL</b></td>
                                <td><b>${carttotal}</b></td>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3">
                    <h5 class="ml-5 border-bottom">Payment Method</h5>
                    <h6 class="text-center">Paypal</h6>
                    <p></p>
                </div>
                <div class="col-lg-6"></div>
            </div>
            <div class="row mt-5">
                <div class="col-lg-6">
                    <h5 class="ml-5">Terms and Conditions</h5>
                    <p class="ml-5">
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
                        when an unknown printer took a galley of type and scrambled it to make a type specimen book.
                    </p>
                </div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3 text-center">
                    <h3 class="signature">balaji</h3>
                    <p>Account Manager</p>
                </div>
            </div>
        </div>
</body>
</html>
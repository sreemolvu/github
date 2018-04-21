<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./resources/css/homecss.css">  

<title>Shopping Cart</title>
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>


<%--<h3 style="color:red;">${message}</h3> --%>

</br>
</br>
</br>
<div class="container">
    
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
 
    <div class="carousel-inner">
 	   <c:forEach items="${productlist}" begin="8" end="8" var="product"> 
      <div class="item active">
       <a href="product?id=${product.id}" ><img src="${pageContext.request.contextPath}/resources/images/${product.id}.PNG" style="width:1200px;height: 600px"></a>
      </div>
      </c:forEach>
   <c:forEach items="${productlist}" begin="11" end="12" var="product"> 
      <div class="item">
        <a href="product?id=${product.id}" ><img src="${pageContext.request.contextPath}/resources/images/${product.id}.PNG" style="width:1200px;height: 600px"></a>
      </div>
    </c:forEach>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  
</div> 
</br>
  </br>
     <c:forEach items="${productlist}" begin="0" end="2" var="product"> 
    <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="${pageContext.request.contextPath}/resources/images/${product.id}.PNG" alt="" style="width: 300px;height: 200px" />
                <div class="caption">
                   <a href="product?id=${product.id}" > <h4 class="group inner list-group-item-heading">
                        ${product.name}</h4></a>
                    <p class="group inner list-group-item-text">
                        ${product.description}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                ${product.price}</p>
                        </div>
                        <div class="col-xs-12 col-md-6" >
                            <a class="btn btn-success" style="background-color: #333;border-color: #333; " href="product?id=${product.id}">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</c:forEach>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
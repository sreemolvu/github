<style>
body{
    margin-top:20px;
}

.store-item {
    padding: 5px;
    position: relative;
    display: block;
    margin-bottom: 30px;
    border: 4px solid #eee;
    -webkit-transition: all .2s ease-out;
    transition: all .2s ease-out;
}

.store-item:hover {
    border-color: #ddd;
    text-decoration: none;
}

.store-item:hover .store-item-image img {
    -webkit-transform: scale(1.3);
    transform: scale(1.3);
}

.store-item:hover .store-item-rating {
    animation-name: fadeInQuick;
    -webkit-animation-name: fadeInQuick;
    animation-duration: .5s;
    -webkit-animation-duration: .5s;
    animation-timing-function: ease-out;
    -webkit-animation-timing-function: ease-out;
    visibility: visible!important;
    display:block;
     opacity: 1;
     background:transparent;
}

.store-item-rating {
    position: absolute;
    top: 0;
    right: 0;
    left: 0;
    text-align: center;
    padding: 10px;
    opacity: 0;
    filter: alpha(opacity=0);
    background-color: #fff;
    -webkit-transition: all .2s ease-out;
    transition: all .2s ease-out;
    z-index: 10;
}

.text-warning, 
.text-warning:hover, 
a.text-warning, 
a.text-warning:focus, 
a.text-warning:hover {
    color: #e67e22;
}

.store-item-image {
    overflow: hidden;
}

.store-item-image img {
    -webkit-transition: transform .2s ease-out;
    transition: transform .2s ease-out;
}

.store-item-info {
    padding: 10px;
    background-color: #f9f9f9;
}

.themed-color-dark {
    color: #394263;
}

.store-item-price {
    font-weight: 700;
    font-size: 28px;
}

.text-primary, .text-primary:hover, a, a:focus, a:hover {
    color: #1bbae1;
    text-decoration:none;
}

.store-menu {
  margin-top: 30px;
}

.store-menu ul li {
  border-bottom: 1px solid #f0f4f7;
}

.store-menu ul li:last-child {
  border-bottom: none;
}

.store-menu ul li a {
  color: #93a3b5;
  font-size: 14px;
  font-weight: 400;
}

.store-menu ul li a i {
  margin-right: 8px;
  font-size: 14px;
}

.store-menu ul li a:hover {
  background-color: #fafcfd;
  color: #5b9bd1;
}

.store-menu ul li.active {
  border-bottom: none;
}

.store-menu ul li.active a {
  color: #5b9bd1;
  background-color: #f6f9fb;
  border-left: 2px solid #5b9bd1;
  margin-left: -2px;
}
</style>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<c:forEach var="p" items="${products}">

<%--
<div class="col-container">
    <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="resources/images/${p.id}.PNG" alt="" width="150" height="150"/>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        ${p.name}</h4>
                    <p class="group inner list-group-item-text">
                        ${p.description}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                ${p.price}</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" style="background-color: #333;border-color: #333; " href="product?id=${p.id}">View</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>



<div class="col-md-3" style="width:500px; height:1500px;">
<ul class="widget-products">
                  <li>
                     <a href="#">
                     <span class="img">
                     <img class="img-thumbnail" src="resources/images/${p.id}.PNG" alt=""style="width:500px; height:300px" >
                     </span>
                     <span class="product clearfix">
                     <span class="name">
                     ${p.name}
                     </span>
                     <span class="price">
                     <i class="fa fa-money"></i> ${p.price}
                     </span>
                     </span>
                     </a>
                  </li>
                  
                    </ul>
               </div>
--%>


<div class="container bootstrap snippet" >
    <div class="row" align="center">
    	<div class="store-item-image">
                  <a href="product?id=${p.id}">
                          <img class="img-thumbnail" src="resources/images/${p.id}.PNG" alt=""style="width:500px; height:300px" class="img-responsive">
                                                  </a>
          </div>
          <div class="store-item-info clearfix" style="width:500px; height:100px" >
                        <span  style="color: #333;" class="store-item-price themed-color-dark pull-right">${p.price}</span>
                        <a href="product?id=${p.id}"style="font-size:20;color: #333;"><strong>${p.name}</strong></a><br>
                        <small><i class="fa fa-shopping-cart text-muted"></i>
                        <a href="product?id=${p.id}" class="text-muted">Add to cart</a></small>
           </div>
    </div>
</div> 
 </c:forEach>       
        

       
       
</br>
</br>
</br>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
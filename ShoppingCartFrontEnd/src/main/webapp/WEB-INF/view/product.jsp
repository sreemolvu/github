
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
.row-product {
    background: #f5f5f5;
    margin-bottom: 30px;
}
#label-product {
    padding-top: 5px;
    padding-bottom: 15px;
    font-weight: bold;
    
}
.product-price {
    padding-top: 6px;
}
.row-product label {
    font-weight: normal;
}
.product-image {
    width: 250px;
    border: 1px dashed #ddd;
    padding: 10px;
    
}
.product-text {
    margin-top: 30px;
}
</style>
</html>
<body>

<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<c:forEach var="p" items="${product}">

<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"><img src="resources/images/${p.id}.PNG" width="550" height="400"/></div>
                    </div>
					
                    <div class="panel panel-default text-center">
                        <h3><div class="panel-title"><span class="glyphicon glyphicon-list-alt"></span>   </div></h3>
                        <hr>
                    <h4>Stock left:${p.stock}!!!</h4>
                    </div>
                </div>
                <div class="details col-md-6">
                    <div class="panel panel-default text-center">
                        <h3><div class="panel-title"><span class="glyphicon glyphicon-list-alt"></span>   Product Name</div></h3>
                        <hr>
                    <h4>${p.name}</h4>
                    </div>
                    <div class="panel panel-default text-center">
                    <div class="rating">
                        <b><h3><div class="panel-title"><span class="glyphicon glyphicon-info-sign"></span>  Category Name</div></h3></b>
                        <hr>
                        <h4>${p.categoryID.name}</h4>
                    </div>
                    </div>
                    <div class="panel panel-default text-center">
                    <div class="rating">
                        <h3><div class="panel-title"><span class="glyphicon glyphicon-info-sign"></span>  Supplier Name</div></h3>
                        <hr>
                        <h4>${p.suppilerID.name}</h4>
                    </div>
                    </div>
                    <div class="panel panel-default text-center">
                        <h3><div class="panel-title"><span class="glyphicon glyphicon-comment"></span>   Description</div></h3>
                        <hr>
                        <h4>${p.description} </h4>
                    </div>
                    <div class="panel panel-default text-center">
                        <h3><div class="panel-title"><span class="glyphicon glyphicon-credit-card"></span>Price</div></h3>
                        <hr>
                        <h2><font color="purple">${p.price}</h2>   </font>                 </div>
                  
                   </div>
            </div>
             <div class="text-center">
                       <a class="btn btn-success"style="background-color: #333;border-color: #333; " href="./user/cart/addcart?pid=${p.id}"><span class="glyphicon glyphicon-gift"></span>Add Cart</a>
                    </div>
        </div>
    </div>
</div> 
<%--

<div class="container">
	
	
<div class="card">
	<div class="row">
		<aside class="col-sm-5 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
  <div> <a href="#"><img src="${pageContext.request.contextPath}/resources/images/${p.id}.PNG" width="550" height="400"></a></div>
</div> <!-- slider-product.// -->

</article> <!-- gallery-wrap .end// -->
		</aside>
		<aside class="col-sm-7">
<article class="card-body-lg">
  <div class="text-center" style="font-size: 20px">
<dl class="item-property">
  <dt>Product Name</dt>
  <dd style="font-style: oblique;float: inherit;"><p>${p.name} </p></dd>
</dl>

<dl class="item-property">
  <dt>Product ID</dt>
  <dd><p>${p.id}</p></dd>
</dl>
<dl class="param param-feature">
  <dt>Category Name</dt>
  <dd>${p.categoryID.name}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>Supplier Name</dt>
  <dd>${p.suppilerID.name}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>Product Description</dt>
  <dd>${p.description}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>Price</dt>
  <dd>${p.price}</dd>
</dl>  <!-- item-property-hor .// -->

<dl class="param param-feature">
  <dt>Stock</dt>
  <dd>${p.stock}!!!!!</dd>
</dl>  <!-- item-property-hor .// -->


	           
                       <a class="btn btn-success"style="background-color: #333;border-color: #333; " href="./user/cart/addcart?pid=${p.id}"><span class="glyphicon glyphicon-gift"></span>Add Cart</a>
                    </div>
	
</article> <!-- card-body.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
</div> <!-- card.// -->


</div>
<!--container.//-->

 --%>

</c:forEach>
</br>
</br>
</br>
<jsp:include page="footer.jsp"></jsp:include>
</body>


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
                       <a class="btn btn-success"style="background-color: #333;border-color: #333;width: 100;height: 50 ; " href="./user/cart/addcart?pid=${p.id}"><span class="glyphicon glyphicon-gift"></span>Add Cart</a>
                    </div>
        </div>
    </div>
</div> 
<%--

<div class="container" >
     <div class="row">
        <div class="form-card">
            <div class="row-product">
                <div class='form-group' style="background-color:white; font-size: 20">
                    <div class="col-sm-6">
                        <label class="control-label col-sm-12" for="name-input-field" id="product-label"></label>
             <div class="col-sm-12" id="label-product">Product Name:${p.name}</div>
                        <div class="col-sm-12" id="label-product">Category Name:${p.categoryID.name}</div>
             
                         <div class="col-sm-12" id="label-product">Supplier Name:${p.suppilerID.name}</div>
                          <div class="col-sm-12" id="label-product">Desciption:${p.description}</div>
                        
                        <div class="col-sm-6">
                            <label class="control-label">Price</label>
                            <div class="product-price">Rp. <strong class="" id="calc-product-price">${p.price}</strong></div>
                        </div>
                    </div>
                     
                    <div class="col-sm-6">
                        <div class="product-image">
                            <img src="resources/images/${p.id}.PNG" style="width:500px; height:300px"/>
                        </div>
                    </div>
                    <div class="text-center">
                       <a class="btn btn-success" href="./user/cart/addcart?pid=${p.id}"><span class="glyphicon glyphicon-gift"></span>Add Cart</a>
                    </div>
                </div>    
            </div>
        </div>
    </div>
</div> --%>
</c:forEach>
</br>
</br>
</br>
<jsp:include page="footer.jsp"></jsp:include>
</body>

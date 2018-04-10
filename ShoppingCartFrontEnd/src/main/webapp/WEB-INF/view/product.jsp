<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<c:forEach var="p" items="${product}">
<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"><img src="resources/images/${p.id}.PNG" width="400" height="400"/></div>
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
                  
                    <div class="text-center">
                       <a class="btn btn-success" href=""><span class="glyphicon glyphicon-gift"></span>Add Cart</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</c:forEach>
</br>
</br>
</br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
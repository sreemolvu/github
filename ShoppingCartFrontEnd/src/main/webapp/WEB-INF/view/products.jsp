
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
                            <a class="btn btn-success" href="product?id=${p.id}">View</a>
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
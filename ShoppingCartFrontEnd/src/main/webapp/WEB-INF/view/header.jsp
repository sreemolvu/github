    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}
</style>
</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}" style="font-style: italic;font-family: monospace;font-weight: bolder;font-size: 32px">Cake Shop</a>
    </div>
    <sec:authorize access="!hasRole('A')">
    	<ul class="nav navbar-nav">
        	<li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
        	<span class="caret"></span></a>
        	 <ul class="dropdown-menu">
          		<c:forEach var="c" items="${categories}" >
          		<li><a href="${pageContext.request.contextPath}/products?id=${c.id}">${c.name}</a></li>
          		</c:forEach>    
         	</ul>
      		</li>
    	</ul>
	</sec:authorize>

   

      <sec:authorize access="hasRole('A')">
      <ul class="nav navbar-nav">
      <li>
     <a class="navbar-brand"  href="admin?msg=">ADMIN</a>
      </li>
      </ul>
     </sec:authorize>
     
     <c:choose>
       <c:when test="${pageContext.request.userPrincipal.name != null}">
     <ul class="nav navbar-nav navbar-right">
         <li ><a>Welcome : ${pageContext.request.userPrincipal.name}</a></li>
          <sec:authorize access="!hasRole('A')">
        	 <li><a href="${pageContext.request.contextPath}/user/cart"><span class="glyphicon glyphicon-shopping-cart"></span>My Cart</a></li>
          </sec:authorize>
          <li> <a href="${pageContext.request.contextPath}/logout"> <span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
           
          </ul>
	</c:when>
	<c:otherwise>
	<ul class="nav navbar-nav navbar-right">
        <li><a href="register"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
         <li><a href="login?error="><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
        
         </c:otherwise>
         </c:choose>
  
  </div>
</nav>


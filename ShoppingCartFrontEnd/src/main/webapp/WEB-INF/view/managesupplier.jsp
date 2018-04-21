<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Supplier</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<h3>${successmessage}</h3>
<h3>${failuremessage}</h3>
<h3>${successmsg}</h3>
<h3>${failuremsg}</h3>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
			
					<form action="sup" method="post">
						
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Supplier ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID"  placeholder="Enter SupplierID"required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="Address" class="cols-sm-2 control-label">Address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="Address" id="Address"  placeholder="Enter Supplier Address"required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Supplier Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Enter SupplierName"required/>
								</div>
							</div>
						</div>

												

							<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Create Supplier</button>
						</div>
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>
	

			<div class="container">
             
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${suppliers}" >
      <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.address}</td>
        <td><a href="editS?id=${c.id}">
          		<span class="glyphicon glyphicon-edit"></span>
       			 </a>/
       			 <a href="deleteS?id=${c.id}" >
        	  	 <span class="glyphicon glyphicon-trash"></span>
        		 </a>
       		</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>			
			</body>
</br>
</br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
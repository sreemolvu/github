<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Category</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<h3>${failuremsg}</h3>
<h3>${successmessage}</h3>
<h3>${failuremessage}</h3>
<h3>${successmsg}</h3>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				
					<form action="cat" method="post">
						
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Category ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID"  placeholder="Enter CategoryID" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="Description" class="cols-sm-2 control-label">Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="Description" id="Description"  placeholder="Enter description" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Category Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Enter category Name" required/>
								</div>
							</div>
						</div>

												

							<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Create category</button>
						</div>
						
					</form>
				</div>
			</div>
		
			
			<div class="container">
             
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${categories}" >
      <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.description}</td>
        	<td><a href="editC?id=${c.id}">
          		<span class="glyphicon glyphicon-edit"></span>
       			 </a>/
       			 <a href="deleteC?id=${c.id}" >
        	  	 <span class="glyphicon glyphicon-trash"></span>
        		 </a>
       		</td> 
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
</br>
</br>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
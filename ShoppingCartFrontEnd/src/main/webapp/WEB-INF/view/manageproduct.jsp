<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Product</title>
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
				<!-- <center><h2><span class="label label-primary">Create new product</span></h2></center>
					 --> 
					<form action="pro" method="post" enctype="multipart/form-data">
				
       				
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Product ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
								
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID"  placeholder="Enter ID" required/>
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
							<label for="name" class="cols-sm-2 control-label">Product Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Enter product Name"required/>
								</div>
							</div>
						</div>

	
						<div class="form-group">
							<label for="price" class="cols-sm-2 control-label">Product Price</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="price" id="price"  placeholder="Enter product price" required/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="image" class="cols-sm-2 control-label">Product Image</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="file" class="form-control"  name ="file" required>
								</div>
							</div>
						</div>
					<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Category Name</label>
							<select name="categorylist"  >
       				 <c:forEach var="c" items="${categories}" ><option value="${c.id}">${c.name}</option></c:forEach>
       				</select>
       				</div>
								<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Supplier Name</label>
							<select name="supplierlist" >
       				 <c:forEach var="c" items="${suppliers}" ><option value="${c.id}">${c.name}</option></c:forEach>
       				</select>
       				</div>
       				
       								

							<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Create product</button>
						</div>
						
					</form>
				</div>
			</div>
			
			
			<div class="container">
             
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Image</th>
        <th>Name</th>
        <th>Description</th>
        <th>price</th>
        <th>CID</th>
        <th>SID</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${products}" >
      <tr>
        <td>${c.id}</td>
        <td><div class="imgcontainer">
    		<img src="resources/images/${c.id}.PNG" alt="product" width="50" height="50">
  			</div>
  		</td>
        <td>${c.name}</td>
        <td>${c.description}</td>
        <td>${c.price}</td>
        <td>${c.categoryID.name}</td>
        <td>${c.suppilerID.name}</td>
        <td><a href="editP?id=${c.id}">
          		<span class="glyphicon glyphicon-edit"></span>
       			 </a>/
       			 <a href="deleteP?id=${c.id}" >
        	  	 <span class="glyphicon glyphicon-trash"></span>
        		 </a>
       		</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
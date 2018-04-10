<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<form action="Uppro" method="post" enctype="multipart/form-data" >
       				
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Product ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
								
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID"  value="${product.id}" readonly="true"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="Description" class="cols-sm-2 control-label">Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="description" id="description" value="${product.description}" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  value="${product.name}" required/>
								</div>
							</div>
						</div>

	
						<div class="form-group">
							<label for="price" class="cols-sm-2 control-label">Product Price</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="price" id="price"  value="${product.price}" required/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="image" class="cols-sm-2 control-label">Product Image</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<img src="resources/images/${product.id}.PNG" alt="product" width="50" height="50"><input type="file" class="form-control"  name ="file" required>
								</div>
							</div>
						</div>
					<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Category Name</label>
							<select name="categorylist"  >
       				 <c:forEach var="c" items="${categories}" >
       				 <option value="${c.id}">${c.name}</option></c:forEach>
       				</select>
       				</div>
								<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Supplier Name</label>
							<select name="supplierlist" >
       				 <c:forEach var="c" items="${suppliers}" ><option value="${c.id}">${c.name}</option></c:forEach>
       				</select>
       				</div>
       				
       								

							<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Update product</button>
						</div>
						
					</form>
				</div>
			</div>
</body>
</html>
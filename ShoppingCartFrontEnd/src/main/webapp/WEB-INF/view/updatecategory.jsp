
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
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				
					<form action="${pageContext.request.contextPath}/admin/Upcat" method="post">
						
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Category ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID" value="${category.id}" readonly="true" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="Description" class="cols-sm-2 control-label">Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="Description" id="Description" value="${category.description}" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Category Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name" value="${category.name}" />
								</div>
							</div>
						</div>

												

							<div class="form-group ">
							<button  style="background-color: #333;border-color: #333 "type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Update category</button>
						</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />						
					</form>
				</div>
			</div>
</br>
</br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				
					<form action="${pageContext.request.contextPath}/admin/Upsup" method="post">
						
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Supplier ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID" value="${supplier.id}" readonly="true" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="Address" class="cols-sm-2 control-label">Address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="Address" id="Address" value="${supplier.address}" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Supplier Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name" value="${supplier.name}" />
								</div>
							</div>
						</div>

												

							<div class="form-group ">
							<button  style="background-color: #333;border-color: #333 " type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Update supplier</button>
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
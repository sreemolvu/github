<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>Register</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Complete your registeration</h5>
					<form action="reg" method="post">
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="email" style="height: 50px" pattern="[a-z0-9._]+@[a-z0-9]+\.[a-z]{2,4}$" class="form-control" name="emailID" id="email"  placeholder="Enter your Email"required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="moblie" class="cols-sm-2 control-label">Mobile</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text"style="height: 50px" pattern="[987]{1}[0-9]{9}$" class="form-control" name="mobile" id="mobile"  placeholder="Enter your mobile"required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" style="height: 50px"pattern="[a-z./s]+$" class="form-control" name="name" id="name"  placeholder="Enter your Name"required/>
								</div>
							</div>
						</div>

						

						

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									
									<input type="password" style="height: 50px" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" class="form-control" name="password" id="password"  placeholder="Enter your Password"required/>
									
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" style="height: 50px" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"required/>
								</div>
							</div>
						</div>

						<div class="form-group " >
							<button style="background-color: #333;border-color: #333 " type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />						
					</form>
				</div>
			</div>


</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
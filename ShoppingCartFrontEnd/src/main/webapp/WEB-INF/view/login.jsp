<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}


.imgcontainer {
    text-align: center;
    margin: 20px 0 8px 0;
}

img.avatar {
    width: 20%;
    border-radius: 30%;
}

.container {
    padding: 12px;
}

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
</br>
</br>
</br>
<h3 align="center">${error}</h3>
<form action="./j_spring_security_check?${_csrf.parameterName}=${_csrf.token}" method="post">

  <div class="imgcontainer">
    <img src="resources\images\avatar.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button style="background-color: #333;border-color: #333 " id="button" class="btn btn-primary btn-lg btn-block login-button" type="submit">Login</button>
    <label>
   
    </label>
  </div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<br/>
<br/>
<br/>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
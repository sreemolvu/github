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
<br/>
<br/>
<br/>
<p style="padding-left:30px;color: orange;font-size: 20">Your order is placed......Thank you for shopping</p>
 <a  style="background-color: #333;border-color: #333 "id="button" class="btn btn-primary btn-lg btn-block login-button" href="${pageContext.request.contextPath}" class="btn btn-default">Continue Shopping</a>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
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
<br/>
<br/>
<br/>


<h3 style="padding-left:30px;color: #333;font-size: 20">Your cart list</h3>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
        
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th style="width:50;">Product</th>
                        <th style="width:50;">Quantity</th>
                        <th >Price</th>
                       
                        <th >Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                 <c:set var = "total"  value = "0"/>
                <c:forEach var="p" items="${cartlist}">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="text-center" class="thumbnail pull-left" href="${pageContext.request.contextPath}/product?id=${p.productID.id}"> <img class="media-object" src="${pageContext.request.contextPath}/resources/images/${p.productID.id}.PNG" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4  class="media-heading"><a href="${pageContext.request.contextPath}/product?id=${p.productID.id}">${p.productID.name}</a></h4>
                                <h5 class="media-heading"></a></h5>
                             <%--<span>Status: </span><span class="text-success"><strong>In Stock</strong></span> --%>   
                            </div>
                        </div></td>
                           <td class="col-sm-8 col-md-6">
                  
                           
								<div class="input-group">
									<input style="display:block;"  type="text" class="form-control" name="quantity" id="quantity"size="2" value="${p.quantity}" />
							
       							 </a>	
								</div>
								
						
                        </td>
                           <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <div class="media-body">
                                <h4 class="text-center" class="media-heading">${p.productID.price}</h4>
                                <h5 class="media-heading"></a></h5>
                             <%--<span>Status: </span><span class="text-success"><strong>In Stock</strong></span> --%>   
                            </div>
                        </div></td>      
                     
                           <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <div class="media-body">
                            
                                <h4 class="text-center" class="media-heading">${p.quantity * p.productID.price}</h4>
                                <h5 class="media-heading"></a></h5>
                             <%--<span>Status: </span><span class="text-success"><strong>In Stock</strong></span> --%>   
                            </div>
                        </div></td>  
               </tr>
                     <c:set var = "total"  value = "${(p.productID.price*p.quantity)+total}"/>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3>${total}</h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<h3 style="padding-left:30px;color: #333;font-size: 20">Please provide shipping address</h3>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
			
				<form action="${pageContext.request.contextPath}/user/order/placeorder" method="post">
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="emailID" id="emailID" value="${user.emailID}" />
								</div>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name" value="${user.name}" />
								</div>
							</div>
						</div>
						
							<div class="form-group">
							<label for="moblie" class="cols-sm-2 control-label">Your Mobile</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="mobile" id="mobile" value="${user.mobile}"  />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="moblie" class="cols-sm-2 control-label">Your Address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="address" id="address" />
								</div>
							</div>
						</div>
					<div class="form-group">
							<label for="moblie" class="cols-sm-2 control-label">City</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="city" id="city" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="moblie" class="cols-sm-2 control-label">Pincode</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="pin" id="pin" />
								</div>
							</div>
						</div>
						
						<div class="form-group " >
							<button style="background-color: #333;border-color: #333 " type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Place Order</button>
						</div>
				</div>
			</div>
					<input type="hidden" name="total" value="${total}"/>
					<input type="hidden" name="pid" value="${p.productID.id}"/>
 					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />						
					</form>
<%--shipping addresss --%>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
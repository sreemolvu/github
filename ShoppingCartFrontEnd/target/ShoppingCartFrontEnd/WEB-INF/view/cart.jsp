 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<br/>
<br/>
<br/>


<c:choose>
  <c:when test="${!empty cartlist}">
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
        
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                       
                        <th class="text-center">Total</th>
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
                       <%--<div class="media">
                            <div class="media-body">
                                <h4  class="media-heading">${p.quantity}</h4>
                                <h5 class="media-heading"></a></h5>
                            --%> 
                           <form action="user/cart/update">
								<div class="input-group">
									<input style="display:block;"  type="text" class="form-control" name="quantity" id="quantity"size="2" value="${p.quantity}" />
							 <input type="hidden" name="pid" value="${p.productID.id}"/>
							  <button type="sumbit" class="btn btn-default btn-sm">
          							<span class="glyphicon glyphicon-refresh"></span> Refresh
       									 </button>
							
								</div>
								</form>
						
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
                        <td>
                        <a class="text-center" href="${pageContext.request.contextPath}/user/cart/delete?pid=${p.productID.id}&id=${p.id}">
          <span class="glyphicon glyphicon-remove"></span>
        </a>
        </td>
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
                        <td>
                        <a  style="background-color: #333;border-color: #333 "id="button" class="btn btn-primary btn-lg btn-block login-button" href="${pageContext.request.contextPath}" class="btn btn-default">Continue Shopping</a></td>
                        <td>
                          <a  style="background-color: #333;border-color: #333 "id="button" class="btn btn-primary btn-lg btn-block login-button" href="${pageContext.request.contextPath}/user/order/checkout" class="btn btn-default">Check Out</a></td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
</c:when>
<c:otherwise>
<p style="padding-left:30px;color: orange;font-size: 20">Your Cart is Empty</p>
</c:otherwise></c:choose>
<jsp:include page="footer.jsp"></jsp:include>
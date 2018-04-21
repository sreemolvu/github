<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<br/><br/><br/><br/>

<h3 style="color:red;">${msg}</h3>
<div class="container">
<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#c">Category</a></li>
  <li><a data-toggle="tab" href="#s">Supplier</a></li>
  <li><a data-toggle="tab" href="#p">Product</a></li>
</ul>

<div class="tab-content">
  <div id="c" class="tab-pane fade in active">
   <div class="main-login main-center">
				
					<form action="./admin/cat" method="post">
						
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
							<button  style="background-color: #333;border-color: #333 " type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Create category</button>
						</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />						
					</form>
				</div>
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
        	<td><a href="admin/editC?id=${c.id}">
          		<span class="glyphicon glyphicon-edit"></span>
       			 </a>/
       			 <a href="admin/deleteC?id=${c.id}" >
        	  	 <span class="glyphicon glyphicon-trash"></span>
        		 </a>
       		</td> 
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>		
  
  <div id="s" class="tab-pane fade">
 
				<div class="main-login main-center">
			
					<form action="./admin/sup" method="post">
						
						<div class="form-group">
							<label for="id" class="cols-sm-2 control-label">Supplier ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ID" id="ID"  placeholder="Enter SupplierID"required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="Address" class="cols-sm-2 control-label">Address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="Address" id="Address"  placeholder="Enter Supplier Address"required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Supplier Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Enter SupplierName"required/>
								</div>
							</div>
						</div>

												

							<div class="form-group ">
							<button  style="background-color: #333;border-color: #333 " type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Create Supplier</button>
						</div>
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
		
			<table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${suppliers}" >
      <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.address}</td>
        <td><a href="admin/editS?id=${c.id}">
          		<span class="glyphicon glyphicon-edit"></span>
       			 </a>/
       			 <a href="admin/deleteS?id=${c.id}" >
        	  	 <span class="glyphicon glyphicon-trash"></span>
        		 </a>
       		</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  </div>
  <div id="p" class="tab-pane fade">
  
				<div class="main-login main-center">
				<!-- <center><h2><span class="label label-primary">Create new product</span></h2></center>
					 --> 
					<form action="./admin/pro?_csrf=${_csrf.token}" method="post" enctype="multipart/form-data">
				
       				
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
							<label for="stock" class="cols-sm-2 control-label">Product Stock</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control"  name ="stock" id="stock" placeholder="Enter product stock" required>
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
							<button  style="background-color: #333;border-color: #333 " type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Create product</button>
						</div>
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />		
					</form>
				</div>
		
			<table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Image</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
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
    		<img src="${pageContext.request.contextPath}/resources/images/${c.id}.PNG" alt="product" width="50" height="50">
  			</div>
  		</td>
        <td>${c.name}</td>
        <td>${c.description}</td>
        <td>${c.price}</td>
        <td>${c.stock}</td> 
        <td>${c.categoryID.name}</td>
        <td>${c.suppilerID.name}</td>
        <td><a href="admin/editP?id=${c.id}">
          		<span class="glyphicon glyphicon-edit"></span>
       			 </a>/
       			 <a href="admin/deleteP?id=${c.id}" >
        	  	 <span class="glyphicon glyphicon-trash"></span>
        		 </a>
       		</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  </div>
</div>

</div>
<br/>
<br/>
<br/>

<jsp:include page="footer.jsp"></jsp:include>
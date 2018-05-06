<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<div class="tab-content profile-page">
	<!-- PROFILE TAB CONTENT -->
	<div class="tab-pane profile active" id="profile-tab">
		<form:form method="POST" modelAttribute="customer"
	action="${pageContext.request.contextPath}/admin/customer/create" class="form-horizontal" role="form">
			<fieldset>
				<h3>
					<i class="fa fa-square"></i>General Information
				</h3>
				<div class="form-group">
			<!--  -	<label for="name" class="col-sm-3 control-label">User Id</label>
					<div class="col-sm-4">
					<form:input path="id" class="form-control" />				
					</div>-->
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-3 control-label">User Name</label>
					<div class="col-sm-4">
					<form:input path="name" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-3 control-label">Password</label>
					<div class="col-sm-4">
					<form:input path="password" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-3 control-label">Last Name</label>
					<div class="col-sm-4">
					<form:input path="lastname" class="form-control" />						
					</div>
				</div>
				
				<div class="form-group">
					<label for="firstname" class="col-sm-3 control-label">First Name</label>
					<div class="col-sm-4">
					<form:input path="firstname" class="form-control" />						
					</div>
				</div>	
				
			<div class="form-group">
				<label for="department" class="col-sm-3 control-label">Department</label>
						<div class="col-sm-4">
							<form:select path="department"
								class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
								<form:option value="HR" label="HR" />
								<form:option value="Technical" label="Technical" />
								<form:option value="Admin" label="Admin" />
							</form:select>
						</div>
					
			</div>
			<div class="form-group">
				<label for="role" class="col-sm-3 control-label">Role</label>
				
						<div class="col-sm-4">
							<form:select path="type" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">
								<form:option value="Admin" label="Admin" />
								<form:option value="Mechanic" label="Mechanic" />
							</form:select>
						</div>
					

			</div>	
			</fieldset>
			<hr />
			
			<fieldset>
				<h3>
					<i class="fa fa-square"></i> More Details
				</h3>
				
				<div class="form-group">
					<label for="phonenumber" class="col-sm-3 control-label">Phone No.</label>
					<div class="col-sm-4">
					<form:input path="phonenumber" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="countrycode" class="col-sm-3 control-label">Country Code</label>
					<div class="col-sm-4">
					<form:input path="countrycode" class="form-control" />						
					</div>
				</div>
				
			</fieldset>
		
		<p class="text-center">
			<input type="submit" value="Create" class="btn btn-custom-primary"/>
			<input type="button" value="Cancel" class="btn btn-custom-primary" onclick="javascript:window.location.href ='${pageContext.request.contextPath}/admin/customer/list';">
		</p>
</form:form>
	</div>
</div>



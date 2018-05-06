<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<div class="tab-content profile-page">
	<!-- PROFILE TAB CONTENT -->
	<div class="tab-pane profile active" id="profile-tab">
		<form:form method="POST" modelAttribute="customer"
	action="${pageContext.request.contextPath}/admin/customer/edit/${customer.id}.html" class="form-horizontal" role="form">
			<fieldset>
			<h3>
				<i class="fa fa-square"></i>Update My Profile
			</h3>
			<div class="form-group">
				<label for="name" class="col-sm-3 control-label">User
					Name</label>
				<div class="col-sm-4">				
					<form:input path="name" class="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-3 control-label">Last
					Name</label>
				<div class="col-sm-4">
					<form:input path="lastname" type="text" id="lastname"
						name="lastname" class="form-control"></form:input>
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-3 control-label">First
					Name</label>
				<div class="col-sm-4">
					<form:input path="firstname" type="text" id="firstname"
						name="firstname" class="form-control"></form:input>
				</div>
			</div>
			<!--  -->
			<div class="form-group">
				<label for="department" class="col-sm-3 control-label">Department</label>
				<!--  -->
				<c:choose>
					<c:when test="${sessionScope.currentuser.type == 'Admin' }">
						<div class="col-sm-4">
							<form:select path="department"
								class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
								<form:option value="HR" label="HR" />
								<form:option value="Technical" label="Technical" />
								<form:option value="Admin" label="Admin" />
							</form:select>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-4">
							<form:input path="department" type="text" id="department"
								name="department" class="form-control" readonly="true"></form:input>
						</div>
					</c:otherwise>
				</c:choose>
				<!--  -->
			</div>
			<div class="form-group">
				<label for="role" class="col-sm-3 control-label">Role</label>
				<!--  -->
				<c:choose>
					<c:when test="${sessionScope.currentuser.type == 'Admin' }">
						<div class="col-sm-4">
							<form:select path="type" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">
								<form:option value="Admin" label="Admin" />
								<form:option value="Mechanic" label="Mechanic" />
							</form:select>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-4">
							<form:input path="type" type="text" id="type" name="type"
								class="form-control" readonly="true"></form:input>
						</div>
					</c:otherwise>
				</c:choose>
				<!--  -->

			</div>
			<div class="form-group">
				<label for="phoneno" class="col-sm-3 control-label">Phone
					No.</label>
				<div class="col-sm-4">
					<form:input path="phonenumber" type="text" id="firstname"
						name="phonenumber" class="form-control"></form:input>

				</div>
			</div>
			<div class="form-group">
				<label for="countrycode" class="col-sm-3 control-label">Country
					Code</label>
				<div class="col-sm-4">
					<form:input path="countrycode" type="text" id="countrycode"
						name="countrycode" class="form-control"></form:input>
				</div>
			</div>
			<hr />
			<div class="form-group">
				<label for="newpassword" class="col-sm-3 control-label">New
					Password</label>
				<div class="col-sm-4">
					<form:input path="password" type="password" id="password"
						name="password" class="form-control"></form:input>

				</div>
			</div>
			<div class="form-group">
				<label for="password2" class="col-sm-3 control-label">Repeat
					Password</label>
				<div class="col-sm-4">
					<input type="password" id="password2" name="password2"
						class="form-control" />

				</div>
			</div>
		</fieldset>
		<p class="text-center">
			<form:button type="submit" class="btn btn-custom-primary">
				<i class="fa fa-floppy-o"></i> Save Changes</form:button>
	
		<input type="button" value="Cancel" class="btn btn-custom-primary" onclick="javascript:window.location.href ='${pageContext.request.contextPath}/admin/customer/list';">
		</p>
	</form:form>
</div>
</div>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="tab-pane settings" id="settings-tab">
	<form:form class="form-horizontal" role="form"
		action="${pageContext.request.contextPath}/updateprofile"
		method="POST" commandName="user">
		<fieldset>
			<h3>
				<i class="fa fa-square"></i>Update My Profile
			</h3>
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">User
					Name</label>
				<div class="col-sm-4">
					<form:input path="id" type="hidden"></form:input>
					<form:input path="name" class="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">Last
					Name</label>
				<div class="col-sm-4">
					<form:input path="lastname" type="text" id="lastname"
						name="lastname" class="form-control"
						value="${sessionScope.currentuser.lastname}"></form:input>
						<form:errors path='lastname' cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">First
					Name</label>
				<div class="col-sm-4">
					<form:input path="firstname" type="text" id="firstname"
						name="firstname" class="form-control"
						value="${sessionScope.currentuser.firstname}"></form:input>
						<form:errors path='firstname' cssStyle="color: red;" />
				</div>
			</div>
			<!--  -->
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">Department</label>
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
								name="department" class="form-control" readonly="true"
								value="${sessionScope.currentuser.department}"></form:input>
						</div>
					</c:otherwise>
				</c:choose>
				<!--  -->
			</div>
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">Role</label>
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
								class="form-control" readonly="true"
								value="${sessionScope.currentuser.type}"></form:input>
						</div>
					</c:otherwise>
				</c:choose>
				<!--  -->

			</div>
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">Phone
					No.</label>
				<div class="col-sm-4">
					<form:input path="phonenumber" type="text" id="firstname"
						name="phonenumber" class="form-control"
						value="${sessionScope.currentuser.phonenumber}"></form:input>
						<form:errors path='phonenumber' cssStyle="color: red;" />

				</div>
			</div>
			<div class="form-group">
				<label for="old-password" class="col-sm-3 control-label">Country
					Code</label>
				<div class="col-sm-4">
					<form:input path="countrycode" type="text" id="countrycode"
						name="countrycode" class="form-control"
						value="${sessionScope.currentuser.countrycode}"></form:input>
						<form:errors path='countrycode' cssStyle="color: red;" />
				</div>
			</div>
			<hr />
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">New
					Password</label>
				<div class="col-sm-4">
					<form:input path="password" type="password" id="password"
						name="password" class="form-control"
						value="${sessionScope.currentuser.password}"></form:input>
						<form:errors path='lastname' cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label for="password2" class="col-sm-3 control-label">Repeat
					Password</label>
				<div class="col-sm-4">
					<input type="password" id="password2" name="password2"
						class="form-control" value="${sessionScope.currentuser.password}" />
						<form:errors path='lastname' cssStyle="color: red;" />
				</div>
			</div>
		</fieldset>
		<p class="text-center">
			<form:button type="submit" class="btn btn-custom-primary">
				<i class="fa fa-floppy-o"></i> Save Changes</form:button>
		</p>
	</form:form>

</div>


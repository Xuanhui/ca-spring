<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
	<div class="main-header">
		<h2>Customer Table</h2>
		<em>Show customer list </em>
	</div>
	<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/admin/customer/create"><button type="button" class="btn btn-default"><i class="fa fa-plus-square"></i>Add a New Customer</button></a>
	<div class="main-content">
		<div class="widget widget-table">
			<div class="widget-header">
				<h3>
					<i class="fa fa-table"></i> customer table
				</h3>
				<em> - <a href="" target="_blank">jQuery Data Table</a> enable
					to show/hide and drap-drop column
				</em>
			</div>
			<!-- SHOW HIDE COLUMNS DATA TABLE -->
			<div class="widget-content">
				<table id="datatable-column-interactive"
					class="table table-sorting table-striped table-hover datatable">
					<thead>
						<tr>
							
							<th>User Name</th>
							<th>Password</th>
							<th>Last Name</th>
							<th>First Name</th>
							<th>Department</th>							
							<th>Role</th>
							<th>Phone No.</th>
							<th>Country Code</th>
							
<!-- 							<th>Reorder Point</th> -->
<!-- 							<th>Minimum Reorder Quantity</th> -->
							
							<c:if test="${sessionScope.currentuser.type=='Admin'}">
								<th></th>
								<th></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${customerList}">
							<tr>
								
								<td>${prod.name}</td>
								<td>${prod.password}</td>
								<td>${prod.lastname}</td>
								<td>${prod.firstname}</td>
								<td>${prod.department}</td>
								<td>${prod.type}</td>								
								<td>${prod.phonenumber}</td>
								<td>${prod.countrycode}</td>
								
<%-- 								<td>${prod.reorderpoint}</td> --%>
<%-- 								<td>${prod.minreorderquantity}</td> --%>
								
								<c:if test="${sessionScope.currentuser.type=='Admin'}">
									<td align="center"><a class="btn btn-block btn-custom-secondary"
										href="${pageContext.request.contextPath}/admin/customer/edit/${prod.id}.html">Edit</a></td>
									<td align="center"><a class="btn btn-block btn-custom-primary"
										href="${pageContext.request.contextPath}/admin/customer/delete/${prod.id}.html">Delete</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- END SHOW HIDE COLUMNS DATA TABLE -->
			<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/admin/customer/create"><button type="button" class="btn btn-default"><i class="fa fa-plus-square"></i>Add a New Customer</button></a>
<%-- 			<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/admin/product/create">Add a New Product</a> --%>
		</div>
	</div>
</div>



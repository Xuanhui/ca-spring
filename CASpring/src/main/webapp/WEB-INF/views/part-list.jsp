<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
	<div class="main-header">
		<h2>Product Table</h2>
		<em>Show product list </em>
	</div>
	<!-- 	<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/product/use"><button type="button" class="btn btn-default"><i class="fa fa-plus-square"></i>Add a New Product</button></a> -->
	<div class="main-content">
		<div class="widget widget-table">
			<div class="widget-header">
				<h3>
					<i class="fa fa-table"></i> product table
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
							<th>ID</th>
							<th>Part Number</th>
							<th>Status</th>
							<th>Supplier Name</th>
							<th>Supplier Email</th>
							<c:if test="${sessionScope.currentuser.type=='admin'}">
								<th></th>
							</c:if>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${listparts}">
						
							<tr>
								<td>${prod.id}</td>
								<td>${prod.partnumber}</td>
								<td>${prod.status}</td>
								<td>${prod.msupplier.companyname}</td>
								<td>${prod.msupplier.email}</td>
							
									<td align="center"><a href="${pageContext.request.contextPath}/product/order/${prod.id}"
										class="btn btn-block btn-custom-secondary">Order</a></td>
										
							
							</tr>
						
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- END SHOW HIDE COLUMNS DATA TABLE -->
			<!--	<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/product/create"><button type="button" class="btn btn-default"><i class="fa fa-plus-square"></i>Add a New Product</button></a>
<%-- 			<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/product/create">Add a New Product</a> --%>  -->
		</div>
	</div>
</div>

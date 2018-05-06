<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
	<div class="main-header">
		<h2>Product Table</h2>
		<em>Show product list </em>
	</div>
	<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/product/create"><button type="button" class="btn btn-default"><i class="fa fa-plus-square"></i>Add a New Product</button></a>
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
			<c:choose>
				<c:when test="${searchList!=null}">
					<div class="widget-content">
						<table id="datatable-column-interactive"
							class="table table-sorting table-striped table-hover datatable">
							<thead>
								<tr>
									<th>Part Number</th>
									<th>Name</th>
									<th>Type</th>
									<th>Unit Price</th>
									<th>Description</th>
									<th>Color</th>
									<th>Dimension</th>
									<th>Manufacturer</th>
									<!-- 							<th>Reorder Point</th> -->
									<th>Minimum Reorder Quantity</th>
									<th>Quantity</th>
									<th>Shelf Location</th>
									<th>Status</th>
									<c:if test="${sessionScope.currentuser.type=='admin'}">
										<th></th>
										<th></th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="prod" items="${searchList}">
									<tr>
										<td>${prod.partnumber}</td>
										<td>${prod.name}</td>
										<td>${prod.parttype}</td>
										<td><fmt:formatNumber value="${prod.unitprice}"
												minFractionDigits="2" /></td>
										<td>${prod.description}</td>
										<td>${prod.color}</td>
										<td>${prod.dimension}</td>
										<td>${prod.manufacturer}</td>
										<td>${prod.reorderpoint}</td>
										<td>${prod.minreorderquantity}</td>
										<td>${prod.quantity}</td>
										<td>${prod.shelflocation}</td>
										<td>${prod.status}</td>
										<c:if test="${sessionScope.currentuser.type=='admin'}">
											<td align="center"><a
												class="btn btn-block btn-custom-secondary"
												href="${pageContext.request.contextPath}/product/edit/${prod.partnumber}.html">Edit</a></td>
											<td align="center"><a
												class="btn btn-block btn-custom-primary"
												href="${pageContext.request.contextPath}/product/delete/${prod.partnumber}.html">Delete</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div></div>
				</c:otherwise>
			</c:choose>



			<c:choose>
				<c:when test="${searchListName!=null}">
					<div class="widget-content">
						<table id="datatable-column-interactive"
							class="table table-sorting table-striped table-hover datatable">
							<thead>
								<tr>
									<th>Part Number</th>
									<th>Name</th>
									<th>Type</th>
									<th>Unit Price</th>
									<th>Description</th>
									<th>Color</th>
									<th>Dimension</th>
									<th>Manufacturer</th>
									<!-- 							<th>Reorder Point</th> -->
									<th>Minimum Reorder Quantity</th>
									<th>Quantity</th>
									<th>Shelf Location</th>
									<th>Status</th>
									<c:if test="${sessionScope.currentuser.type=='admin'}">
										<th></th>
										<th></th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="prod" items="${searchListName}">
									<tr>
										<td>${prod.partnumber}</td>
										<td>${prod.name}</td>
										<td>${prod.parttype}</td>
										<td><fmt:formatNumber value="${prod.unitprice}"
												minFractionDigits="2" /></td>
										<td>${prod.description}</td>
										<td>${prod.color}</td>
										<td>${prod.dimension}</td>
										<td>${prod.manufacturer}</td>
										<td>${prod.reorderpoint}</td>
										<td>${prod.minreorderquantity}</td>
										<td>${prod.quantity}</td>
										<td>${prod.shelflocation}</td>
										<td>${prod.status}</td>
										<c:if test="${sessionScope.currentuser.type=='admin'}">
											<td align="center"><a
												class="btn btn-block btn-custom-secondary"
												href="${pageContext.request.contextPath}/product/edit/${prod.partnumber}.html">Edit</a></td>
											<td align="center"><a
												class="btn btn-block btn-custom-primary"
												href="${pageContext.request.contextPath}/product/delete/${prod.partnumber}.html">Delete</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div></div>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${searchListManufacturer!=null}">
					<div class="widget-content">
						<table id="datatable-column-interactive"
							class="table table-sorting table-striped table-hover datatable">
							<thead>
								<tr>
									<th>Part Number</th>
									<th>Name</th>
									<th>Type</th>
									<th>Unit Price</th>
									<th>Description</th>
									<th>Color</th>
									<th>Dimension</th>
									<th>Manufacturer</th>
									<!-- 							<th>Reorder Point</th> -->
									<th>Minimum Reorder Quantity</th>
									<th>Quantity</th>
									<th>Shelf Location</th>
									<th>Status</th>
									<c:if test="${sessionScope.currentuser.type=='admin'}">
										<th></th>
										<th></th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="prod" items="${searchListManufacturer}">
									<tr>
										<td>${prod.partnumber}</td>
										<td>${prod.name}</td>
										<td>${prod.parttype}</td>
										<td><fmt:formatNumber value="${prod.unitprice}"
												minFractionDigits="2" /></td>
										<td>${prod.description}</td>
										<td>${prod.color}</td>
										<td>${prod.dimension}</td>
										<td>${prod.manufacturer}</td>
										<td>${prod.reorderpoint}</td>
										<td>${prod.minreorderquantity}</td>
										<td>${prod.quantity}</td>
										<td>${prod.shelflocation}</td>
										<td>${prod.status}</td>
										<c:if test="${sessionScope.currentuser.type=='admin'}">
											<td align="center"><a
												class="btn btn-block btn-custom-secondary"
												href="${pageContext.request.contextPath}/product/edit/${prod.partnumber}.html">Edit</a></td>
											<td align="center"><a
												class="btn btn-block btn-custom-primary"
												href="${pageContext.request.contextPath}/product/delete/${prod.partnumber}.html">Delete</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div></div>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${searchListStatus!=null}">
					<div class="widget-content">
						<table id="datatable-column-interactive"
							class="table table-sorting table-striped table-hover datatable">
							<thead>
								<tr>
									<th>Part Number</th>
									<th>Name</th>
									<th>Type</th>
									<th>Unit Price</th>
									<th>Description</th>
									<th>Color</th>
									<th>Dimension</th>
									<th>Manufacturer</th>
									<!-- 							<th>Reorder Point</th> -->
									<th>Minimum Reorder Quantity</th>
									<th>Quantity</th>
									<th>Shelf Location</th>
									<th>Status</th>
									<c:if test="${sessionScope.currentuser.type=='admin'}">
										<th></th>
										<th></th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="prod" items="${searchListStatus}">
									<tr>
										<td>${prod.partnumber}</td>
										<td>${prod.name}</td>
										<td>${prod.parttype}</td>
										<td><fmt:formatNumber value="${prod.unitprice}"
												minFractionDigits="2" /></td>
										<td>${prod.description}</td>
										<td>${prod.color}</td>
										<td>${prod.dimension}</td>
										<td>${prod.manufacturer}</td>
										<td>${prod.reorderpoint}</td>
										<td>${prod.minreorderquantity}</td>
										<td>${prod.quantity}</td>
										<td>${prod.shelflocation}</td>
										<td>${prod.status}</td>
										<c:if test="${sessionScope.currentuser.type=='admin'}">
											<td align="center"><a
												class="btn btn-block btn-custom-secondary"
												href="${pageContext.request.contextPath}/product/edit/${prod.partnumber}.html">Edit</a></td>
											<td align="center"><a
												class="btn btn-block btn-custom-primary"
												href="${pageContext.request.contextPath}/product/delete/${prod.partnumber}.html">Delete</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div></div>
				</c:otherwise>
			</c:choose>

			<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/product/create"><button type="button" class="btn btn-default"><i class="fa fa-plus-square"></i>Add a New Product</button></a>
<%-- 			<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/product/create">Add a New Product</a> --%>
		</div>
	</div>
</div>



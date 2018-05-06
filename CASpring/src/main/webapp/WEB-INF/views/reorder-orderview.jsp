<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
	<div class="main-header">
		<h2>Order View</h2>
		<em>You have made an order and sent an e-mail to supplier successfully.</em>
	</div>
	<div class="main-content">
		<div class="widget widget-table">
			<div class="widget-header">
				<h3>
					<i class="fa fa-table"></i> Order Detail
				</h3>
				<em> - <a href="" target="_blank">jQuery Data Table</a> enable
					to show/hide and drap-drop column
				</em>
			</div>
			<!-- SHOW HIDE COLUMNS DATA TABLE -->
			<div class="widget-content">
			<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/reorder/list/${product.partnumber}.html">
				<table id="datatable-column-interactive"
					class="table table-sorting table-striped table-hover datatable">
					<thead>
						<tr>
							<th>Part No.</th>
							<th>Product Name</th>
							<th>Part Type</th>
							<th>Unit Price</th>
							<th>Manufacturer</th>
							<th>Order Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						
							<tr>
								<td>${product.partnumber}</td>
									<td>${product.name}</td>
									<td>${product.parttype}</td>
								<td><fmt:formatNumber value="${product.unitprice}"
										minFractionDigits="2" /></td>
								<td>${product.manufacturer}</td>
								<c:choose>
									<c:when
										test="${product.quantity +product.minreorderquantity gt product.reorderpoint}">
										<td>${product.minreorderquantity}</td>
									</c:when>
									<c:otherwise>
										<td>${product.reorderpoint-$product.quantity}</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when
										test="${product.quantity +product.minreorderquantity gt product.reorderpoint}">
										<td align = "right">$${(product.minreorderquantity)*product.unitprice}</td>
									<!-- 	<c:set var="total" scope="session"
											value="${(prod.minreorderquantity)*prod.unitprice}" /> -->
									</c:when>
									<c:otherwise>
										<td align="right">$${(product.reorderpoint-$product.quantity)*product.unitprice}</td>

									</c:otherwise>
								</c:choose>
								
							</tr>
					
					</tbody>
				</table>
				</form:form>
			</div>
			<!-- END SHOW HIDE COLUMNS DATA TABLE -->
			<a class="btn btn-block label-with-btn" href = "${pageContext.request.contextPath}/reorder/list"><button type="button" class="btn btn-default">Back</button></a>
		</div>
	</div>
</div>




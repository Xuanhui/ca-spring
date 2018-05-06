<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
	<div class="main-header">
		<h2>Reorder Report</h2>
		<em>Show reorder list </em>
	</div>
	<div class="main-content">
		<div class="widget widget-table">
			<div class="widget-header">
				<h3>
					<i class="fa fa-table"></i> Reorder Report
				</h3>
				<em> - <a href="" target="_blank">Inventory Reorder Report</a> enable
					to show/hide and drap-drop column
				</em>
			</div>
			<!-- SHOW HIDE COLUMNS DATA TABLE -->
			<div class="widget-content">
				<table id="datatable-column-interactive"
					class="table table-sorting table-striped table-hover datatable">
					<thead>
						<tr>

							<th>Part No.</th>
							<th>Unit.Price</th>
							<th>Qty</th>
							<th>Reorder Qty.</th>
							<th>Min.Ord.Qty</th>
							<th>Ord.Qty</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="total" value="${0}"/>
						<c:forEach var="prod" items="${productList}">
							<tr>
								<td>${prod.partnumber}</td>
								<td>$<fmt:formatNumber value="${prod.unitprice}"
										minFractionDigits="2" /></td>
								<td>${prod.quantity}</td>
								<td>${prod.reorderpoint }</td>
								<td>${prod.minreorderquantity}</td>
								<c:choose>
									<c:when
										test="${prod.quantity +prod.minreorderquantity gt prod.reorderpoint}">
										<td>${prod.minreorderquantity}</td>
									</c:when>
									<c:otherwise>
										<td>${prod.reorderpoint-$prod.quantity}</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when
										test="${prod.quantity +prod.minreorderquantity gt prod.reorderpoint}">
										<td align = "right">$${(prod.minreorderquantity)*prod.unitprice}</td>
										<c:set var="total" 
											value="${total+(prod.minreorderquantity)*prod.unitprice}" /> 
									</c:when>
									<c:otherwise>
										<td align="right">$${(prod.reorderpoint-$prod.quantity)*prod.unitprice}</td>
                                            <c:set var="total" 
											value="${total+(prod.reorderpoint-$prod.quantity)*prod.unitprice}" /> 
									</c:otherwise>
								</c:choose>
								<td align="center"><a
									class="btn btn-block btn-custom-secondary"
									href="${pageContext.request.contextPath}/reorder/order/${prod.partnumber}">Order</a></td>
							</tr>
							
						</c:forEach>
						
						<tr> 

							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Total</td>
							<td>${total}</td>
						</tr>
					
					</tbody>
				</table>
			</div>
			<!-- END SHOW HIDE COLUMNS DATA TABLE -->
			
			
		</div>
	</div>
</div>




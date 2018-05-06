<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="content">
	<div class="main-header">
		<h2>Transaction Table</h2>
		<em>Show transaction list </em>
	</div>
		
	
	<div class="main-content">
		<div class="widget widget-table">
			<div class="widget-header">
				<h3>
					<i class="fa fa-table"></i> product table 
<%-- 				${session.tmess } --%>
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
							<th>Transaction ID</th>
							<th>Part No</th>
							<th>Product Name</th>
							<th>User Name</th>
														
							<th>Use Date</th>
							<th>Customer Name</th>
							
							<c:if test="${sessionScope.currentuser.type=='admin'}">
								<th></th>
								<th></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${transactionList}">
							<tr>
								<td>${prod.id}</td>
								<td>${prod.partinfoid}</td>
								<td>${prod.mpartinfo.mproduct.name}</td>
								<td>${prod.mProductConsumption.mcustomer.name }</td>
								<td>${prod.mProductConsumption.date }</td>
								<td>${prod.mProductConsumption.custname }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<!-- END SHOW HIDE COLUMNS DATA TABLE -->
			</div>
	</div>
</div>




<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<div class="tab-content profile-page">
	<!-- PROFILE TAB CONTENT -->
	<div class="tab-pane profile active" id="profile-tab">
		<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/edit/${product.partnumber}" class="form-horizontal" role="form">
			<fieldset>
				<h3>
					<i class="fa fa-square"></i>General Information
				</h3>
				<div class="form-group">
					<label for="partnumber" class="col-sm-3 control-label">Part Number</label>
					<div class="col-sm-4">
					<form:input path="partnumber" class="form-control" readonly="true"/>						
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-3 control-label">Product Name</label>
					<div class="col-sm-4">
					<form:input path="name" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-3 control-label">Product Type</label>
					<div class="col-sm-4">
						<form:select path="parttype">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${productType}" />
						</form:select>
					</div>
				</div>	
				<div class="form-group">
					<label for="unitprice" class="col-sm-3 control-label">Unit Price</label>
					<div class="col-sm-4">
					<form:input path="unitprice" class="form-control" />						
					</div>
				</div>	
				<div class="form-group">
					<label for="quantity" class="col-sm-3 control-label">Quantity</label>
					<div class="col-sm-4">
					<form:input path="quantity" class="form-control" />						
					</div>
				</div>	
				<div class="form-group">
					<label for="status" class="col-sm-3 control-label">Status</label>
					<div class="col-sm-4">
						<form:select path="status">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${productStatus}" />
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
					<label for="description" class="col-sm-3 control-label">Description</label>
					<div class="col-sm-4">
					<form:textarea path="description" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="color" class="col-sm-3 control-label">Colour</label>
					<div class="col-sm-4">
					<form:input path="color" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="dimension" class="col-sm-3 control-label">Dimension</label>
					<div class="col-sm-4">
					<form:input path="dimension" class="form-control" />						
					</div>
				</div>
				<div class="form-group">
					<label for="manufacturer" class="col-sm-3 control-label">Manufacturer</label>
					<div class="col-sm-4">
					<form:input path="manufacturer" class="form-control" />						
					</div>
				</div>	
				<div class="form-group">
					<label for="reorderpoint" class="col-sm-3 control-label">Reorder Point</label>
					<div class="col-sm-4">
					<form:input path="reorderpoint" class="form-control" />						
					</div>
				</div>	
				<div class="form-group">
					<label for="minreorderquantity" class="col-sm-3 control-label">Minimum Reorder Quantity</label>
					<div class="col-sm-4">
					<form:input path="minreorderquantity" class="form-control" />						
					</div>
				</div>	
				<div class="form-group">
					<label for="shelflocation" class="col-sm-3 control-label">Shelf Location</label>
					<div class="col-sm-4">
					<form:input path="shelflocation" class="form-control" />						
					</div>
				</div>	
			</fieldset>
		
		<p class="text-center">
			<input type="submit" value="Save Changes" class="btn btn-custom-primary"/>
			<input type="button" value="Cancel" class="btn btn-custom-primary" onclick="javascript:window.location.href ='${pageContext.request.contextPath}/product/list';">
		</p>
</form:form>
	</div>
</div>



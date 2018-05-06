<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="left-sidebar" class="left-sidebar ">
			<!-- main-nav -->
			<div class="sidebar-scroll">
				<nav class="main-nav">
					<ul class="main-menu">
						<li class="active"><a href="#" class="js-sub-menu-toggle"><i class="fa fa-dashboard fa-fw"></i><span class="text">Dashboard </span>
							<i class="toggle-icon fa fa-angle-down"></i></a>
							<c:choose>
									<c:when test="${sessionScope.currentpagename == 'Product' || sessionScope.currentpagename == 'Transaction'}">
									<ul class="sub-menu open">
									</c:when>
									<c:otherwise>
									<ul class="sub-menu">
									</c:otherwise>
							</c:choose>
								
						<!--  	<ul class="sub-menu open">  -->
								<c:choose>
									<c:when test="${sessionScope.currentpagename == 'Product'}">
										<li class="active"><a href="${pageContext.request.contextPath}/product/list"><span class="text">View Product</span><span class="badge element-bg-color-blue">Current</span></a></li>
								    </c:when>
									<c:otherwise>
									<li><a href="${pageContext.request.contextPath}/product/list"><span class="text">View Product</span></a></li>
								  </c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${sessionScope.currentpagename == 'Transaction'}">
										<li class="active"><a href="${pageContext.request.contextPath}/product/transactionlist"><span class="text">View Transaction History</span><span class="badge element-bg-color-blue">Current</span></a></li>								
									</c:when>
									<c:otherwise>
									<li><a href="${pageContext.request.contextPath}/product/transactionlist"><span class="text">View Transaction History</span></a></li>								
									</c:otherwise>
								</c:choose>
							</ul>
						</li>
						<c:if test="${sessionScope.currentuser.type eq 'Admin'}">
						<li><a href="#" class="js-sub-menu-toggle"><i class="fa fa-navicon"></i><span class="text">Reorder Report</span>
							<i class="toggle-icon fa fa-angle-left"></i></a>
							<!--  <ul class="sub-menu open"> -->
								<c:choose>
									<c:when test="${sessionScope.currentpagename == 'ReorderList'}">
									<ul class="sub-menu open">
									</c:when>
									<c:otherwise>
									<ul class="sub-menu">
									</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${sessionScope.currentpagename=='ReorderList' }">
							<li class="active"><a href="${pageContext.request.contextPath}/reorder/list"><span class="text">Order List</span><span class="badge element-bg-color-blue">Current</span></a></li>
							</c:when>
							<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/reorder/list"><span class="text">Order List</span></a></li>
							</c:otherwise>
							</c:choose>
								
							</ul>
						</li>
						<li><a href="#" class="js-sub-menu-toggle"><i class="fa fa-columns"></i><span class="text">Account Manage</span>
							<i class="toggle-icon fa fa-angle-left"></i></a>
									<c:choose>
									<c:when test="${sessionScope.currentpagename == 'ViewAccount' || sessionScope.currentpagename == 'ManageAccount'}">
									<ul class="sub-menu open">
									</c:when>
									<c:otherwise>
									<ul class="sub-menu">
									</c:otherwise>
							</c:choose>
							
							<c:choose>
							<c:when test="${sessionScope.currentpagename=='ViewAccount' }">
							<li class="active"><a href="${pageContext.request.contextPath}/admin/customer/list"><span class="text">View Account</span><span class="badge element-bg-color-blue">Current</span></a></li>
							</c:when>
							<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/admin/customer/list"><span class="text">View Account</span></a></li>
							</c:otherwise>
							</c:choose>
							
							 <ul class="sub-menu ">
								
							</ul>
						</li>
						</c:if>
						<li><a href="#" class="js-sub-menu-toggle"><i class="fa fa-clipboard fa-fw"></i><span class="text">My Profile</span>
							<i class="toggle-icon fa fa-angle-left"></i></a>
							<ul class="sub-menu ">
								<c:choose>
							<c:when test="${sessionScope.currentpagename=='ViewProfile' }">
							<li class="active"><a href="${pageContext.request.contextPath}/viewprofile"><span class="text">View Profile</span><span class="badge element-bg-color-blue">Current</span></a></li>
							</c:when>
							<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/viewprofile"><span class="text">View Profile</span></a></li>
							</c:otherwise>
							</c:choose>	
								
							</ul>
						</li>
						
					</ul>
				</nav>
				<!-- /main-nav -->
			</div>
</div>



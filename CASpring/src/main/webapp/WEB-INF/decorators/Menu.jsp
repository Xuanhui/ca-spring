<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Top Bar -->
<div class="top-bar navbar-fixed-top">
	<div class="container">
		<div class="clearfix">
			<a href="#" class="pull-left toggle-sidebar-collapse"><i
				class="fa fa-bars"></i></a>
			<!-- logo -->
			<div class="pull-left left logo">
				<a href="#"><img
					src=""
					alt="Stockist - Inventory Management System" /></a>
				<h1 class="sr-only">Stockist - Inventory Management System</h1>
			</div>
			<!-- end logo -->
			<div class="pull-right right">
				<!-- search box -->

				<!-- end search box -->
				<!-- top-bar-right -->
				<div class="top-bar-right">

					<div class="notifications">
						<ul>
							<!-- notification: inbox -->

							<!-- end notification: inbox -->
							<!-- notification: general -->
							<li class="notification-item general">
								<div class="btn-group">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<i class="fa fa-bell"></i><span class="count"></span> <span
										class="circle"></span>
									</a>

								</div>
							</li>
							<!-- end notification: general -->
						</ul>
					</div>
					<!-- logged user and the menu -->
					<c:choose>
						<c:when test="${sessionScope.currentuser.name == null }">
							<div class="btn-group">
								<a href="${pageContext.request.contextPath}/login" class="btn btn-link dropdown-toggle" > 
								<span class="name">Login</span>
								</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="logged-user">

								<div class="btn-group">
									<a href="#" class="btn btn-link dropdown-toggle"
										data-toggle="dropdown"> <span class="name">${sessionScope.currentuser.name }</span>
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="${pageContext.request.contextPath}/viewprofile"> 
										<i class="fa fa-user"></i> <span class="text">Profile</span>
										</a></li>
										<li><a href="${pageContext.request.contextPath}/product/cart"> 
										<i class="fa fa-user"></i> <span class="text">Order Cart</span>
										</a></li>
										<li><a href="${pageContext.request.contextPath}/logout"> 
										<i class="fa fa-power-off"></i> <span class="text">Logout</span>
										</a></li>
									</ul>
								</div>
							</div>
						</c:otherwise>
					</c:choose>

					<!-- end logged user and the menu -->
					<!-- Login -->
				
				</div>
				<!-- end top-bar-right -->
			</div>
		</div>
	</div>
	<!-- /container -->
</div>
<!-- END TOP BAR -->




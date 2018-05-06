<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<head>
		<spring:url value="/css/bootstrap.min.css" var="style1"/><link rel="STYLESHEET" type="text/css" href="${style1}" />
		<spring:url value="/css/font-awesome.min.css" var="style2"/><link rel="STYLESHEET" type="text/css" href="${style2}" />
		<spring:url value="/css/main.css" var="style3"/><link rel="STYLESHEET" type="text/css" href="${style3}" />
		<spring:url value="/css/style-switcher.css" var="style4"/><link rel="STYLESHEET" type="text/css" href="${style4}" />
		<spring:url value="/css/transparent.css" var="style4"/><link rel="STYLESHEET" type="text/css" href="${style4}" />
</head>

	<div class="wrapper page-auth page-login ">
		<div class="inner-page">
			<div class="login-box center-block">
				<form:form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/auth" method="POST" commandName="user">
					<p class="title">Use your username</p>
					<div class="form-group">
						<label for="username" class="control-label sr-only">Username</label>
						<div class="col-sm-12">
							<div class="input-group">
								<form:input placeholder="username" class="form-control" path="name" />
								<form:errors path='name' cssStyle="color: red;" />
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
							</div>
						</div>
					</div>
					<label for="password" class="control-label sr-only">Password</label>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="input-group">
								<form:password placeholder="password" id="password" class="form-control" path="password" />
								<div ><form:errors path='password' cssStyle="color: red;" /></div>
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								
							</div>
						</div>
					</div>
					
					<form:button class="btn btn-custom-primary btn-lg btn-block btn-auth" type="submit"><i class="fa fa-arrow-circle-o-right"></i> Login</form:button>
				</form:form>
				<div class="links">
					<p><a href="#"><font color="red"><b>${errorlogin}</b></font></a></p>
					
				</div>
			</div>
		</div>
	</div>
	<c:url var="jssrc" value="/js/jquery-2.1.0.min.js" /><script src="${jssrc}"></script>
 	<c:url var="jssrc" value="/js/bootstrap.js" /><script src="${jssrc}"></script>
 	<c:url var="jssrc" value="/js/modernizr.js" /><script src="${jssrc}"></script>


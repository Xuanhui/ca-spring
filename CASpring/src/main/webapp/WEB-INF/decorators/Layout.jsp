<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@include file="Header.jsp"%>
<dec:head />
</head>
<body class="sidebar-fixed topnav-fixed dashboard">
	<!-- WRAPPER -->
	<div id="wrapper" class="wrapper">
	<%@ include file="Menu.jsp"%>
	<%@ include file="sidebar.jsp"%>
		<!-- MAIN CONTENT WRAPPER -->
		<div id="main-content-wrapper" class="content-wrapper ">
			<div class="row">
				<div class="col-lg-4 ">
					<ul class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="${pageContext.request.contextPath}/product/list">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/${sessionScope.currentpagename}/list">${sessionScope.currentpagetitle}</a></li>
						<li class="active">${sessionScope.currentpagename}</li>
					</ul>
				</div>
			</div>
						
			<!--  My Container-->
			
			
					
					
						<dec:body />
					
					
		
			
						

			<!-- End Container  -->
			
			<footer class="footer">
				&copy; ISS NUS SA45 Team6 2017
			</footer>
		</div>
					
	</div>
	
	<!-- END WRAPPER -->
		
	<!-- Javascript -->
	<c:url var="jssrc" value="/js/jquery-2.1.0.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/bootstrap.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/modernizr.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.slimscroll.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/king-common.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/bootstrap-tour.custom.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/deliswitch.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.easypiechart.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/raphael-2.1.0.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.flot.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.flot.resize.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.flot.time.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.flot.tooltip.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.flot.pie.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.sparkline.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.dataTables.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/dataTables.bootstrap.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.mapael.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/usa_states.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/king-chart-stat.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/usa_states.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/king-table.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/king-components.js" /><script src="${jssrc}"></script>
	
	<c:url var="jssrc" value="/js/dataTables.colVis.bootstrap.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/dataTables.colReorder.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.jqGrid.min.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/grid.locale-en.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/jquery.jqGrid.fluid.js" /><script src="${jssrc}"></script>
	<c:url var="jssrc" value="/js/bootstrap-datepicker.js" /><script src="${jssrc}"></script>
</body>
</html>



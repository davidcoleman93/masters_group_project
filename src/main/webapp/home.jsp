<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.lang.*"%>
<%@page import="java.io.*"%>
<head>
<%
	if ((session.getAttribute("token") == null) || ((session.getAttribute("user") == null))
			|| ((session.getAttribute("role") == null))) {
		response.sendRedirect("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/index.jsp"); //redirect back to home
	}
%>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>DASHGUM - Bootstrap Admin Template</title>
<link href="assets/css/partition.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">
<link rel="stylesheet" type="text/css" href="assets/css/jee.css">
<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<script src="assets/js/chart-master/Chart.js"></script>
<script src="assets/js/functions.js"></script>
<!--  jQuery -->
<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />
<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <script src="assets/js/modernizr-custom.js"></script>
        <![endif]-->


</head>

<body>
	<section id="container">
		<!-- ******OP BAR CONTENT & NOTIFICATIONS******** -->
		<!--header start-->

		<%
			pageContext.include("assets/pages/header.jsp");
		%>
		<!--header end-->
		<!-- ******MAIN SIDEBAR MENU****** -->
		<!--sidebar start-->
		<%
			String userRole = (String) request.getSession().getAttribute("role");
			pageContext.include("assets/pages/sidebar-" + userRole + ".jsp");
		%>

		<!-- ******MAIN CONTENT START***** -->
		<!--I'm using ec (Event Cause) in the ID to indicate which category it belongs to -->
		<div class="content-holder ec-pmodel">
			<section id="main-content">
				<section class="wrapper">
				</section><! --/wrapper -->
			</section><!-- /MAIN CONTENT -->
		</div>
		<!-- SECOND CONTENT START-->
		<div class="content-holder ">
		</div>
		<!-- SECOND CONTENT ENDS-->
		<!--*** MAIN CONTENT ENDS ***-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/plotly-latest.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>
	<!--Partition script for all Tabs-->
	<script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>
	<!--script for this page-->
	<script src="assets/js/sparkline-chart.js"></script>
	<script src="assets/js/zabuto_calendar.js"></script>

	<!-- Needed for autocomplete ui -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->

	<!-- JQuery library -->

	<!-- Needed for autocomplete ui -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<!-- New script for queries. Added by David C -->
	<script src="assets/js/sorting-tables.js"></script>
	<script src="assets/js/autocomplete.js"></script>
	<script src="assets/js/dropdown.js"></script>
	<script src="assets/js/user-stories.js"></script>

	<!-- For query front-end structure -->
	<script src="assets/js/default_query_template.js"></script>
	<script src="assets/js/user_story_specific_front-end.js"></script>
	<script src = "assets/js/page_partition.js"></script>

</body>
  
        
</html>

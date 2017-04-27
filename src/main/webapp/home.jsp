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

	<!-- Script to generate the queries (Page partitioning) -->
	<script>
        $(document).ready(function () {

			/* USER STORY #4 */
            $('#ec-imsi').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays one text field */
                queryOneTextFieldStructure();

				/* Include if there's a dropdown */
                //queryEmptyDropdownStructure();

				/* Unique display per query */
                querySpecificStructure(
                    "User Story 4",
                    "Display, for a given affected IMSI, the Event ID and Cause Code for any / all failures affecting that IMSI",
                    "IMSI",
                    "imsi_text",
                    "Eg. 344930000000011",
                    "userStory4()"
                );

                //$('#imsi_text').attr("placeholder", "Test");

				/* define which auto-complete to include */
                autoComplete("imsi");
                $(".ec-pmodel").show("fast");
            });

			/* User Story 5 */
            $('#count-imsi-cust').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryInputAndFromAndToDateStructure();

				/* Unique display per query */
                querySpecificStructure(
                    "User Story 5", // heading: User Story 1
                    "Count, for a given IMSI, the number of failures they have had during a given time period.", // description: For a given affected IMSI...
                    "IMSI", // label_text: Eg. IMSI or Phone Model
                    "imsi_text", // input_id: imsi_text
                    "Eg. 344930000000011", // placeholder: E.g 344930000000011(imsi)
                    "userStory5()" // button_method: userStory1()
                );

				/* define if to include auto-complete */
                autoComplete("imsi");

                $(".ec-pmodel").show("fast");
            });

			/* User Story 6 */
            $('#ec-ccode').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryOneTextFieldStructure();

				/* Unique display per query */
                querySpecificStructure(
                    "User Story 6", // heading: User Story 1
                    "For a given IMSI, all the unique Cause Codes associated with its call failures", // description: For a given affected IMSI...
                    "IMSI", // label_text: Eg. IMSI or Phone Model
                    "imsi_text", // input_id: imsi_text
                    "Eg. 344930000000011", // placeholder: E.g 344930000000011
                    "userStory6()" // button_method: userStory1()
                );

				/* define if to include auto-complete */
                autoComplete("imsi");
                x
                $(".ec-pmodel").show("fast");
            });

			/* User Story 7 */
            $('#fail-list-sup').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 7");
                $("#info_description").append("List of all IMSIs with call failures during a given time period");

                $('#queryBtn').click(function () {
                    userStory7();
                });

				/* define if to include auto-complete */
                //autoComplete("ue_type");

                $(".ec-pmodel").show("fast");
            });

			/* User Story 8 */
            $('#count-phone-sup').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryInputAndFromAndToDateStructure();

				/* Unique display per query */
                querySpecificStructure(
                    "User Story 8", // heading: User Story 1
                    "Count, for a given model of phone, the number of call failures it has had during a given time period.", // description: For a given affected IMSI...
                    "Phone Model", // label_text: Eg. IMSI or Phone Model
                    "phone_model_text", // input_id: imsi_text
                    "Eg. VEA3", // placeholder: E.g 344930000000011
                    "userStory8()" // button_method: userStory1()
                );

				/* define if to include auto-complete */
                autoComplete("phone_model");

                $(".ec-pmodel").show("fast");
            });

			/*User Story 9 - IMSI COUNT (NET ENGN) START*/
            $("#count-imsi-netengn").click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 9");
                $("#info_description").append("Count, for each IMSI, the number of call failures and their total duration during a given time period");

                $('#queryBtn').click(function () {
                    userStory9();
                });

                $(".ec-pmodel").show("fast");
            });

			/* User Story 10 - Phone Model */
            $("#ec-pmodel").click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays one text field */
                queryOneTextFieldStructure();

				/* Unique display per query */
                querySpecificStructure(
                    "Phone Model (Net Eng)",
                    "Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType and the number of occurrence.",
                    "Phone model:",
                    "phone_model_text",
                    "E.g. VEA3",
                    "userStory10( 'test' )"
                );

				/* define if to include auto-complete */
                autoComplete("phone_model");

                $(".ec-pmodel").show("fast");
            });

			/* User Story 11 */
            $('#mcc-mnc-time-netengn').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 11");
                $("#info_description").append("Top 10 Market/Operator/Cell ID combinations that had call failures during a time period");

                $('#queryBtn').click(function () {
                    userStory11();
                });

				/* define if to include auto-complete */
                //autoComplete("ue_type");

                $(".ec-pmodel").show("fast");
            });

			/* User Story 12 */
            $('#top-imsi-netengn').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 12");
                $("#info_description").append("Top 10 IMSIs that had call failures during a time period");

                $('#queryBtn').click(function () {
                    userStory12();
                });

                $(".ec-pmodel").show("fast");
            });

			/* User Story 13 query */
            $('#mcc-mnc-graph-netengn').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryOneButtonFieldStructure();

                $("#info_heading").append("User Story 13");
                $("#info_description").append("Graphical Representation of the Top 10 Market/Operator/Cell ID combinations with call failures showing Node, Number of failures & % of all failures");

                $('#queryBtn').click(function () {
                    userStory13();
                });

                $(".ec-pmodel").show("fast");
            });

			/* User Story 14 */
            $('#aff-imsi-sup').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryEmptyDropdownStructure();

                $('#query_dropdown').attr({
                    id:"failure_class_text"
                });

                $("#info_heading").append("User Story 14");
                $("#info_description").append("Display, for a given failure Cause Class, the IMSIs that were affected.");

                $('#queryBtn').click(function () {
                    userStory14();
                });

				/* define if to include auto-complete */
                //dropdown("failure_class");

                $(".ec-pmodel").show("fast");
            });

			/*
			 Chart User story #9
			 */
            $("#chart9").click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 9");
                $("#info_description").append("Count, for each IMSI, the number of call failures and their total duration during a given time period");

                $('#queryBtn').click(function () {
                    userStory9( "charts" );
                });

                $('#query_output').empty();

                $(".ec-pmodel").show("fast");
            });

			/*
			 Chart User story #10
			 */
            $('#chart10').click(function () {
                $(".wrapper").empty();
                queryStructure();

				/* Displays one text field */
                queryOneTextFieldStructure();

				/* Unique display per query */
                querySpecificStructure(
                    "Phone Model (Net Eng)",
                    "Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType and the number of occurrence.",
                    "Phone model:",
                    "phone_model_text",
                    "E.g. VEA3",
                    "userStory10( 'charts' )"
                );

				/* define if to include auto-complete */
                autoComplete("phone_model");

                $('#query_output').empty();

                $(".ec-pmodel").show("fast");
            });

			/*
				Chart User story #11
			*/
            $('#chart11').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 11");
                $("#info_description").append("Top 10 Market/Operator/Cell ID combinations that had call failures during a time period");

                $('#queryBtn').click(function () {
                    userStory11( 'charts' );
                });

                $('#query_output').empty();

                $(".ec-pmodel").show("fast");
            });

			/*
				Chart User story #12
			*/
            $('#chart12').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryFromAndToDateStructure();

                $("#info_heading").append("User Story 12");
                $("#info_description").append("Top 10 IMSIs that had call failures during a time period");

                $('#queryBtn').click(function () {
                    userStory12( 'charts' );
                });

				$('#query_output').empty();

                $(".ec-pmodel").show("fast");
            });

			/*
				Chart User story #13
			*/
            $('#chart13').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();

				/* Displays input field corresponding to query */
                queryOneButtonFieldStructure();

                $("#info_heading").append("User Story 13");
                $("#info_description").append("Graphical Representation of the Top 10 Market/Operator/Cell ID combinations with call failures showing Node, Number of failures & % of all failures");

                $('#queryBtn').click(function () {
                    userStory13( 'charts' );
                });

                $('#query_output').empty();

                $(".ec-pmodel").show("fast");
            });

            //LOOKUP TABLE - EVENT CAUSES
            $('#eventCauses').click(function () {
				/* We must empty the outer container first */
                $(".wrapper").empty();

				/* This defines the structure for all query pages */
                queryStructure();
                $('#query_input').empty();
                $('#query_info').empty();
                showEventCauseTable();

                $(".ec-pmodel").show("fast");
            });

        });

	</script>

</body>
  
        
</html>

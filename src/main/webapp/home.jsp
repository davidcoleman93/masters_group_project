<!DOCTYPE html>
<<<<<<< HEAD
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>DASHGUM - Bootstrap Admin Template</title>


        <!-- Needed for autocomplete ui -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->

        <link href="assets/css/partition.css" rel="stylesheet">
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/jee.css">
        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        <script src="assets/js/chart-master/Chart.js"></script>
        <script src="assets/js/functions.js"></script>
        <!--  jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
        <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
        <!-- Bootstrap Date-Picker Plugin -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
=======
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<%
	if ((session.getAttribute("token") == null) || ((session.getAttribute("user") == null))
			|| ((session.getAttribute("role") == null))) {
		response.sendRedirect("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/index.jsp"); //redirect back to home
	}
%>
<head>
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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
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
>>>>>>> bk_partition_ui
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script src="assets/js/modernizr-custom.js"></script>
<![endif]-->
<<<<<<< HEAD
    </head>

    <body>
        <section id="container">
            <!-- *******TOP BAR CONTENT & NOTIFICATIONS******** -->
            <!--header start-->
            <%@include file="assets/pages/header.jsp" %>
                <!--header end-->
                <!-- ******MAIN SIDEBAR MENU****** -->
                <!--sidebar start-->
                <%@include file="assets/pages/sidebar.jsp" %>
                    <!--sidebar end-->
                    <!-- ******MAIN CONTENT START***** -->
                    <!--I'm using ec (Event Cause) in the ID to indicate whic category it belongs to -->
                    <div class="content-holder ec-pmodel">
                        <section id="main-content">
                            <section class="wrapper">
                                <p>Wrapper test</p>

                            </section><! --/wrapper -->
                        </section><!-- /MAIN CONTENT -->
                    </div>
                    <!-- SECOND CONTENT START-->
                    <div class="content-holder ">

                    </div>
                    <!-- SECOND CONTENT ENDS-->
                    <!--*** MAIN CONTENT ENDS ***-->
                    <!--footer start
=======


</head>

<body>
	<section id="container">
		<!-- *******TOP BAR CONTENT & NOTIFICATIONS******** -->
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
		<script>
//DONT DELETE THIS
<%-- var username = "<%=tok%>";
alert(username); --%>
</script>
		<!--sidebar end-->
		<!-- ******MAIN CONTENT START***** -->
		<!--I'm using ec (Event Cause) in the ID to indicate whic category it belongs to -->
		<div class="content-holder ec-imsi">
			<section id="main-content">
				<section class="wrapper">
					<h3>
						<i class="fa fa-angle-right"></i> IMSI - I call it Sample table
						for now
					</h3>
					<div class="row">
						<div class="col-md-12">
							<div class="content-panel">
								<h4>
									<i class="fa fa-angle-right"></i> Basic Table
								</h4>
								<hr>
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- /row -->
				</section>
				<! --/wrapper -->
			</section>
		</div>
		<!-- SECOND CONTENT START-->
		<div class="content-holder ec-pmodel">
			<section id="main-content">
				<section class="wrapper">
					<h3>
						<i class="fa fa-angle-right"></i> PHONE Model - I call it Sample
						table for now
					</h3>
					<div class="row">
						<div class="col-md-12">
							<div class="content-panel">
								<h4>
									<i class="fa fa-angle-right"></i> Basic Table
								</h4>
								<hr>
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
										<tr>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>1</td>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- /row -->
				</section>
				<! --/wrapper -->
			</section>
		</div>
		<!-- SECOND CONTENT ENDS-->
		<!--*** MAIN CONTENT ENDS ***-->
		<!--footer start
>>>>>>> bk_partition_ui
<footer class="site-footer">
<div class="text-center">LTE FAILURE SYSTEM
<a href="home.html" class="go-top"> <i class="fa fa-angle-up"></i> </a>
</div>
</footer>
footer end-->
<<<<<<< HEAD
                    </section>
                <!-- js placed at the end of the document so the pages load faster -->
                <script src="assets/js/jquery.js"></script>
                <script src="assets/js/jquery-1.8.3.min.js"></script>
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
                <script src="assets/js/user-stories.js"></script>

                <!-- For query front-end structure -->
                <script src="assets/js/default_query_template.js"></script>
                <script src="assets/js/user_story_specific_front-end.js"></script>




        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <!-- Side bar Script-->
                <script>
                    $(document).ready(function () {
                        $("#ec-imsi").click(function () {
                            $(".qform").show("fast");
                            $("#queryname").html("UE Typesxx:");
                            $(".content-holder").slideUp("fast");
                            $(".ec-imsi").show("fast");
                        });

                            /*USer Story 10 - Phone Model start*/
                        $("#ec-pmodel").click(function () {

                            $(".wrapper").empty();
                            queryStructure();

                            queryOneTextFieldStructure();

                            //userStory10Structure();
                            userStory10StructureV2();
                            autoComplete("ue_type");

                            $(".ec-pmodel").show("fast");


                        });
                        /*Phone Model end*/

                        /*User Story 9 - IMSI COUNT (NET ENGN) START*/
                        $("#count-imsi-netengn").click(function () {

                            $(".wrapper").empty();
                            queryStructure();

                            //queryTwoTextFieldStructure();
                            queryFromAndToDateStructure();
                            //queryFromAndToDateTimeStructure();

                            userStory9Structure();
                            //autoComplete("ue_type");

                            $(".ec-pmodel").show("fast");


                        });

                        /*User Story 6 - IMSI COUNT (CUST ENGN) START*/
                        $("#count-imsi-cust").click(function () {
                            $(".wrapper").empty();
                            queryStructure();

                            queryOneTextFieldStructure();

                            userStory6Structure();
                            autoComplete("imsi");

                            $(".ec-pmodel").show("fast");

                        });

                        $("#aff-imsi-sup").click(function () {

                            $(".wrapper").empty();
                            queryStructure();

                            //queryOneTextFieldStructure();
                            queryEmptyDropdownStructure();

                            userStory14Structure();
                            //autoComplete("ue_type");

                            $(".ec-pmodel").show("fast");


                        });


                    });
                </script>



        <script>
            $( function() {
                $( "#fromDate").datepicker({dateFormat: 'yyyy-mm-dd'});
                //$( "#toDate").datepicker();
            } );

            function userStory6(){
                var imsi = document.getElementById('imsi_text').value;
                $("#results").html("");
                $.ajax({
                    type: 'GET',
                    //url: 'api/data/event_cause/by_imsi/' + imsi,
                    url: 'http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/event_cause/by_imsi/' + imsi,
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (aList) {
                        story6 = aList;
                        $("#results").append("<th onclick = 'sortTable(0)'>" + "Cause Code" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +  "</th>" + "<th onclick = 'sortTable(1)'>"+ "Count" + "</th>" );
                        document.getElementById("searched").innerHTML = "Searched: " + imsi + "<br>";
                        document.getElementById("searched").innerHTML += story6.length + " results found!";

                        $.each(story6, function (index, value) {
                            $("#results").append("<tr><td>" + value[0] + "</td><td>" + value[1] + "</td></tr>");
                        });
                    }
                });

            }
        </script>

                </body>

            </html>
=======
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>
	<!--Partition script for all Tabs-->
	<script type="text/javascript"
		src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>
	<!--script for this page-->
	<script src="assets/js/sparkline-chart.js"></script>
	<script src="assets/js/zabuto_calendar.js"></script>
	<!-- Side bar Script-->
	<script>
            $(document).ready(function () {
                $("#ec-imsi").click(function () {
                    $(".content-holder").slideUp("fast");
                    $(".ec-imsi").show("fast");
                });
                $("#ec-pmodel").click(function () {
                    $(".content-holder").slideUp("fast");
                    $(".ec-pmodel").show("fast");
                });
            });
        </script>
</body>

</html>
>>>>>>> bk_partition_ui

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
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
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script src="assets/js/modernizr-custom.js"></script>
<![endif]-->


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

		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="row mtbox">
						<div class="col-lg-12">
							<p>
								<input type="file" accept=".xls,.xlsx,.xlsm,.xlsb" id="excel"
									value="csv">
							<p id="uploadMsg">Select XlS File</p>
							<button id="isubmit">Submit</button>
							</p>
							<pre id="display"></pre>
							<br />
							<script src="assets/script/dist/cpexcel.js"></script>
							<script src="assets/script/shim.js"></script>
							<script src="assets/script/jszip.js"></script>
							<script src="assets/script/xlsx.js"></script>
							<script src="assets/script/ods.js"></script>
							<script
								src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
							<script>
                                                    var X = XLS;

                                                    function convertToCSV(workbook) {
                                                        var result = [];
                                                        workbook.SheetNames.forEach(function (sheetName) {
                                                            var csv = X.utils.sheet_to_csv(workbook.Sheets[sheetName]);
                                                            if (csv.length > 0) {
                                                                result.push("SHEET: " + sheetName);
                                                                result.push("");
                                                                result.push(csv);
                                                            }
                                                            $.ajax({
                                                                type: 'post'
                                                                , url: 'data_import.jsp'
                                                                , data: "content=" + csv + "&" + "fileName=" + sheetName
                                                                , success: function () {
                                                                    /*JSP Start*/
                                                                    <%// String path = application.getRealPath("/csvDirectory");
			String content = request.getParameter("content");
			String fileName = request.getParameter("fileName");
			//making sure content has been posted.
			if (content != null) {
				String filePath = "C:\\Code\\JEEProject\\masters_group_project\\Files\\" + fileName + ".csv";
				try {
					out.println(filePath);
					PrintWriter pw = new PrintWriter(new FileOutputStream(filePath));
					pw.println(content);
					pw.close();
				} catch (IOException e) {
					out.println(e.getMessage());
				}
			}%>
                                                                    /*JSP Ends*/
                                                                }
                                                            });
                                                        });
                                                        //return sheetName;
                                                        return result.join("\n");
                                                    }
                                                    var excel = document.getElementById('excel');
                                                    /*File manager Function*/
                                                    function manageFile(event, file) {
                                                        {
                                                            var reader = new FileReader();
                                                            reader.onload = function (event) {
                                                                var data = event.target.result;
                                                                var workbook;
                                                                workbook = X.read(data, {
                                                                    type: 'binary'
                                                                });
                                                                //displaying is here
                                                                display.innerText = convertToCSV(workbook);
                                                            };
                                                            reader.readAsBinaryString(file);
                                                        }
                                                    }
                                                    /*check file extentions*/
                                                    function validateFileExtention(ext) {
                                                        var extentions = ["xls", "xlsx", "xlsm"
                                                                              , "xlsb"];
                                                        return (extentions.indexOf(ext) > -1);
                                                    }
                                                    /*Handles file manipulations*/
                                                    var uploadmsg = document.getElementById("uploadMsg");
                                                    var submit = document.getElementById("isubmit");
                                                    excel.addEventListener('change', function (event) {
                                                        var file = event.target.files[0]; //file
                                                        //check for valid file extention
                                                        if (validateFileExtention(file.name.split('.').pop()) === true) {
                                                            submit.disabled = false;
                                                            uploadmsg.innerHTML = "";
                                                        }
                                                        else {
                                                            submit.disabled = true;
                                                            uploadmsg.innerHTML = "Thats an Invalid File";
                                                        }
                                                        $('#isubmit').click(function () {
                                                            manageFile(event, file); //calls managefile function
                                                        });
                                                    });
                               </script>
						</div>
					</div>
				</div>
				<!--/row -->
			</section>
		</section>

		<!-- SECOND CONTENT ENDS-->
		<!--*** MAIN CONTENT ENDS ***-->
		<!--footer start
<footer class="site-footer">
<div class="text-center">LTE FAILURE SYSTEM
<a href="home.html" class="go-top"> <i class="fa fa-angle-up"></i> </a>
</div>
</footer>
footer end-->
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

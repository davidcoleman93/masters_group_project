<%-- 
    Document   : index
    Created on : Feb 27, 2017, 6:31:15 PM
    Author     : bobaikato
--%>
<%-- Last Edited Feb 27th--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*"  %> 
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>LTE Failure System</title>

        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="../css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="../js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="../lineicons/style.css">
        <link rel="stylesheet" type="text/css" href="../css/jee.css">

        <!-- Custom styles for this template -->
        <link href="../css/style.css" rel="stylesheet">
        <link href="../css/style-responsive.css" rel="stylesheet">

        <script src="../js/chart-master/Chart.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        </head>

        <body>

      <section id="container" >
          <!-- **********************************************************************************************************************************************************
                TOP BAR CONTENT & NOTIFICATIONS
          ************************************************************************************************************************************************* -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips"></div>
              </div>
            <!--logo start-->
            <a href="../../index.html" class="logo"><b>LTE Failure System</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
               
            </div>
            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.html">Logout</a></li>
                </ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
          <!--sidebar start-->
          <aside>
              <div id="sidebar"  class="nav-collapse ">
                  <!-- sidebar menu start-->
                  <ul class="sidebar-menu" id="nav-accordion">

                      <li class="mt">
                          <a href="../../index.html">
                              <i class="fa fa-dashboard"></i>
                              <span>Dashboard</span>
                          </a>
                      </li>

                      <li class="sub-menu">
                          <a href="javascript:;" >
                              <i class="fa fa-tasks"></i>
                              <span>Data Analysis</span>
                          </a>
                          <ul class="sub">
                              <li><a  href="data_analysis.html">Search for data!</a></li>
                          </ul>
                      </li>

                      <li class="sub-menu">
                          <a href="javascript:;" >
                              <i class="fa fa-th"></i>
                              <span>Data Tables</span>
                          </a>
                          <ul class="sub">
                              <li><a  href="basic_table.html">Basic Table</a></li>
                              <li><a  href="responsive_table.html">Responsive Table</a></li>
                          </ul>
                      </li>
                      <li class="sub-menu">
                          <a href="javascript:;" >
                              <i class=" fa fa-bar-chart-o"></i>
                              <span>Data Charts</span>
                          </a>
                          <ul class="sub">
                              <li><a  href="morris.html">Morris</a></li>
                              <li><a  href="chartjs.html">Chartjs</a></li>
                          </ul>
                      </li>

                      <li class="sub-menu">
                          <a href="javascript:;" >
                              <i class="fa fa-cogs"></i>
                              <span>Components</span>
                          </a>
                          <ul class="active" class="sub">
                              <li><a class="active" href="data_import.jsp">Data Import</a></li>
                              <li><a  href="todo_list.html">Todo List</a></li>
                          </ul>
                      </li>

                  </ul>
                  <!-- sidebar menu end-->
              </div>
          </aside>
          <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">

              <div class="row">                  
                        
                <div class = "row mtbox">

                    <div class="col-lg-12">

                        <p><input type="file" name="ExcelFile" id="xlsFile" value="csv"> Select XlS File</p>

                        <pre id="display"></pre>
                        <br />
                        <script src="../script/dist/cpexcel.js"></script>
                        <script src="../script/shim.js"></script>
                        <script src="../script/jszip.js"></script>
                        <script src="../script/xlsx.js"></script>
                        <script src="../script/ods.js"></script>
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
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
                                        console.log(csv)

                                    }
                                    $.ajax({
                                        type: 'post',
                                        url: 'data_import.jsp',
                                        data: "content=" + csv + "&" + "fileName=" + sheetName,
                                        success: function () {
                                            <%
                                                // String path = application.getRealPath("/csvDirectory");
                                                String content = request.getParameter("content");
                                                String fileName = request.getParameter("fileName");
                                                //making sure content has been posted.
                                                if (content != null) {
                                                    String filePath = "C:\\Software\\Programming\\workspace\\TestProject\\Files\\" + fileName + ".csv";
                                                    try {
                                                        out.println(filePath);
                                                        PrintWriter pw = new PrintWriter(new FileOutputStream(filePath));
                                                        pw.println(content);
                                                        pw.close();
                                                    } catch (IOException e) {
                                                        out.println(e.getMessage());
                                                    }
                                                }
                                            %>
                                        }
                                    });
                                });

                                //return sheetName;
                                return result.join("\n");
                            }

                            var xlsFile = document.getElementById('xlsFile');
                            function manageFile(e) {
                                var files = e.target.files;
                                var fx = files[0];
                                {
                                    var reader = new FileReader();
                                    //var name = fx.name; //file name
                                    reader.onload = function (e) {
                                        var data = e.target.result;
                                        var workbook;
                                        workbook = X.read(data, {type: 'binary'});
                                        //displaying is here
                                        // console.log(workbook.SheetNames);

                                        display.innerText = convertToCSV(workbook);

                                    };
                                    reader.readAsBinaryString(fx);
                                }
                            }

                            if (xlsFile.addEventListener)
                                xlsFile.addEventListener('change', manageFile, false);

                        </script>

                    </div>                      

                </div> 
                  
              </div><!--/row -->

              
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="../../index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery-1.8.3.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../js/jquery.scrollTo.min.js"></script>
    <script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="../js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="../js/common-scripts.js"></script>
    
    <script type="text/javascript" src="../js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="../js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="../js/sparkline-chart.js"></script>
    <script src="../js/zabuto_calendar.js"></script>

    
    <script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>

</html>

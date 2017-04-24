
<%
	String userRoleNAMEx = "";
	String usernameX = (String) request.getSession().getAttribute("user");
	String userRoleNAME = (String) request.getSession().getAttribute("role");
	if (userRoleNAME.equals("administrator")) {
		userRoleNAMEx = "Administrator";
	}
	if (userRoleNAME.equals("customerservice")) {
		userRoleNAMEx = "Customer Service ";
	}
	if (userRoleNAME.equals("networkengineer")) {
		userRoleNAMEx = "Network Engineer ";
	}
	if (userRoleNAME.equals("supportengineer")) {
		userRoleNAMEx = "Support Engineer ";
	}
%>

<!--header start-->
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips"></div>
	</div>
	<!--logo start-->
	<a href="home.jsp" class="logo"><b>LTE Failure System</b></a>
	<!--logo end-->
	<div class="top-menu">

		<div class="collapse navbar-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span> 
						<strong><%=usernameX%></strong> <span
						class="glyphicon glyphicon-chevron-down"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a> <%=userRoleNAMEx%></a></li>
						<li><a href="assets/pages/logout.jsp"> <span
								class="glyphicon glyphicon-log-out  pull-right"></span> Sign Out</a></li>

					</ul></li>
			</ul>
		</div>
	</div>
</header>



<!--header end-->
<%--             <script>
//DONT DELETE THIS
                var username = "<%=tok%>";
                alert(username);
            </script> --%>
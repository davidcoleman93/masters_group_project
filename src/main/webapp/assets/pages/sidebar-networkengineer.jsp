<%--
    Document   : sidebar-cust-rep
    Created on : Apr 22, 2017, 1:15:41 PM
    Author     : bobaikato
--%>
<aside>
    <div id="sidebar" class="nav-collapse ">
        <ul class="sidebar-menu" id="nav-accordion">
            <li class="mt">
                <a class="active" href="home.jsp"> <i class="fa fa-dashboard"></i> <span>Dashboard</span> </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;"> <i class="fa fa-tasks"></i> <span>Event Causes</span> </a>
                <ul class="sub">
                    <li><a id="ec-pmodel">Phone Model (Net Engn)</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;"> <i class="fa fa-phone-square"></i> <span>Call Failure</span> </a>
                <ul class="sub">
                    <li><a id="top-imsi-neteng">Top 10 IMSI (Net Engn)</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;"> <i class="fa fa-sort-numeric-asc"></i> <span>Counts</span> </a>
                <ul class="sub">

                    <li><a id="count-imsi-netengn">IMSI (Net Engn)</a></li>

                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;"> <i class="fa fa-phone-square"></i> <span>Call Failure</span> </a>
                <ul class="sub">
                    <li><a id="mcc-mnc-time-netengn">MCC / MNC TIME (Net Engn)</a></li>
                    <li><a id="mcc-mnc-graph-netengn">MCC / MNC GRAPH (Net Engn)</a></li>
                </ul>
            </li>
        </ul>
    </div>
</aside>

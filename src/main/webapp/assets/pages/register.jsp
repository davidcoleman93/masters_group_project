<%--
    Document   : register
    Created on : Apr 22, 2017, 6:20:04 PM
    Author     : bobaikato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.lang.*"%>
<%@page import="java.io.*"%>
<%@page language="Java"%>

<!DOCTYPE html>
<html lang="en">

    <%
        if ((session.getAttribute("token") == null) || (session.getAttribute("role") == null) || (session.getAttribute("user") == null)) {
            response.sendRedirect("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/index.jsp"); //redirect back to home

        } else {
            String userRole = (String) request.getSession().getAttribute("role");
            if (!userRole.equals("administrator")) {
                response.sendRedirect("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.jsp");
            }
        }
    %>

    <head>

        <meta charset="utf-8">
        <title>REGISTER LTE Users</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../css/form-style.css">

    </head>

    <body>
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 align="center">REGISTER NEW USER</h2>
                                    <!-- Example split danger button -->
                                    <div class="dropdown form-group">
                                        <button id="role-type-toggle" type="button"
                                                data-toggle="dropdown">
                                            Assign Role <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a id="admin">Administrator</a></li>
                                            <li><a id="customer-service">Customer Service</a></li>
                                            <li><a id="support-engineer">Support Engineer</a></li>
                                            <li><a id="network-engineer">Network Engineer</a></li>
                                        </ul>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" name="username" id="username" tabindex="1"
                                                   class="form-control" placeholder="Username"> <span
                                                   id="usersign" class="input-group-addon warning"
                                                   title="Enter username"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="email" name="email" id="email-id" tabindex="1"
                                                   class="form-control" placeholder="Email Address"> <span
                                                   id="emailsign" class=" input-group-addon warning"
                                                   title="Enter E-mail address"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="password" name="password" id="password"
                                                   tabindex="2" class="form-control" placeholder="Password">
                                            <span id="pwordsign1" class="input-group-addon warning "
                                                  title="Enter password"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="password" name="confirm-password"
                                                   id="confirm-password" tabindex="2" class="form-control"
                                                   placeholder="Confirm Password"> <span id="pwordsign2"
                                                   class="input-group-addon warning  "
                                                   title="Enter password again"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" name="user-role" id="user-role"
                                                   tabindex="1" class="form-control"
                                                   placeholder="User Role Appears here!" disabled="disabled">
                                            <span id="rolesign" class="input-group-addon warning "
                                                  title="User role"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div>
                                                <input type="submit" name="register-submit"
                                                       id="register-submit" tabindex="4"
                                                       class="form-control btn btn-register " value="Register">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-heading">
                            <div class="row">
                                <div>
                                    <a id="register-form-link">
                                        <div class="register"></div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container">
                <div class="col-md-10 col-md-offset-1 text-center">
                    <a href="../../home.html">LTE Failure System</a>
                </div>
            </div>
        </footer>
        <script src="../js/jquery-1.8.3.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/form-script.js"></script>

    </body>

</html>

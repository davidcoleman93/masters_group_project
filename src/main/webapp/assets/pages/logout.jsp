<%--
    Document   : logout
    Created on : Apr 22, 2017, 4:17:57 PM
    Author     : bobaikato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	session.setAttribute("token", null);//set token
	session.setAttribute("user", null); //login user
	session.setAttribute("role", null); // login user role
	if ((session.getAttribute("token") == null) && (session.getAttribute("user") == null)
			&& (session.getAttribute("role") == null)) {
		response.sendRedirect("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/");
	}
%>

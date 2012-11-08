
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Login</h2>

	<form:form action="loginProcess" commandName="usuario">
		<table align="center">
			<tr>
				<td>login :</td>
				<td><form:input path="login" /> <b> <form:errors path="login" cssClass="error" /></b></td>
			</tr>
			<tr>
				<td>contrasinal :</td>
				<td><form:password  path="contrasinal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>



</div>






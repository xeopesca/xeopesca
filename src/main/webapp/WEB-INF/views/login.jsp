
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- novas -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div id="ReportDetails">
	<h2>Login</h2>
	<form name="f" action="<c:url value='j_spring_security_check'/>"
		method="POST">

		<input type='text' name='j_username' id="user" value=''/>
		<br> <input type='password' name='j_password' id="pass">
</div>


<input name="submit" type="submit" id="button"
	value="entrar" />
</form>




</div>






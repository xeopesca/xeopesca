<!-- 
/* --------------------------------------------------------------------
Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/

 -->
<%@ page import="java.util.Locale "%>
<%@ page import="org.springframework.context.i18n.LocaleContextHolder"%>
<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>





<c:if test="${param.error == 'true'}">
	<div class="container">
		<div class="span7 offset2">
			<div class="alert">
				<a class="close" data-dismiss="alert-error">x</a> <strong><fmt:message key="site.error.message"/></strong>
				<fmt:message key="login.error.notvalid"/>

			</div>
		</div>
	</div>

</c:if>

<div id="container">

	<form class="form-signin" name="f" action="<c:url value='j_spring_security_check'/>"
		method="POST">
        <h2 class="form-signin-heading"><fmt:message key="login.title.identi"/></h2>
		<input class="input-block-level" placeholder='<fmt:message key="login.input.user"/>' type='text' name='j_username' id="user" value=''/>
		<input class="input-block-level" placeholder='<fmt:message key="login.input.pwd"/>' type='password' name='j_password' id="pass">
		<button class="btn btn-large btn-primary" type="submit"><fmt:message key="login.button.entrar"/></button>
	</form>
</div>


<script src="/bootstrap/js/jquery.js"></script> 
<script src="/bootstrap/js/bootstrap-alert.js"></script> 


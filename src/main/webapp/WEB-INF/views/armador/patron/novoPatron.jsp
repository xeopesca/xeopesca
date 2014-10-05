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
--------------------------------------------------------------------*/-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="ReportDetails">
	<h2><fmt:message key="armador.novoPatron.title"/></h2>

	<form:form method="POST" action="/xeopesca/armador/novoPatron" commandName="usuario">
		<div style="color: #FF0000;">
			<form:errors path="login" />
			<form:errors path="nome" />
			<form:errors path="apelidos" />
			<form:errors path="contrasinal" />
		</div>
		<table >
			<tr>
				<td><fmt:message key="armador.novoPatron.login"/></td>
				<td><form:input path="login" id="login" name="login" required="required" pattern=".{4,10}" maxlength="10" placeholder="min. 4- max. 10" title="min. 4- max. 10"/></td>
			</tr>
			<tr>
				<td><fmt:message key="armador.novoPatron.nome"/></td>
				<td><form:input path="nome" id="nome" name="nome" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="armador.novoPatron.apelidos"/></td>
				<td><form:input path="apelidos" id="apelidos" name="apelidos" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="armador.novoPatron.contrasinal"/></td>
				<td><form:input path="contrasinal" id="contrasinal" name="contrasinal" required="required"  pattern=".{5,}" placeholder="min. 5" title="min. 5"/></td>
				<td><form:input path="tipousuario" value="ROLE_PATRON" type="hidden"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="armador.novoPatron.gardar"/>' /></td>
			</tr>
		</table>
	</form:form>
</div>





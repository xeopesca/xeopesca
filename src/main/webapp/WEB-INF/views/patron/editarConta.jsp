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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2><fmt:message key="patron.editarConta.title"/></h2>

	<form:form action="/xeopesca/editarConta" commandName="usuario">

		<div style="color: #FF0000;">
			<form:errors path="login" />
			<form:errors path="nome" />
			<form:errors path="tipousuario" />
			<form:errors path="contrasinal" />

		</div>

	    <input id="id" name="id" type="hidden" value="${usuario.id}"/>
		<input id="patron_autoriza" name="patron_autoriza" type="hidden" value="${usuario.patron_autoriza}"/>
		<input id="idbarco" name="idbarco" type="hidden" value="${usuario.idbarco}"/>
		<table>
			<tr>
				<td><fmt:message key="patron.editarConta.login"/></td>
				<td><form:input path="login" readonly="true" /></td>
			</tr>
			<tr>
				<td><fmt:message key="patron.editarConta.perfil"/></td>
				<td><form:input path="tipousuario" readonly="true" /></td>
				
			</tr>

			<tr>
				<td><fmt:message key="patron.editarConta.nome"/></td>
				<td><form:input path="nome" /></td>
			</tr>

			<tr>
				<td><fmt:message key="patron.editarConta.apelidos"/></td>
				<td><form:input path="apelidos" /></td>
			</tr>
			<tr>
				<td><fmt:message key="patron.editarConta.contrasinal"/></td>
				<td><form:password path="contrasinal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="patron.editarConta.button.gardar"/>' /></td>
			</tr>

		</table>

	</form:form>



</div>


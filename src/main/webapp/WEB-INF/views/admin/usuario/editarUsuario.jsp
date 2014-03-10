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
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div id="ReportDetails">
	<h2><fmt:message key="admin.editarUsuario.title"/></h2>

	<form:form action="/xeopesca/admin/updateUsuario" commandName="usuario">

		<div style="color: #FF0000;">
			<form:errors path="login" />
			<form:errors path="nome" />
			<form:errors path="tipousuario" />
			<form:errors path="contrasinal" />

		</div>

	    <input id="id" name="id" type="hidden" value="${usuario.id}"/>
		
		<table>
			<tr>
				<td><fmt:message key="admin.editarUsuario.login"/></td>
				<td><form:input path="login" readonly="true" /></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.editarUsuario.perfil"/></td>
				<td><form:select path="tipousuario" >
						<form:option value="ROLE_ADMIN" label="Admin" />
						<form:option value="ROLE_ARMADOR" label="Armador" />
						<form:option value="ROLE_PATRON" label="Patrón" />
						<form:option value="ROLE_ADMINISTRACION" label="Administración" />

					</form:select></td>
			</tr>

			<tr>
				<td><fmt:message key="admin.editarUsuario.nome"/></td>
				<td><form:input path="nome" /></td>
			</tr>

			<tr>
				<td><fmt:message key="admin.editarUsuario.apelidos"/></td>
				<td><form:input path="apelidos" /></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.editarUsuario.contrasinal"/></td>
				<td><form:input path="contrasinal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="admin.editarUsuario.button.gardar"/>' /></td>
			</tr>

		</table>

	</form:form>



</div>





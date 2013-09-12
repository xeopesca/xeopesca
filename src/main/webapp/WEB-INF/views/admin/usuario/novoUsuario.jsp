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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Novo usuario</h2>
	<!--<c:out value="${message}" /> -->

	<form:form action="novoUsuario2" commandName="usuario">

		<div style="color: #FF0000;">
			<form:errors path="login" />
			<form:errors path="nome" />
			<form:errors path="tipousuario" />
			<form:errors path="contrasinal" />

		</div>
		<table >
			<tr>
				<td>Login :</td>
				<td><form:input path="login" /></td>
			</tr>
			<tr>
				<td>Perfil:</td>
				<td><form:select path="tipousuario">
						<form:option value="" label="--- Select ---" />
						<form:option value="ROLE_ADMIN" label="Admin" />
						<form:option value="ROLE_ARMADOR" label="Armador" />
						<form:option value="ROLE_PATRON" label="Patrón" />
						<form:option value="ROLE_ADMINISTRACION" label="Administración" />
						
					</form:select></td>
			</tr>

			<tr>
				<td>Nome :</td>
				<td><form:input path="nome" /></td>
			</tr>

			<tr>
				<td>Apelidos :</td>
				<td><form:input path="apelidos" /></td>
			</tr>
			<tr>
				<td>Contrasinal :</td>
				<td><form:input path="contrasinal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>

	</form:form>



</div>





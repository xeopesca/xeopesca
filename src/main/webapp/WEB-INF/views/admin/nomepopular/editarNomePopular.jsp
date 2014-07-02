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
	<h2><fmt:message key="admin.editarNomePopular.title"/></h2>
	

	<form:form method="POST" action="/xeopesca/admin/editarNomePopular"
		commandName="nome">

		<div style="color: #FF0000;"></div>
		<form:hidden path="id" />
		<table>
			<tr>
				<td><fmt:message key="admin.editarNomePopular.nome"/></td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.editarNomePopular.especie"/></td>
				<td>
				<form:select path="idespecie">
				<form:option value="" label="" />
				<form:options items="${listaEspecie}" itemValue="id" itemLabel="nomecientifico" />
				</form:select>
				</td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="admin.editarNomePopular.button.gardar"/>' /></td>
			</tr>

		</table>

	</form:form>



</div>





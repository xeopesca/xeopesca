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
	<h2><fmt:message key="armador.novoBarco.title"/></h2>
	<form:form method="POST" action="/xeopesca/armador/novoBarco"
		commandName="barco">
		<div style="color: #FF0000;">
			<form:errors path="folio" />
			<form:errors path="nome" />
			<form:errors path="eslora" />
			<form:errors path="idarmador" />
		</div>
		<table>
			<tr>
				<td><fmt:message key="armador.novoBarco.folio"/></td>
				<td><form:input path="folio" required="required" /></td>
			</tr>
			<tr>
				<td><fmt:message key="armador.novoBarco.nome"/></td>
				<td><form:input path="nome" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="armador.novoBarco.eslora"/></td>
				<td><form:input path="eslora" type="number" pattern="\d{1,3}"
				 min="1" max="999" placeholder="min.1 - max. 999" title="min. 1- max. 999" required="required" /></td>
				
			</tr>
			<tr>
				<td><fmt:message key="armador.novoBarco.porto"/></td>
				<td><form:input path="porto" /></td>
				<td><form:input path="idarmador" value="${idArmador}" type="hidden"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="armador.novoBarco.gardar"/>' /></td>
			</tr>
		</table>
	</form:form>
</div>

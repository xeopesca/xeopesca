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

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div id="ReportDetails">
	<h2><fmt:message key="admin.listaArte.title"/></h2>

	<table>
		<tr>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.listaArte.id"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.listaArte.categoria"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.listaArte.nome"/> </th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.listaArte.detalle"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.listaArte.borrar"/></th>
		</tr>
		<c:forEach var="arte" items="${artes}" varStatus="status">
		
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${arte.id}</td>
				<td class="ReportTableValueCell">${arte.categoria}</td>
				<td class="ReportTableValueCell">${arte.nome}</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="editarArte/${arte.id}"> <img src="/images/detalle.gif" /></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="deleteArte/${arte.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>

	</table>
</div>






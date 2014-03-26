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
	<h2><fmt:message key="admin.listadoNomePopular.title"/></h2>
	<div id="Table">
		<div>
			<table>
				<tr>
					<th class="ReportTableHeaderCell"><fmt:message key="admin.listadoNomePopular.nomep"/></th>
					<th class="ReportTableHeaderCell"><fmt:message key="admin.listadoNomePopular.nomec"/></th>
					<th class="ReportTableHeaderCell"><fmt:message key="admin.listadoNomePopular.detalle"/></th>
					<th class="ReportTableHeaderCell"><fmt:message key="admin.listadoNomePopular.borrar"/></th>
					
				</tr>
				<c:forEach var="nomes" items="${nomes}" varStatus="status">
				
					<tr class="ReportDetailsEvenDataRow">
						<td class="ReportTableValueCell">${nomes.nome}</td>
						<td class="ReportTableValueCell">${nomes.especie.nomecientifico}</td>
						<td class="ReportTableValueCell">
							<center>
								<a href="editarNomePopular/${nomes.id}"> <img src="/images/detalle.gif" /></a>
							</center>
						</td>
						<td class="ReportTableValueCell">
							<center>
								<a href="deleteNomepopular/${nomes.id}"> <img src="/images/papelera.gif" /></a>
							</center>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${mensaxe == 'lista vacia'}">
				<div class="container">
						<div class="span7 offset2">
							<div class="alert-success">
							<a class="close" data-dismiss="alert">x</a>
							<fmt:message key="admin.listadoNomePopular.valeira"/>
							</div>
						</div>
				</div>	 
		</c:if>
	</div>
</div>






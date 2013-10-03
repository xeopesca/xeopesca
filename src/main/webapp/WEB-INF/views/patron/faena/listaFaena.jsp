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
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div id="ReportDetails">
	 <h2>Lista de faenas </h2>
	<br>
	<table>
		<tr>
			<th class="ReportTableHeaderCell">Id</th>
			<th class="ReportTableHeaderCell">Data de Inicio</th>
			<th class="ReportTableHeaderCell">Arte empregada</th>
			<th class="ReportTableHeaderCell">Agregar Lance</th>
			<th class="ReportTableHeaderCell">Editar</th>
			<th class="ReportTableHeaderCell">Borrar</th>
		</tr>
		<c:forEach var="faenas" items="${faenas}" varStatus="status">
			


			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${faenas.id}</td>
				<td class="ReportTableValueCell">
				
				<fmt:formatDate type="Date" pattern="yyyy-MM-dd"  value="${faenas.data_inicio}"/>  
				
				</td>
				<td class="ReportTableValueCell">${faenas.arte.nome}</td>
				<td class="ReportTableValueCell">
					<center> 
						<a href="novoLance/${faenas.id}">  <img src="/images/add.png"/></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="editarFaena/${faenas.id}"> <img src="/images/detalle.gif"/> </a>
					</center>
				</td>
				
				<td class="ReportTableValueCell">
					<center>
						<a href="deleteFaena/${faenas.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>
	
	
	</table>
	
</div>




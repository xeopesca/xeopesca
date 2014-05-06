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
	<h2><fmt:message key="admin.buscadorEspecie.title"/></h2>
	    
	<form:form action="buscadorEspecie" commandName="especie">
		<div style="color: #FF0000;">
			<form:errors path="nomecientifico" />
		</div>
		
		<div id="Table">
			<div>
				<table>
					<tr>
						<td><fmt:message key="admin.buscadorEspecie.nomeCientifico"/></td>
						<td><form:input path="nomecientifico" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value='<fmt:message key="admin.buscadorEspecie.button.buscar"/>' /></td>
					</tr>
				</table>
			</div>
			<!-- O código js do cal depende esta condicionalidade está enlazado desde /layout/classic.jsp , 
			<script src="/bootstrap/js/jquery.js"></script>  
			<script src="/bootstrap/js/bootstrap-alert.js"></script> 
			No  referente ao código CSS, atópase en /css/estilo.css referenciado como: ** Adaptación para mensaxe "Non atopado"... ** -->
			<c:if test="${mensaxe == 'lista vacia'}">
				<div class="container">
						<div class="span7 offset2">
							<div class="alert-success">
							<a class="close" data-dismiss="alert">x</a>
							<fmt:message key="admin.buscadorEspecie.especieNonAtopada"/>
							</div>
						</div>
				</div>	 
			</c:if>
		</div>
	</form:form>
	
	
	<c:if test="${!empty especies}">
		<table>
		<tr>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.buscadorEspecie.id"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.buscadorEspecie.nomeCientifico"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.buscadorEspecie.detalle"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="admin.buscadorEspecie.borrar"/></th>
		</tr>
		<c:forEach var="especies" items="${especies}" varStatus="status">
		
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${especies.id}</td>
				<td class="ReportTableValueCell">${especies.nomecientifico}</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="editarEspecie/${especies.id}"> <img src="/images/detalle.gif" /></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="deleteEspecie/${especies.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>

	</table>
	
	</c:if>
	
	<%-- <c:if test="${param.error == 'true'}"> --%>
	<%-- <c:if test="${empty especies}"> --%>
</div>





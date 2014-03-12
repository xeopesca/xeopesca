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
	<h2><fmt:message key="armador.buscadorPatron.title"/></h2>
    

	<form:form method="POST" action="/xeopesca/armador/buscadorPatron"
		commandName="usuario">

		<div style="color: #FF0000;"></div>
		<table>
			
			<tr>
				<td><fmt:message key="armador.buscadorPatron.login"/></td>
				<td><form:input path="login" /></td>
				
			</tr>
			

			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="armador.buscadorPatron.buscar"/>' /></td>
			</tr>

		</table>
		
	</form:form>

<c:if test="${!empty patrons}">

<table>
		<tr>
			<th class="ReportTableHeaderCell"><fmt:message key="armador.buscadorPatron.th.login"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="armador.buscadorPatron.th.nome"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="armador.buscadorPatron.th.apelidos"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="armador.buscadorPatron.th.perfil"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="armador.buscadorPatron.th.detalle"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="armador.buscadorPatron.th.borrar"/></th>		</tr>
		<c:forEach var="users" items="${patrons}" varStatus="status">
			<c:set var="idUsuario" value="${users.id}" />

			<c:url var="urlDeleteUser" value="/borrarUsuario">
				<c:param name="id" value="${users.id}" />
			</c:url>


			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${users.login}</td>
				<td class="ReportTableValueCell">${users.nome}</td>
				<td class="ReportTableValueCell">${users.apelidos}</td>
				<td class="ReportTableValueCell">${users.tipousuario}</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="usuario/edit/${users.id}"> <img src="/images/detalle.gif" /></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="delete/${users.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>

	</table>



</c:if>	
	

</div>





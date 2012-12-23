
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Listado de barcos</h2>

	<table>
		<tr>
			<th class="ReportTableHeaderCell">Folio</th>
			<th class="ReportTableHeaderCell">nome </th>
			<th class="ReportTableHeaderCell">eslora </th>
			<th class="ReportTableHeaderCell">porto </th>
			
			<th class="ReportTableHeaderCell">Detalle</th>
			<th class="ReportTableHeaderCell">Borrar</th>
			
		</tr>
		<c:forEach var="barcos" items="${barcos}" varStatus="status">
		
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${barcos.folio}</td>
				<td class="ReportTableValueCell">${barcos.nome}</td>
			    <td class="ReportTableValueCell">${barcos.eslora}</td>
			   	<td class="ReportTableValueCell">${barcos.porto}</td>
			   
				
				<td class="ReportTableValueCell">
					<center>
						<a href="editarBarco/${barcos.folio}"> <img src="/images/detalle.gif" /></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="deleteBarco/${barcos.folio}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
				
			</tr>
		</c:forEach>

	</table>
</div>






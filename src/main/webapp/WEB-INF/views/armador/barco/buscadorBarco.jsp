
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Buscar barco</h2>
    

	<form:form method="POST" action="/xeopesca/armador/buscadorBarco"
		commandName="barco">

		<div style="color: #FF0000;"></div>
		<table>
			
			<tr>
				<td>Nome :</td>
				<td><form:input path="nome" /></td>
				
			</tr>
			

			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>
		
	</form:form>
	
	
	<c:if test="${!empty barcos}">
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
						<a href="/xeopesca/armador/editarBarco/${barcos.folio}"> <img src="/images/detalle.gif" /></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="/xeopesca/armador/deleteBarco/${barcos.folio}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
				
			</tr>
		</c:forEach>

	</table>
	
	</c:if>
	
	
	
</div>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Listado de nomes populares</h2>

	<table>
		<tr>
			<th class="ReportTableHeaderCell">Nome popular</th>
			<th class="ReportTableHeaderCell">Nome cientifico</th>
			<th class="ReportTableHeaderCell">Detalle</th>
			<th class="ReportTableHeaderCell">Borrar</th>
			
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






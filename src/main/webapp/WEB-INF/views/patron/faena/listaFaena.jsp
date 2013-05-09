
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<td class="ReportTableValueCell">${faenas.data_inicio}</td>
				<td class="ReportTableValueCell">${faenas.arte.nome}</td>
				<td class="ReportTableValueCell">
					<center> +
						<a href="editarFaena/${faenas.id}"> <img src="/images/detalle.gif" /></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="editarFaena/${faenas.id}"> <img src="/images/detalle.gif" /></a>
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




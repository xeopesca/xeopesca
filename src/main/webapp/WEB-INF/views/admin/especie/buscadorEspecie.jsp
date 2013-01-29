
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Buscar especie</h2>
    
	<form:form action="buscadorEspecie" commandName="especie">

		<div style="color: #FF0000;">
			<form:errors path="nomecientifico" />
		</div>
		<table>
			<tr>
				<td>Nome cientifico :</td>
				<td><form:input path="nomecientifico" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Buscar" /></td>
			</tr>

		</table>

	</form:form>
	
	<table>
		<tr>
			<th class="ReportTableHeaderCell">Id</th>
			<th class="ReportTableHeaderCell">Nome científico</th>
			<th class="ReportTableHeaderCell">Detalle</th>
			<th class="ReportTableHeaderCell">Borrar</th>
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

</div>





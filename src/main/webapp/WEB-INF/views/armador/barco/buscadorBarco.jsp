
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Buscar barco</h2>
    

	<form:form method="POST" action="/xeopesca/armador/editarBarco"
		commandName="barco">

		<div style="color: #FF0000;"></div>
		<table>
			<tr>
				<td>Folio :</td>
				<td><form:input path="folio" /></td>
			</tr>
			<tr>
				<td>Nome :</td>
				<td><form:input path="nome" /></td>
				
			</tr>
			<tr>
				<td>Eslora :</td>
				<td><form:input path="eslora" /></td>
				
			</tr>
			<tr>
				<td>Porto :</td>
				<td><form:input path="porto" /></td>
				
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>
		
	</form:form>
	
	<table>
		<tr>
			<th class="ReportTableHeaderCell">Id</th>
			<th class="ReportTableHeaderCell">Nome popular </th>
			<th class="ReportTableHeaderCell">Nome especie </th>
			<th class="ReportTableHeaderCell">Detalle</th>
			<th class="ReportTableHeaderCell">Borrar</th>
		</tr>
		<c:forEach var="nomep" items="${nomes}" varStatus="status">
		
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${nomep.id}</td>
				<td class="ReportTableValueCell">${nomep.nome}</td>
				<td class="ReportTableValueCell">${nomep.especie.nomecientifico}</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="editarNomePopular/${nomep.id}"> <img src="/images/detalle.gif" /></a> 
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="deleteNomepopular/${nomep.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>

	</table>

</div>





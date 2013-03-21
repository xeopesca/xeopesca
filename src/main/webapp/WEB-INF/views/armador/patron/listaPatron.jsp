
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Listado de patróns de un armador</h2>

	<table>
		<tr>
			<th class="ReportTableHeaderCell">Login</th>
			<th class="ReportTableHeaderCell">Nome</th>
			<th class="ReportTableHeaderCell">Apelidos</th>
			<th class="ReportTableHeaderCell">Perfil</th>
			<th class="ReportTableHeaderCell">Borrar</th>
		</tr>
		<c:forEach var="patrons" items="${patrons}" varStatus="status">
			<c:set var="idUsuario" value="${patrons.id}" />

			<c:url var="urlDeleteUser" value="/borrarUsuario">
				<c:param name="id" value="${patrons.id}" />
			</c:url>


			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${patrons.login}</td>
				<td class="ReportTableValueCell">${patrons.nome}</td>
				<td class="ReportTableValueCell">${patrons.apelidos}</td>
				<td class="ReportTableValueCell">${patrons.tipousuario}</td>
				
				<td class="ReportTableValueCell">
					<center>
						<a href="deletePatron/${patrons.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>

	</table>
</div>





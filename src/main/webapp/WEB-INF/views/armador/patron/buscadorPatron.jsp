
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Buscar patrón</h2>
    

	<form:form method="POST" action="/xeopesca/armador/buscadorPatron"
		commandName="usuario">

		<div style="color: #FF0000;"></div>
		<table>
			
			<tr>
				<td>Login :</td>
				<td><form:input path="login" /></td>
				
			</tr>
			

			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>
		
	</form:form>

<c:if test="${!empty patrons}">

<table>
		<tr>
			<th class="ReportTableHeaderCell">Login</th>
			<th class="ReportTableHeaderCell">Nome</th>
			<th class="ReportTableHeaderCell">Apelidos</th>
			<th class="ReportTableHeaderCell">Perfil</th>
			<th class="ReportTableHeaderCell">Detalle</th>
			<th class="ReportTableHeaderCell">Borrar</th>		</tr>
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





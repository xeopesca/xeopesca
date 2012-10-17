
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="ReportDetails">
	<h2>Listado usuarios</h2>

<table>
		<tr>
		   <th class="ReportTableHeaderCell">Login</th>
			<th class="ReportTableHeaderCell">Nome</th>
			<th class="ReportTableHeaderCell">Apelidos</th>
			<th class="ReportTableHeaderCell">Perfil</th>
			<th class="ReportTableHeaderCell">Borrar</th>
		</tr>
<c:forEach var="users" items="${users}" varStatus="status">

    	
    	
    	<tr class="ReportDetailsEvenDataRow">
			<td class="ReportTableValueCell">${users.login}</td>
			<td class="ReportTableValueCell">${users.nome}</td>
			<td class="ReportTableValueCell">${users.apelidos}</td>
			<td class="ReportTableValueCell">${users.tipousuario}</td>
			<td class="ReportTableValueCell">(borrar)</td>
		</tr>
    	
       
</c:forEach>

	</table>


</div>






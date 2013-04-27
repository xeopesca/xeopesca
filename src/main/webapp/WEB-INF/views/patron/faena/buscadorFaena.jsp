
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Buscador faena</h2>
	<br>

	<form:form action="/xeopesca/patron/novaFaena" method="POST"
					commandName="faena">
					
		<table>
			<tr valign="top">
				<td><b>Data de inicio:</b></td>
				<td><form:input path="dataInicio" /></td>
		
				<td><b>Data de fin :</b></td>
				<td><form:input path="dataFin" /></td>
			</tr>
		
		
			<tr valign="top">
				<td><b>Arte</b>:</td>
				
				<td>
				<c:forEach var="artes" items="${artes}" varStatus="status">
					 <form:checkbox path="arte" value="${artes.id}"   label="${artes.nome}"/> 
					 <br>
				</c:forEach>
		
				</td>
		
				<td><b>Especies:</b></td>
				
				<td>
				<c:forEach var="especies" items="${especies}" varStatus="status">
					 <form:checkbox path="estadoMar" value="${especies.id}"   label="${especies.nomecientifico}"/> 
					 <br>
				</c:forEach>
		
				</td>
			</tr>
			
			
			
			
			
			
			<tr>
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
					
					
					
					
	</form:form>

</div>






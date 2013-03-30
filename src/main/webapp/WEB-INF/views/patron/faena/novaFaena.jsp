
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	 <h2>Nova faena </h2>
	<br>
	<form:form  action="/xeopesca/patron/novaFaena" method="POST" commandName="faena">
		
		<table>
		
			<tr>
				<td>Arte:</td>
				<td>
                                     
                                </td>
				<td><form:errors path="estadoMar" cssClass="error" />
				<c:forEach var="artes" items="${artes}" varStatus="status">
					 <form:checkbox path="estadoMar" value="${artes.id}"   label="${artes.nome}"/> 
					 <br>
				</c:forEach>
				
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
		
	</form:form>
	
	
</div>




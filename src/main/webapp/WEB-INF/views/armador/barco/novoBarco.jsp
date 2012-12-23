
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Novo barcor</h2>
	<form:form method="POST" action="novoBarco"
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


</div>





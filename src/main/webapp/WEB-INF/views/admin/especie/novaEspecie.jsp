
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Nova Especie</h2>
	<!--<c:out value="${message}" /> -->

	<form:form action="novaEspecie" commandName="especie" enctype="multipart/form-data">

		<div style="color: #FF0000;">
			<form:errors path="nomecientifico" />
			<form:errors path="path" />
		</div>
		<table>
			<tr>
				<td>Nome :</td>
				<td><form:input path="nomecientifico" /></td>
			</tr>
			<tr>
				<td>Imaxen :</td>
				<td><form:input path="path" />  <input type="file" name="file"/>
				
				</td>
				
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>

	</form:form>



</div>





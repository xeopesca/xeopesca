
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Novo nome popular</h2>
	<form:form method="POST" action="novoNomePopular"
		commandName="NomePopular">

		<div style="color: #FF0000;"></div>

		<table>
			<tr>
				<td>Nome :</td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td>Especie :</td>
				<td>
				<form:select path="idespecie">
				<form:option value="" label="" />
				<form:options items="${listaEspecie}" itemValue="id" itemLabel="nomecientifico" />
				</form:select>
				</td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>

	</form:form>


</div>





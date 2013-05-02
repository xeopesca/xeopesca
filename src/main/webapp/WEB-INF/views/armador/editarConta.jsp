
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Editar usuario armador</h2>

	<form:form action="/xeopesca/editarConta" commandName="usuario">

		<div style="color: #FF0000;">
			<form:errors path="login" />
			<form:errors path="nome" />
			<form:errors path="tipousuario" />
			<form:errors path="contrasinal" />

		</div>

	    <input id="id" name="id" type="hidden" value="${usuario.id}"/>
		<input id="patron_autoriza" name="patron_autoriza" type="hidden" value="${usuario.patron_autoriza}"/>
		<input id="idbarco" name="idbarco" type="hidden" value="${usuario.idbarco}"/>
		
		<table>
			<tr>
				<td>Login :</td>
				<td><form:input path="login" readonly="true" /></td>
			</tr>
			<tr>
				<td>Perfil:</td>
				<td><form:input path="tipousuario" readonly="true" /></td>
				
			</tr>

			<tr>
				<td>Nome :</td>
				<td><form:input path="nome" /></td>
			</tr>

			<tr>
				<td>Apelidos :</td>
				<td><form:input path="apelidos" /></td>
			</tr>
			<tr>
				<td>Contrasinal :</td>
				<td><form:password path="contrasinal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>

	</form:form>



</div>





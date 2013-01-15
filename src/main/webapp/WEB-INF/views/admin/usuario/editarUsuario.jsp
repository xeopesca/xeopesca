
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="ReportDetails">
	<h2>Editar usuario</h2>

	<form:form action="/xeopesca/admin/updateUsuario" commandName="usuario">

		<div style="color: #FF0000;">
			<form:errors path="login" />
			<form:errors path="nome" />
			<form:errors path="tipousuario" />
			<form:errors path="contrasinal" />

		</div>

	    <input id="id" name="id" type="hidden" value="${usuario.id}"/>
		
		<table>
			<tr>
				<td>Login :</td>
				<td><form:input path="login" readonly="true" /></td>
			</tr>
			<tr>
				<td>Perfil:</td>
				<td><form:select path="tipousuario" >
						<form:option value="ROLE_ADMIN" label="Admin" />
						<form:option value="ROLE_ARMADOR" label="Armador" />
						<form:option value="ROLE_PATRON" label="Patrón" />
						<form:option value="ROLE_ADMINISTRACION" label="Administración" />

					</form:select></td>
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
				<td><form:input path="contrasinal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>

	</form:form>



</div>





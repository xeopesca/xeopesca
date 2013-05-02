
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Editar barco</h2>
	

	<form:form method="POST" action="/xeopesca/armador/editarBarco"
		commandName="barco">
		<input id="id" name="id" type="hidden" value="${barco.id}"/>
		<input id="idarmador" name="idarmador" type="hidden" value="${barco.idarmador}"/>
		
		
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
				<td>Patrón asignado :</td>
				<td>
					<form:select path="idpatron" >
							<form:option value="" label="" />
							<form:options items="${patrons}" itemValue="id" itemLabel="login"  />				
					</form:select>	 
						 <br>
					
				</td>
			</tr>
			

			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>
		
	</form:form>



</div>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div id="ReportDetails">
	 <h2>Engadir lance </h2>
	
	<form:form  action="/xeopesca/patron/addLance"  commandName="lance">
		<input id="idfaena" name="idfaena" type="hidden" value="${lance.idfaena}"/>
		<table>
		<tr>
			<td>Arte:</td>
			<td></td>
			<td>Data inicio:</td>
			<td></td>
			<td>Hora inicio:</td>
			<td></td>	
		</tr>
		<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
		</tr>
		
		</table>
	</form:form>
</div>








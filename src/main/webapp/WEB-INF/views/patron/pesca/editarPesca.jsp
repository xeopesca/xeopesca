
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div id="ReportDetails">
	 <h2>Editar pesca </h2>
	
	
<div id="ReportDetails">
	 <h2>Engadir pesca </h2>
	
	<form:form  action="/xeopesca/patron/updatePesca"  commandName="pesca">
		<input id="id" name="id" type="hidden" value="${pesca.id}"/>
		<input id="idlance" name="idlance" type="hidden" value="${pesca.idlance	}"/>
	    <input id="idespecie" name="idespecie" type="hidden" value="${pesca.idespecie}"/>
		
	
		<table>
		<tr>
			<td>Especie:</td>
			<td>
				<form:input disabled="true" path="especie.nomecientifico" />			    
			</td>
		</tr>
		<tr>
			<td>Peso:</td>
			<td>
			    <form:input  path="peso" />
			</td>
			<td>Peso descarte:</td>
			<td>
				<form:input  path="pesodescarte" />
				
			</td>
			
		</tr>
		<tr>
			<td>Unidades:</td>
			<td>
			    <form:input  path="ud" />
			</td>
			<td>Unidades descarte:</td>
			<td>
				<form:input  path="uddescarte" />
			</td>
			
		</tr>
		<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
		</tr>
		
		</table>
	</form:form>
</div>
	








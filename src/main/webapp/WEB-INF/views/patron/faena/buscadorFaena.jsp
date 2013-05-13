
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Buscador faena</h2>
	<form:form  action="/xeopesca/patron/novaFaena" method="POST" commandName="faena">
		<input id="idbarco" name="idbarco" type="hidden" value="${faena.idbarco}"/>
		
		<table>
		
			<tr>
				<td>Arte:</td>
				
				<td>
					<form:select path="arte">
							<form:options items="${artes}" itemValue="id" itemLabel="nome" />
					</form:select>
				</td>
			<td>Data inicio:</td>
				<td><form:input path="dataInicio"  id="dinicio" /></td>
				
				
			</tr>
			<tr>
				<td>Lua:</td>
				<td><form:select path="lua">
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
				
				<td>Data fin:</td>
				<td><form:input  path="dataFin" id="dfin"/></td>
				
			</tr>
			
			<tr>
				<td>Estado mar:</td>
				<td>
					<form:select path="estadoMar" >
						<form:options items="${mar}" itemValue="id" itemLabel="literal" />				
					</form:select>		
				</td>
				
				<td>Estado ceo:</td>
				<td>
					<form:select path="estadoCeo" >
						<form:options items="${ceo}" itemValue="id" itemLabel="literal" />
					</form:select>	
				</td>
			</tr>
			<tr>
				<td>Dirección vento:</td>
				<td>
					<form:select path="direccionVento" >
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
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





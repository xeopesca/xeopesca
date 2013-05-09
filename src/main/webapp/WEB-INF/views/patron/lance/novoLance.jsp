
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>






<div id="ReportDetails">
	 <h2>Lances dunha faena </h2>
	
	<form:form  action="#"  commandName="faena">
		<input id="idbarco" name="idbarco" type="hidden" value="${faena.idbarco}"/>
		<input id="id" name="id" type="hidden" value="${faena.id}"/>
		<table>
		
			<tr>
				<td>Arte:</td>
				
				<td>
					<form:select disabled="true" path="arte">
							<form:options  items="${artes}" itemValue="id" itemLabel="nome" disabled="true" />
					</form:select>
				</td>
			<td>Data inicio:</td>
				<td><form:input disabled="true" path="dataInicio" readonly="true" id="dinicio" /></td>
				<td>Hora inicio:</td>
				<td><form:input disabled="true" path="horaInicio" /> </td>
				
			</tr>
			<tr>
				<td>Lua:</td>
				<td><form:select disabled="true" path="lua">
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
				
				<td>Data fin:</td>
				<td><form:input disabled="true"  path="dataFin" readonly="true" id="dfin"/></td>
				
				<td>Hora fin:</td>
				<td><form:input disabled="true" path="horaFin"  /></td>
				
			
			</tr>
			<tr>
				<td>Temp. Aire:</td>
				<td><form:input disabled="true" path="tempAire" /></td>
				
				<td>Temp. Superficie:</td>
				<td><form:input disabled="true" path="tempSuperficie" /></td>
				
				<td>Temp. Fondo:</td>
				<td><form:input disabled="true" path="tempFondo" /></td>
			
			</tr>
			<tr>
				<td>Estado mar:</td>
				<td>
					<form:select disabled="true" path="estadoMar" >
						<form:options items="${mar}" itemValue="id" itemLabel="literal" />				
					</form:select>		
				</td>
				
				<td>Estado ceo:</td>
				<td>
					<form:select disabled="true" path="estadoCeo" >
						<form:options disabled="true" items="${ceo}" itemValue="id" itemLabel="literal" />
					</form:select>	
				</td>
			</tr>
			<tr>
				<td>Dirección vento:</td>
				<td>
					<form:select disabled="true" path="direccionVento" >
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
					</form:select>	
					
				</td>
				
				<td>Velocidade vento:</td>
				<td>
					<form:input disabled="true"  path="velocidadeVento" />
				</td>
			</tr>
			
			
			
			<tr>
				<td></td>
				
			</tr>
		</table>
		 <h2>Lances </h2>
		 + Agregar lance
	</form:form>
	<form:form  action="/xeopesca/patron/novaFaena" method="POST" commandName="faena">
	<td><input  type="submit" value="Enviar" /></td>
	</form:form>
</div>




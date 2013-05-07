
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"dfin",
			dateFormat:"%d-%m-%Y"
		});
		
		new JsDatePick({
			useMode:2,
			target:"dinicio",
			dateFormat:"%d-%m-%Y"
		});
	};
</script>





<div id="ReportDetails">
	 <h2>Nova faena </h2>
	<br>
	<form:form  action="/xeopesca/patron/novaFaena" method="POST" commandName="faena">
		
		<table>
		
			<tr>
				<td>Arte:</td>
				
				<td>
					<form:select path="arte">
							<form:options items="${artes}" itemValue="id" itemLabel="nome" />
					</form:select>
				</td>
			<td>Data inicio:</td>
				<td><form:input path="dataInicio" readonly="true" id="dinicio" /></td>
				<td>Hora inicio:</td>
				<td><form:input path="horaInicio" /> </td>
				
			</tr>
			<tr>
				<td>Lua:</td>
				<td><form:select path="lua">
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
				
				<td>Data fin:</td>
				<td><form:input  path="dataFin" readonly="true" id="dfin"/></td>
				
				<td>Hora fin:</td>
				<td><form:input path="horaFin"  /></td>
				
			
			</tr>
			<tr>
				<td>Temp. Aire:</td>
				<td><form:input path="tempAire" /></td>
				
				<td>Temp. Superficie:</td>
				<td><form:input path="tempSuperficie" /></td>
				
				<td>Temp. Fondo:</td>
				<td><form:input path="tempFondo" /></td>
			
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
					<form:input path="direccionVento" />
				</td>
				
				<td>Velocidade vento:</td>
				<td>
					<form:input path="velocidadeVento" />
				</td>
			</tr>
			
			
			
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
		
	</form:form>
	
	
</div>




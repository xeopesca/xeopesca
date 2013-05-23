
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	 <h2>Buscador faena </h2>
	
	<form:form  action="/xeopesca/patron/buscadorFaena" method="POST" commandName="faena">
		<input id="idbarco" name="idbarco" type="hidden" value="${faena.idbarco}"/>
		<input id="id" name="id" type="hidden" value="${faena.id}"/>
		
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
				
				
			</tr>
			<tr>
				<td>Lua:</td>
				<td><form:select path="lua">
						<form:option value="" label="Todas" />
					
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
				
				<td>Data fin:</td>
				<td><form:input  path="dataFin" readonly="true" id="dfin"/></td>
			
			</tr>
			
			<tr>
				<td>Estado mar:</td>
				<td>
					<form:select path="estadoMar" >
						<form:option value="" label="Todos" />
						<form:options items="${mar}" itemValue="id" itemLabel="literal" />				
					</form:select>		
				</td>
				
				<td>Estado ceo:</td>
				<td>
					<form:select path="estadoCeo" >
						<form:option value="" label="Todos" />
						<form:options items="${ceo}" itemValue="id" itemLabel="literal" />
					</form:select>	
				</td>
			</tr>
			<tr>
				<td>Dirección vento:</td>
				<td>
					<form:select path="direccionVento" >
						<form:option value="" label="Todas" />
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
					</form:select>	
					
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


<c:if test="${!empty resultado}">

<div id="ReportDetails">
	 <h2>Lista de faenas </h2>
	<table>
		<tr>
			<th class="ReportTableHeaderCell">Id</th>
			<th class="ReportTableHeaderCell">Data de Inicio</th>
			<th class="ReportTableHeaderCell">Arte empregada</th>
			<th class="ReportTableHeaderCell">Agregar Lance</th>
			<th class="ReportTableHeaderCell">Editar</th>
			<th class="ReportTableHeaderCell">Borrar</th>
		</tr>
		<c:forEach var="faenas" items="${resultado}" varStatus="status">
	
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${faenas.id}</td>
				<td class="ReportTableValueCell">
				
				<fmt:formatDate type="Date" pattern="yyyy-MM-dd"  value="${faenas.data_inicio}"/>  
				
				</td>
				<td class="ReportTableValueCell">${faenas.arte.nome}</td>
				<td class="ReportTableValueCell">
					<center> 
						<a href="novoLance/${faenas.id}">  <img src="/images/add.png"/></a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<center>
						<a href="editarFaena/${faenas.id}"> <img src="/images/detalle.gif"/> </a>
					</center>
				</td>
				
				<td class="ReportTableValueCell">
					<center>
						<a href="deleteFaena/${faenas.id}"> <img src="/images/papelera.gif" /></a>
					</center>
				</td>
			</tr>


		</c:forEach>
	
	
	</table>
	
</div>

</c:if>
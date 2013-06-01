
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
	
	<form:form  action="/xeopesca/armador/buscador" method="POST" commandName="faena">
		<input id="id" name="id" type="hidden" value="${faena.id}"/>
		
		<table>
		
			<tr>
				<td>Arte:</td>
				
				<td>
					<form:select path="arte">
					    	<form:option value="" label="Todas" />
					
							<form:options items="${artes}" itemValue="id" itemLabel="nome" />
					</form:select>
				</td>
			<td>Periodio inicio:</td>
				<td><form:input path="dataInicio" readonly="true" id="dinicio" /></td>
			<td>Periodo fin:</td>
				<td><form:input  path="dataFin" readonly="true" id="dfin"/></td>
			
				
			</tr>
			<tr>
				<td>Lua:</td>
				<td><form:select path="lua">
						<form:option value="" label="Todas" />
					
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
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
				<td>Direccion do vento:</td>
				<td>
					<form:select path="direccionVento" >
						<form:option value="" label="Todas" />
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
					</form:select>	
					
				</td>
				<td>Barco:</td>
				<td>
					
					<form:select path="idbarco" >
						<form:options items="${barcos}" itemValue="id" itemLabel="folio" />
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


<c:if test="${!empty resultado}">

<div id="ReportDetails">
	 <h2>Lista de faenas </h2>
		<c:forEach var="faenas" items="${resultado2}" varStatus="status">
		<h4> Faena do 						<fmt:formatDate type="Date" pattern="yyyy-MM-dd"  value="${faenas.data_inicio}"/>  
		 - Arte: ${faenas.arte.nome}   </h4>
						
						
						
		
		
		
			<li>Arte: ${faenas.arte.nome}  </li>
		<c:forEach var="lances" items="${faenas.listaLances}" varStatus="status">
		
		<ul>
			<li>Lugar: ${lances.descripcion} </li>
		
			<!-- aa -->
		<table>
		<tr>
			<th class="ReportTableHeaderCell">Id pesca</th>
			<th class="ReportTableHeaderCell">Nome cientifico</th>
			<th class="ReportTableHeaderCell">Pesp</th>
			<th class="ReportTableHeaderCell">Peso descarte</th>
			<th class="ReportTableHeaderCell">Ud.</th>
			<th class="ReportTableHeaderCell">Ud. descarte</th>
		</tr>
		<c:forEach var="pesca" items="${lances.listaPesca}" varStatus="status">
	
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${pesca.id}</td>
				<td class="ReportTableValueCell">${pesca.especie.nomecientifico} </td>
				<td class="ReportTableValueCell">${pesca.peso}</td>
				<td class="ReportTableValueCell">
					${pesca.pesodescarte}
				</td>
				<td class="ReportTableValueCell">
					${pesca.ud}
				</td>
				
				<td class="ReportTableValueCell">
					${pesca.uddescarte}
				</td>
			</tr>


		</c:forEach>
		</table>	
		</ul>
			<!-- bb -->
		
		</c:forEach>
		
		
		
</c:forEach>
	 
	 
</div>	

</c:if>

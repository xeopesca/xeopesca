<!-- 
/* --------------------------------------------------------------------
Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/

 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	 <h2><fmt:message key="patron.novoLance.title"/> </h2>
	
	<form:form  action="#"  commandName="faena">
		<input id="idbarco" name="idbarco" type="hidden" value="${faena.idbarco}"/>
		<input id="id" name="id" type="hidden" value="${faena.id}"/>
		<table>
		
			<tr>
				<td><fmt:message key="patron.novoLance.arte"/></td>
				
				<td>
					<form:select disabled="true" path="arte">
							<form:options  items="${artes}" itemValue="id" itemLabel="nome" disabled="true" />
					</form:select>
				</td>
			<td><fmt:message key="patron.novoLance.di"/></td>
				<td><form:input disabled="true" path="dataInicio" readonly="true" id="dinicio" /></td>
				<td><fmt:message key="patron.novoLance.hi"/></td>
				<td><form:input disabled="true" path="horaInicio" /> </td>
				
			</tr>
			<tr>
				<td><fmt:message key="patron.novoLance.lua"/></td>
				<td><form:select disabled="true" path="lua">
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
				
				<td><fmt:message key="patron.novoLance.df"/></td>
				<td><form:input disabled="true"  path="dataFin" readonly="true" id="dfin"/></td>
				
				<td><fmt:message key="patron.novoLance.hf"/></td>
				<td><form:input disabled="true" path="horaFin"  /></td>
				
			
			</tr>
			<tr>
				<td><fmt:message key="patron.novoLance.ta"/></td>
				<td><form:input disabled="true" path="tempAire" /></td>
				
				<td><fmt:message key="patron.novoLance.ts"/></td>
				<td><form:input disabled="true" path="tempSuperficie" /></td>
				
				<td><fmt:message key="patron.novoLance.tf"/></td>
				<td><form:input disabled="true" path="tempFondo" /></td>
			
			</tr>
			<tr>
				<td><fmt:message key="patron.novoLance.em"/></td>
				<td>
					<form:select disabled="true" path="estadoMar" >
						<form:options items="${mar}" itemValue="id" itemLabel="literal" />				
					</form:select>		
				</td>
				
				<td><fmt:message key="patron.novoLance.ec"/></td>
				<td>
					<form:select disabled="true" path="estadoCeo" >
						<form:options disabled="true" items="${ceo}" itemValue="id" itemLabel="literal" />
					</form:select>	
				</td>
			</tr>
			<tr>
				<td><fmt:message key="patron.novoLance.dv"/></td>
				<td>
					<form:select disabled="true" path="direccionVento" >
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
					</form:select>	
					
				</td>
				
				<td><fmt:message key="patron.novoLance.vv"/></td>
				<td>
					<form:input disabled="true"  path="velocidadeVento" />
				</td>
			</tr>
			
			
			
			<tr>
				<td></td>
				
			</tr>
		</table>
		 <h2><fmt:message key="patron.novoLance.title.lances"/> </h2>
		
	
	</form:form>

	<table>
		<tr>
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.id"/></th>
			
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.lugar"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.especie"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.peso"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.pesod"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.ud"/></th>
			<th class="ReportTableHeaderCell"><fmt:message key="patron.novoLance.title.table.udd"/></th>
			<th class="ReportTableHeaderCell"></th>
			<th class="ReportTableHeaderCell"></th>
			<th class="ReportTableHeaderCell"></th>
		</tr>

		<c:forEach var="lances" items="${lances}" varStatus="status">
			<tr class="ReportDetailsEvenDataRow">
				<td class="ReportTableValueCell">${lances.id}</td>
				<td class="ReportTableValueCell"><b>${lances.descripcion}</b></td>
				<td class="ReportTableValueCell"></td>
				<td class="ReportTableValueCell"></td>
				<td class="ReportTableValueCell"></td>
				<td class="ReportTableValueCell"></td>
				<td class="ReportTableValueCell"></td>
				<td class="ReportTableValueCell">
					<center> 
						<a href="/xeopesca/patron/addPesca/${lances.id}"> 
							<img src="/images/addPeixe.png"/>
						</a>
					</center>
				</td>
				<td class="ReportTableValueCell">
					<a href="/xeopesca/patron/editarLance/${lances.id}"> 
						<img src="/images/detalle.gif"/>
					</a>
				</td>
				
				<td class="ReportTableValueCell">
					<!-- Borrar lance por post -->
					<form:form  action="/xeopesca/patron/deleteLance"  commandName="lance">
						<input id="id" name="id" type="hidden" value="${lances.id}"/>
						<input id="idfaena" name="idfaena" type="hidden" value="${lances.idfaena}"/>
						
						<input type="image" src="/images/papelera.gif" alt="borrar">	
					</form:form>
				</td>
				
				
				<c:forEach var="pesca" items="${lances.listaPesca}" varStatus="status">
					<tr class="ReportDetailsEvenDataRow">
							<td class="ReportTableValueCell"></td>
							<td class="ReportTableValueCell"></td>
							
							<td class="ReportTableValueCell">${pesca.especie.nomecientifico}</td>
							<td class="ReportTableValueCell">${pesca.peso}</td>
							<td class="ReportTableValueCell">${pesca.pesodescarte}</td>
							<td class="ReportTableValueCell">${pesca.ud}</td>
							<td class="ReportTableValueCell">${pesca.uddescarte}</td>
							<td class="ReportTableValueCell"> </td>
							
							<td class="ReportTableValueCell">
								
								<a href="/xeopesca/patron/editarPesca/${pesca.id}"> 
									<img src="/images/detalle.gif"/>
								</a>
							</td>
							<td class="ReportTableValueCell">
								<!-- Borrar Pesca  -->
									<form:form  action="/xeopesca/patron/deletePesca"  commandName="pesca">
										<input id="id" name="id" type="hidden" value="${pesca.id}"/>
										
										<input type="image" src="/images/papelera.gif" alt="borrar">	
									</form:form>
								
								
							</td>
							
					</tr>
					
					
					
				</c:forEach>
			</tr>
		</c:forEach>
		<tr>
			<td> </td>
		 	<td>	 
		 		<a href="<c:url value="/xeopesca/patron/addLance/${faena.id}"/>">+ Agregar lance</a>
		 	</td>
		</tr>
	</table>


</div>





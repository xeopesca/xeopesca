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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="ReportDetails">
	<h2><fmt:message key="admin.novaArte.title"/></h2>

	<form:form action="novoArte" commandName="arte">
		<div style="color: #FF0000;">
			<form:errors path="actividade" />
			<form:errors path="categoria" />
			<form:errors path="nome" />
		</div>
		<table>
			<tr>
				<td><fmt:message key="admin.novaArte.actividade"/></td>
				<td>
					<form:select path="actividade" required="required">
						<form:option value="" label="" />
						<form:option value="Marisqueo" label="Marisqueo" />
						<form:option value="Pesca" label="Pesca" />
					</form:select>
				
				</td>
			</tr>
			<tr>
				<td><fmt:message key="admin.novaArte.categoria"/></td>
				<td>
					<form:select path="categoria" required="required">
						<form:option value="" label="" />
						<form:option value="Nasas" label="Nasas" />
						<form:option value="Embarcacion ou vara" label="Embarcacion ou vara" />
						<form:option value="Rastros" label="Rastros" />
						<form:option value="Anzol" label="Anzol" />
						<form:option value="En malle" label="En malle" />
						<form:option value="Cerco" label="Cerco" />
						<form:option value="Nasas" label="Nasas" />
						<form:option value="Arrastre" label="Arrastre" />
						<form:option value="Artes remolcadas" label="Artes remolcadas" />						
					</form:select>		
				</td>
			</tr>
			<tr>
				<td><fmt:message key="admin.novaArte.nome"/></td>
				<td><form:input path="nome" required="required"/></td>
			</tr>
			
			<tr>
				<td><fmt:message key="admin.novaArte.descripcion"/></td>
				<td><form:textarea path="descripcion" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="admin.novaArte.button.gardar"/>' /></td>
			</tr>
		</table>
	</form:form>
</div>





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
	<h2><fmt:message key="admin.editarEspecie.title"/></h2>

	<form:form action="/xeopesca/admin/updateEspecie" commandName="especie" enctype="multipart/form-data">
	    <input id="id" name="id" type="hidden" value="${especie.id}"/>

		<div style="color: #FF0000;">
			<form:errors path="nomecientifico" />
			<form:errors path="path" />
		</div>
		<table>
			<tr>
				<td><fmt:message key="admin.editarEspecie.nome"/></td>
				<td><form:input path="nomecientifico" /></td>
				
			</tr>
			<tr>
				<td><fmt:message key="admin.editarEspecie.imaxen"/></td>
				<td>
			
					<c:if test="${especie.path ==''}">
						<form:input path="path" /> 
 						<input type="file" name="file"/>
 					</c:if>
				    		
				</td>
				
			</tr>
			<tr>
			
				<td> </td>
				<td> <c:if test="${especie.path !=''}">
 						<img src= ${especie.path}>
 						 <input type="file" name="file"/>
 						
 					</c:if>		
 				</td>
         	</tr>

			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="admin.editarEspecie.button.gardar"/>' /></td>
			</tr>

		</table>

	</form:form>



</div>





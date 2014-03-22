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
	<h2>
		<fmt:message key="patron.addLance.title" />
	</h2>
	<p id="aviso"><fmt:message key="patron.addLance.aviso" /></p>
	<form:form action="/xeopesca/patron/addLance" commandName="lance">
		<input id="idfaena" name="idfaena" type="hidden"
			value="${lance.idfaena}" />
		<table>
			<tr>
				<td><fmt:message key="patron.addLance.desc" /></td>
				<td><form:input path="descripcion" /></td>
			</tr>
			<tr>
				<td><fmt:message key="patron.addLance.coor" /></td>
				<td><form:input id="punto" path="punto_inicio" readonly="True" /></td>
			</tr>
		</table>

		<div id="Map" style="height: 225px; width: 425px;""></div>

		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
		<script src="/js/patron/addLance.js" type="text/javascript"></script>
				
	<input type="submit" value="Enviar" />
	</form:form>
</div>







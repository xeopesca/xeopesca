<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     





<div id="ReportDetails">
	<h2>Novo Usuario</h2>
	<form:form method="post" commandName="usuario">
		<table width="95%"  cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Increase (%):</td>
				<td width="20%"><form:input path="percentage" /></td>
				<td width="60%"><form:errors path="percentage" cssClass="error" />
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Enviar">
	</form:form>


</div>
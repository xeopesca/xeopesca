
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<h2>Nova Especie</h2>
	<!--<c:out value="${message}" /> -->

	<form:form action="novoArte" commandName="arte">

		<div style="color: #FF0000;">
			<form:errors path="actividade" />
		</div>
		<table>
			<tr>
				<td>Actividade :</td>
				<td>
					<form:select path="actividade">
						<form:option value="" label="--- Select ---" />
						<form:option value="Marisqueo" label="Marisqueo" />
						<form:option value="Pesca" label="Pesca" />
					</form:select>
				
				</td>
			</tr>
			<tr>
				<td>Categoria :</td>
				<td>
					<form:select path="categoria">
						<form:option value="" label="--- Select ---" />
						<form:option value="Nasas" label="Nasas" />
						<form:option value="Embarcación ou vara" label="Embarcación ou vara" />
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
				<td>Nome :</td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td>Imaxen: :</td>
				<td><form:input path="path" /></td>
			</tr>
			<tr>
				<td>Descripcion: :</td>
				<td><form:textarea path="descripcion" /></td>
				</td>
			</tr>



			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>

		</table>

	</form:form>



</div>





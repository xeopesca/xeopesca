
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	 <h2>Portada patron</h2>
	<br>
	
<div id="panel">
	<ul id="tabs">
    	<li>Mapa</li>
        <li>Tabla</li>
      
    </ul>
	<div id="paneles" style="height:350px">
		<div>
		<div id="Map" style="height:350px"></div>
			
		</div>
		
		<div>
			<p>Aqui vai a tabla </p>
			<table>
		<tr>
			<th class="ReportTableHeaderCell">Tipo</th>
			<th class="ReportTableHeaderCell">Login</th>
			<th class="ReportTableHeaderCell">Nome</th>
			<th class="ReportTableHeaderCell">Apelidos</th>
			<th class="ReportTableHeaderCell"></th>
		</tr>
		<tr class="ReportDetailsEvenDataRow">
			<td class="ReportTableValueCell">Admin</td>
			<td class="ReportTableValueCell">admin</td>
			<td class="ReportTableValueCell">Pablo</td>
			<td class="ReportTableValueCell">Belay Fernández</td>
			<td class="ReportTableValueCell">(borrar)</td>

		</tr>
		<tr class="ReportDetailsEvenDataRow">
			<td class="ReportTableValueCell">Administración Pública</td>
			<td class="ReportTableValueCell">xose.carballido</td>
			<td class="ReportTableValueCell">Xose Manuel</td>
			<td class="ReportTableValueCell">Carballido Gonzalez</td>
			<td class="ReportTableValueCell">(borrar)</td>

		</tr>
		</tr>
		<tr class="ReportDetailsEvenDataRow">
			<td class="ReportTableValueCell">Administración Pública</td>
			<td class="ReportTableValueCell">cons.pesca</td>
			<td class="ReportTableValueCell">Xunta de Galicia</td>
			<td class="ReportTableValueCell">Consellería de Pesca</td>
			<td class="ReportTableValueCell">(borrar)</td>

		</tr>
		</tr>
		<tr class="ReportDetailsEvenDataRow">
			<td class="ReportTableValueCell">Armador</td>
			<td class="ReportTableValueCell">benitosl</td>
			<td class="ReportTableValueCell">Benito</td>
			<td class="ReportTableValueCell">Hidalgo Sánchez</td>
			<td class="ReportTableValueCell">(borrar)</td>

		</tr>
		<tr class="ReportDetailsEvenDataRow">
					<td class="ReportTableValueCell">Admin</td>
					<td class="ReportTableValueCell">admin</td>
					<td class="ReportTableValueCell">Pablo</td>
					<td class="ReportTableValueCell">Belay Fernández</td>
					<td class="ReportTableValueCell">(borrar)</td>
		
		</tr>
		<tr class="ReportDetailsEvenDataRow">
					<td class="ReportTableValueCell">Administración Pública</td>
					<td class="ReportTableValueCell">xose.carballido</td>
					<td class="ReportTableValueCell">Xose Manuel</td>
					<td class="ReportTableValueCell">Carballido Gonzalez</td>
					<td class="ReportTableValueCell">(borrar)</td>
		
		</tr>
				<tr class="ReportDetailsEvenDataRow">
					<td class="ReportTableValueCell">Admin</td>
					<td class="ReportTableValueCell">admin</td>
					<td class="ReportTableValueCell">Pablo</td>
					<td class="ReportTableValueCell">Belay Fernández</td>
					<td class="ReportTableValueCell">(borrar)</td>
		
		</tr>
		<tr class="ReportDetailsEvenDataRow">
					<td class="ReportTableValueCell">Administración Pública</td>
					<td class="ReportTableValueCell">xose.carballido</td>
					<td class="ReportTableValueCell">Xose Manuel</td>
					<td class="ReportTableValueCell">Carballido Gonzalez</td>
					<td class="ReportTableValueCell">(borrar)</td>
		
		</tr>
				<tr class="ReportDetailsEvenDataRow">
					<td class="ReportTableValueCell">Admin</td>
					<td class="ReportTableValueCell">admin</td>
					<td class="ReportTableValueCell">Pablo</td>
					<td class="ReportTableValueCell">Belay Fernández</td>
					<td class="ReportTableValueCell">(borrar)</td>
		
		</tr>
		<tr class="ReportDetailsEvenDataRow">
					<td class="ReportTableValueCell">Administración Pública</td>
					<td class="ReportTableValueCell">xose.carballido</td>
					<td class="ReportTableValueCell">Xose Manuel</td>
					<td class="ReportTableValueCell">Carballido Gonzalez</td>
					<td class="ReportTableValueCell">(borrar)</td>
		
		</tr>
	</table>

		</div>
	</div>
</div>
<script type="text/javascript">
	cm_tabs({tab : 'tabs', container : 'paneles', active : 1});
</script>

</div>






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
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	 <h2><fmt:message key="patron.buscadorFaena.title"/></h2>
	
	<form:form  action="/xeopesca/patron/buscadorFaena" method="POST" commandName="faena">
		<input id="idbarco" name="idbarco" type="hidden" value="${idbarco}"/>
		<input id="id" name="id" type="hidden" value="${faena.id}"/>
		
		<table>
		
			<tr>
				<td><fmt:message key="patron.buscadorFaena.arte"/></td>
				
				<td>
					<form:select  path="arte">
    						<form:option value="" label="Todas" />
						
							<form:options items="${artes}" itemValue="id" itemLabel="nome" />
					</form:select>
				</td>
			<td><fmt:message key="patron.buscadorFaena.peri"/></td>
				<td><form:input path="dataInicio" readonly="true" id="dinicio" /></td>
			<td><fmt:message key="patron.buscadorFaena.perf"/></td>
				<td><form:input  path="dataFin" readonly="true" id="dfin"/></td>
			
				
			</tr>
			<tr>
				<td><fmt:message key="patron.buscadorFaena.lua"/></td>
				<td><form:select path="lua" id="idlua">
						<form:option value="" label="Todas" />
					
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
			<td><fmt:message key="patron.buscadorFaena.estadorMar"/></td>
				<td>
					<form:select path="estadoMar" id="idmar" >
						<form:option value="" label="Todos" />
						<form:options items="${mar}" itemValue="id" itemLabel="literal" />				
					</form:select>		
				</td>
				
			<td><fmt:message key="patron.buscadorFaena.estadoCeo"/></td>
				<td>
					<form:select path="estadoCeo" id="idceo" >
						<form:option value="" label="Todos" />
						<form:options items="${ceo}" itemValue="id" itemLabel="literal" />
					</form:select>	
				</td>	
				
			</tr>
			
			
			<tr>
				<td><fmt:message key="patron.buscadorFaena.dirv"/></td>
				<td>
					<form:select path="direccionVento" id="idvento" >
						<form:option value="" label="Todas" />
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
					</form:select>	
					
				</td>
				
				
				
			</tr>
			
			
			
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="patron.buscadorFaena.button.gardar"/>' /></td>
				
			</tr>
		</table>
		
	</form:form>
	<br>
	<br>
	
</div>


<c:if test="${!empty resultado}">


<div id="ReportDetails">
		 <h2>Mapa de resultados </h2>
	<div id="Map" style="height:415px;width:110ppx;"></div>
	
		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
					<script>
			//
			var selectControl, drawControls;
	//funcions
	
	function onPopupClose(evt) {
			
            selectControl.unselect(selectedFeature);
        }
        function onFeatureSelect(feature) {
					
            selectedFeature = feature;
            popup = new OpenLayers.Popup.FramedCloud("chicken", 
                                     feature.geometry.getBounds().getCenterLonLat(),
                                     null,
                                     "<div style='font-size:.8em'>"+
									 "Faena: <a href='"+"editarFaena/"+feature.attributes.id+"'>" + feature.attributes.id+"</a>"+ 
									 "<br>Lance: <a href='"+"novoLance/"+feature.attributes.id+"'>" + feature.attributes.idlance+"</a>"+ 
									 
									 
									 "<br>Lugar: " + feature.attributes.descripcion +
									 
									 
									 "<br>Fecha: " + feature.attributes.data_inicio +
									  "</div>",
                                     null, true, onPopupClose);
            feature.popup = popup;
            map.addPopup(popup);
        }
        function onFeatureUnselect(feature) {
					
            map.removePopup(feature.popup);
            feature.popup.destroy();
            feature.popup = null;
        }    ;
   
	
			
			
			//MAPA
			var idbarco = document.getElementById('idbarco').value; 
			var dinicio = document.getElementById('dinicio').value; 
			var dfin = document.getElementById('dfin').value; 
			
			var idlua  	= document.getElementById('idlua').value; 
			var idmar  	= document.getElementById('idmar').value; 
			var idceo 	= document.getElementById('idceo').value;  
			var idvento = document.getElementById('idvento').value; 
			
			
			var bounds = new OpenLayers.Bounds(308780.2375,4472890.525,833068.2375,4997178.525);
			var initialbbox = new OpenLayers.Bounds(398396.573996919,4606383.09616855,743451.90103171,4863685.95423634);
			var maxRes = 1024;
			var lat            = 5302009.63;
			var lon            = -1160006.63  ;
			
			var fromProjection = new OpenLayers.Projection("EPSG:900913");   // Transform from WGS 1984
			var mapProjection   = new OpenLayers.Projection("EPSG:900913"); // to Spherical Mercator Projection
			var position       = new OpenLayers.LonLat(lon, lat).transform( fromProjection, mapProjection);
			
			var zoom           = 7;
			
			
			map = new OpenLayers.Map('Map', {
				units: 'm',
				controls: [
					new OpenLayers.Control.Navigation(),
					new OpenLayers.Control.ScaleLine(),
					new OpenLayers.Control.MousePosition(),
					new OpenLayers.Control.LayerSwitcher(),
					new OpenLayers.Control.Zoom	()
				],
				projection: mapProjection,
			});
		
			
			
						
			var mapnik         = new OpenLayers.Layer.OSM();
			map.addLayer(mapnik);
			
			var satellite = new OpenLayers.Layer.Google("Google sat&eacutelite",
					{type: google.maps.MapTypeId.SATELLITE});
map.addLayer(satellite);
			
			//FILTROS
			var filtroBarco = new OpenLayers.Filter.Comparison({
		            type: OpenLayers.Filter.Comparison.EQUAL_TO,
		            property: "idbarco",
		            value: idbarco
		        });
				
			var filt = new OpenLayers.Filter.Logical({
						type: OpenLayers.Filter.Logical.AND,
						filters: [filtroBarco]
					});
			

			if (dinicio!=''){
				var filtroFechaFin = new OpenLayers.Filter.Comparison({
					type: OpenLayers.Filter.Comparison.GREATER_THAN_OR_EQUAL_TO,
					property: "data_inicio",
					value: dinicio
				});
				filt.filters.push(filtroFechaFin);
			}	

			if (dfin!=''){
				var filtroFechaFin = new OpenLayers.Filter.Comparison({
					type: OpenLayers.Filter.Comparison.LESS_THAN_OR_EQUAL_TO,
					property: "data_inicio",
					value: dfin
				});
				filt.filters.push(filtroFechaFin);
			}		
			
			
			
			if (idlua!='')
			{
				var filtroLua = new OpenLayers.Filter.Comparison({
	            type: OpenLayers.Filter.Comparison.EQUAL_TO,
	            property: "lua",
	            value: idlua
				});
			
				filt.filters.push(filtroLua);
			};
			
			if (idmar!=''){
				
				var filtroMar = new OpenLayers.Filter.Comparison({
								type: OpenLayers.Filter.Comparison.EQUAL_TO,
								property: "estado_mar",
								value: idmar
					});
				filt.filters.push(filtroMar);
			};

			
			if (idceo!=''){
				
				var filtroCeo = new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.EQUAL_TO,
						property: "estado_ceo",
						value: idceo
					});
				filt.filters.push(filtroCeo);
			}
			
			if (idvento!=''){
				var filtroVento = new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.EQUAL_TO,
						property: "direccion_vento",
						value: idvento
					});
				filt.filters.push(filtroVento);
			}
			
			
			
			var protocol = new OpenLayers.Protocol.WFS({ 
				url: "http://localhost:8080/geoserver/wfs",
				featureNS: "http://localhost:8080/xeopesca",
				featureType: "vista_faena_lance",
				outputFormat: 'json',
				defaultFilter: filt,
				maxFeatures: '20',
				readFormat: new OpenLayers.Format.GeoJSON()
			}); 
		
			var lances = new OpenLayers.Layer.Vector("Lances", { 
				strategies: [new OpenLayers.Strategy.Fixed()], 
				protocol: protocol, 
				
			});	
			map.addLayer(lances);
		 
		 
			map.setCenter(position, zoom);
			
			
			//Configuracion popup onclick
			 selectControl = new OpenLayers.Control.SelectFeature(lances,
		                {onSelect: onFeatureSelect, onUnselect: onFeatureUnselect});
		
			drawControls = {
		                polygon: new OpenLayers.Control.Geolocate(lances,
		                            OpenLayers.Handler.Polygon),
		                select: selectControl
		            };
			 for(var key in drawControls) {
						
		                map.addControl(drawControls[key]);
						drawControls[key].activate();
		            }
			map.setCenter(position, zoom);
						
		</script>
</div>


</div>



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
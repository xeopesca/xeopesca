<!-- 
/* --------------------------------------------------------------------
This file is part of xeoPesca

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
	 <h2> <fmt:message key="patron.buscadorPesca.title"/></h2>
	
	<form:form  action="/xeopesca/patron/buscadorpesca" method="POST" commandName="faena">
		<input id="idbarco" name="idbarco" type="hidden" value="${idbarco}"/>
		<input id="id" name="id" type="hidden" value="${faena.id}"/>
		
		<table>
		
			<tr>
				<td><fmt:message key="patron.buscadorPesca.especie"/></td>
				<td>
					<form:select path="especies" id="idespecie" >
						<form:option value="" label="Todas" />
						<form:options items="${especies}" itemValue="id" itemLabel="nomecientifico" />
					</form:select>	
					
				</td>
				
				
				
			<td><fmt:message key="patron.buscadorPesca.peri"/></td>
				<td><form:input path="dataInicio" readonly="true" id="dinicio" /></td>
			<td><fmt:message key="patron.buscadorPesca.perf"/></td>
				<td><form:input  path="dataFin" readonly="true" id="dfin"/></td>
			
				
			</tr>
			<tr>
				<td><fmt:message key="patron.buscadorPesca.lua"/></td>
				<td><form:select path="lua" id="idlua">
						<form:option value="" label="Todas" />
					
						<form:options items="${lua}" itemValue="id" itemLabel="literal" />
						
					</form:select></td>
			<td><fmt:message key="patron.buscadorPesca.estadomar"/></td>
				<td>
					<form:select path="estadoMar" id="idmar" >
						<form:option value="" label="Todos" />
						<form:options items="${mar}" itemValue="id" itemLabel="literal" />				
					</form:select>		
				</td>
				
			<td><fmt:message key="patron.buscadorPesca.estadoceo"/></td>
				<td>
					<form:select path="estadoCeo" id="idceo" >
						<form:option value="" label="Todos" />
						<form:options items="${ceo}" itemValue="id" itemLabel="literal" />
					</form:select>	
				</td>	
				
			</tr>
			
			
			<tr>
				<td><fmt:message key="patron.buscadorPesca.dirv"/></td>
				<td>
					<form:select path="direccionVento" id="idvento" >
						<form:option value="" label="Todas" />
						<form:options items="${dirvento}" itemValue="id" itemLabel="literal" />
					</form:select>	
					
				</td>
				<td><fmt:message key="patron.buscadorPesca.pesocapturas"/></td>
				<td>
									<form:input  path="peso"  id="idpeso"/>

				</td>
				
				
			</tr>
			
			
			
			<tr>
				<td></td>
				<td><input type="submit" value='<fmt:message key="patron.buscadorPesca.gardar"/>' /></td>
				
			</tr>
		</table>
		
	</form:form>
	
	
</div>




<div id="ReportDetails">
		 <h2>Mapa de resultados </h2>
	<div id="Map" style="height:415px;width:110ppx;"></div>
	
		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
		<script>
			
		var selectControl, drawControls;
	
		function onPopupClose(evt) {
			
            selectControl.unselect(selectedFeature);
        }
        function onFeatureSelect(feature) {
					
            selectedFeature = feature;
            popup = new OpenLayers.Popup.FramedCloud("chicken", 
                                     feature.geometry.getBounds().getCenterLonLat(),
                                     null,
                                     "<div style='font-size:.8em'>"+
									 "Especie: "+feature.attributes.especie_nomecientifico+" <br> " + 
									 "Peso: "+feature.attributes.pesca_peso+"  " +  "Peso Descarte: "+feature.attributes.pesca_pesodescarte	+" <br> " + 
									 "Fecha: "+feature.attributes.faena_data_inicio+" <br> " + 
									 "Lugar: "+feature.attributes.lance_descripcion+" <br> " + 
									 "Temperatura superficie : "+feature.attributes.faena_temp_superficie+" <br> " + 
									 "Temperatura aire : "+feature.attributes.faena_temp_aire	+" <br> " + 
									 "Temperatura fondo : "+feature.attributes.faena_temp_fondo	+" <br> " + 	
									 "<img   width='200' height='150' src='"+feature.attributes.especie_path	+"  '> </img> <br> " + 
									 
									  "</div>",
                                     null, true, onPopupClose);
            feature.popup = popup;
            map.addPopup(popup);
        };
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
			var idpeso =  document.getElementById('idpeso').value; 
			var idespecie = document.getElementById('idespecie').value; 
			
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
		            property: "faena_idbarco",
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
			if (idpeso!=''){
				var filtroPeso = new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.GREATER_THAN_OR_EQUAL_TO,
						property: "pesca_peso",
						value: idpeso
					});
				filt.filters.push(filtroPeso);
			}
			
			if (idespecie!=''){
				var filtroEsp = new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.EQUAL_TO,
						property: "pesca_idespecie",
						value: idespecie
					});
				filt.filters.push(filtroEsp);
			}
			
			var protocol = new OpenLayers.Protocol.WFS({ 
				url: "http://localhost:8080/geoserver/wfs",
				featureNS: "http://localhost:8080/xeopesca",
				featureType: "vista_especies_lance",
				outputFormat: 'json',
				defaultFilter: filt,
				readFormat: new OpenLayers.Format.GeoJSON()
			}); 
		
			var lances = new OpenLayers.Layer.Vector("Especies", { 
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





 
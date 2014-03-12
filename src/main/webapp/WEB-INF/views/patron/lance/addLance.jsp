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
	 <h2><fmt:message key="patron.addLance.title"/></h2>
	
	<form:form  action="/xeopesca/patron/addLance"  commandName="lance">
		<input id="idfaena" name="idfaena" type="hidden" value="${lance.idfaena}"/>
		
		
	
		<table>
		<tr>
			<td><fmt:message key="patron.addLance.desc"/></td>
			<td>
				<form:input  path="descripcion" />
				
			</td>
		</tr>
		<tr>
			<td><fmt:message key="patron.addLance.coor"/></td>
			<td>
			    <form:input  id="punto" path="punto_inicio" />
			</td>
			
			
		</tr>
	
		
	
		</table>
		
		<div id="Map" style= height:225px;width:425px;"></div>
		
		
			<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
			<script>
			 OpenLayers.Control.Click = OpenLayers.Class(OpenLayers.Control, {                
	                defaultHandlerOptions: {
	                    'single': true,
	                    'double': false,
	                    'pixelTolerance': 0,
	                    'stopSingle': false,
	                    'stopDouble': false
	                },

	                initialize: function(options) {
	                    this.handlerOptions = OpenLayers.Util.extend(
	                        {}, this.defaultHandlerOptions
	                    );
	                    OpenLayers.Control.prototype.initialize.apply(
	                        this, arguments
	                    ); 
	                    this.handler = new OpenLayers.Handler.Click(
	                        this, {
	                            'click': this.trigger
	                        }, this.handlerOptions
	                    );
	                }, 

	                trigger: function(e) {
	        			var markers = new OpenLayers.Layer.Markers( "Markers" );
	             	    var lonlat = map.getLonLatFromPixel(e.xy);
	             	    var tesxtoPunto = document.getElementById('punto');
	                    //alert("Posicion: " + lonlat.lat + " N, " + lonlat.lon + " E");
	                    
	                    //Gardamos o punto no campo de texto
	                    tesxtoPunto.value = '';
	                    tesxtoPunto.value =lonlat.lon+' '+lonlat.lat;

	                    //Engadimos o markers
	    				map.addLayer(markers);
		    			markers.addMarker(new OpenLayers.Marker(lonlat));

		    			//PROBAS
		    			//var rM = map.getLayersByName("Markers");
		    			//alert(''+map.name);
		    			
	                    
		    			
		    			//alert(markers.name);
		    			//Borrar layer mapa
	                   // map.removeLayer(markers);
		    			//markers[0].erase();
		    			
	                }

	            });
			
			
				//Configuracion mapa
				var lat            = 43.35387;
				var lon            = -8.43609;
				var zoom           = 7;
			 
				var fromProjection = new OpenLayers.Projection("EPSG:4326");   // Transform from WGS 1984
				var toProjection   = new OpenLayers.Projection("EPSG:900913"); // to Spherical Mercator Projection
				var position       = new OpenLayers.LonLat(lon, lat).transform( fromProjection, toProjection);
			 
				map = new OpenLayers.Map("Map");
				var mapnik         = new OpenLayers.Layer.OSM();
				map.addLayer(mapnik);
			 
				
			 
				map.setCenter(position, zoom);
				
				 var click = new OpenLayers.Control.Click();
	                map.addControl(click);
	                click.activate();
			</script>
		
		</div>
		<input type="submit" value="Enviar" />
		
		
	</form:form>
</div>








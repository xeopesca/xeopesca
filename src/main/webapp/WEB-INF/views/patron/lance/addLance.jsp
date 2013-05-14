
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div id="ReportDetails">
	 <h2>Engadir lance </h2>
	
	<form:form  action="/xeopesca/patron/addLance"  commandName="lance">
		<input id="idfaena" name="idfaena" type="hidden" value="${lance.idfaena}"/>
		
		
	
		<table>
		<tr>
			<td>Descripcion:</td>
			<td>
				<form:input  path="descripcion" />
				
			</td>
		</tr>
		<tr>
			<td>Coordenadas:</td>
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
	                    var lonlat = map.getLonLatFromPixel(e.xy);
	                    alert("You clicked near " + lonlat.lat + " N, " +
	                                              + lonlat.lon + " E");
	                   
	                    //Gardamos o punto no campo de texto
	                    var myTextField = document.getElementById('punto');
	                    myTextField.value = '';
	                    myTextField.value =lonlat.lat+' , '+lonlat.lon;
	                    
	                    
	                    //Engadimos o marker
	                    var markers = new OpenLayers.Layer.Markers( "Markers" );
	    				map.addLayer(markers);
		    				markers.addMarker(new OpenLayers.Marker(lonlat));
	                    
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








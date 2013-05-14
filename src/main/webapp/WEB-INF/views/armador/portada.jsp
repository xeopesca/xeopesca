
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div id="ReportDetails">
	<!--  <h2>Portada armador</h2>-->
	<br>
	
<div id="panel">
	<ul id="tabs">
    	<li>Mapa</li>
        <li>Tabla</li>
      
    </ul>
	<div id="paneles" style="height:650px">
		<div>
		<div id="Map" style="height:650px"></div>
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
			 
				var markers = new OpenLayers.Layer.Markers( "Markers" );
				map.addLayer(markers);
				markers.addMarker(new OpenLayers.Marker(position));
			 
				map.setCenter(position, zoom);
				
				 var click = new OpenLayers.Control.Click();
	                map.addControl(click);
	                click.activate();
			</script>
		
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






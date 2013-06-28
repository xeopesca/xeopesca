
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<input id="idbarcos" type="hidden" value="${idbarcos}"/>


<div id="ReportDetails">
	  <h2>Portada armador</h2>

	<div id="Map" style="height:415px;width:110ppx;">
		
	</div>
	
<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
			<script>
	var selectControl, drawControls;
			
	//FUNCIONS	
	function onPopupClose(evt) {
			
            selectControl.unselect(selectedFeature);
        };
        function onFeatureSelect(feature) {
			
            selectedFeature = feature;
            popup = new OpenLayers.Popup.FramedCloud("chicken", 
                                     feature.geometry.getBounds().getCenterLonLat(),
                                     null,
                                     "<div style='font-size:.8em'>"+
									 "<br>Barco: " + feature.attributes.folio +
									 "<br>Data: " + feature.attributes.data_fin +
									 "<br>Lugar: " + feature.attributes.descripcion +
									 "<br>Hora inicio: " + feature.attributes.hora_inicio +
									 "<br>Temperatura aire: " + feature.attributes.temp_aire +
									 "<br>Temperatura superficie: " + feature.attributes.temp_superficie +
									 "<br>Temperatura fondo: " + feature.attributes.temp_fondo +
									 "<br>Velocidade vento: " + feature.attributes.velocidade_vento +
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
	var idbarcos = document.getElementById('idbarcos').value; 
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
	
	var satellite = new OpenLayers.Layer.Google("Google satélite",
			{type: google.maps.MapTypeId.SATELLITE});
map.addLayer(satellite);
	//AGregamos filtros dos barcos
	var filt = new OpenLayers.Filter.Logical({
    type: OpenLayers.Filter.Logical.OR,
    filters: []
	});
	
	//bucle do filtro
	var barcos  = idbarcos.split(';');
	var tamano  = barcos.length-1;
	for (var i = 0; i < tamano; i++) {
		x = new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.EQUAL_TO,
						property: "idbarco",
						value: barcos[i]
					});
		filt.filters.push(x);
	}
	

	//PROTOCOLO
	var protocol = new OpenLayers.Protocol.WFS({ 
		url: "./geoserver/wfs",
		featureNS: "http://localhost:8080/xeopesca",
		featureType: "vista_faena_lance",
		outputFormat: 'json',
		defaultFilter: filt,
		maxFeatures: '100',
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

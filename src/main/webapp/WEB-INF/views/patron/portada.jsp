
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	 
	 
 <input id="idbarco" type="hidden" value="${idbarco}"/>


<div id="ReportDetails">
	  <h2>Portada patrón</h2>

		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
			<script src="/js/mapa/patron/mapa.js"></script>
			<script>
				
   
/**
		Funcion: 	 init()
		Descripcion: Lanza o mapa
*/ 
function init() {
	var nome_feature ="vista_faena_lance";
	var lat            = 5302009.63;
	var lon            = -1160006.63  ;
	
	var fromProjection = new OpenLayers.Projection("EPSG:900913");   
	var mapProjection   = new OpenLayers.Projection("EPSG:900913"); 
	var position       = new OpenLayers.LonLat(lon, lat).transform( fromProjection, mapProjection);
	
	var zoom           = 8;
	
	
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

	
	cargarCapas(map);
	var filt = aplicarFiltros();

	
	var protocol = new OpenLayers.Protocol.WFS({ 
		url: "http://localhost:8080/geoserver/wfs",
		featureNS: "http://localhost:8080/xeopesca",
		featureType: nome_feature,
		outputFormat: 'json',
		defaultFilter: filt,
		maxFeatures: '20',
		readFormat: new OpenLayers.Format.GeoJSON()
	}); 

	var lances = new OpenLayers.Layer.Vector(nome_feature, { 
		strategies: [new OpenLayers.Strategy.Fixed()], 
		protocol: protocol, 
		
	});	
	map.addLayer(lances);
 
	var markers = new OpenLayers.Layer.Markers( "Markers" );
	map.addLayer(markers);
	markers.addMarker(new OpenLayers.Marker(position));
 
	map.setCenter(position, zoom);
	
	//alert(map.getProjection());
	
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
		
    //  selectControl.active();
	
} //Fin funcion init


				 
			</script>
		
		</div>
		

</div>
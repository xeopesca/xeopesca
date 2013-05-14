<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Patrón</title>
<link rel="stylesheet" type="text/css" media="all" href="/js/calendar/jsDatePick_ltr.min.css" />

<link rel="stylesheet" href="/css/estilo.css" type="text/css" />
<link rel="stylesheet" href="/css/tabs.css" type="text/css" />



<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
<script>
function init() {
	var bounds = new OpenLayers.Bounds(308780.2375,4472890.525,833068.2375,4997178.525);
	var initialbbox = new OpenLayers.Bounds(398396.573996919,4606383.09616855,743451.90103171,4863685.95423634);
	var maxRes = 1024;
	var lat            = 43.50;
	var lon            = -8.25;
	
	var fromProjection = new OpenLayers.Projection("EPSG:4326");   // Transform from WGS 1984
	var mapProjection   = new OpenLayers.Projection("EPSG:900913"); // to Spherical Mercator Projection
	var position       = new OpenLayers.LonLat(lon, lat).transform( fromProjection, mapProjection);
	
	var zoom           = 7;
	
	
	var map = new OpenLayers.Map('Map', {
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
	
	var protocol = new OpenLayers.Protocol.WFS({ 
		url: "http://localhost:8080/geoserver/wfs",
		featureNS: "http://localhost:8080/xeopesca",
		featureType: "estacion",
		outputFormat: 'json',
		readFormat: new OpenLayers.Format.GeoJSON()
	}); 

	var autopistas = new OpenLayers.Layer.Vector("Estaci&oacutens", { 
		strategies: [new OpenLayers.Strategy.Fixed()], 
		protocol: protocol, 
	});	
	map.addLayer(autopistas);
 
	var markers = new OpenLayers.Layer.Markers( "Markers" );
	map.addLayer(markers);
	markers.addMarker(new OpenLayers.Marker(position));
 
	map.setCenter(position, zoom);
	
	
}
</script>

<script type="text/javascript" src="/js/calendar/jsDatePick.min.1.3.js"></script>



</head>
  <body onload="init()">

<div id="ReportHeader">
	<h1>xeoPesca </h1>	
	<tiles:insertAttribute name="menu" />


</div>

	<tiles:insertAttribute name="body" />
	<!--<tiles:insertAttribute name="footer" />-->


</body>
</html>













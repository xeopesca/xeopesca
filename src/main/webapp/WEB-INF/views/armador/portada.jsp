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

<input id="idbarcos" type="hidden" value="${idbarcos}"/>


<div id="ReportDetails">
	  <h2><fmt:message key="armador.portada.title"/></h2>

	<div id="Map" style="height:415px;width:110ppx;">
		
	</div>
	
<script src="/js/i18n/${locale}.js"></script>
<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
<script src="/js/config.js"></script>

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
									 "<br>"+i18n_msg.barco+": " + feature.attributes.folio +
									 "<br>"+i18n_msg.fecha+": " + feature.attributes.data_fin +
									 "<br>"+i18n_msg.lugar+": " + feature.attributes.descripcion +
									 "<br>"+i18n_msg.horai+": " + feature.attributes.hora_inicio +
									 "<br>"+i18n_msg.temp_aire+": " + feature.attributes.temp_aire +
									 "<br>"+i18n_msg.temp_supe+": " + feature.attributes.temp_superficie +
									 "<br>"+i18n_msg.temp_fondo+": " + feature.attributes.temp_fondo +
									 "<br>"+i18n_msg.velo_vento+": " + feature.attributes.velocidade_vento +
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
	
	var satellite = new OpenLayers.Layer.Google("Google sat&eacutelite",
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
		url: URL_GEOSERVER ,
		featureNS: FEATURE_NS,
		featureType: "vista_faena_lance",
		outputFormat: 'json',
		defaultFilter: filt,
		maxFeatures: MAX_FEATURE,
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

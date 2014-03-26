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

 //var map, drawControls, selectControl, selectedFeature;
	
	/**
		Funcion: 	 onPopupClose(evt)
		Descripcion: Cerrar un popup
	*/
    function onPopupClose(evt) {
        selectControl.unselect(selectedFeature);
    }
	/**
		Funcion: 	 onFeatureSelect(feature)
		Descripcion: Abre un popup ao selecionar un punto
	*/
    function onFeatureSelect(feature) {
        selectedFeature = feature;
        popup = new OpenLayers.Popup.FramedCloud("infode", 
        feature.geometry.getBounds().getCenterLonLat(),
                                     null, " <div ><iframe src='./info.html'  width='250' height='180'></iframe> </div>" ,
									 
                                     null, true, onPopupClose);
            feature.popup = popup;
            map.addPopup(popup);
    }
	/**
		Funcion: 	 onFeatureUnselect(feature) 
		Descripcion: Cerrar un popup ao deselecionar
	*/
    function onFeatureUnselect(feature) {
					

            map.removePopup(feature.popup);
            feature.popup.destroy();
            feature.popup = null;
    } 
	
	/**
		Funcion: 	 cargarCapas(map) 
		Descripcion: Carga as mapas de OPM e Google
	*/
	function cargarCapas(map) {
		//Capas			
		var mapnik         = new OpenLayers.Layer.OSM();

		var physical = new OpenLayers.Layer.Google("Google f�sico",
							{type: google.maps.MapTypeId.TERRAIN});
		var streets = new OpenLayers.Layer.Google("Google streets");
		var hybrid = new OpenLayers.Layer.Google("Google h�brido",
							{type: google.maps.MapTypeId.HYBRID});
		var satellite = new OpenLayers.Layer.Google("Google sat�lite",
							{type: google.maps.MapTypeId.SATELLITE});
		
		map.addLayers([mapnik,physical, streets, hybrid, satellite]);

    } 
	
	function aplicarFiltros(){
	var filtro = new OpenLayers.Filter.Logical({
				type: OpenLayers.Filter.Logical.OR,
				filters: [
					new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.EQUAL_TO,
						property: "idbarco",
						value: "1"
					}),
					new OpenLayers.Filter.Comparison({
						type: OpenLayers.Filter.Comparison.EQUAL_TO,
						property: "id",
						value: "22"
					})
				]
				});	
	return filtro;

	}
	
	function controlesMapa(){
	
	
	
	}


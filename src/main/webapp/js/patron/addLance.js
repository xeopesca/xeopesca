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

/**
* Mostra o mapa para engadir un lance
* e cando prememos no mapa carga as 
* coordenadas no campo correspondente 
*/

OpenLayers.Control.Click = OpenLayers
		.Class(
				OpenLayers.Control,
				{
					defaultHandlerOptions : {
						'single' : true,
						'double' : false,
						'pixelTolerance' : 0,
						'stopSingle' : false,
						'stopDouble' : false
					},

					initialize : function(options) {
						this.handlerOptions = OpenLayers.Util.extend({},
								this.defaultHandlerOptions);
						OpenLayers.Control.prototype.initialize.apply(this,
								arguments);
						this.handler = new OpenLayers.Handler.Click(this, {
							'click' : this.trigger
						}, this.handlerOptions);
					},

					trigger : function(e) {

						var avisoErro = document.getElementById("aviso");// mostra
																			// erro
																			// de
																			// navigator.geolocation.getCurrentPosition

						if (navigator.geolocation) {
							navigator.geolocation
									.getCurrentPosition(
											function(position) {
												var markers = new OpenLayers.Layer.Markers(
														"Markers");
												var fromProjection = new OpenLayers.Projection(
														"EPSG:4326"); // Transform
																		// from
																		// WGS
																		// 1984
												var toProjection = new OpenLayers.Projection(
														"EPSG:900913"); // to
																		// Spherical
																		// Mercator
																		// Projection
												var lonLat = new OpenLayers.LonLat(
														position.coords.longitude,
														position.coords.latitude)
														.transform(
																fromProjection,
																toProjection);
												var tesxtoPunto = document
														.getElementById('punto');
												tesxtoPunto.value = '';
												tesxtoPunto.value = lonLat.lon
														+ ' ' + lonLat.lat;
												map.addLayer(markers);
												markers
														.addMarker(new OpenLayers.Marker(
																lonLat));
											}, showError);
						} else {
							avisoErro.innerHTML = "Geolocation is not supported by this browser.";
						}

						function showError(error) {
							switch (error.code) {
							case error.PERMISSION_DENIED:
								avisoErro.innerHTML = "User denied the request for Geolocation.";
								break;
							case error.POSITION_UNAVAILABLE:
								avisoErro.innerHTML = "Location information is unavailable.";
								break;
							case error.TIMEOUT:
								avisoErro.innerHTML = "The request to get user location timed out.";
								break;
							case error.UNKNOWN_ERROR:
								avisoErro.innerHTML = "An unknown error occurred.";
								break;
							}
						}
					}
				});
// Configuracion mapa
var lat = 43.35387;
var lon = -8.43609;
var zoom = 7;

var fromProjection = new OpenLayers.Projection("EPSG:4326"); // Transform
																// from WGS 1984
var toProjection = new OpenLayers.Projection("EPSG:900913"); // to Spherical
																// Mercator
																// Projection
var position = new OpenLayers.LonLat(lon, lat).transform(fromProjection,
		toProjection);

map = new OpenLayers.Map("Map");
var mapnik = new OpenLayers.Layer.OSM();
map.addLayer(mapnik);

map.setCenter(position, zoom);

var click = new OpenLayers.Control.Click();
map.addControl(click);
click.activate();
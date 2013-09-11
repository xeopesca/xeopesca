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
package com.xeopesca.util;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import com.vividsolutions.jts.io.ParseException;


public class GeometryUtil {
	
	private GeometryUtil()
	{}
	
	 public static Geometry wktToGeometry(String wktPoint) {
	        WKTReader fromText = new WKTReader();
	        Geometry geom = null;
	        try {
	            geom = fromText.read(wktPoint);
	        } catch (ParseException e) {
	            throw new RuntimeException("Not a WKT string:" + wktPoint);
	        }
	        return geom;
	    }

}

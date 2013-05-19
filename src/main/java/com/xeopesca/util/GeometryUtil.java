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

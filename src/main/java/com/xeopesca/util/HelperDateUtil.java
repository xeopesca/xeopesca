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

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperDateUtil {
	
	
	private HelperDateUtil (){}
	
	
	public static Date StringToDate (String fechaCadena){
		///String strFecha = "2007-12-25";

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = null;
		try {

		fecha = formatoDelTexto.parse(fechaCadena);

		} catch (Exception ex) {

		ex.printStackTrace();

		}		
		return fecha;
	}
	
	public static Date StringToTime (String fechaCadena){
		///String strFecha = "2007-12-25";

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm");
		Date fecha = null;
		try {

		fecha = formatoDelTexto.parse(fechaCadena);

		} catch (Exception ex) {

		ex.printStackTrace();

		}		
		return fecha;
	}
	
	
	public static String DateToString (Date fecha){
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
		
		return formatoDeFecha.format(fecha);
	}

	public static String TimeToString (Date fecha){
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("HH:mm");
		
		return formatoDeFecha.format(fecha);
	}
}

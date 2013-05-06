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

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm:ss");
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
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("hh:mm:ss");
		
		return formatoDeFecha.format(fecha);
	}
}

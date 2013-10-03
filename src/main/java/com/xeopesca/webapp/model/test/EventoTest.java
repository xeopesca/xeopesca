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
package com.xeopesca.webapp.model.test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.lowagie.text.pdf.codec.postscript.ParseException;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTReader;
import com.xeopesca.util.JPAUtil;
import com.xeopesca.webapp.model.dao.EventoDAO;
import com.xeopesca.webapp.model.vos.Evento;

public class EventoTest {
	
	
	public static void main(String[] args) {
		System.out.println("********************");
		System.out.println("*** Novo Evento *****************");
		System.out.println("********************");
		newEvento ();
		
		System.out.println("********************");
		System.out.println("*** List Eventos *****************");
		System.out.println("********************");
		listEvents();
		
		System.out.println("********************");
		System.out.println("*** Buscar Evento *****************");
		System.out.println("********************");
		findEvent(new Long(1));
		findEvent(new Long(2));
		
		

		System.out.println("********************");
		System.out.println("*** Actualizar Evento *****************");
		System.out.println("********************");
		updateEvente(new Long(1));
	}
	
	/**
	 * Agrega un novo evento a base de datos
	 * */
	private static void newEvento(){
		EventoDAO mgr = new EventoDAO();

		String[] args = "store POINT(10 5)".split(" ");

		Evento evento = new Evento();
		evento.setDate(new Date());
		evento.setTitle("Mar coru�a");
		//Posicion
		try {
			Geometry geom = wktToGeometry("POINT(10 5)");
		} catch (com.vividsolutions.jts.io.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//mgr.save(evento);
		mgr.create(evento);
		System.out.println("Borramos : "+evento.getId());
		//mgr.delete(evento.getId());
		
		
	}
	
	/**
	 * Lista todolos eventos da base de datos
	 * */
	private static void listEvents(){
		EventoDAO mgr = new EventoDAO();

		List events = mgr.findAll();
		for (int i = 0; i < events.size(); i++) {
			Evento event = (Evento) events.get(i);
			
			System.out.println(event.toSting());
			
		}

	}
	
	public static void findEvent(Long id){
		EventoDAO mgr = new EventoDAO();
		Evento evento = mgr.find(new Long(id));
		System.out.println(evento.toSting());
		
	}
	
	
	public static void updateEvente(Long id){
		EventoDAO mgr = new EventoDAO();
		Evento evento = mgr.find(new Long(id));
		
		Random rand = new Random();
		int i = rand.nextInt();
		System.out.println(">>Titulo do evento "+i);
		evento.setTitle("Titulo do evento"+" "+i);
		System.out.println(">>"+evento.toSting());
	}

	/**
	 * Utility method to assemble all arguments save the first into a String
	 * @throws com.vividsolutions.jts.io.ParseException 
	 */
	/*private static String assemble(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			builder.append(args[i]).append(" ");
		}
		return builder.toString();
	}*/
	   private static Geometry wktToGeometry(String wktPoint) throws com.vividsolutions.jts.io.ParseException, ParseException {
	        WKTReader fromText = new WKTReader();
	        Geometry geom = null;
	        geom = fromText.read(wktPoint);
	        return geom;
	    }
}

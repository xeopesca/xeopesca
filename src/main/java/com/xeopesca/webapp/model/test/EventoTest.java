package com.xeopesca.webapp.model.test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.webapp.model.dao.EventoDAO;
import com.xeopesca.webapp.model.vos.Event;
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

		String[] args = "store POINT(10 56)".split(" ");

		Evento evento = new Evento();
		evento.setDate(new Date());
		evento.setTitle("titulo do evento probas");
		
		//mgr.save(evento);
		mgr.create(evento);
		System.out.println("Borramos : "+evento.getId());
		mgr.delete(evento.getId());
		
		
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
	 */
	/*private static String assemble(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			builder.append(args[i]).append(" ");
		}
		return builder.toString();
	}*/

}

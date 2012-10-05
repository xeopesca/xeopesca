package com.xeopesca.webapp.model.test;

import java.util.Date;
import java.util.List;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.webapp.model.dao.EventManager;
import com.xeopesca.webapp.model.vos.Event;

public class EventTest {
	
	
	public static void main(String[] args) {
		
		newEvent (args);
		System.out.println("********************");
		listEvents();
		System.out.println("********************");

	}
	
	/**
	 * Agrega un novo evento a base de datos
	 * */
	private static void newEvent(String[] args){
		EventManager mgr = new EventManager();

		args = "store POINT(10 56)".split(" ");

		// args =
		// "find POLYGON((1\\ 1,20\\ 1,20\\ 20,1\\ 20,1\\ 1)) ".split(" ");

		if (args.length != 0) {
			if (args[0].equals("store")) {
				mgr.createAndStoreEvent("My Event", new Date(), assemble(args));
			} else if (args[0].equals("find")) {
				List events = mgr.find(args[1]);
				for (int i = 0; i < events.size(); i++) {
					Event event = (Event) events.get(i);
					System.out.println("Event: " + event.getTitle()
							+ ", Time: " + event.getDate() + ", Location: "
							+ event.getLocation());
				}
			}

			JPAUtil.close();
			mgr = null;
		}
	}
	/**
	 * Lista todolos eventos da base de datos
	 * */
	private static void listEvents(){
		EventManager mgr = new EventManager();

		List events = mgr.findAll();
		for (int i = 0; i < events.size(); i++) {
			Event event = (Event) events.get(i);
			System.out.println("Event: " + event.getTitle() + ", Time: "
					+ event.getDate() + ", Location: " + event.getLocation());
		}

	}

	/**
	 * Utility method to assemble all arguments save the first into a String
	 */
	private static String assemble(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			builder.append(args[i]).append(" ");
		}
		return builder.toString();
	}

}

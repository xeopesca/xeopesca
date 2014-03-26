package com.xeopesca.webapp.controller.commons;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleResolverXeopesca {
	
	private LocaleResolverXeopesca(){};
	
	public static String getIdiom(){
		String idiom = LocaleContextHolder.getLocale().getLanguage().toLowerCase();
		
		return idiom;
		
	}

}

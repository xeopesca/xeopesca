package com.xeopesca.webapp.controller.commons;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleResolverXeopesca {

	private LocaleResolverXeopesca() {
	};

	public static String getIdiom() {
		String idiom = LocaleContextHolder.getLocale().getLanguage()
				.toLowerCase();
		String output = "gl";
		if (idiom.equalsIgnoreCase("gl")) {
			output = idiom;
		} else if (idiom.equalsIgnoreCase("es")) {
			output = idiom;
		} else if (idiom.equalsIgnoreCase("pt")) {
			output = idiom;
		}else if(idiom.equalsIgnoreCase("en")){
			output = idiom;
		} else{
			output ="gl";
		}
		return idiom;

	}

}

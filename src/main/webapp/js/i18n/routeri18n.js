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
var i18n = null;

function getI18n( cadena){
	var lang = determineLocale();
	
}

function determineLocale(){
	
	var lang;
    if (navigator.userLanguage) // Explorer
        l_lang = navigator.userLanguage;
    else if (navigator.language) // Firefox & Chrome
    	lang = navigator.language; 
    else //Valor por defecto
    	lang = "gl";
    
	//En firefox devolve o código con gl_ES por iso facemos un substring
    lang = lang.substring(0, 2).toLowerCase();
    
    
    //Definimos os locales soportas na aplicación
    switch (lang)
    {
    case 'gl':
      lang = 'gl';
      break;
    case 'es':
    	lang = 'es';
      break;
    case 'pt':
    	lang = 'pt';
      break;
    case 'en':
    	lang = 'en';
      break;
    default:
    	lang = 'gl';
    }
}



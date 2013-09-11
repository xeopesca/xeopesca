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



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static  EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("persistencia");

   /* static {
        try {
            emFactory = Persistence.createEntityManagerFactory("persistencia");
        }catch(Throwable ex){
            System.err.println(">>Cannot create EntityManagerFactory.");
            throw new ExceptionInInitializerError(ex);
        }
    }*/
    

    public static EntityManager createEntityManager() {
    	
         if(!emFactory.isOpen()){
        	 emFactory = Persistence.createEntityManagerFactory("persistencia");
        	 
         }
        return emFactory.createEntityManager();
    }

    public static void close(){
        emFactory.close();
    }
}

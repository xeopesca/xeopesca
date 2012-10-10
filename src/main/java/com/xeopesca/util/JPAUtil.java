package com.xeopesca.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static  EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("persistencia");

    static {
        try {
            emFactory = Persistence.createEntityManagerFactory("persistencia");
        }catch(Throwable ex){
            System.err.println(">>Cannot create EntityManagerFactory.");
            throw new ExceptionInInitializerError(ex);
        }
    }

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

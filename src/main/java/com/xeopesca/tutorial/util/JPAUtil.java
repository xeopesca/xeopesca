package com.xeopesca.tutorial.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static  EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("persistencia");
/*
    static {
        try {
            emFactory = Persistence.createEntityManagerFactory("persistencia");
        }catch(Throwable ex){
            System.err.println(">>Cannot create EntityManagerFactory.");
            throw new ExceptionInInitializerError(ex);
        }
    }*/

    public static EntityManager createEntityManager() {
    /*	 Map<String, String> map = new HashMap<String, String>();
    	 map.put("hibernate.connection.driver_class","org.hibernate.spatial.dialect.postgis.PostgisDialect");
         map.put ("hibernate.connection.url","jdbc:postgresql://localhost:5432:xeopesca");
         map.put ("hibernate.connection.username","postgres");
         map.put ("hibernate.connection.password","1234");
         map.put ("hibernate.connection.pool_size","5");
         map.put ("hibernate.show_sql","true");
         map.put ("hibernate.format_sql","true");
         map.put ("hibernate.max_fetch_depth","5");
         map.put ("hibernate.hbm2ddl.auto","update");
         
      

       
    	EntityManager x = emFactory.createEntityManager(map);
    	
       return x;*/
    	
    	
    	
        return emFactory.createEntityManager();
    }

    public static void close(){
        emFactory.close();
    }
}

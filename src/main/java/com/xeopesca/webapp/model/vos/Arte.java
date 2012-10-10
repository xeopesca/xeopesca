package com.xeopesca.webapp.model.vos;


// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Arte generated by hbm2java
 */
public class Arte  implements java.io.Serializable {


     private long id;
     private String actividade;
     private String categoria;
     private String nome;
     private String path;
     private String descripcion;
     private Set faenas = new HashSet(0);
     private Set barcos = new HashSet(0);

    public Arte() {
    }

	
    public Arte(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Arte(long id, String actividade, String categoria, String nome, String path, String descripcion, Set faenas, Set barcos) {
       this.id = id;
       this.actividade = actividade;
       this.categoria = categoria;
       this.nome = nome;
       this.path = path;
       this.descripcion = descripcion;
       this.faenas = faenas;
       this.barcos = barcos;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getActividade() {
        return this.actividade;
    }
    
    public void setActividade(String actividade) {
        this.actividade = actividade;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getFaenas() {
        return this.faenas;
    }
    
    public void setFaenas(Set faenas) {
        this.faenas = faenas;
    }
    public Set getBarcos() {
        return this.barcos;
    }
    
    public void setBarcos(Set barcos) {
        this.barcos = barcos;
    }




}



package com.xeopesca.webapp.model.vos;
// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA



/**
 * Pesca generated by hbm2java
 */
public class Pesca  implements java.io.Serializable {


     private PescaId id;
     private Lance lance;
     private Float peso;
     private Long ud;
     private Float pesodescarte;
     private Float uddescarte;

    public Pesca() {
    }

	
    public Pesca(PescaId id, Lance lance) {
        this.id = id;
        this.lance = lance;
    }
    public Pesca(PescaId id, Lance lance, Float peso, Long ud, Float pesodescarte, Float uddescarte) {
       this.id = id;
       this.lance = lance;
       this.peso = peso;
       this.ud = ud;
       this.pesodescarte = pesodescarte;
       this.uddescarte = uddescarte;
    }
   
    public PescaId getId() {
        return this.id;
    }
    
    public void setId(PescaId id) {
        this.id = id;
    }
    public Lance getLance() {
        return this.lance;
    }
    
    public void setLance(Lance lance) {
        this.lance = lance;
    }
    public Float getPeso() {
        return this.peso;
    }
    
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    public Long getUd() {
        return this.ud;
    }
    
    public void setUd(Long ud) {
        this.ud = ud;
    }
    public Float getPesodescarte() {
        return this.pesodescarte;
    }
    
    public void setPesodescarte(Float pesodescarte) {
        this.pesodescarte = pesodescarte;
    }
    public Float getUddescarte() {
        return this.uddescarte;
    }
    
    public void setUddescarte(Float uddescarte) {
        this.uddescarte = uddescarte;
    }




}


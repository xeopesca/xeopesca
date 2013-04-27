package com.xeopesca.webapp.buscador;
// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.Set;

/**
 * Faena Buscador
 */
public class FaenaBuscador  implements java.io.Serializable {


     private long id;
     private String arte;
     private String barco;
     private String dataInicio;
     private Date horaInicio;
     private String dataFin;
     private Date horaFin;
     private Float tempAire;
     private String estadoMar;
     private Float tempSuperficie;
     private Float direccionVento;
     private Float velocidadeVento;
     private Float tempFondo;
     private Integer lua;
    
    public FaenaBuscador() {
    }
    
	
    public FaenaBuscador(long id, String arte, String barco) {
        this.id = id;
        this.arte = arte;
        this.barco = barco;
    }
    public FaenaBuscador(long id, String arte, String barco, String dataInicio, Date horaInicio, String dataFin, Date horaFin, Float tempAire, String estadoMar, Float tempSuperficie, Float direccionVento, Float velocidadeVento, Float tempFondo, Integer lua, Set lances) {
       this.id = id;
       this.arte = arte;
       this.barco = barco;
       this.dataInicio = dataInicio;
       this.horaInicio = horaInicio;
       this.dataFin = dataFin;
       this.horaFin = horaFin;
       this.tempAire = tempAire;
       this.estadoMar = estadoMar;
       this.tempSuperficie = tempSuperficie;
       this.direccionVento = direccionVento;
       this.velocidadeVento = velocidadeVento;
       this.tempFondo = tempFondo;
       this.lua = lua;
     
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
  
    public String getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getDataFin() {
        return this.dataFin;
    }
    
    public void setDataFin(String dataFin) {
        this.dataFin = dataFin;
    }
    public Date getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    public Float getTempAire() {
        return this.tempAire;
    }
    
    public void setTempAire(Float tempAire) {
        this.tempAire = tempAire;
    }
    public String getEstadoMar() {
        return this.estadoMar;
    }
    
    public void setEstadoMar(String estadoMar) {
        this.estadoMar = estadoMar;
    }
    public Float getTempSuperficie() {
        return this.tempSuperficie;
    }
    
    public void setTempSuperficie(Float tempSuperficie) {
        this.tempSuperficie = tempSuperficie;
    }
    public Float getDireccionVento() {
        return this.direccionVento;
    }
    
    public void setDireccionVento(Float direccionVento) {
        this.direccionVento = direccionVento;
    }
    public Float getVelocidadeVento() {
        return this.velocidadeVento;
    }
    
    public void setVelocidadeVento(Float velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }
    public Float getTempFondo() {
        return this.tempFondo;
    }
    
    public void setTempFondo(Float tempFondo) {
        this.tempFondo = tempFondo;
    }
    public Integer getLua() {
        return this.lua;
    }
    
    public void setLua(Integer lua) {
        this.lua = lua;
    }


	public String getArte() {
		return arte;
	}


	public void setArte(String arte) {
		this.arte = arte;
	}


	public String getBarco() {
		return barco;
	}


	public void setBarco(String barco) {
		this.barco = barco;
	}




}



package com.xeopesca.webapp.view;

// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.Set;

/**
 * Faena Buscador
 */
public class FaenaBuscador implements java.io.Serializable {

	private long id;

	private String dataInicio;
	private String dataFin;
	private String barco;
	private String arte;
	private String especies;
	private Integer lua;
	private Integer estadoMar;
	private Integer estadoCeo;
	private Integer direccionVento;

	private Float tempAire;
	private Float tempSuperficie;
	private Float velocidadeVento;
	private Float tempFondo;

	private Date horaFin;
	private Date horaInicio;

	public FaenaBuscador() {
	}

	public Integer getEstadoMar() {
		return estadoMar;
	}

	public void setEstadoMar(Integer estadoMar) {
		this.estadoMar = estadoMar;
	}

	public Integer getEstadoCeo() {
		return estadoCeo;
	}

	public void setEstadoCeo(Integer estadoCeo) {
		this.estadoCeo = estadoCeo;
	}

	public Integer getDireccionVento() {
		return direccionVento;
	}

	public void setDireccionVento(Integer direccionVento) {
		this.direccionVento = direccionVento;
	}

	public FaenaBuscador(long id, String arte, String barco) {
		this.id = id;
		this.arte = arte;
		this.barco = barco;
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

	public Float getTempSuperficie() {
		return this.tempSuperficie;
	}

	public void setTempSuperficie(Float tempSuperficie) {
		this.tempSuperficie = tempSuperficie;
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

	public String getEspecies() {
		return especies;
	}

	public void setEspecies(String especies) {
		this.especies = especies;
	}

}

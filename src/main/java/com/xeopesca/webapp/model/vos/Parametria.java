package com.xeopesca.webapp.model.vos;

// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;

/**
 * Usuario generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "parametria")
public class Parametria implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	private String parametro;
	private String literal;
	private String valor;
	
	
	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id = id;
	}
	
	public String getLiteral() {
		return literal;
	}
	public void setLiteral(String literal) {
		this.literal = literal;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	
	
	

}
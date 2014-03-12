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
package com.xeopesca.webapp.model.vos;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

/**
 * Lance generated by hbm2java
 */
@Entity
@Table(name = "lance")
public class Lance  implements java.io.Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(generator = "increment")
	 @GenericGenerator(name = "increment", strategy = "increment")
     private long id;
     private Long idfaena;  
     private String descripcion;
     
     @Type(type = "org.hibernate.spatial.GeometryType")
 	 private Point punto_inicio;
     
     @Type(type = "org.hibernate.spatial.GeometryType")
  	 private Point punto_fin;
     
     @JoinColumn(name = "idfaena",insertable=false, updatable=false)
     @ManyToOne(optional = false, fetch = FetchType.LAZY)
     private Faena faena;
     
     @OneToMany(cascade={CascadeType.ALL})
     @JoinColumn(name="idlance")
     private List<Pesca> listaPesca;

     
     public List<Pesca> getListaPesca() {
		return listaPesca;
	}

	public void setListaPesca(List<Pesca> listaPesca) {
		this.listaPesca = listaPesca;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




	public Long getIdfaena() {
		return idfaena;
	}

	public void setIdfaena(Long idfaena) {
		this.idfaena = idfaena;
	}


	public Point getPunto_inicio() {
		return punto_inicio;
	}

	public void setPunto_inicio(Point punto_inicio) {
		this.punto_inicio = punto_inicio;
	}

	public Point getPunto_fin() {
		return punto_fin;
	}

	public void setPunto_fin(Point punto_fin) {
		this.punto_fin = punto_fin;
	}

	public Faena getFaena() {
		return faena;
	}

	public void setFaena(Faena faena) {
		this.faena = faena;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}



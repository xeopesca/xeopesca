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

// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Especie generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "especie")
public class Especie implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	
	private String nomecientifico;
	
    //--@ Length(max = 255, message = "O path non pode ser maior a 255 caracteres") 
	private String path;
   

	public Especie() {
	}

	public Especie(long id) {
		this.id = id;
	}

	public Especie(long id, String nomeCientifico, String path, Set nomepopulars) {
		this.id = id;
		this.nomecientifico = nomeCientifico;
		this.path = path;
		// this.nomepopulars = nomepopulars;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
//	Para mostrar mensaxe de validación empregamos unha definición creada por defecto polo propio framework
//	que non é necesario indicar aquí, adaptamos a mensaxe para internacionalización no properties: NotBlank.especie.nomecientifico
	@NotBlank
	public String getnomecientifico() {
		return this.nomecientifico;
	}

	
	public void setnomecientifico(String nomeCientifico) {
		this.nomecientifico = nomeCientifico;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	/*
	 * public Set getNomepopulars() { return this.nomepopulars; }
	 * 
	 * public void setNomepopulars(Set nomepopulars) { this.nomepopulars =
	 * nomepopulars; }
	 */

}

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
package com.xeopesca.webapp.model.vos;

// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Arte generated by hbm2java
 */
@Entity
@Table(name = "arte")
public class Arte implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@NotBlank ( message = "A actividade non pode estar valeira")
	private String actividade;
	@NotBlank ( message = "A categor�a  non pode estar valeira")
	private String categoria;
	@NotBlank ( message = "O nome non pode estar valeiro")
	private String nome;
	private String path;
	private String descripcion;

	// private Set faenas = new HashSet(0);
	// private Set barcos = new HashSet(0);

	public Arte() {
	}

	public Arte(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Arte(long id, String actividade, String categoria, String nome,
			String path, String descripcion, Set faenas, Set barcos) {
		this.id = id;
		this.actividade = actividade;
		this.categoria = categoria;
		this.nome = nome;
		this.path = path;
		this.descripcion = descripcion;
		// this.faenas = faenas;
		// this.barcos = barcos;
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
	/*
	 * public Set getFaenas() { return this.faenas; }
	 * 
	 * public void setFaenas(Set faenas) { this.faenas = faenas; } public Set
	 * getBarcos() { return this.barcos; }
	 * 
	 * public void setBarcos(Set barcos) { this.barcos = barcos; }
	 */

}

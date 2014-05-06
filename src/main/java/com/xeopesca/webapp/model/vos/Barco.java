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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Barco generated by hbm2java
 */
@Entity
@Table(name = "barco")
public class Barco  implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	private String folio;
	private String nome;
	private Long eslora;
	private String porto;
	private Long idarmador;
	private Long idpatron;
	
	//-----
	 @JoinColumn(name = "idarmador",insertable=false, updatable=false)
     @OneToOne(optional = false, fetch = FetchType.LAZY)
     private Usuario armador;
	 
	 @JoinColumn(name = "idpatron",insertable=false, updatable=false)
     @OneToOne(optional = false, fetch = FetchType.LAZY)
     private Usuario patron;
	 
	
	//---
	 
    
    public Usuario getPatron() {
		return patron;
	}


	public void setPatron(Usuario patron) {
		this.patron = patron;
	}


	public Usuario getArmador() {
		return armador;
	}


	public void setArmador(Usuario armador) {
		this.armador = armador;
	}


	public Barco() {
    }

	
    public Barco(String folio, String nome) {
        this.folio = folio;
        this.nome = nome;
    }
  
    public Barco(String folio, String nome, Long eslora, String porto, long idarmador, long idpatron) {
        this.folio = folio;
        this.nome = nome;
        this.eslora = eslora;
        this.porto = porto;
        this.idarmador = idarmador;
        this.idpatron = idarmador;
     }
    
    public Barco(String folio, Tipoloxiabarco tipoloxiabarco, Usuario usuario, String nome, Long eslora, String porto, Set usuarios, Set artes, Set faenas) {
       this.folio = folio;
       this.nome = nome;
       this.eslora = eslora;
       this.porto = porto;

    }
   
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getEslora() {
        return this.eslora;
    }
    
    public void setEslora(Long eslora) {
        this.eslora = eslora;
    }
    public String getPorto() {
        return this.porto;
    }
    
    public void setPorto(String porto) {
        this.porto = porto;
    }

   
	public Long getIdpatron() {
		return idpatron;
	}


	public void setIdpatron(Long idpatron) {
		this.idpatron = idpatron;
	}


	public Long getIdarmador() {
		return idarmador;
	}


	public void setIdarmador(Long idarmador) {
		this.idarmador = idarmador;
	}

	


}



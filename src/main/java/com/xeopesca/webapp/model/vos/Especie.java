package com.xeopesca.webapp.model.vos;

// Generated 05-oct-2012 22:49:11 by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 * Especie generated by hbm2java
 */
@Entity
@Table(name = "especie")
public class Especie implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	@NotBlank ( message = "O nome científico non pode estar valeiro")
	private String nomecientifico;
	
    @Length(max = 255, message = "O path non pode ser maior a 255 caracteres") 
	private String path;
    
    @Transient
	MultipartFile file;


	// private Set nomepopulars = new HashSet(0);

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

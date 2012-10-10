package com.xeopesca.webapp.model.vos;

import com.vividsolutions.jts.geom.Point;
import com.xeopesca.util.dao.GenericDaoHibernate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Karel Maesen, Geovise BVBA creation-date: 6/18/12
 */
@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	private String title;

	private Date date;
	

	@Type(type = "org.hibernate.spatial.GeometryType")
	private Point location;

	public Evento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Point getLocation() {
		return this.location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
	public String toSting (){
		return ("Event: " + this.getTitle() + ", Time: "
				+ this.getDate() + ", Location: " + this.getLocation()+" ID: "+this.getId());

	}
}

package com.xeopesca.webapp.view;


import java.util.List;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.xeopesca.util.GeometryUtil;
import com.xeopesca.webapp.model.vos.Lance;


public class LanceView  implements java.io.Serializable {

	
     private long id;
     private Long idfaena;  
     private String descripcion;
     
 	 private String punto_inicio;
 	 

 	 public Lance convertToLance(){
 		 Lance saida = new Lance();
 		 saida.setDescripcion(this.getDescripcion());
 		// saida.setFaena(faena)
 		 saida.setIdfaena(this.idfaena);
 		 saida.setId(this.id);
 		
 		 Geometry punto = GeometryUtil.wktToGeometry("POINT ("+this.punto_inicio+")");
 		 saida.setPunto_inicio((Point)punto);
 		 
 		 
 		 return saida;
 		 
 	 }
 	 
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPunto_inicio() {
		return punto_inicio;
	}

	public void setPunto_inicio(String punto_inicio) {
		this.punto_inicio = punto_inicio;
	}
     
  	


}



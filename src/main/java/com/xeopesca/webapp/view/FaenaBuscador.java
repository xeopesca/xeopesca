package com.xeopesca.webapp.view;

import java.util.ArrayList;
import java.util.List;

import com.xeopesca.util.HelperDateUtil;
import com.xeopesca.webapp.model.vos.Faena;



/**
 * Faena Buscador
 */
@SuppressWarnings("serial")
public class FaenaBuscador implements java.io.Serializable {

	private long id;
	
	private Long   idbarco;
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

	private String horaFin;
	private String horaInicio;

	public FaenaBuscador() {
	}
	
	public static Faena convertFaenaBuscardorToFaena(FaenaBuscador faenaB){
		
		Faena f = new Faena();
		if (faenaB.getArte()!=null && !faenaB.getArte().isEmpty()){
	 		f.setIdarte(new Long (faenaB.getArte()));
		}
 		//datainicio
 		if (faenaB.getDataInicio()!= null && faenaB.getDataInicio().length()>0){
 	 	 	f.setData_inicio(HelperDateUtil.StringToDate(faenaB.getDataInicio()));
 		}
 		else{
 			f.setData_inicio(null);
 		}
 		//Data fin
 		if (faenaB.getDataFin()!= null && faenaB.getDataFin().length()>0){
 	 	 	f.setData_fin(HelperDateUtil.StringToDate(faenaB.getDataFin()));
 		}
 		else{
 			f.setData_fin(null);
 		}
 	 	//hora inicio
 		if (faenaB.getHoraInicio()!=null && faenaB.getHoraInicio().length()>0){
 	 		f.setHora_inicio(HelperDateUtil.StringToTime(faenaB.getHoraInicio()));
 		}else{
 			f.setHora_inicio(null);
 		}
 		
 			
 		//hora fin
 		if (faenaB.getHoraFin()!=null && faenaB.getHoraFin().length()>0){
 	 		f.setHora_fin(HelperDateUtil.StringToTime(faenaB.getHoraFin()));
 		}else{
 			f.setHora_fin(null);
 		}
 		
 		f.setLua(faenaB.getLua());
 		f.setTemp_aire(faenaB.getTempAire());
 		f.setTemp_superficie(faenaB.getTempSuperficie());
 		f.setTemp_fondo(faenaB.getTempFondo());
 		f.setEstado_mar(faenaB.getEstadoMar()); 
		f.setVelocidade_vento(faenaB.getVelocidadeVento());
		f.setDireccion_vento(faenaB.getDireccionVento());
		if (faenaB.getIdbarco() != null){
			f.setIdbarco(faenaB.getIdbarco());
		}else{
			//f.setIdbarco(null);
		}
		
		f.setEstado_ceo(faenaB.getEstadoCeo());
		
		return f;
	}
	
	public static FaenaBuscador convertFaenaToFaenaBuscardor(Faena faena){
		
		
		FaenaBuscador fb = new FaenaBuscador();
		
		fb.setArte( Long.toString(faena.getIdarte()));
 		//datainicio
		fb.setDataInicio(HelperDateUtil.DateToString(faena.getData_inicio()));
		
 		//Data fin
		fb.setDataFin(HelperDateUtil.DateToString(faena.getData_fin()));
 	 	//hora inicio
		fb.setHoraInicio(HelperDateUtil.TimeToString(faena.getHora_inicio()));
 		//hora fin
		fb.setHoraFin(HelperDateUtil.TimeToString(faena.getHora_fin()));
		//lua
		fb.setLua(faena.getLua());
		//Aire
		fb.setTempAire(faena.getTemp_aire());
		//Temp superficie
		fb.setTempSuperficie(faena.getTemp_superficie());
		//Temp fonde
		fb.setTempFondo(faena.getTemp_fondo());
		//Estado mar
		fb.setEstadoMar(faena.getEstado_mar());
		//Velocidade vento
		fb.setVelocidadeVento(faena.getVelocidade_vento());
		//Dir Vento
		fb.setDireccionVento(faena.getDireccion_vento());
		//Id Barco
		fb.setIdbarco(faena.getIdbarco());
		//Estado ceo
		fb.setEstadoCeo(faena.getEstado_ceo());
		//ID
		fb.setId(faena.getId());

		return fb;
	}
	
	public static List<FaenaBuscador> convertFaenaToListFaenaBuscardor (List<Faena> lista){
		List<FaenaBuscador>saida =  new  ArrayList<FaenaBuscador>();
		if (lista != null){
			for (int i= 0; i < lista.size(); i++)
			{
				saida.add(FaenaBuscador.convertFaenaToFaenaBuscardor(lista.get(i)));
			}
			
		}
		
		
		return saida;
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

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getDataFin() {
		return this.dataFin;
	}

	public void setDataFin(String dataFin) {
		this.dataFin = dataFin;
	}

	public String getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(String horaFin) {
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

	public Long getIdbarco() {
		return idbarco;
	}

	public void setIdbarco(Long idbarco) {
		this.idbarco = idbarco;
	}

}

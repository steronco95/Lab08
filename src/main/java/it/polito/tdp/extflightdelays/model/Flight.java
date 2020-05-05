package it.polito.tdp.extflightdelays.model;

import java.time.LocalDateTime;

public class Flight {

	private int areoportoPartenza;
	private int areoportoArrivo;
	private float distanzaMedia;

	public Flight(int partenza, int arrivo, float distMedia) {
		
		this.areoportoPartenza = partenza;
		this.areoportoArrivo = arrivo;
		this.distanzaMedia = distMedia;
		
	}

	public int getAreoportoPartenza() {
		return areoportoPartenza;
	}

	public void setAreoportoPartenza(int areoportoPartenza) {
		this.areoportoPartenza = areoportoPartenza;
	}

	public int getAreoportoArrivo() {
		return areoportoArrivo;
	}

	public void setAreoportoArrivo(int areoportoArrivo) {
		this.areoportoArrivo = areoportoArrivo;
	}

	public float getDistanzaMedia() {
		return distanzaMedia;
	}

	public void setDistanzaMedia(float distanzaMedia) {
		this.distanzaMedia = distanzaMedia;
	}
	
	public String toString() {
		
		return this.areoportoPartenza + " " + this.areoportoArrivo + " " + this.distanzaMedia;
		
	}
	

	

}

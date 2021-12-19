package model;

import java.time.LocalDateTime;

public class Rezervacija {
	
	private int brojMesta;
	private LocalDateTime vreme;
	private LocalDateTime kreirana;
	private boolean otkazana;
	private Gost gost;
	
	public Rezervacija() {}

	public Rezervacija(int brojMesta, LocalDateTime vreme, LocalDateTime kreirana, boolean otkazana, Gost gost) {
		super();
		this.brojMesta = brojMesta;
		this.vreme = vreme;
		this.kreirana = kreirana;
		this.otkazana = otkazana;
		this.gost = gost;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public LocalDateTime getVreme() {
		return vreme;
	}

	public void setVreme(LocalDateTime vreme) {
		this.vreme = vreme;
	}

	public LocalDateTime getKreirana() {
		return kreirana;
	}

	public void setKreirana(LocalDateTime kreirana) {
		this.kreirana = kreirana;
	}

	public boolean isOtkazana() {
		return otkazana;
	}

	public void setOtkazana(boolean otkazana) {
		this.otkazana = otkazana;
	}

	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}
}

package model;

import java.time.LocalDate;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cena")
public class Cena {

	private float vrednost;
	private float popust;
	private LocalDate kreirana;
	
	public Cena() {}
	
	public Cena(float vrednost, float popust, LocalDate kreirana) {
		this.vrednost = vrednost;
		this.popust = popust;
		this.kreirana = kreirana;
	}
	
	public float getVrednost() {
		return this.vrednost;
	}
	
	public void setVrednost(float vrednost) {
		this.vrednost = vrednost;
	}
	
	public float getPopust() {
		return this.popust;
	}
	
	public void setPopust(float popust) {
		this.popust = popust;
	}
	
	public float getCena() {
		return vrednost - vrednost*(popust/100);
	}
	
	public void setKreirana(LocalDate kreirana) {
		this.kreirana = kreirana;
	}
	
	public LocalDate getKreirana() {
		return this.kreirana;
	}
}

package model;

import java.time.LocalDate;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cena")
public class Cena {

	private long id;
	private float vrednost;
	private float popust;
	private LocalDate kreirana;
	
	public Cena() {}
	
	public Cena(long id, float vrednost, float popust, LocalDate kreirana) {
		this.id = id;
		this.vrednost = vrednost;
		this.popust = popust;
		this.kreirana = kreirana;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

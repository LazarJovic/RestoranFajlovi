package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("tipJela")
public class TipJela {
	
	private long id;
	private String naziv;
	
	public TipJela() {}

	public TipJela(String naziv) {
		this.naziv = naziv;
	}
	
	public TipJela(long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}

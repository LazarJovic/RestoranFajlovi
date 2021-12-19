package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("jelo")
public class Jelo {
	
	private long id;
	private String naziv;
	private String opis;
	private String recept;
	private boolean uklonjeno;
	private TipJela tipJela;
	private SlikaJela slikaJela;
	
	public Jelo() {}
	
	public Jelo(long id, String naziv, String opis, String recept, boolean uklonjeno, TipJela tipJela, SlikaJela slikaJela) {
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.recept = recept;
		this.uklonjeno = uklonjeno;
		this.tipJela = tipJela;
		this.slikaJela = slikaJela;
	}

	public long getId() {
		return id;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getRecept() {
		return recept;
	}

	public void setRecept(String recept) {
		this.recept = recept;
	}

	public boolean isUklonjeno() {
		return uklonjeno;
	}

	public void setUklonjeno(boolean uklonjeno) {
		this.uklonjeno = uklonjeno;
	}

	public TipJela getTipJela() {
		return tipJela;
	}

	public void setTipJela(TipJela tipJela) {
		this.tipJela = tipJela;
	}

	public SlikaJela getSlikaJela() {
		return slikaJela;
	}

	public void setSlikaJela(SlikaJela slikaJela) {
		this.slikaJela = slikaJela;
	}
}

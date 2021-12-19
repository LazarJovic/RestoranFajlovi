package model;

public class JeloCena {
	
	private long jeloId;
	private String nazivJela;
	private String opisJela;
	private float cenaJela;
	private String putanjaSlike;
	private String nazivTipaJela;
	
	public JeloCena() {}
	
	public JeloCena(long jeloId, String nazivJela, String opisJela, float cenaJela, String putanjaSlike, String nazivTipaJela) {
		this.jeloId = jeloId;
		this.nazivJela = nazivJela;
		this.opisJela = opisJela;
		this.cenaJela = cenaJela;
		this.putanjaSlike = putanjaSlike;
		this.nazivTipaJela = nazivTipaJela;
	}

	public long getJeloId() {
		return jeloId;
	}

	public void setJeloId(long jeloId) {
		this.jeloId = jeloId;
	}

	public String getNazivJela() {
		return nazivJela;
	}

	public void setNazivJela(String nazivJela) {
		this.nazivJela = nazivJela;
	}

	public String getOpisJela() {
		return opisJela;
	}

	public void setOpisJela(String opisJela) {
		this.opisJela = opisJela;
	}

	public float getCenaJela() {
		return cenaJela;
	}

	public void setCenaJela(float cenaJela) {
		this.cenaJela = cenaJela;
	}

	public String getPutanjaSlike() {
		return putanjaSlike;
	}

	public void setPutanjaSlike(String putanjaSlike) {
		this.putanjaSlike = putanjaSlike;
	}

	public String getNazivTipaJela() {
		return nazivTipaJela;
	}

	public void setNazivTipaJela(String nazivTipaJela) {
		this.nazivTipaJela = nazivTipaJela;
	}
}

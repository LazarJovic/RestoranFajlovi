package model;

import enums.Uloga;

public class KorisnickiNalog {
	
	private String lozinka;
	private String korisnickoIme;
	private Uloga uloga;
	
	public KorisnickiNalog() {}

	public KorisnickiNalog(String korisnickoIme, String lozinka, Uloga uloga) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	
	public boolean promenaLozinke(String novaLozinka) {
		return true; //TODO: Implementiraj metodu za promenu lozinke
	}
}

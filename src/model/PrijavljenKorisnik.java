package model;

import enums.Uloga;

public class PrijavljenKorisnik {

	private static PrijavljenKorisnik instance = null;
	
	private String korisnickoIme;
	private Uloga uloga;
	
	private PrijavljenKorisnik() {}
	
	public static PrijavljenKorisnik getInstance() {
		if (instance == null) {
			instance = new PrijavljenKorisnik();
		}
		
		return instance;
	}
	
	public static void setInstanceToNull() {
		instance = null;
	}
	
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}
	
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	
	public Uloga getUloga() {
		return this.uloga;
	}
}

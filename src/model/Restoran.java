package model;

import java.util.Set;

public class Restoran {
	
	private String naziv;
	private String telefon;
	private String adresa;
	private String mesto;
	private String email;
	private Set<TipJela> tipoviJela;
	private Set<Korisnik> korisnici;
	private Set<Rezervacija> rezervacije;
	
	public Restoran() {}

	public Restoran(String naziv, String telefon, String adresa, String mesto, String email) {
		super();
		this.naziv = naziv;
		this.telefon = telefon;
		this.adresa = adresa;
		this.mesto = mesto;
		this.email = email;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<TipJela> getTipoviJela() {
		return tipoviJela;
	}

	public void setTipoviJela(Set<TipJela> tipoviJela) {
		this.tipoviJela = tipoviJela;
	}

	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public Set<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
}

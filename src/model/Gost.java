package model;

import java.util.Set;

public class Gost {
	
	private String ime;
	private String prezime;
	private String telefon;
	private String email;
	private Set<Rezervacija> rezervacije;
	
	public Gost() {}
	
	public Gost(String ime, String prezime, String telefon, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
}

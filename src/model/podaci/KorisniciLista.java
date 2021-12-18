package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import model.Korisnik;

@XStreamAlias("korisniciLista")
public class KorisniciLista {
	
	public static KorisniciLista instance = null;
	
	@XStreamAlias("korisnici")	
	private ArrayList<Korisnik> korisnici;
	
	@XStreamOmitField
	private long idGenerator;
	
	private KorisniciLista() {
		this.korisnici = new ArrayList<Korisnik>();
	}
	
	public static KorisniciLista getInstance() {
		if (instance == null) {
			instance = new KorisniciLista();
		}
		
		return instance;
	}

	private long generisiId() {
		return ++idGenerator;
	}
	
	public static void setInstance(KorisniciLista korisniciLista) {
		instance = korisniciLista;
	}
	
	public ArrayList<Korisnik> getKorisnici() {
		return this.korisnici;
	}
	
	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	public void dodajKorisnika(Korisnik korisnik) {
		this.korisnici.add(korisnik);
	}
	
	public void izmeniKorisnika(String ime,String prezime,String telefon,String email,String stariEmail) {
		Korisnik korisnik = dobaviKorisnikaPoEmailAdresi(stariEmail);
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setTelefon(telefon);
		korisnik.setEmail(email);
		
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getId() == korisnik.getId()) {
				korisnici.remove(i);
				korisnici.add(i, korisnik);
			}
		}
	}
	
	public Korisnik dobaviKorisnikaPoKorisnickomImenu(String korisnickoIme) {
		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
				.stream()
				.filter(korisnik -> korisnik.getKorisnickiNalog().getKorisnickoIme().equals(korisnickoIme))
				.collect(Collectors.toList());
		if (korisnikLista.size() == 0) {
			return null;
		}
		
		return korisnikLista.get(0);
	}
	
	public Korisnik dobaviKorisnikaPoEmailAdresi(String email) {
		ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
				.stream()
				.filter(korisnik -> korisnik.getEmail().equals(email))
				.collect(Collectors.toList());
		if (korisnikLista.size() == 0) {
			return null;
		}
		
		return korisnikLista.get(0);
	}
}
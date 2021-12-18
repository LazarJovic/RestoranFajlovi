package observer;

import java.util.EventObject;

import model.Korisnik;

public class IzmenaKorisnikaEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1334177919567093006L;
	private Korisnik korisnik;
	
	public IzmenaKorisnikaEvent(Korisnik korisnik) {
		super("Izmena korisnika");
		this.korisnik = korisnik;
	}
	
	public Korisnik getKorisnik() {
		return this.korisnik;
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
}

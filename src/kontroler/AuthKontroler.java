package kontroler;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import model.Korisnik;
import model.PrijavljenKorisnik;
import model.podaci.KorisniciLista;
import util.Bezbednost;

public class AuthKontroler {
	
	public AuthKontroler() {}
	
	public String login(String korisnickoIme, String lozinka) throws MissingValueException, BadCredentialsException {
		if (checkIfNullOrEmpty(korisnickoIme)) {
			throw new MissingValueException("Nije validno uneto korisničko ime.");
		} else if (checkIfNullOrEmpty(lozinka)) {
			throw new MissingValueException("Nije validno uneta lozinka.");
		}
		
		Korisnik korisnik = KorisniciLista.getInstance().dobaviKorisnikaPoKorisnickomImenu(korisnickoIme);
		if (korisnik == null || !korisnik.getKorisnickiNalog().getLozinka().equals(Bezbednost.generisiHashLozinke(lozinka))) {
			throw new BadCredentialsException("Uneseni kredencijali nisu odgovarajući.");
		}
		
		PrijavljenKorisnik prijavljenKorisnik = PrijavljenKorisnik.getInstance();
		prijavljenKorisnik.setKorisnickoIme(korisnickoIme);
		prijavljenKorisnik.setUloga(korisnik.getKorisnickiNalog().getUloga());
		
		return korisnik.getKorisnickiNalog().getUloga().toString();
	}
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}
}

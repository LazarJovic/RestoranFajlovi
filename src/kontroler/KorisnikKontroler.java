package kontroler;

import java.sql.SQLException;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.ResultEmptyException;
import izuzeci.UniqueValueException;
import model.Korisnik;
import model.podaci.KorisniciLista;
import util.Validacija;

public class KorisnikKontroler {
	
	private Korisnik korisnik;
	
	public KorisnikKontroler() {}
	
	public Korisnik dobaviKorisnikaPoKorImenu(String korisnickoIme) throws ResultEmptyException {
		Korisnik korisnik = KorisniciLista.getInstance().dobaviKorisnikaPoKorisnickomImenu(korisnickoIme);
		if (korisnik == null) {
			throw new ResultEmptyException("Ne postoji korisnik sa korisničkim imenom " + korisnickoIme);
		}
		
		return korisnik;
	}
	
	public void izmeniKorisnika(String ime, String prezime, String telefon, String email, String stariEmail) throws MissingValueException, SQLException, BadFormatException, UniqueValueException {
		if (Validacija.praznaIliNepostojecaVrednost(ime)) {
			throw new MissingValueException("Nije validno uneto ime.");
		} else if (Validacija.praznaIliNepostojecaVrednost(prezime)) {
			throw new MissingValueException("Nije validno uneto prezime.");
		} else if (Validacija.praznaIliNepostojecaVrednost(telefon)) {
			throw new MissingValueException("Nije validno unet telefon.");
		} else if (!Validacija.validanTelefon(telefon)) {
			throw new BadFormatException("Broj telefona može da sadrži samo cifre 0-9.");
		} else if (Validacija.praznaIliNepostojecaVrednost(email)) {
			throw new MissingValueException("Nije validno uneta email adresa.");
		} else if (!Validacija.validanEmail(email)) {
			throw new BadFormatException("Email adresa nije uneta u validnom formatu. Mora biti oblika text@text.text");
		} else if (KorisniciLista.getInstance().dobaviKorisnikaPoEmailAdresi(email) != null && !email.equals(stariEmail)) {
			throw new UniqueValueException("Uneta email adresa je već registrovana.");
		}
		
		KorisniciLista.getInstance().izmeniKorisnika(ime, prezime, telefon, email, stariEmail);
		korisnik.azurirajKorisnika(ime, prezime, telefon, email);
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
}

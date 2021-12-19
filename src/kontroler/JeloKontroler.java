package kontroler;

import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.NotSavedException;
import izuzeci.ResultEmptyException;
import model.Cena;
import model.Cenovnik;
import model.Jelo;
import model.JeloCena;
import model.SlikaJela;
import model.TipJela;
import model.podaci.CenovnikLista;
import model.podaci.JelaLista;
import model.podaci.TipJelaLista;
import util.Fajlovi;
import util.Validacija;

public class JeloKontroler {

	private List<JeloCena> jela;
	
	public JeloKontroler() {
		jela = new ArrayList<JeloCena>();
	}
	
	public List<JeloCena> dobaviJelaSaCenama() throws ResultEmptyException {
		HashMap<Long, Cena> najnovijeCene = CenovnikLista.getInstance().dobaviNajnovijeCeneZaJela();
		for (Jelo jelo : JelaLista.getInstance().getJela()) {
			jela.add(new JeloCena(jelo.getId(), jelo.getNaziv(), jelo.getOpis(),
					najnovijeCene.get(jelo.getId()).getVrednost(), jelo.getSlikaJela().getPutanja(), jelo.getTipJela().getNaziv()));
		}
		
		if (jela.size() == 0) {
			throw new ResultEmptyException("Nema jela dodatih u jelovnik.");
		}
		
		return jela;
	}
	
	public JeloCena dodajJelo(String naziv, String tipJela, String opis, String recept, String cena, File selektovanaSlika) throws
	MissingValueException, BadFormatException, NotSavedException {
		if (Validacija.praznaIliNepostojecaVrednost(naziv)) {
			throw new MissingValueException("Nije unet naziv jela.");
		} else if (Validacija.praznaIliNepostojecaVrednost(tipJela)) {
			throw new MissingValueException("Nije odabran tip jela.");
		} else if (Validacija.praznaIliNepostojecaVrednost(opis)) {
			throw new MissingValueException("Nije uent opis jela.");
		} else if (Validacija.praznaIliNepostojecaVrednost(recept)) {
			throw new MissingValueException("Nije validno unet recept jela.");
		} else if (selektovanaSlika == null) {
			throw new MissingValueException("Nije odabrana slika jela.");
		}
		
		try {
			Float.parseFloat(cena);
		} catch (NumberFormatException e) {
			throw new BadFormatException("Cena jela treba da bude broj.");
		}
		
		Image slika = Fajlovi.dobaviSlikuOdFajla(selektovanaSlika);
		boolean sacuvana = Fajlovi.sacuvajSliku(selektovanaSlika, slika);
		
		if (!sacuvana) {
			throw new NotSavedException("Slika nije uspešno sačuvana!");
		}
		
		JelaLista jelaLista = JelaLista.getInstance();
		TipJelaLista tipJelaLista = TipJelaLista.getInstance();
		CenovnikLista cenovnikLista = CenovnikLista.getInstance();
		TipJela tip = tipJelaLista.dobaviTipPoNazivu(tipJela);
		
		long jeloId = jelaLista.generisiId();
		float cenaVrednost = Float.parseFloat(cena);
		String putanjaSlike = "/" + selektovanaSlika.getName();
		
		jelaLista.dodajJelo(new Jelo(jeloId, naziv, opis, recept, false, tip, new SlikaJela(putanjaSlike)));
		ArrayList<Cena> cene = new ArrayList<Cena>(Arrays.asList(new Cena(Float.parseFloat(cena), 0, LocalDate.now())));
		cenovnikLista.dodajCenovnik(new Cenovnik(cenovnikLista.generisiId(), cene));
		
		return new JeloCena(jeloId, naziv, opis, cenaVrednost, putanjaSlike, tipJela);
	}
}

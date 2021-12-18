package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import enums.Uloga;
import model.KorisnickiNalog;
import model.Korisnik;
import model.podaci.KorisniciLista;
import serijalizacija.Serijalizacija;

public class Pokretanje {
	
	public static void inicijalizujKorisnike() throws IOException {
		KorisniciLista korisniciLista = KorisniciLista.getInstance();
		Korisnik vlasnik = new Korisnik(1, "Admir", "Admirovic", "064324234", "admin@maildrop.cc", LocalDate.parse("1990-07-04"), LocalDate.parse("2008-07-04"),
				new KorisnickiNalog("admin", "240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9", Uloga.VLASNIK));
		Korisnik sef = new Korisnik(2, "Sef", "Sefic", "064568634", "sef@maildrop.cc", LocalDate.parse("1990-07-04"), LocalDate.parse("2008-07-04"),
				new KorisnickiNalog("sef", "e5751dd4aa5ecd9cbe1a5f8fc1bcc685dee27dd4949bb3305b01c19705546691", Uloga.SEF_KUHINJE));
		Korisnik menadzer = new Korisnik(3, "Menadzer", "Menadzeric", "064323251", "menadzer@maildrop.cc", LocalDate.parse("1990-07-04"), LocalDate.parse("2008-07-04"),
				new KorisnickiNalog("menadzer", "765e80b06e58c709836f8bb7e973b80c388ae3214969db59a5d60f5482efdbb7", Uloga.MENADZER));
		korisniciLista.dodajKorisnika(vlasnik);
		korisniciLista.dodajKorisnika(sef);
		korisniciLista.dodajKorisnika(menadzer);
		
		Serijalizacija serijalizacija = new Serijalizacija();
		File f = new File("./podaci/korisnici.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {
			serijalizacija.getXStream().toXML(korisniciLista, os);
		} finally {
			os.close();
		}
	}
	
}

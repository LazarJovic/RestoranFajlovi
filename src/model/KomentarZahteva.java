package model;

import java.time.LocalDateTime;

public class KomentarZahteva {
	
	private String tekst;
	private LocalDateTime kreiran;
	
	public KomentarZahteva() {}

	public KomentarZahteva(String tekst, LocalDateTime kreiran) {
		super();
		this.tekst = tekst;
		this.kreiran = kreiran;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public LocalDateTime getKreiran() {
		return kreiran;
	}

	public void setKreiran(LocalDateTime kreiran) {
		this.kreiran = kreiran;
	}
}

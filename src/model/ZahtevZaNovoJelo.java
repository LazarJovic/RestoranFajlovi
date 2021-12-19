package model;

import java.time.LocalDateTime;
import java.util.Set;

import enums.StatusZahtevaZaJelo;

public class ZahtevZaNovoJelo {
	
	private LocalDateTime kreiran;
	private StatusZahtevaZaJelo status;
	private int brojSlanja;
	private Jelo jelo;
	private Set<KomentarZahteva> komentari;
	
	public ZahtevZaNovoJelo() {}

	public ZahtevZaNovoJelo(LocalDateTime kreiran, StatusZahtevaZaJelo status, int brojSlanja, Jelo jelo) {
		super();
		this.kreiran = kreiran;
		this.status = status;
		this.brojSlanja = brojSlanja;
		this.jelo = jelo;
	}

	public LocalDateTime getKreiran() {
		return kreiran;
	}

	public void setKreiran(LocalDateTime kreiran) {
		this.kreiran = kreiran;
	}

	public StatusZahtevaZaJelo getStatus() {
		return status;
	}

	public void setStatus(StatusZahtevaZaJelo status) {
		this.status = status;
	}

	public int getBrojSlanja() {
		return brojSlanja;
	}

	public void setBrojSlanja(int brojSlanja) {
		this.brojSlanja = brojSlanja;
	}

	public Jelo getJelo() {
		return jelo;
	}

	public void setJelo(Jelo jelo) {
		this.jelo = jelo;
	}

	public Set<KomentarZahteva> getKomentari() {
		return komentari;
	}

	public void setKomentari(Set<KomentarZahteva> komentari) {
		this.komentari = komentari;
	}
	
	public void povecajBrojSlanja() {
		this.brojSlanja++;
	}
}

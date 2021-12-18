package pogled.meni;

public class MeniVlasnik extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4294229498194545072L;
	private MeniStavka stavkaZaposleni;
	private MeniStavka stavkaZahteviZaJelo;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaInfoRestorana;
	private MeniStavka stavkaOdjava;
	
	public MeniVlasnik() {
		super();
		
		stavkaZaposleni = new MeniStavka("/employees1.png", "Zaposleni");
		stavkaZahteviZaJelo = new MeniStavka("/meal1.png", "Zahtevi za jelo");
		stavkaRezervacije = new MeniStavka("/reservation1.png", "Rezervacije");
		stavkaInfoRestorana = new MeniStavka("/info1.png", "Informacije o restoranu");
		stavkaOdjava = new MeniStavka("/logout32.png", "Odjava");
		
		add(stavkaZaposleni, "wrap, align center");
		add(stavkaZahteviZaJelo, "wrap, align center");
		add(stavkaRezervacije, "wrap, align center");
		add(stavkaInfoRestorana, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
	}
	
	public MeniStavka getStavkaZaposleni() {
		return this.stavkaZaposleni;
	}
	
	public MeniStavka getStavkaZahteviZaJelo() {
		return this.stavkaZahteviZaJelo;
	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
	
	public MeniStavka getStavkaInfoRestorana() {
		return this.stavkaInfoRestorana;
	}
	
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
}

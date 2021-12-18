package pogled.meni;

public class MeniSefKuhinje extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = -670002200747993656L;
	private MeniStavka stavkaTipoviJela;
	private MeniStavka stavkaZahteviZaJelo;
	private MeniStavka stavkaOdjava;
	
	public MeniSefKuhinje() {
		super();
		
		stavkaTipoviJela = new MeniStavka("/mealType1.png", "Tipovi jela");
		stavkaZahteviZaJelo = new MeniStavka("/meal1.png", "Zahtevi za jelo");
		stavkaOdjava = new MeniStavka("/logout32.png", "Odjava");
		
		add(stavkaTipoviJela, "wrap, align center");
		add(stavkaZahteviZaJelo, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
	}
	
	public MeniStavka getStavkaTipoviJela() {
		return this.stavkaTipoviJela;
	}
	
	public MeniStavka getStavkaZahteviZaJelo() {
		return this.stavkaZahteviZaJelo;
	}
	
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
}

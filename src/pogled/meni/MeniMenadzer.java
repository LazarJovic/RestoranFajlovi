package pogled.meni;

public class MeniMenadzer extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4213576067747275882L;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaOdjava;
	
	public MeniMenadzer() {
		super();
		
		stavkaRezervacije = new MeniStavka("/reservation1.png", "Rezervacije");
		stavkaOdjava = new MeniStavka("/logout32.png", "Odjava");
		
		add(stavkaRezervacije, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
	
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
}

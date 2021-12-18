package pogled.pocetni_prozor;


public class PocetniProzorFabrika {

	public PocetniProzorFabrika() {}
	
	public PocetniProzor napraviPocetniProzor(String uloga) {
		switch (uloga) {
		case "Vlasnik":
			return new PocetniProzorVlasnik();
		case "Menadžer":
			return new PocetniProzorMenadzer();
		case "Šef kuhinje":
			return new PocetniProzorSef();
		default:
			return new PocetniProzor();
		}
	}
	
}

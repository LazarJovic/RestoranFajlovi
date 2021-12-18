package pogled.meni;

public class MeniFabrika {

	public MeniFabrika() {}
	
	public Meni napraviMeni(String uloga) {
		switch (uloga) {
		case "VLASNIK":
			return new MeniVlasnik();
		case "MENADZER":
			return new MeniMenadzer();
		case "SEF_KUHINJE":
			return new MeniSefKuhinje();
		default:
			return new Meni();
		}
	}
	
}

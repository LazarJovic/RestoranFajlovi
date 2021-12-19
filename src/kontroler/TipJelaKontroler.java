package kontroler;

import java.util.ArrayList;

import model.podaci.TipJelaLista;

public class TipJelaKontroler {
	
	public TipJelaKontroler() {}
	
	public String[] dobaviNaziveTipovaJela() {
		ArrayList<String> nazivi = TipJelaLista.getInstance().dobaviNaziveTipovaJela();
		
		String[] naziviTipovaJela = new String[nazivi.size()];
		return nazivi.toArray(naziviTipovaJela);
	}
}

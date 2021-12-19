package kontroler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import izuzeci.ResultEmptyException;
import model.Cena;
import model.Jelo;
import model.JeloCena;
import model.podaci.CenovnikLista;
import model.podaci.JelaLista;

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
	
}

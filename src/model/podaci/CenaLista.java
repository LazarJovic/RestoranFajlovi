package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Cena;
import model.Cenovnik;

@XStreamAlias("ceneLista")
public class CenaLista {

public static CenaLista instance = null;
	
	@XStreamAlias("cene")
	private ArrayList<Cena> cene;
	
	private CenaLista() {
		this.cene = new ArrayList<Cena>();
	}
	
	public static CenaLista getInstance() {
		if (instance == null) {
			instance = new CenaLista();
		}
		
		return instance;
	}
	
	public long generisiId() {
		int brojCena = cene.size();
		return ++brojCena;
	}
	
	public static void setInstance(CenaLista cenaLista) {
		instance = cenaLista;
	}
	
	public ArrayList<Cena> getCene() {
		return this.cene;
	}
	
	public void setCene(ArrayList<Cena> cene) {
		this.cene = cene;
	}
	
	public Cena dodajCenu(Cena cena) {
		this.cene.add(cena);
		return cena;
	}
}

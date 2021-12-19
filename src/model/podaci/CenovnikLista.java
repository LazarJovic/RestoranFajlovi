package model.podaci;

import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Cena;
import model.Cenovnik;

@XStreamAlias("cenovnikLista")
public class CenovnikLista {

	public static CenovnikLista instance = null;
	
	@XStreamAlias("cenovnik")
	private ArrayList<Cenovnik> cenovnik;
	
	private CenovnikLista() {
		this.cenovnik = new ArrayList<Cenovnik>();
	}
	
	public static CenovnikLista getInstance() {
		if (instance == null) {
			instance = new CenovnikLista();
		}
		
		return instance;
	}
	
	public long generisiId() {
		int brojCena = cenovnik.size();
		return ++brojCena;
	}
	
	public static void setInstance(CenovnikLista cenovnikLista) {
		instance = cenovnikLista;
	}
	
	public ArrayList<Cenovnik> getCenovnik() {
		return this.cenovnik;
	}
	
	public void setCenovnik(ArrayList<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	public Cenovnik dodajCenovnik(Cenovnik cenovnik) {
		this.cenovnik.add(cenovnik);
		return cenovnik;
	}
	
	public HashMap<Long, Cena> dobaviNajnovijeCeneZaJela() {
		HashMap<Long, Cena> najviseCene = new HashMap<Long, Cena>();
		for (Cenovnik cenovnik : this.cenovnik) {
			najviseCene.put(cenovnik.getJeloId(), cenovnik.dobaviNajnovijuCenu());
		}
		
		return najviseCene;
	}
}

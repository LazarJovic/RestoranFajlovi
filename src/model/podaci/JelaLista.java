package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.Jelo;

@XStreamAlias("jelaLista")
public class JelaLista {

	public static JelaLista instance = null;
	
	@XStreamAlias("jela")
	private ArrayList<Jelo> jela;
	
	private JelaLista() {
		this.jela = new ArrayList<Jelo>();
	}
	
	public static JelaLista getInstance() {
		if (instance == null) {
			instance = new JelaLista();
		}
		
		return instance;
	}
	
	public long generisiId() {
		int brojJela = jela.size();
		return ++brojJela;
	}
	
	public static void setInstance(JelaLista jelaLista) {
		instance = jelaLista;
	}
	
	public ArrayList<Jelo> getJela() {
		return this.jela;
	}
	
	public void setJela(ArrayList<Jelo> jela) {
		this.jela = jela;
	}
	
	public Jelo dodajJelo(Jelo jelo) {
		this.jela.add(jelo);
		return jelo;
	}
}

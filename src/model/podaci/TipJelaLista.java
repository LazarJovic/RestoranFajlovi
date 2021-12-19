package model.podaci;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.TipJela;

@XStreamAlias("tipoviJelaLista")
public class TipJelaLista {

	public static TipJelaLista instance = null;
	
	@XStreamAlias("tipoviJela")
	private ArrayList<TipJela> tipoviJela;
	
	private TipJelaLista() {
		this.tipoviJela = new ArrayList<TipJela>();
	}
	
	public static TipJelaLista getInstance() {
		if (instance == null) {
			instance = new TipJelaLista();
		}
		
		return instance;
	}
	
	public long generisiId() {
		int brojTipovaJela = tipoviJela.size();
		return ++brojTipovaJela;
	}
	
	public static void setInstance(TipJelaLista tipJelaLista) {
		instance = tipJelaLista;
	}
	
	public ArrayList<TipJela> getTipoviJela() {
		return this.tipoviJela;
	}
	
	public void setTipoviJela(ArrayList<TipJela> tipoviJela) {
		this.tipoviJela = tipoviJela;
	}
	
	public TipJela dodajTipJela(TipJela tipJela) {
		this.tipoviJela.add(tipJela);
		return tipJela;
	}
	
	public ArrayList<String> dobaviNaziveTipovaJela() {
		ArrayList<String> nazivi = new ArrayList<String>();
		tipoviJela.forEach(tipJela -> {
			nazivi.add(tipJela.getNaziv());
		});
		
		return nazivi;
	}
}

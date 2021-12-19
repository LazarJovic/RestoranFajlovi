package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cenovnik")
public class Cenovnik {

	private long jeloId;
	private List<Cena> cene;
	
	public Cenovnik() {
		this.cene = new ArrayList<Cena>();
	}
	
	public Cenovnik(long jeloId, ArrayList<Cena> cene) {
		this.jeloId = jeloId;
		this.cene = cene;
	}
	
	public long getJeloId() {
		return jeloId;
	}
	
	public void setJeloId(long jeloId) {
		this.jeloId = jeloId;
	}
	
	public List<Cena> getCene() {
		return cene;
	}
	
	public void setCene(ArrayList<Cena> cene) {
		this.cene = cene;
	}
	
	public Cena dobaviNajnovijuCenu() {
		return cene.stream().max(Comparator.comparing(Cena::getKreirana)).get();
	}
}

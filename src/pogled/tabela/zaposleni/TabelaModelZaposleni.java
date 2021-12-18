package pogled.tabela.zaposleni;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Korisnik;
import observer.IzmenaTabeleEvent;
import observer.Observer;
import observer.Publisher;
import util.PogledUtil;

public class TabelaModelZaposleni extends AbstractTableModel implements Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8628930585725232299L;
	private List<Korisnik> korisnici;
	private List<Observer> observers;
	
	public TabelaModelZaposleni(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	public void dodajKorisnika(Korisnik korisnik) {
		this.korisnici.add(korisnik);
	}
	
	public void izmeniKorisnika(Korisnik izmenjenKorisnik) {
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getKorisnickiNalog().getKorisnickoIme()
					.equals(izmenjenKorisnik.getKorisnickiNalog().getKorisnickoIme())) {
				korisnici.remove(i);
				korisnici.add(i, izmenjenKorisnik);
			}
		}
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return korisnici.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Ime";
		case 1:
			return "Prezime";
		case 2:
			return "Telefon";
		case 3:
			return "Email adresa";
		case 4:
			return "Uloga";
		case 5:
			return "Datum zaposlenja";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return String.class;
		case 6:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Korisnik korisnik = korisnici.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return korisnik.getIme();
		case 1:
			return korisnik.getPrezime();
		case 2:
			return korisnik.getTelefon();
		case 3:
			return korisnik.getEmail();
		case 4:
			return korisnik.getKorisnickiNalog().getUloga().toString();
		case 5:
			return PogledUtil.getFormatDatuma().format(korisnik.getDatumZaposlenja());
		case 6:
			return new JButton();
		default:
			return "";
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 6;
	}

	@Override
	public void addObserver(Observer observer) {
		if (observers == null)
			observers = new ArrayList<Observer>();
		observers.add(observer);	
	}

	@Override
	public void removeObserver(Observer observer) {
		if (null == observers)
			return;
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.updatePerformed(new IzmenaTabeleEvent());
		}
	}

}

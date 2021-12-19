package pogled.tabela.jelovnik;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.JeloCena;
import observer.IzmenaTabeleEvent;
import observer.Observer;
import observer.Publisher;

public class TabelaModelJelovnik extends AbstractTableModel implements Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987067730871371449L;
	private List<JeloCena> jelovnik;
	private List<Observer> observers;
	
	public TabelaModelJelovnik(List<JeloCena> jelovnik) {
		this.jelovnik = jelovnik;
	}
	
	public void dodajJelo(JeloCena jeloCena) {
		this.jelovnik.add(jeloCena);
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return jelovnik.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Prikaz";
		case 1:
			return "Tip jela";
		case 2:
			return "Naziv";
		case 3:
			return "Opis";
		case 4:
			return "Cena (rsd)";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Icon.class;
		case 1:
		case 2:
		case 3:
			return String.class;
		case 4:
			return Float.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		JeloCena jeloCena = jelovnik.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Image mealImage = null;
			try {
				mealImage = ImageIO.read(new File("./img/jela/" + jeloCena.getPutanjaSlike()));
			} catch (IOException e) {
				return null;
			}
			Image resizedImg = mealImage.getScaledInstance(80, 60,  java.awt.Image.SCALE_SMOOTH);
			return new ImageIcon(resizedImg);
			
		case 1:
			return jeloCena.getNazivTipaJela();
		case 2:
			return jeloCena.getNazivJela();
		case 3:
			return jeloCena.getOpisJela();
		case 4:
			return jeloCena.getCenaJela();
		default:
			return "";
		}
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

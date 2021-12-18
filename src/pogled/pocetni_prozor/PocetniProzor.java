package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import serijalizacija.Serijalizacija;

public class PocetniProzor extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7677437678594445511L;
	protected List<JPanel> paneli;
	
	public PocetniProzor() {
		setSize(new Dimension(1300, 800));
		setTitle("Sistem za upravljanje restoranom");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		addWindowListener(this);
	}
	
	protected void osveziProzor() {
		this.revalidate();
		this.repaint();
	}
	
	protected void postaviPanel(String imePanela) {
		for (JPanel panel : paneli) {
			if (panel.getName().equals(imePanela)) {
				add(panel, BorderLayout.CENTER);
			} else {
				remove(panel);
			}
		}
	}
	
	protected void zatvori() {
		this.dispose();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame frame= (JFrame) e.getComponent();
		int code=JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da želite da zatvorite aplikaciju?","Zatvaranje aplikacije?",JOptionPane.YES_NO_OPTION);
		if (code!=JOptionPane.YES_OPTION){
		
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
		else{
			Serijalizacija serijalizacija = new Serijalizacija();
			try {
				serijalizacija.sacuvaj();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Nije moguće sačuvati aplikaciju.", "Greška pri čuvanju aplikacije", JOptionPane.ERROR_MESSAGE);
			}
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

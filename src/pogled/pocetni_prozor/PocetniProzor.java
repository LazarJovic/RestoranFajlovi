package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PocetniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7677437678594445511L;
	protected List<JPanel> paneli;
	
	public PocetniProzor() {
		setSize(new Dimension(1300, 800));
		setTitle("Sistem za upravljanje restoranom");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
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
}

package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelZahteviZaJelo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6957585671582717663L;

	public PanelZahteviZaJelo() {
		setName("ZahteviZaJelo");
		JLabel lbl = new JLabel("ZAHTEVI ZA JELO");
		add(lbl);
		setVisible(true);
	}
}

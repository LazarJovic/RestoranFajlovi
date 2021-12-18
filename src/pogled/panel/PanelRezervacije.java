package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRezervacije extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2428310626343765569L;

	public PanelRezervacije() {
		setName("Rezervacije");
		JLabel lbl = new JLabel("REZERVACIJE");
		add(lbl);
		setVisible(true);
	}
}

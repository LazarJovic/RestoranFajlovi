package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfoRestorana extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7478981598463422180L;

	public PanelInfoRestorana() {
		setName("InfoRestorana");
		JLabel lbl = new JLabel("INFO");
		add(lbl);
		setVisible(true);
	}
}

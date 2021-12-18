package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTipoviJela extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5125396345868515023L;

	public PanelTipoviJela() {
		setName("TipoviJela");
		JLabel lbl = new JLabel("TIPOVI JELA");
		add(lbl);
		setVisible(true);
	}
}

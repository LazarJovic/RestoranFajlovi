package pogled;

import java.awt.Dimension;

import javax.swing.JPasswordField;

public class LozinkaPolje extends JPasswordField {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2089290195522444395L;

	public LozinkaPolje(String tekst, int width, int height) {
		setText(tekst);
		setPreferredSize(new Dimension(width, height));
	}
}

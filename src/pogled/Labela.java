package pogled;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Labela extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6919378394905955450L;

	public Labela(String tekst, Font font, Color frgColor) {
		setText(tekst);
		setFont(font);
		setForeground(frgColor);
		setName("Moja labela");
	}
}

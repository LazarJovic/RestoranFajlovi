package pogled;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import util.PogledUtil;

public class FormaDugme extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5100936599710414289L;

	public FormaDugme(String text, Color backColor, Color foreColor, int width, int height) {
		this.setText(text);
		this.setPreferredSize(new Dimension(width, height));
		this.setForeground(foreColor);
		this.setBackground(backColor);
		this.setFont(PogledUtil.getRobotoFont(13, true));
		this.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(foreColor, 2), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}
}

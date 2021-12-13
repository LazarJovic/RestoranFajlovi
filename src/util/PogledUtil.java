package util;

import java.awt.Color;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

public class PogledUtil {
	
	public static Font getRobotoFont(int velicina, boolean isBold) {
		if (isBold) {
			return new Font("roboto", Font.BOLD, velicina);
		} else {
			return new Font("roboto", Font.PLAIN, velicina);
		}
		
	}
	
	public static Font getLabelaFont() {
		return getRobotoFont(16, true);
	}
	
	public static Font getTeksPoljeFont() {
		return getRobotoFont(14, false);
	}
	
	public static Font getMaliNaslovFont() {
		return getRobotoFont(18, true);
	}
	
	public static Font getVelikiNaslovFont() {
		return getRobotoFont(24, true);
	}
	
	// zelena
	public static Color getPrimarnaBoja() {
		return new Color(16, 97, 4);
	}
	
	// siva
	public static Color getSekundarnaBoja() {
		return new Color(64, 71, 62);
	}
	
	// svetlo siva
	public static Color getTercijarnaBoja() {
		return new Color(190, 196, 188);
	}
	
	public static Color getForegroundColor() {
		return Color.WHITE;
	}
	
	public static DateTimeFormatter getFormatDatuma() {
		return DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	}
	
	public static String[] getTipoviZaposlenih() {
		String[] tipoviZaposlenih = { "Vlasnik", "Menadžer", "Šef kuhinje", "Konobar"};
		return tipoviZaposlenih;
	}
}

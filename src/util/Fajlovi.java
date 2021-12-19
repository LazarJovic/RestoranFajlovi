package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Fajlovi {

	public static boolean sacuvajSliku(File selektovanaSlika, Image slika) {
		String ekstenzija = selektovanaSlika.getName().split("\\.")[1];
		File savedFile = new File("./img/jela/" + selektovanaSlika.getName());
		 BufferedImage bi = new BufferedImage(
				 slika.getWidth(null), slika.getHeight(null),
	                BufferedImage.TYPE_INT_RGB);

	        Graphics2D graphics2D = bi.createGraphics();
	        graphics2D.drawImage(slika, 0, 0, null);
	        graphics2D.dispose();
		try {
			ImageIO.write(bi, ekstenzija, savedFile);
		} catch (IOException e1) {
			return false;
		}
		
		return true;
	}
	
	public static Image dobaviSlikuOdFajla(File selektovanaSlika) {
		ImageIcon ikonica =  new ImageIcon(selektovanaSlika.getAbsolutePath());
		return ikonica.getImage();
	}
	
}

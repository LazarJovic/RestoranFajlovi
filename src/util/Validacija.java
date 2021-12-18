package util;

public class Validacija {
	
	public static boolean praznaIliNepostojecaVrednost(String input) {
		return input == null || input.equals("");
	}
	
	public static boolean validanEmail(String email) {
		if (email.matches("(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean validanTelefon(String telefon) {
		if (telefon.matches("[0-9]+")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean validnaLozinka(String lozinka) {
		if (lozinka.length() >= 8 && proveriLozinku(lozinka)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean proveriLozinku(String str) {
	    char ch;
	    boolean postojiVelikoSlovo = false;
	    boolean postojiMaloSlovo = false;
	    boolean postojiBroj = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	        	postojiBroj = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	        	postojiVelikoSlovo = true;
	        } else if (Character.isLowerCase(ch)) {
	        	postojiMaloSlovo = true;
	        }
	        if(postojiBroj && postojiVelikoSlovo && postojiMaloSlovo)
	            return true;
	    }
	    return false;
	}
}

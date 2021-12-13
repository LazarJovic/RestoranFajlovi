package izuzeci;

public class BadFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7514790728819302492L;
	private String naslov;
	
	public BadFormatException(String message) {
		super(message);
		naslov = "Pogrešan format";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}

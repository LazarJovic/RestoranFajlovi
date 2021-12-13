package izuzeci;

public class BadCredentialsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5817151281811951018L;
	private String naslov;
	
	public BadCredentialsException(String message) {
		super(message);
		naslov = "Pogrešni kredencijali";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}

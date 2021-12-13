package izuzeci;

public class NotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8872240250376760574L;
	private String naslov;
	
	public NotFoundException(String message) {
		super(message);
		this.naslov = "Nepostojeća vrednost";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}

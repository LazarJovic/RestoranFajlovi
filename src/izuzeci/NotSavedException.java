package izuzeci;

public class NotSavedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -26858233954219702L;
	private String naslov;
	
	public NotSavedException(String message) {
		super(message);
		this.naslov = "Fajl nije sacuvan";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}


package izuzeci;

public class UniqueValueException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6585991520753742229L;
	private String naslov;
	
	public UniqueValueException(String message) {
		super(message);
		this.naslov = "Zauzeta vrednost";
	}
	
	public String getNaslov() {
		return this.naslov;
	}

}

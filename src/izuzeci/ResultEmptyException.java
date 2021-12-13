package izuzeci;

public class ResultEmptyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6585991520753742229L;
	private String naslov;
	
	public ResultEmptyException(String message) {
		super(message);
		this.naslov = "Rezultat je prazan";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}

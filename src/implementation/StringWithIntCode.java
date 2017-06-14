package implementation;

/**
 * Return type class that contains a string and an integer code.
 *
 * @author Tudor Paraschivescu
 */
public class StringWithIntCode {
	
	private String text;
	
	private int code;
	
	/**
	 * Instantiate a StringWithIntCode.
	 *
	 * @param text the text
	 * @param code the code
	 */
	public StringWithIntCode(String text, int code) {
		this.text = text;
		this.code = code;
	}
	
	/**
	 * Get the string of this instance.
	 *
	 * @return The text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Get the code  of this instance.
	 *
	 * @return The integer code
	 */
	public int getIntCode() {
		return this.code;
	}

}

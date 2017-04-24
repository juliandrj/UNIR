/**
 * 
 */
package es.edu.unir.farmacia.excepcions;

/**
 * @author juliandrj
 *
 */
public class FarmaciaException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param message
	 */
	public FarmaciaException(String message) {
		super(message);
	}
	/**
	 * @param message
	 * @param cause
	 */
	public FarmaciaException(String message, Throwable cause) {
		super(message, cause);
	}

}

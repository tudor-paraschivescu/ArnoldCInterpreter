package implementation;

/**
 * The Interface Visitable
 * 
 * @author Tudor Paraschivescu
 */
public interface Visitable {
	
	/**
	 * Accept a visitor and execute it.
	 *
	 * @param v the visitor
	 */
	public void accept(Visitor v);
	
}

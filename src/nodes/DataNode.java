package nodes;

import java.util.HashMap;

/**
 * The Interface DataNode.
 * 
 * @author Tudor Paraschivescu
 */
public interface DataNode {
	
	/**
	 * Gets the value.
	 *
	 * @param map the hash map
	 * @return the value
	 */
	public int getValue(HashMap<String, Integer> map);

}

/**
 * A Huffman Node class with the proper constructors, accessors, and modifiers
 * @author Anish Seth
 * @version 1-28-16
 */
public class HuffmanNode implements Comparable<HuffmanNode>
{
	private String key;
	private int value;
	private HuffmanNode left;
	private HuffmanNode right;
	/**
	 * Sets key and value to parameters while setting left and right pointers to null
	 * @param k Key for the node
	 * @param v Value for the node
	 */
	public HuffmanNode(String k, int v)
	{
		key = k;
		value = v;
		left = null;
		right = null;
	}
	/**
	 * Sets key, value, and both pointers to parameters
	 * @param k Key for the node
	 * @param v Value for the node
	 * @param l pointer for the left node of the current node
	 * @param r pointer for the right node of the current node
	 */
	public HuffmanNode(String k, int v, HuffmanNode l, HuffmanNode r)
	{
		key = k;
		value = v;
		left = l;
		right = r;
	}
	/**
	 * Accessor that returns the node to the left of the current node
	 * @return Huffman Node to the left of the current node
	 */
	public HuffmanNode getLeft()
	{
		return left;
	}
	/**
	 * Accessor that returns the node to the right of the current node
	 * @return Huffman Node to the right of the current node
	 */
	public HuffmanNode getRight()
	{
		return right;
	}
	/**
	 * Accessor that returns the key of the current node
	 * @return key of the current node
	 */
	public String getKey()
	{
		return key;
	}
	/**
	 * Accessor that returns the value of the current node
	 * @return value of the current node
	 */
	public int getValue()
	{
		return value;
	}
	/**
	 * Modifier that sets the left pointer to the parameter
	 * @param l New node the left pointer will be set to
	 */
	public void setLeft(HuffmanNode l)
	{
		left = l;
	}
	/**
	 * Modifier that sets the right pointer to the parameter
	 * @param l New node the right pointer will be set to
	 */
	public void setRight(HuffmanNode r)
	{
		right = r;
	}
	/**
	 * Checks whether or not the current Huffman Node is a leaf
	 * @return true if it is a leaf, false otherwise
	 */
	public boolean isLeaf()
	{
		return (left == null && right == null);
	}
	/**
	 * String representation of the current Huffman Node
	 */
	public String toString()
	{
		if(isLeaf())
			return key + ": " + value;
		else
		{
			if (right == null)
				return key + value + "(," + left.toString() + ")";
			else if(left == null)
				return key + value + "(," + right.toString() + ")";
			return key + value + "(" + left.toString() + "," + right.toString() + ")";		}
	}
	/**
	 * Compares the values of the current Huffman Node and the parameter
	 * @param o Huffman Node the current node will be compared to
	 * @return If the current node is greater than the parameter, return a positive value
	 * @return If they are equal, return 0
	 * @return If the parameter is greater than the current node, return a negative value
	 */
	public int compareTo(HuffmanNode o)
	{
		return value - o.getValue();
	}

}

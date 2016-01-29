import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
/**
 * @author Anish Seth
 */
public class HuffmanTree
{
	private HuffmanNode root;
	private String input;
	private HashMap<Character, Integer> map;
	private PriorityQueue<HuffmanNode> queue;
	
	public HuffmanTree(String s)
	{
		input = s;
		map = new HashMap<Character, Integer>();
		queue = new PriorityQueue<HuffmanNode>();
	}
	public String encoder(String s)
	{
		return "";
	}
	public String decoder(String s)
	{
		return "";
	}
	public String toString()
	{
		root.toString();
	}
}

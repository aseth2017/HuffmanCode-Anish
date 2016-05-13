import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;
/**
 * Class that creates a HuffmanTree using HuffmanNodes
 * Creates a Priority Queue and initializes the tree itself using a Hashmap
 * @author Anish Seth
 */
public class HuffmanTree
{
	private HuffmanNode root;
	private String s;
	private HashMap<String, Integer> map;
	private PriorityQueue<HuffmanNode> queue;

	/**
	* Constructor
	* Initializes map, queue, and tree
	*/
	public HuffmanTree(String string)
	{
		s = string;
		root = null;
		createqueue();
		createmap();
		createtree();
	}
	public void createqueue()
	{
		queue = new PriorityQueue<HuffmanNode>();
		Object[] key = map.keySet().toArray();
		for(int i = 0; i < key.length; i++)
		{
			queue.add(new HuffmanNode(key[i].toString(), map.get(key[i])));
		}
	}
	public void createmap()
	{
		map = new HashMap<String, Integer>();
		for(int i = 0; i < s.length(); i++)
		{
			String hold = s.charAt(i);
			if(map.containsKey(hold))
			{
				int index = map.get(i);
				map.remove(i);
				map.put(hold, index + 1);
			}
			else
			{
				map.put(hold, 1);
			}
		}
	}
	public void createtree()
	{
		HuffmanNode hold;
		while(queue.size() > 1)
		{
			hold = new HuffmanNode(queue.poll(), queue.poll());
			queue.add(hold);
			root = hold;
		}
	}
	public String encode()
	{
		String encode;
		for(int i = 0; i < s.length(); i++)
		{
			HuffmanNode hold = root;
			while((hold.getLeft() != null) && (hold.getRight() != null))
			{
				if(hold.getLeft().getKey().contains(s.substring(i, i + 1)))
				{
					hold = hold.getLeft();
					encode += "1";
				}
				else if(hold.getRight().getKey().contains(s.substring(i, i + 1)))
				{
					hold = hold.getRight();
					encode += "0";
				}
			}
		}
		return encode;
	}
	public String decoder(String s)
	{
		String decode = "";
		int i = 0;
		while(i < s.length())
		{
			HuffmanNode hold = root;
			while((hold.getLeft() != null) && (hold.getRight() != null))
			{
				if(s.substring(i, i + 1).equals("1"))
					hold = hold.getLeft();
				else if(s.substring(i, i + 1).equals("0"))
					hold = hold.getRight();
				i++;
			}
			decode += hold.getKey();
		}
		return decode;
	}
	public String toString()
	{
		return root.toString();
	}
}

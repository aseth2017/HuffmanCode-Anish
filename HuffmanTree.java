import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;
/**
 * Class that creates a HuffmanTree
 * Creates a Priority and initializes the tree itself using a Hashmap
 * With help from Will Long
 * @author Anish Seth
 */
public class HuffmanTree
{
	private HuffmanNode root;
	private HashMap<String, Integer> map;
	private PriorityQueue<HuffmanNode> queue;
	
	public HuffmanTree(String input)
	{
		map = new HashMap<String, Integer>();
		queue = new PriorityQueue<HuffmanNode>();
		for(int i = 0; i < input.length(); i++)
		{
			if(map.containsKey(input.substring(i,i + 1)))
				map.put(input.substring(i,i + 1), map.get(input.substring(i,i + 1)) + 1);
			else
				map.put(input.substring(i,i + 1), 1);
		}
		initQueue();
		initTree();
	}
	public PriorityQueue<HuffmanNode> initQueue()
	{
		String[] key =  map.keySet().toArray(new String[0]);
		for(int i = 0; i < key.length; i++)
		{
			queue.add(new HuffmanNode(key[i], map.get(key[i])));
		}
		return queue;
	}
	public HuffmanNode initTree()
	{
		while(queue.size() > 1)
		{
			HuffmanNode top = queue.poll();
			HuffmanNode topv2 = queue.poll();
			HuffmanNode hold = new HuffmanNode(top.getKey() + topv2.getKey(), top.getValue() + topv2.getValue());
			root = hold;
			queue.add(root);
			hold.setLeft(top);
			hold.setRight(topv2);

		}
		return root;
	}
	public String encoder(String s)
	{
		String encode = "";
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

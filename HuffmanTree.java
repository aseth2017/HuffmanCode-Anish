import java.util.HashMap;
import java.util.PriorityQueue;
/**
 * Class that creates a HuffmanTree
 * Creates a Priority and initializes the tee itself using a Hashmap
 * @author Anish Seth
 */
public class HuffmanTree
{
	private HuffmanNode root;
	private String input;
	private HashMap<String, Integer> map;
	private PriorityQueue<HuffmanNode> queue;
	
	public HuffmanTree(String s)
	{
		input = s;
		map = new HashMap<String, Integer>();
		queue = new PriorityQueue<HuffmanNode>();
		for(int i = 0; i < input.length(); i++)
		{
			if(map.containsKey(input.substring(i,i + 1)))
				map.put(input.substring(i,i + 1), map.get(input.substring(i,i + 1) + 1));
			else
				map.put(input.substring(i,i + 1), 1);
		}
	}
	public PriorityQueue<HuffmanNode> initQueue()
	{
		String[] key = map.keySet().toArray(new String[0]);
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
		return "";
	}
	public String decoder(String s)
	{
		return "";
	}
	public String toString()
	{
		return root.toString();
	}
}

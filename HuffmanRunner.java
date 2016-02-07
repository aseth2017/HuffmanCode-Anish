import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
public class HuffmanRunner
{
	public static void main(String [] args)
	{
		HuffmanTree tree = new HuffmanTree("Sally sells seashells by the seashore, the shells she sells are seashells");
		System.out.println(tree.encoder("Sally sells seashells, the shells she sells are seashells"));
		System.out.println(tree.decoder("011111011000100100010001010110010011001010110110100000110010011001111001000011000011010100000110010011001010000011010101100100110010011000010111010101101101000001100100110"));
	}
}
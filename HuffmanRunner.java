public class HuffmanRunner
{
	public static void main(String[] args)
	{
		HuffmanNode root = new HuffmanNode("f", 3);
		HuffmanNode root2 = new HuffmanNode("e", 11);
		root.setLeft(root);
		System.out.println("run");
		System.out.println(root2.compareTo(root));
	}
}
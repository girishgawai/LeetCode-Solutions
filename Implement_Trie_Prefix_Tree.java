package leetcode.coomplex.code;

import java.util.HashMap;

public class Implement_Trie_Prefix_Tree {
	
	private class Node {
		int data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean isTerminal = false;
	}
	
	private Node root;
	
	public Implement_Trie_Prefix_Tree()
	{
		Node nn = new Node();
		nn.data = '*';
		this.root = nn;
	}
	
	public void insert(String word)
	{
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
			}
			else
			{
				Node nn = new Node();
				nn.data = ch;
				node.children.put(ch, nn);
				node = nn;
			}
		}
		
		node.isTerminal = true;
	}
	
	public boolean search(String word)
	{
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
			}
			else
			{
				return false;
			}
		}
		
		return node.isTerminal;
	}
	
	public boolean startsWith(String prefix)
	{
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}

}

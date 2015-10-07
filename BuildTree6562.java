package pp_6562;

import java.util.ArrayList;
import java.util.List;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public class BuildTree6562 {
public final TreeNode6562 root;
private ArrayList<List<Integer>> encode=  new ArrayList<List<Integer>>(); ;

	public BuildTree6562(TreeNode6562 root, int value) {
		this.root = root;
		for (int i = 0; i < value; i++)
		encode.add(null);
		buildNodeTree6562(root, new ArrayList<Integer>());
	}

	private void buildNodeTree6562(Tree6562 root, List<Integer> pre) {
		if (root instanceof TreeNode6562) {
			TreeNode6562 node = (TreeNode6562)root;
			pre.add(0);
			buildNodeTree6562(node.leftNode, pre);
			pre.remove(pre.size() - 1);
			pre.add(1);
			buildNodeTree6562(node.rightNode, pre);
			pre.remove(pre.size() - 1);
		}
		else if (root instanceof TreeLeaf6562) {
			TreeLeaf6562 leaf = (TreeLeaf6562)root;
			encode.set(leaf.leafValue, new ArrayList<Integer>(pre));
		}
		else {
			System.out.println("Node type is illagal");
		}
	}

	public List<Integer> getNodeValue6562(int val)throws Exception{
		if (val < 0)
			throw new IllegalArgumentException("Illegal symbol");
		else if (encode.get(val) == null)
			throw new IllegalArgumentException("No code for given symbol");
		else
			return encode.get(val);
	}
	
	

}

package pp_6562;

import java.util.ArrayList;
import java.util.Queue;

/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public final class Mapping6562 {
	private int[] treeLength;
	private int[] mapFreq;
	
	public Mapping6562(int[] values) {
		mapFreq = values; 
		treeLength = values;
	}
	
	public Mapping6562(BuildTree6562 tree, int endLimit) {
		treeLength = new int[endLimit];
		treeLengthTable6562(tree.root, 0);
	}
	
	public int getNodeLimit6562() {
		return treeLength.length;
	}
	
	public int getNodeLength6562(int symbol) {
		return treeLength[symbol];
	}
	
	private void treeLengthTable6562(Tree6562 root, int next) {
		if (root instanceof TreeNode6562) {
			TreeNode6562 node = (TreeNode6562)root;
			treeLengthTable6562(node.leftNode, next+1);
			treeLengthTable6562(node.rightNode, next+1);
		} else if (root instanceof TreeLeaf6562) {
			int leafvalue = ((TreeLeaf6562)root).leafValue;
			if (treeLength[leafvalue]!=0)
				{
				System.out.println("leafValue has more then one value");
				}
			if(leafvalue >=treeLength.length)
			{
				System.out.println("leafValue extends treelimit");
			}
			treeLength[leafvalue] = next;
		} else {
			System.out.println("node value is illegal");
		}
	}
	
	public BuildTree6562 treeMap6562() {
		ArrayList<Tree6562> node = new ArrayList<Tree6562>();
		for (int i = upto6562(treeLength); i >= 1; i--) { 
			ArrayList<Tree6562> newNode = new ArrayList<Tree6562>();
			for (int j = 0; j < treeLength.length; j++)
			{
				if (treeLength[j] == i)
					newNode.add(new TreeLeaf6562(j));
			}
			for (int j = 0; j < node.size(); j += 2)
			newNode.add(new TreeNode6562(node.get(j), node.get(j + 1)));
			node = newNode;
		}
		return new BuildTree6562(new TreeNode6562(node.get(0), node.get(1)), treeLength.length);
	}
	
	
	
	private int upto6562(int[] array) {
		int val = array[0];
		for (int x : array)
			val = Math.max(x, val);
		return val;
	}	
	
	public void plus6562(int index) {
		if (index < 0 || index >= mapFreq.length)
			throw new IllegalArgumentException("Symbol out of range");
		if (mapFreq[index] == Integer.MAX_VALUE)
			throw new RuntimeException("Arithmetic overflow");
		mapFreq[index]++;
	}
	

	public BuildTree6562 mapTree6562() {
		Queue<Tree6562> q = new PriorityQueue6562<Tree6562>();
		for (int i = 0; i < mapFreq.length; i++) {
			if (mapFreq[i] > 0)
				q.add(new Tree6562(new TreeLeaf6562(i), i, mapFreq[i]));
			}
		for (int i = 0; i < mapFreq.length && q.size() < 2; i++) {
			if (i >= mapFreq.length || mapFreq[i] == 0)
				q.add(new Tree6562(new TreeLeaf6562(i), i, 0));
		}
		while (q.size() > 1) {
			Tree6562 n1 = q.remove();
			Tree6562 n2 = q.remove();
			q.add(new Tree6562(new TreeNode6562(n1.root, n2.root),Math.min(n1.EntityNode, n2.EntityNode),n1.incedence + n2.incedence));
		}
		return new BuildTree6562((TreeNode6562)q.remove().root, mapFreq.length);
	}	
}


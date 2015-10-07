package pp_6562;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public class Tree6562 implements Comparable<Tree6562> {
	public Tree6562 root;
	public int EntityNode;
	public long incedence;
	Tree6562()
	{
		this.root = null;
		this.EntityNode =0;
		this.incedence = 0;
	}
	public Tree6562(Tree6562 root, int EntityNode, long incedence) {
		this.root = root;
		this.EntityNode = EntityNode;
		this.incedence = incedence;
	}
	public int compareTo(Tree6562 otherNode) {
		if (incedence < otherNode.incedence)
			return -1;
		else if (incedence > otherNode.incedence)
			return 1;
		else if (EntityNode < otherNode.EntityNode)
			return -1;
		else if (EntityNode > otherNode.EntityNode)
			return 1;
		else
			return 0;
	}	

}


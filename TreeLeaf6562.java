package pp_6562;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public class TreeLeaf6562 extends Tree6562{
	public int leafValue;
	
	TreeLeaf6562(int nodeValue)
	{
		try
		{
		if(nodeValue < 0)
		{}
		}
		catch(Exception e){ System.out.println("Value is not valid");
		}
		
		this.leafValue = nodeValue;
	}

	
}

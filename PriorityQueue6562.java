package pp_6562;

import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
@SuppressWarnings("hiding")
public class PriorityQueue6562<Tree6562> extends AbstractCollection<Tree6562> implements Queue<Tree6562>
{
	private static final int DEFAULT_CAPACITY = 250;
	private int _heapSize; 
    private Tree6562 [ ] _heapArray; 
    private Comparator<?super Tree6562> _comparator;
    
    /*constructing empty priority queue*/
	@SuppressWarnings("unchecked")
	public PriorityQueue6562()
	{
		_heapSize = 0;// intial size in heap
		_comparator = null;
		_heapArray = (Tree6562[])new Object[DEFAULT_CAPACITY+1]; //initial default capacity for heap Array
		
	}
	/* compainring left and right node using compareTo method*/
	@SuppressWarnings({"unchecked", "rawtypes" })
	private int compareNodes6562(Tree6562 leftNode , Tree6562 RightNode)
	{
		if(_comparator == null)
			return ((Comparable)leftNode).compareTo(RightNode);
		else
			return _comparator.compare(leftNode, RightNode);
		}
	
	/* returning no. of items in priority Queue*/
	public int size()
	{
		return _heapSize;
	}
	
	public void clear()
	{
		_heapSize = 0;
	}
	public boolean add(Tree6562 tree)
	{
		if((_heapSize + 1) == _heapArray.length)
		makeHeapArrayDouble6562();
		int _inc = ++_heapSize;
		_heapArray[0] = tree;
		for(;compareNodes6562(
				tree,_heapArray[_inc/2]) < 0;
				_inc/=2)
			_heapArray[_inc]=_heapArray[_inc/2];
		_heapArray[_inc]=tree;
		return true;
	}
   
 /*returning iterator*/
	public Iterator<Tree6562> iterator()
	{
		return new Iterator<Tree6562>()
				{
			int currentSize = 0;
			public boolean hasNext()
			{
				return currentSize!= size();
			}
			@Override
			public Tree6562 next() {
				// TODO Auto-generated method stub
				if(hasNext())
					return _heapArray[++currentSize];
				else
					throw new NoSuchElementException();

			}
			public void remove()
			{
				System.out.println("Unsupported Exception");
			}
				};
	}

    public Tree6562 check( )
    {
        if( isEmpty( ) )
            throw new NoSuchElementException( );
        return _heapArray[ 1 ];
    }
    
/* Remove smallest element */
    public Tree6562 remove( )
    {
        Tree6562 min = element();
        _heapArray[1] = _heapArray[_heapSize--];
       filterDown6562(1);
        return min;
    }
/* filtering down */
    private void filterDown6562(int value)
    {
    	int node;
        Tree6562 temp = _heapArray[value];
        for(;value * 2 <= _heapSize;value = node )
        {
        	node = value * 2;
            if( node != _heapSize &&
                    compareNodes6562(
                    		_heapArray[ node + 1 ],
                    		_heapArray[ node ] ) 
                    		< 0 )
                node++;
            if( compareNodes6562(
            		_heapArray[ node ], temp ) 
            		< 0 )
                _heapArray[value ] = _heapArray[ node ];
            else
                break;
            }
        _heapArray[value ] = temp;
    }
  /* extend array size */
    @SuppressWarnings("unchecked")
	private void makeHeapArrayDouble6562( )
    {
    	Tree6562[] tempArray;
    	tempArray =(Tree6562[])new Object[_heapArray.length*2];
    	for(int j=0;j<_heapArray.length;j++)
    		tempArray[j]=_heapArray[j];
    	_heapArray =tempArray;
    }
	@Override
	public boolean offer(Tree6562 e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tree6562 peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tree6562 poll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tree6562 element() {
		// TODO Auto-generated method stub
        if(isEmpty())
            throw new NoSuchElementException();
        return _heapArray[ 1 ];
	}

}
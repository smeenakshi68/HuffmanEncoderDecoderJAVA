package pp_6562;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public class Hdec6562 {
	UpdateInput6562 input;
	BuildTree6562 buildTree;
	Mapping6562 map;
	static File inputFile;
	static File outputFile;
	OutputStream out;
	static int maxlength = 256;
		Hdec6562()
		{
		try
		{
			
		input = new UpdateInput6562(new BufferedInputStream(new FileInputStream(inputFile)));
		out = new BufferedOutputStream(new FileOutputStream(outputFile));
		map = readbyte6562(input);
		buildTree = map.treeMap6562();
		decompress6562(input,out,buildTree);
		out.close();
		input.close6562();
		}
		catch(Exception e){}
	}
		public Hdec6562(UpdateInput6562 in) {
			this.input = in;
		}
		
	static Mapping6562 readbyte6562(UpdateInput6562 in){
		int[] path = new int[maxlength+1];
		for (int i = 0; i < path.length; i++) {
			int val = 0;
			for (int j = 0; j < 8; j++) 
				val = val << 1 | in.checkEnd6562();
			path[i] = val;
		}
		return new Mapping6562(path);
	}

	public int readValue6562(){
		TreeNode6562 currentNode = buildTree.root;
		while (true) {
			Tree6562 nextNode;
			int checkValue = input.checkEnd6562();
			if (checkValue == 0) nextNode = currentNode.leftNode;
			else if (checkValue == 1) nextNode = currentNode.rightNode;
			else {throw new RuntimeException("Not valid argument");}
			if (nextNode instanceof TreeLeaf6562)
				return ((TreeLeaf6562)nextNode).leafValue;
			else if (nextNode instanceof TreeNode6562)
				currentNode = (TreeNode6562)nextNode;
			else {throw new RuntimeException("Not valid argument");}
		}
	}
	
	static void decompress6562(UpdateInput6562 in, OutputStream out,BuildTree6562 code) throws IOException {
		Hdec6562 dec = new Hdec6562(in);
		dec.buildTree= code;
		while (true) {
			int readvalue = dec.readValue6562();
			if (readvalue == maxlength)
				break;
			out.write(readvalue);
		}
	}
	public static void main(String[] args){
		if (args.length == 0) 
		{
			System.out.println("Please pass the input filename with extension");

		}
		else
			{
			inputFile = new File(args[0]);
			outputFile = new File(args[0].substring(0, args[0].length()-4));
			if(inputFile.canRead()==false)
			{
				System.out.println("No huf file existed in location! please check");
			}
			else if(args[0].indexOf(".huf")!=(args[0].length()-4))
			{
				System.out.println(".huf is missed from file name");
			}
			else if(args[0].indexOf(".")!=(args[0].length()-8))
			{
				System.out.println("On command Line encoded filename type is missing before .huf");
			}
			else
			{
			new Hdec6562();
			}
			}
		}
}


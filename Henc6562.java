package pp_6562;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public class Henc6562 {
	BuildTree6562 buildTree;
	Mapping6562 maptree ;
	static File inputFile;
	static File outputFile;
	static InputStream in ;
	UpdateOutput6562 output;
	Mapping6562 map;
	static int maxLength = 256;
	Henc6562()
	{

		try {
		map = getMap6562(inputFile);
		map.plus6562(maxLength); 
		maptree = new Mapping6562(map.mapTree6562(),maxLength+1);
		in = new BufferedInputStream(new FileInputStream(inputFile));
		output = new UpdateOutput6562(new BufferedOutputStream(new FileOutputStream(outputFile)));
		writeCode6562(output,maptree);
		compress6562( in, output,maptree.treeMap6562());
		output.close6562();
		in.close();}
		catch(Exception e){ e.printStackTrace();}
		finally {
			
		}
	}
	public Henc6562(UpdateOutput6562 out) {
		if (out == null)
		{
			System.out.println("File is empty");
		}
		output = out;
	}
	public void writeBits6562(int symbol) throws IOException {
		if (buildTree == null)
			System.out.println("Code tree is null");
		List<Integer> bits;
		try {
			bits = buildTree.getNodeValue6562(symbol);
		for (int b : bits)
			output.writeByte6562(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void writeCode6562(UpdateOutput6562 out,Mapping6562 map){
		for (int i = 0; i < map.getNodeLimit6562(); i++) {
			int val = map.getNodeLength6562(i);
			for (int j = 7; j >= 0; j--)
				out.writeByte6562((val>>j)&1);
		}
	}
	private static Mapping6562 getMap6562(File f)
	{
		Mapping6562 map = new Mapping6562(new int[maxLength+1]);
		try
		{
		InputStream input = new BufferedInputStream(new FileInputStream(f));
		while(true)
			{
				int b = input.read();
				if(b==-1)
				{
					break;
					}
				map.plus6562(b);
			}
			input.close();
			}
		catch(Exception e){ e.printStackTrace();}
		return map;
	}
	static void compress6562(InputStream in, UpdateOutput6562 out,BuildTree6562 tree)throws Exception
	{
		Henc6562 com = new Henc6562(out);
		com.buildTree = tree;
		while(true)
		{
			int b = in.read();
			if(b==-1) break;
			com.writeBits6562(b);
		}
		com.writeBits6562(maxLength);
	}
	
	public static void main(String args[])
	{
		if (args.length == 0) 
		{
			System.out.println("Please pass the input filename with extension");

		}
		else
		{
		inputFile = new File(args[0]);
		outputFile = new File(args[0]+".huf");
		new Henc6562();
		}
	}
}

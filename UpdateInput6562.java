package pp_6562;

import java.io.InputStream;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public class UpdateInput6562 {
	int remBits,nextBit,end;
	Boolean reachEnd = false;
	InputStream in;
	
	public UpdateInput6562(InputStream in)
	{ 
		this.remBits = 0;
		this.in = in;
	}
	
	public int readByte6562()
	{
		if(reachEnd == true){return -1;}
		if(remBits==0)
		{
			try
			{
		nextBit = in.read();
		if(nextBit == -1)
		{
			reachEnd = true;
			return -1;
		}
		remBits = 8;
			}
			catch(Exception e){System.out.println(e);}
		}
		remBits--;
		return (nextBit >>> remBits) & 1;
		}
	
public int checkEnd6562() {
		end = readByte6562();
		if (end != -1)
		return end;
		return end;
		}
public void close6562(){
	try
	{
	in.close();
	}
	catch(Exception e){}
}
}

package pp_6562;
import java.io.OutputStream;
/* 
 * SHARMA MEENAKSHI cs610 PP 6562
 */
public final class UpdateOutput6562 {
	int numBits,cbit;
	OutputStream out;
	
	
	public UpdateOutput6562(OutputStream out)
	{ 
		this.numBits = 0;
		this.out = out;
		this.cbit =0 ;
	}
	
	public void writeByte6562(int bit) {
		if (!(bit == 0 || bit == 1))
		{
			System.out.println("Stream must have either 0 or 1");
		}
		cbit = cbit << 1 | bit;
		numBits++;
		try
		{
		if (numBits== 8) {
			out.write(cbit);
			numBits= 0;
		}
		}
		catch(Exception e){ System.out.println("Update  Output Stream Exception");}
	}

	public void close6562(){
		try
		{
		while (numBits!= 0)
			writeByte6562(0);
		out.close();
		}
		catch(Exception e){}
	}


}

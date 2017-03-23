//http://community.topcoder.com/stat?c=problem_statement&pm=2884

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Mailbox
{
	public int impossible(String collection, String[] address)
	{
		int count = 0;
		int[] c = new int[256];
		Arrays.fill(c,0);
		for(int i=0;i<collection.length();i++){
		   c[collection.charAt(i)] += 1;
		}
		
	    int[] b = new int[256];
		for(String addr: address){
		  System.arraycopy(c,0,b,0,c.length);
		  for(int j=0;j<addr.length();j++){
		    if(addr.charAt(j)==' ')
		      continue;
		    int v = b[addr.charAt(j)];
		    if(v<=0){
		      count++;
		      break;
		    }else{
		      b[addr.charAt(j)] -= 1;
		    }
		   }
		}
		return count;
	}
	
	<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!
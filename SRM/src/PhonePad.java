import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PhonePad
{
	public int fingerMovement(String phoneNumber)
	{
	  String total = "123456789*0#";
	  Map<Character,String> m = new HashMap<Character,String>();
	  int k = 0;
	  for(int i=0;i<4;i++){
	     for(int j=0;j<3;j++){
	       m.put(total.charAt(k),i+","+j);
	       k++;
	     }
	  }
	  phoneNumber = "5"+phoneNumber;
	  int count = 0;
	  for(int x=0;x<phoneNumber.length()-1;x++){
	    System.out.println(phoneNumber.charAt(x)+","+phoneNumber.charAt(x+1));
	    String[] co1 = m.get(phoneNumber.charAt(x)).split(",");
	    String[] co2 = m.get(phoneNumber.charAt(x+1)).split(",");
	    
	    int x1 = Integer.parseInt(co1[0]);
	    int y1= Integer.parseInt(co1[1]);
	    int x2 = Integer.parseInt(co2[0]);
	    int y2= Integer.parseInt(co2[1]);
	    
	    count += Math.abs(x1-x2) + Math.abs(y1-y2);
	  }  
	  
	  return count;
	  
		
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
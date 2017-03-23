
/*SRM 255 Div2 Mid
http://community.topcoder.com/stat?c=problem_statement&pm=4483
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class WordCompositionGame
{
	public String score(String[] listA, String[] listB, String[] listC)
	{
	    HashSet hset1 = new HashSet();
	    HashSet hset2 = new HashSet();
	    HashSet hset3 = new HashSet();
	    
	    for(String str: listA){
	      hset1.add(str);
	    }
	    
	    for(String str: listB){
	      hset2.add(str);
	    }
	    
	    for(String str: listC){
	      hset3.add(str);
	    }
	    
	    int result1 = cresults(listA, hset2, hset3);
	    int result2 = cresults(listB, hset1, hset3);
	    int result3 = cresults(listC, hset1, hset2);
	    
	    return result1+"/"+result2+"/"+result3;
	    
	    
	
		
	}
	
	public int cresults(String[] list, HashSet hset1, HashSet hset2){
	
	  int total1 = 3;
	  int result = 0;
	  
	  for(int i=0;i<list.length;i++){
	     String str = list[i];
	     if(hset1.contains(str)){
	       total1-=1;
	     
	     }
	     if(hset2.contains(str)){
	       total1-=1;
	     }
	     result+=total1;
	     total1 = 3;
	  
	  }
	  
	  return result;
	
	}
	
	
	
	
	
	
	
}
//Powered by [KawigiEdit] 2.0!
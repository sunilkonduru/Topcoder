/*
  SRM 513 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=11502
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class YetAnotherIncredibleMachine
{
	public int countWays(int[] platformMount, int[] platformLength, int[] balls)
	{
	  long ret = 1;
	  for(int i=0;i<platformLength.length;i++){
	   long count = 0;
	    for(int posLeft = platformMount[i]-platformLength[i];posLeft<=platformMount[i];posLeft++){
	    boolean bf=false;
	    for(int ball:balls){
	      if(ball>=posLeft&&ball<=posLeft+platformLength[i]){
	        bf=true;
	      }
	    }
	    if(!bf){
	      count++;
	    }
	    
	    }
	   ret = (ret*count);
	  }
	  return (int)ret%1000000009;	  
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
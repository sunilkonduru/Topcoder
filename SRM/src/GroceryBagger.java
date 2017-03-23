/*
   SRM 222 Div 2 mid
   http://community.topcoder.com/stat?c=problem_statement&pm=3450
*/


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GroceryBagger
{
	public int minimumBags(int strength, String[] itemType)
	{
	  int sum = 0;
	  HashMap<String,Integer> hmap = new HashMap<String,Integer>();
	  for(String item: itemType){
	    if(hmap.containsKey(item)){
	      hmap.put(item,(hmap.get(item)+1));
	    }
	    else{
	       hmap.put(item,1);
	    }
	   }
	    System.out.println(hmap.size());
	    for(Map.Entry<String,Integer> entry: hmap.entrySet()){
	       int value = entry.getValue();
	       int t1 = value/strength;
	       int t2 = value%strength;
	       if(t2!=0)
	         t1=t1+1;
	       sum+=t1;
	   
	  //return t
	  }	
	  return sum;
	}
	
	
}
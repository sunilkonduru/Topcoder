//The most important condition. Imagine we have two consecutive coin denominations i and i+1. In a single query, we cannot have get too many coins of type i, because it is possible that it was better to use the higher denomination i+1 to get less coins in total for the query.

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ColorfulCoinsEasy
{
	public String isPossible(int[] values)
	{  
	   if(values.length==1)
	     return "Possible";
	   int[] maxcount = new int[values.length-1];
	   for(int i=0;i<values.length-1;i++){
	      maxcount[i]=(values[i+1]/values[i]);
	   }
	   Arrays.sort(maxcount);
	   for(int i=0;i<maxcount.length;i++){
	     if(i+1 >= maxcount[i])
	       return "Impossible";
	   
	   }
	   return "Possible";
	   
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
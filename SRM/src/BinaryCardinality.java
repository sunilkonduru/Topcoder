/*
 type: sorting
 SRM 166 Div2 Mid
 http://community.topcoder.com/stat?c=problem_statement&pm=1519

*/


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BinaryCardinality
{
	public int[] arrange(int[] numbers)
	{
	   List<Integer> list = new ArrayList<Integer>();
	   
	   for(int no: numbers){
	   
	     list.add(no);
	   }
	   Collections.sort(list, new Comparator<Integer>(){
	      public int compare(Integer a, Integer b){
	        int v1 = Integer.bitCount(a);
	        int v2 = Integer.bitCount(b);
	        if(v1>v2)
	           return 1;
	        else if(v1<v2)
	           return -1;
	        else{
	           if(a>b)
	             return 1;
	           else if(a<b)
	              return -1;
	           else
	              return 0;
	        }  
	      }  
	   
	   });
	   int s= list.size();
	   int[] a = new int[s];
	   for(int i=0;i<a.length;i++){
	      a[i]=list.get(i);
	   }
	   return a;	
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
/*
 SRM 253 Div2 500
 http://community.topcoder.com/stat?c=problem_statement&pm=4674
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Decipher
{
	public String[] decipher(String[] encoded, String frequencyOrder)
	{
	  MyComparator mc = new MyComparator();
	  TreeMap<Character, Integer> tm = new TreeMap<Character,Integer>() ;
	  List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>() ;
	  Map<Character,Character> res = new HashMap<Character,Character>();
	  for(String enc: encoded){
	   char[] en = enc.toCharArray();
	   for(char e: en){
	    if(e== ' '){}
	    else if(tm.containsKey(e))
	      tm.put(e,tm.get(e)+1);
	    else 
	      tm.put(e,1);
	   }
	  }
	  
	  for(Map.Entry<Character,Integer> entry: tm.entrySet()){
	    list.add(entry);
	  }
	  
	  Collections.sort(list,mc);
	  int i = 0;
	  String[] results = new String[encoded.length];
	 
	  for(String enc: encoded){
	    int k =0;
	    char[] fo = frequencyOrder.toCharArray();
	    System.out.println(frequencyOrder);
	    for(Map.Entry<Character,Integer> entry: list){
	       if(k<fo.length){
	       System.out.println(fo[k]+" "+entry.getKey()+" "+entry.getValue());
	       if(fo[k]==' ')
	         res.put(' ', ' ');
	       res.put(entry.getKey(),fo[k]);
	       k++;
	       }
	       
	    }
	    char[] en = enc.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    int j=0;
	   for(char e: en){
	    if(e==' ')
	      sb.append(' ');
	    else{
	        //System.out.println(list.get(j).getKey());
	    	sb.append(res.get(e));
	    	j++;
	    }
	   }
	   results[i]= new String(sb.toString());
	   i++;
	  }
	return results;	
	}
	public class MyComparator implements Comparator{
	 public int compare(Object o1, Object o2){
	  Map.Entry m1 = (Map.Entry) o1;
	  Map.Entry m2 = (Map.Entry) o2;
	  int v1 = (Integer)m1.getValue();
	  int v2 = (Integer)m2.getValue();
	  if(v1>v2)
	    return -11;
	  else if(v1<v2)
	    return 1;
	  else{
	    return ((Character)m1.getKey()).compareTo((Character)m2.getKey());
	  }
	 } 
	
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
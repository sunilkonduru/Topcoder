/*
  SRM 227 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=3520
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ClientsList
{
	public String[] dataCleanup(String[] names)
	{
	  List<String> list = new ArrayList<String>();
	  for(String name: names){
	     if(name.contains(",")){
	         String[] nms=name.split(", ");
	         String tmp = nms[1]+" "+nms[0];
	         list.add(tmp);
	     }
	     else{
	       list.add(name);
	     
	     }
	  
	  }
	  
	  Collections.sort(list,new Comparator<String>(){
	   
	   public int compare(String a, String b){
	    String[] names1 = a.split(" ");
	    String[] names2 = b.split(" ");
	    int val = names1[1].compareTo(names2[1]); 
	    if(val==0){
	      return names1[0].compareTo(names2[0]);
	    }
	    else{
	      return val;
	    }
	   }
	  
	  });
	  
	  String[] temp = new String[names.length];
	  
	  for(int i =0; i<temp.length;i++){
	     temp[i]=list.get(i);
	  }		
	  return temp;			
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
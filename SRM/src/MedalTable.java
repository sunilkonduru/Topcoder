/*
 SRM 209 Div2 500
 http://community.topcoder.com/stat?c=problem_statement&pm=2922
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MedalTable
{
	public String[] generate(String[] results)
	{  Map<String, Integer> gold = new HashMap<String, Integer>();
	   Map<String, Integer> silver = new HashMap<String, Integer>();
	   Map<String, Integer> bronze = new HashMap<String, Integer>();
	   for(String result: results){
	        String[] medals = result.split(" ");
	        if(gold.containsKey(medals[0])){
	           gold.put(medals[0],(gold.get(medals[0])+1));
	        }
	        else
	           gold.put(medals[0],1);
	        if(silver.containsKey(medals[1]))
	           silver.put(medals[1],(silver.get(medals[1]+1)));
	        else
	           silver.put(medals[1],1);
	           
	        if(bronze.containsKey(medals[2]))
	           bronze.put(medals[2],(bronze.get(medals[2])+1));
	        else
	           bronze.put(medals[2],1);
	           
	   }
	   
	   Set<String> set = new HashSet<String>();
	   
	   for(String res: results){
	     String[] resu= res.split(" ");
	     for(String result: resu){
	     int g=0,s=0,b=0;
	     if(gold.get(result)!=null)
	        g=gold.get(result);
	     if(silver.get(result)!=null)
	        s=silver.get(result);
	     if(bronze.get(result)!=null)
	        b=bronze.get(result);
	     set.add(result+" "+g+" "+s+" "+b);
	     }
	   }
	   
	   List<String> list = new ArrayList<String>(set);
	   
	   Collections.sort(list, new Comparator<String>(){
	   public int compare(String a, String b){
	    String[] s1 = a.split(" ");
	    String[] s2 = b.split(" ");
	    int v1 = s1[1].compareTo(s2[1]);
	    if(v1!=0)
	      return -v1;
	    else{	     
	     int v2 = s1[2].compareTo(s2[2]);
	      if(v2!=0)
	        return -v2;
	      else{
	        int v3 = s1[3].compareTo(s2[3]);
	        if(v3!=0)
	          return -v3;
	        else{
	          return s1[0].compareTo(s2[0]);
	        }
	      }
	    }
	   }
	   
	   });
	  
	  String[] temp = new String[list.size()];
	  for(int i=0;i<list.size();i++)
	    temp[i]=list.get(i);
	  for(int i=0;i<temp.length;i++)
	  	System.out.println(temp[i]);
	  return temp; 		
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
/*
SRM 204 Div 2 500
http://community.topcoder.com/stat?c=problem_statement&pm=2854
*/
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Aaagmnrs
{
	public String[] anagrams(String[] phrases)
	{  
	 Set<String> a = new HashSet<String>();
	 List<String> list = new ArrayList<String>();
	 for(String phrase: phrases){
	   String[] sp = phrase.split(" ");
	   StringBuffer sb = new StringBuffer();
	   for(String s: sp){
	     sb.append(s.toLowerCase());
	   }
	  String ph = sb.toString();
	  char[] cph = ph.toCharArray();
	  Arrays.sort(cph);
	  String sph = new String(cph);
	  if(a.contains(sph)){
	   
	  }
	  else{
	   a.add(sph);
	   list.add(phrase);
	  }
	 }
	 String[] res = new String[list.size()];
	 return list.toArray(res);
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
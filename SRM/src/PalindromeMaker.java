/*
  SRM 274 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=5881
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PalindromeMaker
{
	public String make(String baseString)
	{
		char[] sorted = baseString.toCharArray();
		Arrays.sort(sorted);
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		for(char s: sorted){
		if(map.containsKey(s)){
		  map.put(s,map.get(s)+1);
		
		}
		else{
		map.put(s,1);
		}
		}
		int i=0;
		char[] res = new char[sorted.length];
	    int j = res.length-1;	
		for(Map.Entry<Character,Integer> entry: map.entrySet()){
		 char key = entry.getKey();
		 int val = entry.getValue();
		 if(val%2==1){
		   map.put(key,1);
		 }else{
		   map.put(key,0);
		 }
		 int ctot= val/2;
		 for(int k=i;k<(i+ctot);k++){
		  res[k]=key;
		  System.out.println(res[k]);
		 }
		 i += ctot;
		 
		 for(int k=j;k>=(j-ctot);k--){
		 res[k] = key;
		 System.out.println(res[k]);
		 }
         j -= ctot;		 
		}
		System.out.println("res");
		for(char r:res){
		  System.out.print(r);
		}
		
		
		char finalChar;
		int count = 0;
		
		for(Map.Entry<Character,Integer> entry: map.entrySet()){
		   char key = entry.getKey();
		   int val = entry.getValue();
		   if(val==1){
		      res[sorted.length/2]=key;
		      count+=1;
		   }
		  if(count>1)
		    return "";
		}
		
		
		
	    String result= new String(res);
	    System.out.println(result);
	    return result;
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
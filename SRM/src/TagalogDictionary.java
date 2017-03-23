/*
 SRM 342 Div 2 500
 http://community.topcoder.com/stat?c=problem_statement&pm=7411
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TagalogDictionary
{
	public String[] sortWords(String[] words)
	{
		MyComparator mc = new MyComparator();
		Arrays.sort(words,mc);
		return words;
		
	}
	
	public class MyComparator implements Comparator{
	String str = "abkdeghilmnngoprstuwy";
	
	public int compare(Object o1, Object o2){
	  String a = (String) o1;
	  String b = (String) o2;
	  char[] c1 = a.toCharArray();
	  char[] c2 = b.toCharArray();
	  int length = Math.min(c1.length,c2.length);
	  int i=0,j=0;
	  while(i<c1.length&&j<c2.length){
	     StringBuffer sb1 = new StringBuffer();
	     StringBuffer sb2 = new StringBuffer();
	     char u1 = a.charAt(i);
	     char u2 = b.charAt(j);
	     i++;
	     j++;
	     if(u1=='n'){
	        System.out.println("Yes N");
	        if((i)<c1.length&&(a.charAt(i)=='g')){
	         sb1.append('n');
	         sb1.append('g');
	         System.out.println("Entered Inside sb1");
	         i++;
	        }
	        else{
	         sb1.append('n');
	        }
	     }
	     else{
	      sb1.append(u1);
	     }
	    if(u2=='n'){
	     if((j)<c2.length&&(b.charAt(j)=='g')){
	        System.out.println(b.charAt(j)+"Hello");
	        sb2.append('n');
	        sb2.append('g');
	        System.out.println("Entered Inside");
	        j++;
	      }
	      else{
	       sb2.append('n'); 
	      }
	    }
	    else{
	     sb2.append(u2);
	    }
	    String s1 = sb1.toString();
	    String s2 = sb2.toString();
	    System.out.println(sb1+" "+sb2);
	    Integer res1 = str.indexOf(s1);
	    Integer res2 = str.indexOf(s2);
	    if(res1.compareTo(res2)!=0)
	      return res1.compareTo(res2);
	    
	  }
	  
      Integer i1 = c1.length;
      Integer i2 = c2.length;
      if(i1<i2)
      {
         return -1;
      } 
      else if(i1>i2)
        return   1;
      else
        return 0;
	  
	  
	}
	
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
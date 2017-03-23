/*
  SRM 529 Div2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=11740
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class KingSort
{
	public String[] getSortedList(String[] kings)
	{
		List<String> k= new ArrayList<String>();
		Character[] ro={'I','V','X','L'};
		Integer [] no={1,5,10,50};
		Map<Character,Integer> rn= new HashMap<Character,Integer>();
		for(int i =0;i<ro.length;i++){
		  rn.put(ro[i],no[i]);
		}
		for(String king: kings){
		k.add(king);
		}
		
		Collections.sort(k, new MyComparator(rn));
		
		return k.toArray(kings);
		
	}
	
	public class MyComparator implements Comparator{
	  
	  Map<Character, Integer> rn;
	  public MyComparator(Map<Character,Integer> rn){
	    this.rn =rn;
	  }
	  public Integer convertRoman(String str){
	    char[] r= str.toCharArray();
	    Integer sum = 0;
	    int prev=0;
	    int curr;
	    for(int i=r.length-1;i>=0;i--){
	      curr = (Integer) rn.get(r[i]);
	      if(curr<prev){
	        sum = (sum-curr);
	      }
	      else
	         sum+=curr;
	      prev = curr;
	    }
	    
	    System.out.println(str+":"+sum);
	    return sum;
	  }
	  
	  public int compare(Object o1, Object o2){
	    String a =(String) o1;
	    String b =(String) o2;
	    String[] a1= a.split(" ");
	    String[] b1 = b.split(" ");
	    int r1 = a1[0].compareTo(b1[0]);
	    if(r1==0){
	      Integer i1=(Integer)convertRoman(a1[1]);
	      Integer i2=(Integer)convertRoman(b1[1]);
	      return i1.compareTo(i2);
	    }
	    
	    return r1;
	  }
	}
	
	
	
}
//Powered by [KawigiEdit] 2.0!
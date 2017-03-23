/*
 SRM 183 Div 2 500
 http://community.topcoder.com/stat?c=problem_statement&pm=2336
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BridgeSort
{
	public String sortedHand(String hand)
	{   char[] a=new char[]{'C','D','H','S'};
	    String[] suits = new String[]{"Clubs","Diamonds","Hearts","Spades"};
		Map<String,TreeSet<Character>> m = new TreeMap<String, TreeSet<Character>>();
		MyComparator mc = new MyComparator();
		
		for(int i=0;i<hand.length();i=i+2){
		 int index = 0;
         
		 while(a[index]!=hand.charAt(i))
		 index++;
		 
		 String suit = suits[index];
		 char val = hand.charAt(i+1);
		 if(m.containsKey(suit)){
		   TreeSet ts = m.get(suit);
		   ts.add(val);
		   m.put(suit,ts);
		 }
		 else{
		   TreeSet ts = new TreeSet(mc);
		   ts.add(val);
		   m.put(suit,ts);
		 }
		}
		StringBuffer sb = new StringBuffer();
		for(String s: suits){
		TreeSet ts = m.get(s);
		if(ts!=null){
		for(Iterator it = ts.iterator();it.hasNext();){
		 sb.append(s.charAt(0));
		 sb.append((Character) it.next());
		}
		}
		}
        String res = new String(sb.toString());
        return res;		
		
	}
	
	public class MyComparator implements Comparator{
	 String str = "23456789TJQKA";
	 public int compare(Object o1, Object o2){
	   Character c1 = (Character) o1;
	   Character c2 = (Character) o2;
	   if(str.indexOf(c1) > str.indexOf(c2))
	      return 1;
	   else if(str.indexOf(c1) < str.indexOf(c2))
	      return -1;
	   else
	     return 0;
	 } 
	}
	
}
//Powered by [KawigiEdit] 2.0!
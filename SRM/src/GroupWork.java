/*
  SRM 322 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=6804
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GroupWork
{
	public long bestGroup(int[] p, int[] s)
	{
	  int i = 0;
	  List<String> list= new ArrayList<String>();
	  for(int s1: s){
	    String str = i+","+s1;
	    list.add(str);
	    i++;
	  }	
	  Arrays.sort(s);
	  int[] s2 = new int[s.length];
	  i=0;
	  for(int k=s.length-1;k>=0;k--){
	   s2[k]=s[i];
	   i++;
	  }
	  Collections.sort(list, new Comparator<String>(){
	  public int compare(String a, String b){
	     Integer index1 = Integer.parseInt(a.split(",")[1]);
	     Integer index2=Integer.parseInt(b.split(",")[1]);
	     return -index1.compareTo(index2);
	  }
	 });
	 
	 int[] p1 = new int[p.length];  
	 i=0;
	 System.out.println("list");
	 for(String s1: list){
	   System.out.println(s1);
	 }
	 
	 for(String a: list){
	   int b = Integer.parseInt(a.split(",")[0]);
	   p1[i]=p[b];
	   System.out.println(p[b]);
	   i++;
	 }
	
	long sump=0;
	 long max=-1000000;
	 long low;
	 long res=0;
	 for(int j=0;j<p1.length;j++){
	   sump+=(long)p1[j];
	   System.out.println("sump:"+sump);
	   low=(long)s2[j];
	   res = sump*low;
	   System.out.println("res:"+res);
	   if(res>max){
	     max = res;
	   }
	   
	 
	 }
	 
	 return max;
	 
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
/*
  SRM 588 Div2 test case 6 failed 500
  http://community.topcoder.com/stat?c=problem_statement&pm=12707
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GUMIAndSongsDiv2
{
	
	public int atoi(String a){
	  return Integer.parseInt(a);
	}
	
	public int maxSongs(int[] duration, int[] tone, int T)
	{
		int max=0;
		int N=duration.length;
		int[] cost = new int[N];
		List<String> list = new ArrayList<String>();
		for(int i=0;i<N;i++){
		list.add(i+","+duration[i]+","+tone[i]);
		}
		Collections.sort(list,new Comparator<String>(){
		  public int compare(String a, String b){
		   String[] a1 = a.split(",");
		   String[] b1 = b.split(",");
		   Integer i1 =  Math.abs(atoi(a1[1])-atoi(a1[2]))*atoi(a1[1]);
		   Integer i2 = Math.abs(atoi(b1[1])-atoi(b1[2]))*atoi(b1[1]);
		   return i1.compareTo(i2);
		   
		  }
		
		});
		int[] d = new int[N];
		int[] t = new int[N];
		int i = 0;
		for(String a: list){
		 String[] b = a.split(",");
		 d[i]=atoi(b[1]);
		 t[i]=atoi(b[2]);
		 i++;
		}
		int c=d[0];
		if(d[0]>T)
		  return 0;
		for(int j=1;j<N;j++){
		 c += Math.abs(t[j]-t[j-1])+d[j];
		 if(c>T)
		  return j;
		}
		return N;
		
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
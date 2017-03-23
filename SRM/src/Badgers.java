/*
  SRM 476 Div2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=10797
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Badgers
{
	public int feedMost(int[] hunger, int[] greed, int totalFood)
	{
		int count = 0;
		List<String> list = new ArrayList<String>();
		for(int i=0;i<hunger.length;i++){
		  String str=hunger[i]+","+i;
		  list.add(str);
		}
		Collections.sort(list,new Comparator<String>(){
		
		public int compare(String a, String b){
		  Integer i1 = Integer.parseInt(a.split(",")[0]);
		  Integer i2 = Integer.parseInt(b.split(",")[0]);
		  Integer i3 = Integer.parseInt(a.split(",")[1]);
		  Integer i4 = Integer.parseInt(b.split(",")[1]);
		  
		  int res1 = i1.compareTo(i2);
		  if(res1==0){
		    return i3.compareTo(i4);
		  }
		  else{
		    return res1;
		  }
		
		}
		
		});
		boolean all1=true;
		
		Arrays.sort(hunger);
		int[] g = new int[greed.length];
		int k=0;
		for(String a: list){
		   g[k]=greed[Integer.parseInt(a.split(",")[1])];
		   k++;
		}
		
		int sum1 = 0;
		int prev1=0;
		for(int i=0;i<hunger.length;i++){
		 for(int j=0;j<=i;j++){
		 	sum1 += hunger[j]+g[j]*i;
		 }
		 if(sum1<=totalFood){
		 sum1=0;
		 }
		 if(sum1>totalFood){
		  all1=false;
		  prev1=i;
		  break;
		 }
		 
		}
		
		
		
		
	
		List<String> list1 = new ArrayList<String>();
		for(int i=0;i<greed.length;i++){
		  String str=greed[i]+","+i;
		  list1.add(str);
		}
		Collections.sort(list1,new Comparator<String>(){
		
		public int compare(String a, String b){
		  Integer i1 = Integer.parseInt(a.split(",")[0]);
		  Integer i2 = Integer.parseInt(b.split(",")[0]);
		  Integer i3 = Integer.parseInt(a.split(",")[1]);
		  Integer i4 = Integer.parseInt(b.split(",")[1]);
		  
		  int res1 = i1.compareTo(i2);
		  if(res1==0){
		    return i3.compareTo(i4);
		  }
		  else{
		    return res1;
		  }
		
		}
		
		});
		
		Arrays.sort(greed);
		boolean all2=true;
		int[] g1 = new int[hunger.length];
		k=0;
		for(String a: list){
		   g1[k]=hunger[Integer.parseInt(a.split(",")[1])];
		   k++;
		}
		
		int sum2 = 0;
		int prev2=0;
		for(int i=0;i<hunger.length;i++){
		 for(int j=0;j<=i;j++){
		 	sum2 += g1[j]+greed[j]*i;
		 }
		 if(sum2<=totalFood){
		 sum2=0;
		 }
		 if(sum2>totalFood){
		  all2=false;
		  prev2=i;
		  break;
		 }
		 
		}
		
		if(all1){
		
		prev1=hunger.length;
		}
		
		if(all2){
		 prev2=hunger.length;
		}
		
		System.out.println(prev1);
		System.out.println(prev2);
		
	  return (prev1>prev2)?prev1:prev2;
	}
	
	
	
	
	
	
}
//Powered by [KawigiEdit] 2.0!
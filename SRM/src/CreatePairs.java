/*
  SRM 332 Div2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=7309
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CreatePairs
{
	public int maximalSum(int[] data)
	{
		Arrays.sort(data);
		int p = 0;
		int z = 0;
		int n = 0;
		int l = data.length;
		int n1=0;
		for(int i=0;i<l;i++){
		   if(data[i]<0)
		     n++;
		   if(data[i]==1)
		     n1++;
		   if(data[i]>1)
		     p++;
		   if(data[i]==0)
		     z++;
		}
		System.out.println("Hello z"+z);
		int sum = 0;
		int i;
		boolean val = true;
		for(i=l-1;i>=1&&val;){
		  if(data[i]>1&&data[i-1]>1&&p>1){
		    sum += data[i]*data[i-1];
		    System.out.println("sum:"+sum);
		    i=i-2;
		    System.out.println("i:"+i);
		  }
		  else{
		   val = false;
		  }
		}
		System.out.println("hey P"+p);
		if(p%2!=0&&data[i]!=1){
		  sum += data[i];
		  i--;
		}
		if(n1>0){
		  sum+=n1*1;
		}
		
		int j = i;
		val = true;
		for(i=0;i<l-1&&i<j&&val;){
		  if(data[i]<0&&data[i+1]<0&&n>1){
		    sum += data[i]*data[i+1];
		    i=i+2;
		  }
		  else{
		   val=false;
		  }
		
		}
		
		System.out.println("Hey n"+n);
		if(z!=0&&n%2!=0){
		  
		}
		else if(n%2!=0){
		   sum += data[i];
		}
		System.out.println(sum);
		return sum;
		
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
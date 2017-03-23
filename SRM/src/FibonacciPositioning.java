/*
  SRM 298 Div 2 Mid
  http://community.topcoder.com/stat?c=problem_statement&pm=6160
*/


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class FibonacciPositioning
{
	public double getFPosition(int n)
	{
		if(n==1)
		  return 2.0;
		double[] f= new double[n+10];
		
		
		f[0]=1;
		f[1]=1;
		boolean val=false;
		for(int i=2;i<n+10;i++){
		 f[i]=f[i-1]+f[i-2];
		}
		int len = f.length;
		int i;
		for(i=2;i<len;i++){
		  if(f[i]==(double)n)
		    return  (double)(i+1);
		 else if(f[i]>n)
		    break;
		}
		System.out.println(i);
		System.out.println(f[i-1]);
		System.out.println(f[i]);
		return (i)+(((double)n-f[i-1])/(f[i]-f[i-1]));
		
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
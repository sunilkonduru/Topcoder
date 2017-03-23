import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MinimumSquareEasy
{
	public long minArea(int[] x, int[] y)
	{
		double ax = 0, ay = 0;
		int n = x.length;
		for(int i:x){
		  ax += (double) i;
		}
		for(int i: y){
		  ay += (double) i;
		}
		ax = ax/n; ay = ay/n;
		double firstMax=Integer.MIN_VALUE,secondMax=Integer.MIN_VALUE;
		List<String> list = new ArrayList<String>();
		for(int i=0;i<x.length;i++){
		    double distance =  Math.pow((ax-(double)x[i]),2)+Math.pow((ay-(double)y[i]),2);
		    list.add(x[i]+","+y[i]+","+distance);
		}
		Collections.sort(list,new Comparator<String>(){
	      public int compare(String a, String b){
	        Double dist1 = Double.parseDouble(a.split(",")[2]);
	        Double dist2 = Double.parseDouble(b.split(",")[2]);
	        return -dist1.compareTo(dist2);
	      }
		});
		list.remove(0); list.remove(1);
	    int actualxpoint = 0, actualypoint = 0;
	    int largestxpoint = Integer.MIN_VALUE, smallestxpoint = Integer.MAX_VALUE;
	    
	    for(String a: list){
	     int xv = Integer.parseInt(a.split(",")[0]);
 	     int distx = Math.abs(xv);
 	     if(distx>largestxpoint){
 	       largestxpoint = distx;
 	       actualxpoint=xv; 
 	     }    
 	     if(distx<smallestxpoint){
 	       smallestxpoint = distx;
 	       actualypoint = xv;
 	     }
	    }
	    
	    if(actualxpoint>=0){
	      actualxpoint +=1;
	    }
	    else{
	     actualxpoint -=1;
	    }
		
		if(actualypoint>=0){
	      actualypoint +=1;
	    }
	    else{
	     actualypoint -=1;
	    }
		
		return (long)Math.pow((actualxpoint - actualypoint),2);
	}
	
	
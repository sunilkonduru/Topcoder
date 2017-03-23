//srm - 445.

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TheNewHouseDivTwo
{
	public int count(int[] x, int[] y)
	{
		Map<Integer,Set<Integer>> xa = new HashMap<Integer,Set<Integer>>();
		Map<Integer,Set<Integer>> ya = new HashMap<Integer,Set<Integer>>();
		Set<String> points = new HashSet<String>();
		for(int i=0;i<x.length;i++){
		   if(xa.containsKey(x[i])){
		     Set<Integer> set = xa.get(x[i]);
		     set.add(y[i]);
		     xa.put(x[i],set);
		   }
		   else{
		     Set<Integer> set = new HashSet<Integer>();
		     set.add(y[i]);
		     xa.put(x[i],set);
		   }
		   
		   
		   if(ya.containsKey(y[i])){
		     Set<Integer> set = ya.get(y[i]);
		     set.add(x[i]);
		     ya.put(y[i],set);
		   }
		   else{
		     Set<Integer> set = new HashSet<Integer>();
		     set.add(x[i]);
		     ya.put(y[i],set);
		   }
		   
		}
		
		int count = 0;
		
		for(int i=0;i<x.length;i++){
		  int xv = x[i];
		  for(int j=0;j<y.length;j++){
		    
		    int yv = y[j];
		    Set<Integer> set1 = xa.get(xv);
		    Iterator<Integer> it = set1.iterator();
		    int xMax = Integer.MIN_VALUE;
		    int xMin = Integer.MAX_VALUE;
		    int yMax = Integer.MIN_VALUE;
		    int yMin = Integer.MAX_VALUE;
		    while(it.hasNext()){
		       int v1 = it.next();
		       if(xMax<v1){
		         xMax=v1;
		       }
		       if(xMin>v1){
		         xMin = v1;
		       }
		    }
		    
		    Set<Integer> set2 = ya.get(yv);
		    Iterator<Integer> it1 = set2.iterator();
		    
		    while(it1.hasNext()){
		      int v1 = it1.next();
		       if(yMax<v1){
		         yMax=v1;
		       }
		       if(yMin>v1){
		         yMin = v1;
		       }
		    }
		     
		    if(xMax>xv && xMin<xv && yMax>yv&&yMin<yv){
		      String str = xv+","+yv;
		      if(points.contains(str)){
		      
		      }
		      else{
		        count++;
		        points.add(str);
		        System.out.println(xv+","+yv);
		      }
		    }
		    
		  }
		  
		}
		
		return points.size();
	}
	
	
}


//easier solution - 2nd try

 public int count(int[] x, int[] y) {

        int limit = 99;

        int cnt = 0;

        for (int i = -limit; i <= limit; i++)

        {

            for (int j = -limit; j <= limit; j++)

            {

                boolean north = false, south = false, east = false, west = false;

                for (int k = 0; k < x.length; k++)

                {

                    if (y[k] > j && x[k] == i)

                        north = true;



                    if (y[k] < j && x[k] == i)

                        south = true;



                    if (x[k] > i && y[k] == j)

                        east = true;



                    if (x[k] < i && y[k] == j)

                        west = true;

                }



                if (north && south && west && east)

                    cnt++;

            }

        }

        return cnt;

}

//Powered by [KawigiEdit] 2.0!
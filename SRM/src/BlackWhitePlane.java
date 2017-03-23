/*
  SRM 271 Div2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=4497
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BlackWhitePlane
{
	public double area(String[] circles)
	{
	   List<C> l = new ArrayList<C>();
	   for(int i=0;i<circles.length;i++){
	     C c1 = new C(Integer.parseInt(circles[i].split(" ")[0]), Integer.parseInt(circles[i].split(" ")[1]),Integer.parseInt(circles[i].split(" ")[2]));
	     l.add(c1);
	   } 	
	   Collections.sort(l);
	   List<C> l2 = new ArrayList<C>();
	   boolean[] b = new boolean[l.size()];
	   Arrays.fill(b, false);
	   b[0]=true;
	   l2.add(l.get(0));
	   for(int i=1;i<l.size();i++){
	     int c = 0;
	     for(int j=0;j<l2.size();j++){
	       if(liesInside(l.get(i),l2.get(j)))
	         c++;
	     }
	     l2.add(l.get(i));
	     if(c%2==0){
	      b[i] = true;
	     }
	     c++;
	   }   
	   double res=0;
	   System.out.println(Math.PI);
	   for(int i=0;i<b.length;i++){
	     if(b[i]){
	       res +=Math.PI * (l.get(i).r) * (l.get(i).r);
	       System.out.println("white"+l.get(i).r+""+res);
	     }
	     else{
	        res -=Math.PI * (l.get(i).r) * (l.get(i).r);
	        System.out.println("black"+l.get(i).r+""+res);
	     }
	     
	   }
	   return res;
	}
	
	public boolean liesInside(C c1, C c2){
	  return (((c1.x-c2.x)*(c1.x-c2.x)+(c1.y-c2.y)*(c1.y-c2.y)) < (c2.r*c2.r));
	  
	}
	
	
	public class C implements Comparable{
	 int x;
	 int y;
	 Integer r;
	 
	 public C(int x, int y, int r){
	   this.x=x;
	   this.y=y;
	   this.r=r;
	 }
	 
	 public int compareTo(Object o1){
	 C c1 = (C) o1;
	 return -this.r.compareTo(c1.r);
	 }
	
	
	}
	
	
	
	
}
//Powered by [KawigiEdit] 2.0!
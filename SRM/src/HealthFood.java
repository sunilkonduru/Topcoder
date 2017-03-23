/*
 SRM 219 Div2 500
 http://community.topcoder.com/stat?c=problem_statement&pm=3118
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class HealthFood
{
    public class Dish{
    int protein, carbs, fat, cal, index;
    
    
    public Dish(int p, int c, int f,int index){
     this.protein=p;
     this.carbs = c;
     this.fat=f;
     this.cal= 9*f+5*c+5*p;
     this.index = index;
    }
    
    public boolean lessThan(Dish d, char c){
      switch(c){
      case 'P': return protein<d.protein;
      case 'p': return protein>d.protein;
      case 'C': return carbs<d.carbs;
      case 'c': return carbs>d.carbs;
      case 'T': return cal<d.cal;
      case 't': return cal>d.cal;
      case 'F': return fat<d.fat;
      case 'f': return fat>d.fat;
      case 'i': return d.index<index;
      default: return false;
      }
    }
    }
    
    class MyComparator implements Comparator{
      String sortString;
      public MyComparator(String str){
        sortString=str+"i";
      }
      public int compare(Object o1, Object o2){
       if(o1==o2) return 0;
       Dish d1 = (Dish) o1;
       Dish d2 = (Dish) o2;
       for(int i=0;i<sortString.length();i++){
         if(d1.lessThan(d2,sortString.charAt(i)))
           return 1;
         else if(d2.lessThan(d1,sortString.charAt(i)))
            return -1;  
       }
       return -1;
      }
    
    }
    
    public int returnIndexFor(String dietPlan,Dish[] ds){
      MyComparator m = new MyComparator(dietPlan);
      TreeSet ts = new TreeSet(m);
      for(int i=0;i<ds.length;i++){
        ts.add(ds[i]);
      }
      for(Iterator i=ts.iterator();i.hasNext();){
        Dish d=(Dish)i.next();
        return d.index;
      }
      return -1;
      }
     
    
	public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans)
	{
	  System.out.println("Hello");
	  Dish[] ds = new Dish[protein.length];
      for (int i = 0; i < protein.length; i++)
      {
        ds[i] = new Dish(protein[i], carbs[i], fat[i], i);
      }
      int[] res = new int[dietPlans.length];
      for (int j = 0; j < dietPlans.length; j++)
      {
        res[j] = returnIndexFor(dietPlans[j], ds); 
      }
        return res;
    }

	
	
}
/*
  SRM 203 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=2911
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MatchMaking
{
	public class Pair{
	  String m,f, ma, fa;
	  public Pair(String f, String m, String fa, String ma){
	    this.m = m;
	    this.f = f;
	    this.fa=fa;
	    this.ma=ma;
	  }
	  
	  public int points(){
	    int count=0;
	    for(int i=0;i<ma.length();i++){
	     if(ma.charAt(i)==fa.charAt(i))
	       count++;
	    }
	    return count;
	  }
	  
	
	}
	
	public class MyComparator implements Comparator{
     
     public int compare(Object o1, Object o2){
       Pair p1 = (Pair)o1;
       Pair p2 = (Pair)o2;
       if(p1.points()<p2.points())
         return 1;
       else if(p1.points()>p2.points())
         return -1;
       else{
          int v = p1.f.compareTo(p2.f);     
          if(v>0)
            return 1;
          else if(v<0)
            return -1;
          else{
            int v1 = p1.m.compareTo(p2.m);
            if(v1>0)
              return 1;
            else if(v1<0)
              return -1;
            else
              return 0;
          }
       
       }
       
     }
	
	}
	
	public String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman)
	{ 
	  int nw = namesWomen.length;
	  int nm = namesMen.length;
	  Pair[] p = new Pair[nw*nm];
	  int k =0;
	  for(int i=0;i<namesWomen.length;i++){
	    for(int j=0;j<namesMen.length;j++){

	      p[k]=new Pair(namesWomen[i],namesMen[j],answersWomen[i], answersMen[j]);
	      k++;
	    }
	  }
	  List<Pair> list = new ArrayList<Pair>();
	  for(Pair p1:p){
	    list.add(p1);
	  }
	  Collections.sort(list,new MyComparator());
	  Map<String, String> map = new HashMap<String, String>();
	  //Arrays.sort(namesWomen);
	  for(Iterator it=list.iterator();it.hasNext();){
	   Pair p1 = (Pair)it.next();
	    String f = p1.f;
	    String m = p1.m;
	    System.out.println(f+" "+m);
	    boolean fp = Arrays.asList(namesWomen).contains(f);
	    boolean mp = Arrays.asList(namesMen).contains(m);
	    if(fp&&mp){
	     if(queryWoman.equals(f)){
	       System.out.println(queryWoman);
	       return m;
	     }
	     else{
	      namesWomen=remove(namesWomen,f);
	      System.out.println(f+"Taken by"+m);
	      namesMen = remove(namesMen,m);
	      
	     }
	    }
	  }
	  return null;
	}
	
	public String[] remove(String[] arr, String str){
	  List<String> result = new LinkedList<String>();
	  if(arr!=null){
	  for(String item: arr){
	  if(item!=null&&!item.equals(str)){
	    result.add(item);
	  }
	  }
	  }
	  return result.toArray(arr);
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
/*
  SRM 265 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=1993
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ScheduleStrength
{
	public String[] calculate(String[] teams, String[] results)
	{   
	    HashMap<String, List<String>> to = new HashMap<String,List<String>>();
	    HashMap<String, String> lw = new HashMap<String,String>();
	    List<String> sortList = new ArrayList<String>();
	    int k = 0;
		for(String result: results){
		  int j =0;
		  int l=0, w=0;
		  
		  List<String> list = new ArrayList<String>();
		  for(int i=0;i<teams.length;i++){
		    if(result.charAt(i)!='-'){
		     list.add(teams[j]);
		    }
		    if(result.charAt(i)=='W'){
		     w++;
		    }
		    if(result.charAt(i)=='L'){
		     l++;
		    }
		    j++;
		  }

		  String res = w+","+l;
		  to.put(teams[k],list);
		  lw.put(teams[k],res);
		  sortList.add(teams[k]);
		  System.out.println(teams[k]+" "+res +"size:");
		  k++;
		}
		
		HashMap<String, Double> ca = new HashMap<String, Double>();
		for(String team: teams){
		  int wins = Integer.parseInt(lw.get(team).split(",")[0]);
		  int los = Integer.parseInt(lw.get(team).split(",")[1]);
		  List<String> op = to.get(team);
		  int gw = 0;
		  int gl = 0;
		  for(String o: op){
		   String[] res= lw.get(o).split(",");
		   gw+=Integer.parseInt(res[0]);
		   gl+=Integer.parseInt(res[1]);
		  }
		 double lw1 = gw - los;
		 double ll = gl - wins;
		 double total = lw1+ll;
		 double val = lw1/total;
		 System.out.println(team+" "+lw1+" "+total+" "+val);
		 ca.put(team, val);;
		}
	  
		Collections.sort(sortList, new MyComparator(ca));

		String[] res = new String[teams.length];
		sortList.toArray(res);
		return res;
		
	}
	
	public class MyComparator implements Comparator{
	    HashMap<String,Double> ca = null;	
		public MyComparator(HashMap<String,Double> ca){
		  this.ca = ca;
		}
		
		public int compare(Object o1, Object o2){
		   String a = (String) o1;
		   String b = (String) o2;
		   double v1 = ca.get(a);
		   double v2 = ca.get(b);
		   if(v1>v2)
		     return -1;
		   else if(v1<v2)
		      return 1;
		   else{
		     return a.compareTo(b);
		   }
		}
		}
	
	
}
//Powered by [KawigiEdit] 2.0!
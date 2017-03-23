/*
  SRM 207 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=2866
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class RegularSeason
{
	public String[] finalStandings(String[] teams, int rounds)
	{  
	   List<String> list = new ArrayList<String>();
	   for(String team: teams){
         list.add(team.split(" ")[0]);	   
	   }
	   Map<String, Double> map = new TreeMap<String, Double>();
	   for(int i=0;i<teams.length;i++){
	     String[] sc = teams[i].split(" ");
	     String ct = sc[0];
	     for(int j=1;j<sc.length;j++){
	       if(i+1==j)
	         continue;
	       double curr = (Double.parseDouble(sc[j])*rounds);       
	       String opp = list.get(j-1);
	       double oppv= ((100-Double.parseDouble(sc[j]))*rounds);
	       if(map.containsKey(ct)){
	         map.put(ct, map.get(ct)+curr);
	       }
	       else{
	        map.put(ct,curr);
	       }
	       
	       if(map.containsKey(opp)){
	         map.put(opp,map.get(opp)+oppv);
	       }
	       else{
	         map.put(opp,oppv);
	       }
	     
	     }
	   
	   }
	   List<Map.Entry<String,Double>> slist= new ArrayList<Map.Entry<String,Double>>();
	   
	   for(Map.Entry<String,Double> entry: map.entrySet()){
	   slist.add(entry);
	   }
	   
	   Collections.sort(slist, new Comparator(){
	   
	   public int compare(Object o1, Object o2){
	   
	   Map.Entry<String,Double> m1 =(Map.Entry<String,Double>)o1;
	   Map.Entry<String,Double> m2 =(Map.Entry<String,Double>)o2;
	   Double d1 = m1.getValue();
	   Double d2 = m2.getValue();
	   
	   if(d1==d2){
	     return m1.getKey().compareTo(m2.getKey());
	   }
	   else{
	     return -d1.compareTo(d2);
	   }
	   
	   
	   }
	   
	   });
	   
	   String[] res = new String[slist.size()];
	   int i=0;
	   for(Map.Entry<String,Double> entry: slist){
	     double val=entry.getValue()/100;
	     double v2 =entry.getValue()/100;
	     int v1 =(int) v2;
	     double dec = val-v1;
	     System.out.println("dec"+dec);
	     if(dec>=0.5){
	      v1=v1+1; 
	     }
	    
	     res[i]=entry.getKey()+" "+v1;
	     System.out.println(res[i]+" "+entry.getValue());
	     i++;
	   
	   }
	   
		return res;
	}
	
	
	
}
//Powered by [KawigiEdit] 2.0!
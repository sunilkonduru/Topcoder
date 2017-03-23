/*
  SRM 241 Div2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=4485
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ReportAccess
{
	public String[] whoCanSee(String[] userNames, String[] allowedData, String[] reportData)
	{
		Map<String,Set<String>> map=new HashMap<String,Set<String>>();
		int m =userNames.length;
		int n = allowedData.length;
		int o = reportData.length;
		for(int i=0;i<m;i++){
		     String ad = allowedData[i];
		     String[] a= ad.split(" ");
		     for(String ad1: a){
		     
		     if(map.containsKey(ad1)){
		       Set<String> l = map.get(ad1);
		        l.add(userNames[i]);
		        System.out.println(ad1+""+l);
		        map.put(ad1,l);
		     }
		     else{
		       Set<String> list = new TreeSet<String>();
		       list.add(userNames[i]);
		       map.put(ad1, list);
		       System.out.println("p:"+ad1+""+list);
		     }
		    }
		  
		
		}
		
		Set<String> set = null;
	    List<String> list=null;
	    if(reportData.length>0){
	     set=map.get(reportData[0]);
	    }
	    else{
	    	String[] res = {};
	    	return res;
	    }
	    
	    boolean y=true;
	    for(int i=0;i<o;i++){
	      if(map.containsKey(reportData[i]))
	        y=false;
	    
	    }
	    
	    if(y){
	      String[] res = {};
	    	return res;
	    }
	    
	    Set<String> set2 = set;
	    Set<String> set3 =null;
		for(int i=1;i<reportData.length;i++){
		  System.out.println(map);
		  System.out.println(reportData[i]);
		  Set<String> set1 = map.get(reportData[i]);
		  set3 = new TreeSet<String>();
		 
        if(set1!=null){		  
		  
		  Iterator<String> it = set1.iterator();
		  while(it.hasNext()){
		    String next = it.next();
		    if(set2.contains(next)){
		      set3.add(next);
		    }
		  
		  }
		  set2=set3;
		}
		}
     	
       	List<String> res = null;
       	if(reportData.length==1){
       	  res=new ArrayList<String>(set);
       	}
       	else{
       	  res = new ArrayList<String>(set3);
       	}	
     	Collections.sort(res);
     	String[] result = new String[res.size()];
		for(int i=0;i<result.length;i++){
		  result[i]=res.get(i);
		}
		return result;
		
		
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
/*
  SRM 336 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=7313
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ServiceNames
{
	public String[] makeList(String[] services)
	{   final String KINDOF = " ==> ";
	    final String DUP= ", ";
	    Map<String,String> map = new TreeMap<String,String>();
	   	for(String service:services){
	   	   String[] ser = service.split(" ");
	   	   String grp=ser[0];
	   	   for(int i=1;i<ser.length;i++){
	   	     if(map.containsKey(ser[i])){
	   	       map.put(ser[i],map.get(ser[i])+DUP+grp);
	   	     }
	   	     else{
	   	       map.put(ser[i],grp);
	   	     }
	   	   }
	   	}
	   	List<String> list = new ArrayList<String>();
	   	for(Map.Entry<String,String> entry: map.entrySet()){
	   	  String key = entry.getKey();
	   	  String val = entry.getValue();
	   	  String[] vals = val.split(", ");
	   	  Arrays.sort(vals);
	   	  String val1 = "";
	   	  for(int i=0;i<vals.length;i++){
	   	    if((i+1)==vals.length){
	   	      val1 += vals[i];
	   	      break;
	   	    }
	   	    val1 +=vals[i]+DUP;
	   	  }
	   	  String res= key+KINDOF+val1;
	   	  list.add(res);
	   	}
	   	String[] results = new String[list.size()];
	   	return list.toArray(results);
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
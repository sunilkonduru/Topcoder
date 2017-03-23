/*
  SRM 397 Div 2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=8745
*/
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SortingGame
{
	public String reverse(int b, int e, String str){
	  System.out.println("Str:"+str);
	  System.out.println("b:"+b+"e:"+e);
	  char[] a = str.toCharArray();
	  List<Character> list = new ArrayList<Character>();
	  for(int i=0;i<b;i++){
	    list.add(a[i]);
	  }
	  for(int i=e;i>=b;i--){
	   list.add(a[i]);
	  }
	  for(int i=e+1;i<a.length;i++){
	   list.add(a[i]);
	  }
	  Character [] c =new Character[a.length];
	  list.toArray(c);
	  char[] d = new char[c.length];
	  int k=0;
	  for(char c1:c){
	   d[k]=c1;
	   k++;
	   
	  }
	  
	  return new String(d);
	}
	
	public int fewestMoves(int[] board, int k)
	{
		HashSet<String> visited = new HashSet<String>();
	    StringBuffer sb = new StringBuffer();
	    StringBuffer sb1=new StringBuffer();
	    for(int i:board){
	    sb1.append(i);
	    }
	    String str = sb1.toString();
	    int[] sbi = new int[board.length];
	    for(int i=0;i<board.length;i++){
	      sbi[i]=board[i];
	    }
	    Arrays.sort(sbi);
	    for(int s: sbi){
	    	sb.append(s);
	    }
	    String sa=sb.toString();
	    if(str.equals(sa))
	      return 0;
		Queue q = new LinkedList();
		int count = 1;
		q.add(str);
		q.add("$");
		//visited.add(str);
		while(!q.isEmpty()){
		  String str2 = (String)q.remove();
		  System.out.println("str2:"+str2);
		  if(visited.contains(str2)){
		   continue;
		  }
		  if(str2.equals("$")){
		   count++;
		   q.add("$");
		   if(q.peek().equals("$"))
		     return -1;
		   continue;
		  }
		  char[] sc=str2.toCharArray();
		  visited.add(str2);
		  for(int i=0;i<sc.length;i++){
		    if((i+k-1)<sc.length){
		    String str1 = reverse(i,i+k-1,str2);
		    System.out.println("str1:"+str1+":"+k);
		    if(str1.equals(sa))
		      return count;
		    else{ 
		      q.add(str1);
		      //visited.add(str1);
		    }
		    } 
		  }
		 
		}
		return -1;
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
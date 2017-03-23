//missed a condition
//wrong solution.
//one thing to realize is, using a set here is a very bad option. I was worried about recomputing the points for each of the elements, it is just O(1), only eight elements. so, recomputing is ok all the time
//I got outofspace exception for this problem and also I missed a condition too.
//for matrix neighbour problem always use dx and dy approach as shown below.
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BombSweeper
{
	public double winPercentage(String[] board)
	{   
	
	    Set<String> set = new HashSet<String>();
	    double total = board[0].length()*board.length;
	    int loss = 0;
		for(int i=0;i<board.length;i++){
		  for(int j=0;j<board[0].length();j++){
		    
		     
		     if(board[i].charAt(j)=='B'){
		        loss++;
		        String c = i+","+j;
		        //System.out.println("c"+""+c);
		        set.add(c);
		        if(i-1>=0){
		          set.add((i-1)+","+j);
		          //System.out.println((i-1)+","+j);
		          if(j-1>=0){
		            set.add((i-1)+","+(j-1));
		            //System.out.println((i-1)+","+(j-1));
		          }
		          if(j+1<=board[0].length())
		            set.add((i-1)+","+(j+1));
		        }
		        if((i+1)<=board.length-1){
		          set.add((i+1)+","+j);
		          //System.out.println((i+1)+","+j);
		          if((j+1)<=board[0].length())
		            set.add((i+1)+","+(j+1));
		            //System.out.println((i+1)+","+j);
		          if(j-1>=0)
		            set.add((i+1)+","+(j-1));
		        }
		        
		        if(j-1>=0)
		          set.add(i+","+(j-1));
		          //System.out.println(i+","+(j-1));
		        if(j+1<=board[0].length()-1)
		          set.add(i+","+(j+1));
		          //System.out.println(i+","+(j+1));
		     }
		  }
		}
		
		System.out.println("output");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
		  String str = it.next();
		  System.out.println(str);
		}
		System.out.println("total"+total);
		int count = set.size();
		double res = (total-count)/((total-count)+loss);
		return res;
	}
	
	
}



//Better solution: SRM 156
//For matrix neighbours


import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BombSweeper
{
     int[] dx = {-1,-1,-1,0,0,1,1,1};
	 int [] dy ={-1,0,1,-1,1,-1,0,1};
	 int n;
	 int m;

	public double winPercentage(String[] board)
	{   
	   n = board.length;
	   m = board[0].length(); 
	   boolean[][] v = new boolean[n][m];
	   for(int i=0;i<n;i++)
	     for(int j=0;j<m;j++)
	        if(board[i].charAt(j)=='B') v[i][j]=true;
	   
	   int loss=0, wins=0;
	   for(int i=0;i<n;i++){
	     for(int j=0;j<m;j++){
	       if(v[i][j]) loss++;
	       else{
	          boolean w = true;
	          for(int k=0;k<dx.length;k++){
	            int v1 = i+dx[k];
	            int v2 = j+dy[k];
	            if(ok(v1,v2)&&v[v1][v2])
	             w = false;
	          }
	          if(w)
	            wins++;
	       }  
	     
	     }
	   }    
	  
	    return (double)(wins*100)/(double)(wins+loss);  
	    
	}
	
	boolean ok(int x, int y){
	  return x>=0&&y>=0&&x<n&&y<m;
	}
	
	
}

//Powered by [KawigiEdit] 2.0!
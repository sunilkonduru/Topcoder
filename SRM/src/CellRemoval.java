
//http://community.topcoder.com/stat?c=problem_statement&pm=10275

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CellRemoval
{
	public static boolean[] isLeaf;
	public static boolean[][] E;
	public static int count = 0;
	public static int deleted;
	public int cellsLeft(int[] parent, int deletedCell)
	{
	  int src=-1;
	  deleted = deletedCell;
	  isLeaf= new boolean[parent.length];
	  E= new boolean[parent.length][parent.length];
	  Arrays.fill(isLeaf,true);
	  for(int i=0;i<parent.length;i++){
	    if(parent[i]==-1)
	      src = i;
	    else{
	      E[parent[i]][i]=true;
	      isLeaf[parent[i]]=false;
	    }
	  }
	  dfs(src);
	  return count;	
	}
	
	public static void dfs(int src){
	  if(src==deleted)
	    return;
	    
	  if(isLeaf[src])
	    count++;
	  for(int i=0;i<E[0].length;i++){
	    if(E[src][i])
	      dfs(i);
	  }
	}
	
	//<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!


class CellRemoval1
{
	boolean[][] isConnected;
	boolean[] marked;
	boolean[] isLeaf;
	int deleted;
	int count = 0;
	public int cellsLeft(int[] parent, int deletedCell)
	{
		isConnected = new boolean[parent.length][parent.length];
		marked= new boolean[parent.length];
		isLeaf = new boolean[parent.length];
		deleted = deletedCell;
		Arrays.fill(isLeaf,true);
		int src=-1;
		for(int i=0;i<parent.length;i++){
			if(parent[i]==-1){
				src = i;
				continue;
			}

			isLeaf[parent[i]]=false;
			isConnected[parent[i]][i]=true;
			//isConnected[i][parent[i]]=true;

		}
		marked[deletedCell]=true;
		if(src==deletedCell)//missed this condition was failing otherwise I have already entered into the dfs loop and started going a depth below
			return 0;

		dfs(src);
		return count;
	}

	public void dfs(int src){
		if(isLeaf[src]){
			count++;
		}
		for(int i=0;i<isConnected[0].length;i++){
			if(i==src)
				continue;
			if(!marked[i]&&isConnected[src][i]) { //made a mistake here marked[i]
				marked[src] = true;
				dfs(i);
			}
		}
	}


}
//Powered by [KawigiEdit] 2.0!
